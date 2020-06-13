package com.demo.grpc.service;

import com.google.common.base.Objects;
import com.google.common.collect.Maps;
import com.google.protobuf.StringValue;
import ecommerce.OrderManagementGrpc;
import ecommerce.OrderManagementOuterClass;
import io.grpc.stub.StreamObserver;

import java.util.Map;
import java.util.Random;
import java.util.logging.Logger;

/**
 * @author qlx
 * @date 2020/6/13 8:47
 */
public class OrderMgtServiceImpl extends OrderManagementGrpc.OrderManagementImplBase {

    private static final Logger logger = Logger.getLogger(OrderMgtServiceImpl.class.getName());

    private OrderManagementOuterClass.Order order1 = OrderManagementOuterClass.Order
            .newBuilder()
            .setId("102")
            .addItems("Google Pixel 3A").addItems("Mac Book Pro")
            .setDescription("Mountain View, CA")
            .setPrice(1800)
            .build();

    private OrderManagementOuterClass.Order order2 = OrderManagementOuterClass.Order
            .newBuilder()
            .setId("103")
            .addItems("Apple Watch S4")
            .setDescription("San Jose, CA")
            .setPrice(400)
            .build();

    private OrderManagementOuterClass.Order order3 = OrderManagementOuterClass.Order
            .newBuilder()
            .setId("104")
            .addItems("Google Home Mini").addItems("Google Nest Hub")
            .setDescription("Mountain View, CA")
            .setPrice(400)
            .build();

    private OrderManagementOuterClass.Order order4 = OrderManagementOuterClass.Order
            .newBuilder()
            .setId("105")
            .addItems("Amazon Echo")
            .setDescription("San Jose, CA")
            .setPrice(30)
            .build();

    private OrderManagementOuterClass.Order order5 = OrderManagementOuterClass.Order.newBuilder()
            .setId("106")
            .addItems("Amazon Echo").addItems("Apple iPhone XS")
            .setDestination("Mountain View, CA")
            .setPrice(300)
            .build();

    private Map<String, OrderManagementOuterClass.Order> orderMap = Maps.newHashMap();

    {
        orderMap.put(order1.getId(), order1);
        orderMap.put(order2.getId(), order2);
        orderMap.put(order3.getId(), order3);
        orderMap.put(order4.getId(), order4);
        orderMap.put(order5.getId(), order5);

    }
    @Override
    public void addOrder(OrderManagementOuterClass.Order request, StreamObserver<StringValue> responseObserver) {
        logger.info("添加编号为" + request.getId() + "的订单");
        orderMap.put(request.getId(), request);
        StringValue id = StringValue.newBuilder().setValue(request.getId()).build();
        responseObserver.onNext(id);
        responseObserver.onCompleted();
    }

    @Override
    public void getOrder(StringValue request, StreamObserver<OrderManagementOuterClass.Order> responseObserver) {

        OrderManagementOuterClass.Order order = orderMap.get(request.getValue());
        if (!Objects.equal(order, null)) {
            logger.info("获取到了编号为" + request.getValue() + "的订单的信息");
            responseObserver.onNext(order);
            responseObserver.onCompleted();
        } else {
            logger.info("没有编号为" + request.getValue() + "的订单的信息");
            responseObserver.onCompleted();
        }
    }

    private Map<String, OrderManagementOuterClass.CombinedShipment> combinedShipmentMap = Maps.newHashMap();
    private static final int BATCH_SIZE = 3;

    @Override
    public StreamObserver<StringValue> processOrder(StreamObserver<OrderManagementOuterClass.CombinedShipment> responseObserver) {
        return new StreamObserver<StringValue>() {
            int batchMarker = 0;
            @Override
            public void onNext(StringValue value) {
                logger.info("处理的orderId是：" + value.getValue());
                OrderManagementOuterClass.Order currentOrder = orderMap.get(value.getValue());
                if (currentOrder == null) {
                    logger.info("No order found. ID " + value.getValue());
                    return;
                }

                batchMarker++;
                String orderDestination = currentOrder.getDestination();
                OrderManagementOuterClass.CombinedShipment existsShipment = combinedShipmentMap.get(orderDestination);
                if (existsShipment != null) {
                    existsShipment = OrderManagementOuterClass.CombinedShipment
                            .newBuilder(existsShipment)
                            .addOrderList(currentOrder)
                            .build();
                    combinedShipmentMap.put(orderDestination, existsShipment);
                } else {
                    OrderManagementOuterClass.CombinedShipment shipment = OrderManagementOuterClass.CombinedShipment
                            .newBuilder()
                            .build();
                    shipment.newBuilderForType()
                            .addOrderList(currentOrder)
                            .setId("CMB-" + new Random().nextInt(1000) + ":" + currentOrder.getDestination())
                            .setStatus("Processed!")
                            .build();
                    combinedShipmentMap.put(currentOrder.getDestination(), shipment);
                }

                if (batchMarker == BATCH_SIZE) {
                    for (Map.Entry<String, OrderManagementOuterClass.CombinedShipment> entry : combinedShipmentMap.entrySet()) {
                        responseObserver.onNext(entry.getValue());
                    }
                    batchMarker = 0;
                    combinedShipmentMap.clear();
                }
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onCompleted() {
                for (Map.Entry<String, OrderManagementOuterClass.CombinedShipment> entry : combinedShipmentMap.entrySet()) {
                    responseObserver.onNext(entry.getValue());
                }
                responseObserver.onCompleted();
            }
        };
    }
}
