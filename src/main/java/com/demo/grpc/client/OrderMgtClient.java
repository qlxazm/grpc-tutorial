package com.demo.grpc.client;

import com.google.protobuf.StringValue;
import ecommerce.OrderManagementGrpc;
import ecommerce.OrderManagementOuterClass;
import io.grpc.Channel;
import io.grpc.ClientInterceptors;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

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

        Channel channel1 = ClientInterceptors.intercept(channel, new OrderClientInterceptor());

        // 同步stub
        OrderManagementGrpc.OrderManagementBlockingStub stub = OrderManagementGrpc.newBlockingStub(channel1);
        // 异步stub
        OrderManagementGrpc.OrderManagementStub asyncStub = OrderManagementGrpc.newStub(channel);

        OrderManagementOuterClass.Order order = OrderManagementOuterClass.Order
                .newBuilder()
                .setId("101")
                .addItems("iPhone XS").addItems("Mac Book Pro")
                .setDescription("San Jose, CA")
                .setPrice(2300)
                .build();

        // 添加一个订单
        StringValue result = stub.addOrder(order);
        logger.info("添加了一个订单之后的结果" + result);

        StringValue orderId = StringValue.newBuilder().setValue("103").build();
        OrderManagementOuterClass.Order order1 = stub.getOrder(orderId);
        logger.info("从server获取的订单的数据是：" + order1.getDescription());
    }
}
