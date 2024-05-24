package com.realProject.salesManagement.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.realProject.salesManagement.Entity.Product;
import java.util.List;

@Repository
public interface ProductJparepo extends JpaRepository<Product, Integer> {
List<Product> findByCategory(String category);
}
