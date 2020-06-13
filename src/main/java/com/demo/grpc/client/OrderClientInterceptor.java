package com.demo.grpc.client;

import com.demo.grpc.service.OrderMgtServerInterceptor;
import io.grpc.*;

import java.util.logging.Logger;

/**
 * @author qlx
 * @date 2020/6/13 21:00
 */
public class OrderClientInterceptor implements ClientInterceptor {

    private static final Logger logger = Logger.getLogger(OrderMgtServerInterceptor.class.getName());

    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> methodDescriptor,
                                                               CallOptions callOptions,
                                                               Channel channel) {
        return new ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT>(channel.newCall(methodDescriptor, callOptions)) {
            @Override
            public void start(Listener<RespT> responseListener, Metadata headers) {
                logger.info("client发送到server......");
                super.start(new ForwardingClientCallListener.SimpleForwardingClientCallListener<RespT>(responseListener) {
                    @Override
                    public void onMessage(RespT message) {
                        logger.info("client拦截到的从server发送过来的信息" + message);
                        super.onMessage(message);
                    }
                }, headers);
            }
        };
    }
}
