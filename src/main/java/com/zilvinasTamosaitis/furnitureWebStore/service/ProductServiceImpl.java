package com.zilvinasTamosaitis.furnitureWebStore.service;

import com.sun.xml.bind.v2.model.core.ID;
import com.zilvinasTamosaitis.furnitureWebStore.controller.ProductController;
import com.zilvinasTamosaitis.furnitureWebStore.model.Product;
import com.zilvinasTamosaitis.furnitureWebStore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public List<Product> GetAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void saveProduct(Product product) {
        this.productRepository.save(product);
    }

    @Override
    public Product getProductById(long id) {
        Optional<Product> optional = productRepository.findById(id);
        Product product = null;
        if (optional.isPresent()) {
            product = optional.get();
        } else {
            throw new RuntimeException("Product not found for id :: " + id);
        }
        return product;
    }

    @Override
    public void deleteProductById(long id) {
        this.productRepository.deleteById(id);
    }

}
