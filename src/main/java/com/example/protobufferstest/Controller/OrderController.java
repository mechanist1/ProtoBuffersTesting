package com.example.protobufferstest.Controller;

import com.example.protobufferstest.GRPCautogenerated.com.example.grpc.generated.*;
import com.example.protobufferstest.Models.Order;
import com.example.protobufferstest.Service.OrderServiceLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.grpc.StatusRuntimeException;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderServiceLogic orderServiceLogic;

    @Autowired
    public OrderController(OrderServiceLogic orderServiceLogic) {
        this.orderServiceLogic = orderServiceLogic;
    }

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody GrpcOrder grpcOrder) {
        OrderResponse response = orderServiceLogic.createOrder(grpcOrder);
        return ResponseEntity.ok(response.getMessage());
    }
    @GetMapping()
    public ResponseEntity<Page<Order>> getAllUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        return orderServiceLogic.getAllOrders(page, size);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GrpcOrder> getOrder(@PathVariable Long id) {
        OrderRequest request = OrderRequest.newBuilder().setId(id).build();
        try {
            GrpcOrder order = orderServiceLogic.getOrder(request);
            return ResponseEntity.ok(order);
        } catch (StatusRuntimeException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @PutMapping
    public ResponseEntity<String> updateOrder(@RequestBody GrpcOrder grpcOrder) {
        OrderResponse response = orderServiceLogic.updateOrder(grpcOrder);
        return ResponseEntity.ok(response.getMessage());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long id) {
        OrderRequest request = OrderRequest.newBuilder().setId(id).build();
        try {
            OrderResponse response = orderServiceLogic.deleteOrder(request);
            return ResponseEntity.ok(response.getMessage());
        } catch (StatusRuntimeException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @PostMapping("/inventory")
    public ResponseEntity<String> addInventory(@RequestBody GrpcInventory grpcInventory) {
        InventoryResponse response = orderServiceLogic.addInventory(grpcInventory);
        return ResponseEntity.ok(response.getMessage());
    }

    @GetMapping("/inventory/{id}")
    public ResponseEntity<GrpcInventory> getInventory(@PathVariable Long id) {
        InventoryRequest request = InventoryRequest.newBuilder().setId(id).build();
        try {
            GrpcInventory inventory = orderServiceLogic.getInventory(request);
            return ResponseEntity.ok(inventory);
        } catch (StatusRuntimeException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @PutMapping("/inventory")
    public ResponseEntity<String> updateInventory(@RequestBody GrpcInventory grpcInventory) {
        InventoryResponse response = orderServiceLogic.updateInventory(grpcInventory);
        return ResponseEntity.ok(response.getMessage());
    }

    @DeleteMapping("/inventory/{id}")
    public ResponseEntity<String> deleteInventory(@PathVariable Long id) {
        InventoryRequest request = InventoryRequest.newBuilder().setId(id).build();
        try {
            InventoryResponse response = orderServiceLogic.deleteInventory(request);
            return ResponseEntity.ok(response.getMessage());
        } catch (StatusRuntimeException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @PostMapping("/link")
    public ResponseEntity<String> linkOrderToInventory(@RequestBody LinkRequest linkRequest) {
        // This method needs to be implemented in OrderServiceLogic.
        // Assuming a placeholder response for now.
        throw new UnsupportedOperationException("LinkOrderToInventory is not yet implemented.");
    }
}
