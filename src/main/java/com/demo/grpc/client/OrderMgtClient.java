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
        invokeOrderProcess(asyncStub);
    }

    private static void invokeOrderProcess(OrderManagementGrpc.OrderManagementStub asyncStub) {

        final CountDownLatch finishLatch = new CountDownLatch(1);

        StreamObserver<OrderManagementOuterClass.CombinedShipment> responseObserver = new StreamObserver<OrderManagementOuterClass.CombinedShipment>() {
            @Override
            public void onNext(OrderManagementOuterClass.CombinedShipment shipment) {
                logger.info("Combined Shipment : " + shipment.getOrderListList());
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onCompleted() {
                logger.info("Order Processing completed!");
                finishLatch.countDown();
            }
        };

        StreamObserver<StringValue> observerProcessRequest = asyncStub.processOrder(responseObserver);
        observerProcessRequest.onNext(StringValue.newBuilder().setValue("101").build());
        observerProcessRequest.onNext(StringValue.newBuilder().setValue("102").build());
        observerProcessRequest.onNext(StringValue.newBuilder().setValue("103").build());
        observerProcessRequest.onNext(StringValue.newBuilder().setValue("104").build());

        if (finishLatch.getCount() == 0) {
            logger.warning("RPC completed or errorted before we finished sending");
            return;
        }
        observerProcessRequest.onCompleted();

        try {
            if (!finishLatch.await(120, TimeUnit.SECONDS)) {
                logger.warning("FAILED: Process orders cannot finish within 60 seconds");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
