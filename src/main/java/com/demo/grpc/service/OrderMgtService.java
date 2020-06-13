package com.demo.grpc.service;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * @author qlx
 * @date 2020/6/13 11:03
 */
public class OrderMgtService {

    private static final Logger logger = Logger.getLogger(OrderMgtService.class.getName());

    private Server  server;

    private void start() throws IOException {
        int port = 50051;
        server = ServerBuilder.forPort(port)
                .addService(new OrderMgtServiceImpl())
                .build()
                .start();

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
