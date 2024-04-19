package vn.id.quanghuydevfs.drcomputer.controller.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.id.quanghuydevfs.drcomputer.dto.order.OrderDto;
import vn.id.quanghuydevfs.drcomputer.exception.ResourceNotFoundException;
import vn.id.quanghuydevfs.drcomputer.model.order.Order;
import vn.id.quanghuydevfs.drcomputer.repository.OrderRepository;
import vn.id.quanghuydevfs.drcomputer.service.OrderService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/order")
public class OrderController {
    @Autowired
    private OrderService service;
    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("")
    public ResponseEntity<List<Order>> getOrders() {
        var orders = service.getOrders();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable long id) {
        var order = service.getOrderById(id);
        return ResponseEntity.ok(order);
    }

    @PostMapping("/create")
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderDto orderDto) throws ResourceNotFoundException {
        return ResponseEntity.ok(service.createOrder(orderDto));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteOrder(long id) {
        return ResponseEntity.ok(service.delete(id));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/myorder/{email}")
    public ResponseEntity<?> myOrder(@PathVariable String email) {
        List<Order> orders = orderRepository.findAllByUserEmail(email);
        return ResponseEntity.ok(orders);
    }
}
