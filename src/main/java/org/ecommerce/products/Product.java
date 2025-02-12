package org.ecommerce.products;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @NotNull(message = "can not be null")
  private String name;

  @NotNull
  private int price;
  @NotNull
  private String description;
  private String stock;

  @Enumerated(EnumType.STRING)
  private ProductStatus status;
  private Long comission;

  @ManyToOne(cascade = CascadeType.ALL)
  @JsonBackReference
  private SubCategory subCategory;

  public SubCategory getSubCategory() {
    return subCategory;
  }

  public void setSubCategory(SubCategory subCategory) {
    this.subCategory = subCategory;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getStock() {
    return stock;
  }

  public void setStock(String stock) {
    this.stock = stock;
  }

  public ProductStatus getStatus() {
    return status;
  }

  public void setStatus(ProductStatus status) {
    this.status = status;
  }

  public Long getComission() {
     return comission;
  }

  public void setComission(Long comission) {
     this.comission = comission;
  }

}
