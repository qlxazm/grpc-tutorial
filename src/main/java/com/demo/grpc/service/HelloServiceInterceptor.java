package com.demo.grpc.service;

import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;

import java.util.logging.Logger;

/**
 * @author qlx
 * @date 2020/6/13 8:00
 */
public class HelloServiceInterceptor implements io.grpc.ServerInterceptor {

    private static final Logger log = Logger.getLogger(HelloServiceInterceptor.class.getName());

    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> serverCall, Metadata metadata, ServerCallHandler<ReqT, RespT> serverCallHandler) {
        return null;
    }
}
