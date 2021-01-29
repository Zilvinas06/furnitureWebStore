package com.zilvinasTamosaitis.furnitureWebStore.products;


import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;


    @GetMapping(path = "/getAll")
    public List<Product> getProducts() {
        return productRepository.findAll();

    }

    @GetMapping(path = "/getProductByTitle/{id}")
    public String getProductByTitle(@PathVariable Long id) {
        productRepository.findById(id);
        return "this product ";
    }


    @PostMapping("/add")
    public String addProduct(@RequestBody Product product) {
        productRepository.save(product);
        return "product added" + product.getTitle();
    }

    @DeleteMapping(path = "{productId}")
    public void deleteProduct(@PathVariable("productId") Long productId) {
        productRepository.deleteById(productId);
    }

    @PutMapping("/update/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable( "productId") Long productId)
            throws ResourceNotFoundException {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));
        product.setTitle(product.getTitle());
        product.setCategory(product.getCategory());
        product.setPrice(product.getPrice());
        product.setMake(product.getMake());
        product.setPicByte(product.getPicByte());
        product.setType(product.getType());
        final Product updatedProduct = productRepository.save(product);
        return ResponseEntity.ok(updatedProduct);

    }
}


