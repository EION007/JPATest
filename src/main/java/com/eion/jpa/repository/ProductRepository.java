package com.eion.jpa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.eion.jpa.entity.Product;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
  List<Product> findByName(String name);

  List<Product> findByNameAndDesc(String name, String desc);

  List<Product> findByPriceGreaterThan(Double price);

  List<Product> findByDescContains(String desc);

  List<Product> findByPriceBetween(Double price1, Double price2);

  List<Product> findByDescLike(String desc);

  List<Product> findByIdIn(List<Integer> ids, Pageable pageable);

  Page<Product> findAll(Pageable pageable);

}
