package org.ecommerce.products;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RequestMapping("/product")
class ProductController {
  private final ProductService productService;

  ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping("/all")
  List<Category> getAllProducts() {
    return productService.getAllProducts();
  }
  
  @PutMapping("/update-status")
  Optional<Product> updateProductStatusToActive(@RequestBody Product product) {
    return productService.updateStatus(product);
  }

}
