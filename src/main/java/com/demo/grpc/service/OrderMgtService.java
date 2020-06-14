package com.demo.grpc.service;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.ServerInterceptors;
import io.grpc.netty.shaded.io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
import io.grpc.netty.shaded.io.netty.handler.ssl.ClientAuth;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Logger;

/**
 * @author qlx
 * @date 2020/6/13 11:03
 */
public class OrderMgtService {

    private static final Logger logger = Logger.getLogger(OrderMgtService.class.getName());

    private Server  server;

    private void start() throws IOException {

        URL certUrl = getClass().getClassLoader().getResource("certs/server.crt");
        URL pemUrl = getClass().getClassLoader().getResource("certs/server.pem");
        URL caUrl = getClass().getClassLoader().getResource("certs/ca.crt");

        File certFile = new File(certUrl.getFile());
        File pemFile = new File(pemUrl.getFile());
        File caFile = new File(caUrl.getFile());

        int port = 50051;
        server = NettyServerBuilder.forPort(port)
                .addService(new OrderMgtServiceImpl())
                .sslContext(GrpcSslContexts.forServer(certFile, pemFile)
                        .trustManager(caFile)
                        .clientAuth(ClientAuth.OPTIONAL)
                        .build())
                .build()
                .start();

        /*server = ServerBuilder.forPort(port)
                .addService(ServerInterceptors.intercept(new OrderMgtServiceImpl(), new OrderMgtServerInterceptor()))
                .build()
                .start();*/

        logger.info("服务器已经打开，正在" + port + "端口监听");

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            logger.info("*** shutting down gRPC server since JVM is shutting down");
            OrderMgtService.this.stop();
            logger.info("*** server shut down");
        }));

    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        final OrderMgtService server = new OrderMgtService();
        server.start();
        server.blockUntilShutdown();
    }
}
