package com.demo.grpc.client;

import com.google.protobuf.StringValue;
import ecommerce.OrderManagementGrpc;
import ecommerce.OrderManagementOuterClass;
import io.grpc.*;
import io.grpc.netty.shaded.io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder;
import io.grpc.netty.shaded.io.netty.handler.ssl.SslContext;

import javax.net.ssl.SSLException;
import java.io.File;
import java.net.URL;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * @author qlx
 * @date 2020/6/13 10:17
 */
public class OrderMgtClient {

    private static final Logger logger = Logger.getLogger(OrderMgtClient.class.getName());

    public static void main(String[] args) throws SSLException {

        URL url = OrderMgtClient.class.getClassLoader().getResource("certs/server.crt");
        File certFile = new File(url.getFile());
        SslContext sslContext = GrpcSslContexts
                .forClient()
                .trustManager(certFile)
                .build();

        // 使用TSL保护程序
        ManagedChannel channel = NettyChannelBuilder.forAddress("localhost", 50051)
                .useTransportSecurity()
                .sslContext(sslContext)
                .build();

       /* ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();*/

        Channel channel1 = ClientInterceptors.intercept(channel, new OrderClientInterceptor());

        // 同步stub
        OrderManagementGrpc.OrderManagementBlockingStub stub = OrderManagementGrpc
                .newBlockingStub(channel1);
//                .withDeadlineAfter(1000, TimeUnit.MILLISECONDS);
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
        try {
            StringValue result = stub.addOrder(order);
            logger.info("添加了一个订单之后的结果" + result);
        } catch (StatusRuntimeException e) {
            /* 演示deadline
            if (e.getStatus().getCode() == Status.Code.DEADLINE_EXCEEDED) {
                logger.warning("预期时间内没有调用结束");
            } */
            logger.warning("client察觉到server出错，出错信息是：" + e.getMessage());
        }

       /* StringValue orderId = StringValue.newBuilder().setValue("103").build();
        OrderManagementOuterClass.Order order1 = stub.getOrder(orderId);
        logger.info("从server获取的订单的数据是：" + order1.getDescription());*/
    }
}
