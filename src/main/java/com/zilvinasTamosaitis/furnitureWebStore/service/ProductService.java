package com.zilvinasTamosaitis.furnitureWebStore.service;

import com.zilvinasTamosaitis.furnitureWebStore.model.Product;
import com.zilvinasTamosaitis.furnitureWebStore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public void addProduct(Product product) {
        Optional<Product> productOptional = productRepository.findProductByTitle(product.getTitle());
        System.out.println(product);
        if (productOptional.isPresent()) {
            throw new IllegalStateException("title taken");
        }
        productRepository.save(product);
    }

    public void deleteProduct(Long productId) {
        boolean exists = productRepository.existsById(productId);
        if (!exists) {
            throw new IllegalStateException(
                    "product with id" + productId + "does not exists");
        }
        productRepository.deleteById(productId);
    }

    @Transactional
    public void updateProduct(Long productId, String title, String category) {
        Product product = productRepository.findById(productId).
                orElseThrow(() -> new IllegalStateException(
                        "product with id " + productId + " does not exists "));
        if (title != null && title.length() > 0 && !Objects.equals(product.getTitle(), title)) {
            product.setTitle(title);
        }
        if (category != null && category.length() > 0 && !Objects.equals(product.getCategory(), category)) {
            Optional<Product> productOptional = productRepository.findProductByTitle(title);
            if (productOptional.isPresent()) {
                throw new IllegalStateException("category taken ");
            }
            product.setCategory(category);
        }
    }

}



