package org.ecommerce.products;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "category")
    @JsonManagedReference
    private List<SubCategory> subCategories;

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

    public List<SubCategory> getSubCategories() {
      return subCategories;
    }

    public void setSubCategories(List<SubCategory> subCategories) {
      this.subCategories = subCategories;
    }
}
