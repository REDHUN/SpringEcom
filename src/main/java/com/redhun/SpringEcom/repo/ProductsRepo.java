package com.redhun.SpringEcom.repo;

import com.redhun.SpringEcom.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  ProductsRepo extends JpaRepository <Products,Integer>{
}
