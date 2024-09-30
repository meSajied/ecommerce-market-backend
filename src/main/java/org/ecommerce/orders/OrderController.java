package org.ecommerce.orders;

import org.ecommerce.customers.Customer;
import org.ecommerce.customers.CustomerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
class OrderController {
  private final OrderService orderService;

  OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  @GetMapping("/list")
  List<Order> getList() {
    return orderService.getAllOrders();
  }

  @PostMapping("/create")
  Order create(@RequestPart Order order, 
      @RequestPart("customer") Customer customer, @RequestPart("orderItem") List<OrderItem> orderItem) {
    
    return orderService.create(order, customer, orderItem);
  }
}
