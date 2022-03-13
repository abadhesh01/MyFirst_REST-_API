package com.project.app.user.Repository;

import java.util.List;

import com.project.app.user.Entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
     @Query("select p from Product p")
     public List<Product> getAllUserProducts();

}
