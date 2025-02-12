package org.ecommerce.vendor;

import java.util.List;

import org.ecommerce.products.Product;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Vendor {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  private String name;
  private String phone;
  private String email;
  private String password;
  private String address;

  @OneToMany(cascade = CascadeType.ALL)
  @JsonManagedReference
  private List<Product> products;
  
  public Long getId() {
  return id;
  }

  public String getName() {
  return name;
  }

  public void setName(String name) {
  this.name = name;
  }

  public String getPhone() {
  return phone;
  }

  public void setPhone(String phone) {
  this.phone = phone;
  }

  public String getEmail() {
  return email;
  }

  public void setEmail(String email) {
  this.email = email;
  }

  public String getPassword() {
  return password;
  }

  public void setPassword(String password) {
  this.password = password;
  }

  public String getAddress() {
  return address;
  }

  public void setAddress(String address) {
  this.address = address;
  }

  public List<Product> getProducts() {
     return products;
  }

  public void setProducts(List<Product> products) {
     this.products = products;
  }
  
}
