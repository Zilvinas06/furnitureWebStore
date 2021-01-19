package com.zilvinasTamosaitis.furnitureWebStore.controller;


import com.zilvinasTamosaitis.furnitureWebStore.model.Product;
import com.zilvinasTamosaitis.furnitureWebStore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/products")
public class ProductController {


    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts(){
        return List.of(new Product("man","kede",1,"efsdf", 2F, "aptrauktas pelvele"));
    }



    @PostMapping("/product/add")
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }

    @DeleteMapping(path = "{productId}")
    public void deleteProduct(@PathVariable("productId") Long productId) {
        productService.deleteProduct(productId);
    }

    @PutMapping(path = "{productId}")
    public void updateProduct(
            @PathVariable("productId") Long productId,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String category) {
        productService.updateProduct(productId, title, category);


    }
}



