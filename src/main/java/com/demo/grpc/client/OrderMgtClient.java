package com.demo.grpc.client;

import com.google.protobuf.StringValue;
import ecommerce.OrderManagementGrpc;
import ecommerce.OrderManagementOuterClass;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Iterator;
import java.util.logging.Logger;

/**
 * @author qlx
 * @date 2020/6/13 10:17
 */
public class OrderMgtClient {

    private static final Logger logger = Logger.getLogger(OrderMgtClient.class.getName());

    public static void main(String[] args) {

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        // 同步stub
        OrderManagementGrpc.OrderManagementBlockingStub stub = OrderManagementGrpc.newBlockingStub(channel);
        // 异步stub
        OrderManagementGrpc.OrderManagementStub asyncStub = OrderManagementGrpc.newStub(channel);


        // 查询一个订单
        StringValue searchText = StringValue.newBuilder().setValue("Google").build();

        Iterator<OrderManagementOuterClass.Order> iter = stub.searchOrders(searchText);
        while (iter.hasNext()) {
            OrderManagementOuterClass.Order order = iter.next();
            logger.info("从server获取的订单的数据是：" + order.getItemsList());
        }
    }
}
