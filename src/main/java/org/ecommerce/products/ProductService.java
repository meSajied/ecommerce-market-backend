package org.ecommerce.products;

import java.util.List;
import java.util.Optional;

import org.hibernate.mapping.Collection;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
class ProductService {
  private final CategoryRepository categoryRepository;
  private final ProductRepository productRepository;

  ProductService(CategoryRepository categoryRepository, 
      ProductRepository productRepository) {
    this.categoryRepository = categoryRepository;
    this.productRepository = productRepository;
  }

  List<Category> getAllProducts() {
    return categoryRepository.findAll();
  }

  Optional<Product> updateStatus(Product product) {
    return productRepository.findById(product.getId()).map(existingData -> {
      return updateData(existingData, product);
    });
  }

  private Product updateData(Product existingData, Product newData) {
    System.out.println("Updating product status: " + newData.getStatus());
    existingData.setStatus(newData.getStatus());
    
    return productRepository.save(existingData);
  }
}
