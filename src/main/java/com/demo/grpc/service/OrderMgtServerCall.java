package com.demo.grpc.service;

import io.grpc.ForwardingServerCall;
import io.grpc.MethodDescriptor;
import io.grpc.ServerCall;

import java.util.logging.Logger;

/**
 * @author qlx
 * @date 2020/6/13 17:25
 */
public class OrderMgtServerCall<ReqT, RespT> extends ForwardingServerCall.SimpleForwardingServerCall {

    private static final Logger logger = Logger.getLogger(OrderMgtServerCall.class.getName());

    public OrderMgtServerCall(ServerCall<ReqT, RespT> delegate) {
        super(delegate);
    }

    @Override
    protected ServerCall<ReqT, RespT> delegate() {
        return super.delegate();
    }

    @Override
    public MethodDescriptor<ReqT, RespT> getMethodDescriptor() {
        return super.getMethodDescriptor();
    }

    @Override
    public void sendMessage(Object message) {
        logger.info("Message from Service -> Client : " + message);
        super.sendMessage(message);
    }
}
