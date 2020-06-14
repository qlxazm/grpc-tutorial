package com.demo.grpc.client;

import com.google.protobuf.StringValue;
import ecommerce.OrderManagementGrpc;
import ecommerce.OrderManagementOuterClass;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.netty.shaded.io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder;
import io.grpc.netty.shaded.io.netty.handler.ssl.SslContext;

import javax.net.ssl.SSLException;
import java.io.File;
import java.net.URL;
import java.util.logging.Logger;

/**
 * @author qlx
 * @date 2020/6/13 10:17
 */
public class OrderMgtClient {

    private static final Logger logger = Logger.getLogger(OrderMgtClient.class.getName());

    public static void main(String[] args) throws SSLException {

        URL certUrl = OrderMgtClient.class.getClassLoader().getResource("certs/client.crt");
        URL pemUrl = OrderMgtClient.class.getClassLoader().getResource("certs/client.pem");
        URL caUrl = OrderMgtClient.class.getClassLoader().getResource("certs/ca.crt");

        File certFile = new File(certUrl.getFile());
        File pemFile = new File(pemUrl.getFile());
        File caFile = new File(caUrl.getFile());

        SslContext sslContext = GrpcSslContexts
                .forClient()
                .trustManager(caFile)
                .keyManager(certFile, pemFile)
                .build();
        ManagedChannel channel = NettyChannelBuilder.forAddress("localhost", 50051)
                .useTransportSecurity()
                .sslContext(sslContext)
                .build();


        /*ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();*/

        // 同步stub
        OrderManagementGrpc.OrderManagementBlockingStub stub = OrderManagementGrpc.newBlockingStub(channel);
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
