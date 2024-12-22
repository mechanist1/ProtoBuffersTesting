package com.example.protobufferstest.Service;

import com.example.protobufferstest.GRPCautogenerated.com.example.grpc.generated.*;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class OrderServiceImpl extends OrderServiceGrpc.OrderServiceImplBase {
    private final OrderServiceLogic orderServiceLogic;

    public OrderServiceImpl(OrderServiceLogic orderServiceLogic) {
        this.orderServiceLogic = orderServiceLogic;
    }

    @Override
    public void createOrder(GrpcOrder request, StreamObserver<OrderResponse> responseObserver) {
        try {
            OrderResponse response = orderServiceLogic.createOrder(request);
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(e);
        }
    }

    @Override
    public void getOrder(OrderRequest request, StreamObserver<GrpcOrder> responseObserver) {
        try {
            GrpcOrder response = orderServiceLogic.getOrder(request);
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(e);
        }
    }

    @Override
    public void updateOrder(GrpcOrder request, StreamObserver<OrderResponse> responseObserver) {
        try {
            OrderResponse response = orderServiceLogic.updateOrder(request);
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(e);
        }
    }

    @Override
    public void deleteOrder(OrderRequest request, StreamObserver<OrderResponse> responseObserver) {
        try {
            OrderResponse response = orderServiceLogic.deleteOrder(request);
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(e);
        }
    }

    @Override
    public void addInventory(GrpcInventory request, StreamObserver<InventoryResponse> responseObserver) {
        try {
            InventoryResponse response = orderServiceLogic.addInventory(request);
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(e);
        }
    }

    @Override
    public void getInventory(InventoryRequest request, StreamObserver<GrpcInventory> responseObserver) {
        try {
            GrpcInventory response = orderServiceLogic.getInventory(request);
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(e);
        }
    }

    @Override
    public void updateInventory(GrpcInventory request, StreamObserver<InventoryResponse> responseObserver) {
        try {
            InventoryResponse response = orderServiceLogic.updateInventory(request);
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(e);
        }
    }

    @Override
    public void deleteInventory(InventoryRequest request, StreamObserver<InventoryResponse> responseObserver) {
        try {
            InventoryResponse response = orderServiceLogic.deleteInventory(request);
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(e);
        }
    }
}
