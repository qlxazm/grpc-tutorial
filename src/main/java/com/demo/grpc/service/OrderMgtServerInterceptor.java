package com.demo.grpc.service;

import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;

import java.util.logging.Logger;


/**
 * @author qlx
 * @date 2020/6/13 13:31
 */
public class OrderMgtServerInterceptor implements io.grpc.ServerInterceptor {

    private static final Logger logger = Logger.getLogger(OrderMgtServerInterceptor.class.getName());

    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> call,
                                                                 Metadata headers,
                                                                 ServerCallHandler<ReqT, RespT> serverCallHandler) {
        logger.info("远程过程调用时经过了服务端拦截器 " + call.getMethodDescriptor().getFullMethodName());
        ServerCall<ReqT, RespT> serverCall = new OrderMgtServerCall<>(call);
        return new OrderMgtServerCallListener<>(serverCallHandler.startCall(serverCall, headers));
    }
}
