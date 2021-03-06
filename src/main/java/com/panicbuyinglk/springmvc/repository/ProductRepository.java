package com.panicbuyinglk.springmvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.panicbuyinglk.springmvc.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	@Query(value = "SELECT * FROM product p WHERE p.register_user_id = :userId", nativeQuery = true)
	List<Product> getProductsByUser(@Param("userId") int userId);
	
	
	@Query(value = "SELECT * FROM product p WHERE p.product_Id= :productId", nativeQuery = true)
	Product getProductById(@Param("productId") int productId);
	
	@Query(value = "SELECT * FROM product p WHERE status=1", nativeQuery = true)
	List<Product> getActiveProducts();

}
