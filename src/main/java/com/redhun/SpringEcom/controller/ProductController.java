package com.redhun.SpringEcom.controller;

import com.redhun.SpringEcom.model.Products;
import com.redhun.SpringEcom.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductsService productsService;

    @GetMapping("/products")
    public ResponseEntity< List<Products>> getProducts(){

        return  new ResponseEntity<>(productsService.getAllProducts(), HttpStatus.ACCEPTED) ;
    }

    @GetMapping("/product/{id}")
    public  ResponseEntity< Products>getProduct(@PathVariable("id") int id){

        Products product=productsService.getProduct(id);
        if(product!=null)
       return new  ResponseEntity<>(product,HttpStatus.OK) ;
        else
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
@PostMapping("/product")
  public ResponseEntity<?> addProduct(@RequestPart Products product, @RequestPart MultipartFile imageFile){

    Products savedProduct= null;
    try {
        savedProduct = productsService.addProduct(product,imageFile);
        return  new ResponseEntity<>(savedProduct,HttpStatus.CREATED);

    } catch (IOException e) {
      return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
}
