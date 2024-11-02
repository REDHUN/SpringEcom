package com.redhun.SpringEcom.service;

import com.redhun.SpringEcom.model.Products;
import com.redhun.SpringEcom.repo.ProductsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@Service
public class ProductsService {
    @Autowired
    private ProductsRepo repo;
    public List<Products> getAllProducts() {
       return repo.findAll();
    }

    public Products getProduct(int id) {

        return  repo.findById(id).orElse( new Products(-1));
    }

    public Products addProduct(Products product, MultipartFile image) throws IOException {

        product.setImageName(image.getOriginalFilename());
        product.setImageType(image.getContentType());
        product.setImageData(image.getBytes());
        return  repo.save(product);
    }

    public Products updateProduct(Products product, MultipartFile imageFile) throws IOException {

        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());
        return  repo.save(product);
    }

    public void deleteProduct(int id) {
        repo.deleteById(id);
    }

    public List<Products> searchProducts(String keyword) {
        return  repo.searchProducts(keyword);
    }
}
