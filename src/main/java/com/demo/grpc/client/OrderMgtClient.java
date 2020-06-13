package com.demo.grpc.client;

import com.google.protobuf.StringValue;
import ecommerce.OrderManagementGrpc;
import ecommerce.OrderManagementOuterClass;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * @author qlx
 * @date 2020/6/13 10:17
 */
public class OrderMgtClient {

    private static final Logger logger = Logger.getLogger(OrderMgtClient.class.getName());

    public static void main(String[] args) {

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        // 同步stub
        OrderManagementGrpc.OrderManagementBlockingStub stub = OrderManagementGrpc.newBlockingStub(channel);
        // 异步stub
        OrderManagementGrpc.OrderManagementStub asyncStub = OrderManagementGrpc.newStub(channel);

        // 更新Order
        invokeOrderUpdate(asyncStub);
    }

    private static void invokeOrderUpdate(OrderManagementGrpc.OrderManagementStub asyncStub) {
        OrderManagementOuterClass.Order order = OrderManagementOuterClass.Order
                .newBuilder()
                .setId("102")
                .addItems("iPhone XS").addItems("Mac Book Pro")
                .setDescription("San Jose, CA")
                .setPrice(2300)
                .build();

        OrderManagementOuterClass.Order order1 = OrderManagementOuterClass.Order
                .newBuilder()
                .setId("103")
                .addItems("Mac Book Pro")
                .setDescription("San Jose, CA")
                .setPrice(2100)
                .build();
        OrderManagementOuterClass.Order order2 = OrderManagementOuterClass.Order
                .newBuilder()
                .setId("104")
                .addItems("Google Home Mini")
                .setDescription("Mountain View, CA")
                .setPrice(1900)
                .build();

        final CountDownLatch finishLatch = new CountDownLatch(1);

        StreamObserver<StringValue> updateOrderResponseObserver = new StreamObserver<StringValue>() {
            @Override
            public void onNext(StringValue stringValue) {
                logger.info("调用server的update接口的返回值是：" + stringValue.getValue());
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onCompleted() {
                logger.info("调用server的update接口完成");
                finishLatch.countDown();
            }
        };

        StreamObserver<OrderManagementOuterClass.Order> requestStreamObserver = asyncStub.updateOrders(updateOrderResponseObserver);
        requestStreamObserver.onNext(order);
        requestStreamObserver.onNext(order1);
        requestStreamObserver.onNext(order2);

        if (finishLatch.getCount() == 0) {
            logger.warning("RPC completed or errored before we finished sending.");
            return;
        }

        requestStreamObserver.onCompleted();

        try {
            if (!finishLatch.await(10, TimeUnit.SECONDS)) {
                logger.warning("FAILED : Process orders cannot finish within 10 seconds");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
