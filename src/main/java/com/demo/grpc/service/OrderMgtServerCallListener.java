package com.demo.grpc.service;

import io.grpc.ForwardingServerCall;
import io.grpc.ForwardingServerCallListener;
import io.grpc.ServerCall;

import java.util.logging.Logger;

/**
 * @author qlx
 * @date 2020/6/13 17:31
 */
public class OrderMgtServerCallListener<R> extends ForwardingServerCallListener<R> {

    private static final Logger logger = Logger.getLogger(OrderMgtServerCallListener.class.getName());

    private final ServerCall.Listener<R> delegate;

    public OrderMgtServerCallListener(ServerCall.Listener<R> delegate) {
        this.delegate = delegate;
    }

    @Override
    protected ServerCall.Listener<R> delegate() {
        return delegate;
    }

    @Override
    public void onMessage(R message) {
        logger.info("Message Received from Client -> Service " + message);
        super.onMessage(message);
    }
}
