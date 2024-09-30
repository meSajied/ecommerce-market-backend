package org.ecommerce.orders;

import java.util.List;

import org.ecommerce.customers.Customer;
import org.ecommerce.customers.CustomerRepository;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
class OrderService {
  private final OrderRepository orderRepository;
  private final CustomerRepository customerRepository;
  private final OrderItemRepository orderItemRepository;

  OrderService(OrderRepository orderRepository, 
      CustomerRepository customerRepository, 
      OrderItemRepository orderItemRepository) {
    this.orderRepository = orderRepository;
    this.customerRepository = customerRepository;
    this.orderItemRepository = orderItemRepository;
  }

  List<Order> getAllOrders() {
    return orderRepository.findAll();
  }

  Order create(Order order, Customer customer, List<OrderItem> orderItem) {
    customerRepository.save(customer);
    orderItemRepository.saveAll(orderItem);
    order.setCustomer(customer);
    order.setOrderItems(orderItem);

    return orderRepository.save(order);
  }
}
