package com.demo.grpc.service;

import com.demo.grpc.hello.HelloGrpc;
import com.demo.grpc.hello.HelloRequest;
import com.demo.grpc.hello.HelloResponse;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * @author qlx
 * @date 2020/6/9 23:16
 */
public class HelloServer {

    private static final int PORT = 50051;

    private Server server;

    private void start() throws Exception {
        // 开启服务器
        server = ServerBuilder.forPort(PORT)
                .addService(new HelloIml())
                .build()
                .start();
        System.out.println("服务器已经开启......");

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.err.println("*** 关闭grpc服务端 ***");

                try {
                    HelloServer.this.stop();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.err.println("*** server shut down ***");
            }
        });
    }

    private void stop() throws InterruptedException {
        if (server != null) {
            server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
        }
    }

    private static class HelloIml extends HelloGrpc.HelloImplBase {
        @Override
        public void sayHello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
            HelloResponse response = HelloResponse.newBuilder().setMessage("服务器接收到的客户端的消息是：" + request.getName()).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws Exception{
        HelloServer server = new HelloServer();
        server.start();
        server.blockUntilShutdown();
    }
}
