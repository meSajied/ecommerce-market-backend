package org.ecommerce.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"org.ecommerce.products", 
		"org.ecommerce.customers", "org.ecommerce.orders", "org.ecommerce.vendor"})
		
@EntityScan(basePackages = {"org.ecommerce.products", 
		"org.ecommerce.customers", "org.ecommerce.orders", 
		"org.ecommerce.admin", "org.ecommerce.vendor"})

@EnableJpaRepositories(basePackages = {"org.ecommerce.products", 
		"org.ecommerce.customers", "org.ecommerce.orders", "org.ecommerce.vendor"})
public class EcommerceMarketBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceMarketBackendApplication.class, args);
	}

}
