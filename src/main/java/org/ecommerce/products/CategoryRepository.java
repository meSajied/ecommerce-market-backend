package org.ecommerce.products;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface CategoryRepository extends JpaRepository<Category, Integer> {
  /*
  @Query("SELECT DISTINCT c FROM Category c " +
  "JOIN c.subCategories sc "+
  "JOIN Product p ON sc.id = p.id WHERE p.status = 'ACTIVE'")
  List<Category> findProductByActiveStatus();
  */
}
