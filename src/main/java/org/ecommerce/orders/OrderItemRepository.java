package org.ecommerce.orders;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
  
}
