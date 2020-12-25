package com.zilvinasTamosaitis.furnitureWebStore.service;

import com.zilvinasTamosaitis.furnitureWebStore.model.Product;


import java.util.List;

public interface ProductService {
    List<Product> GetAllProducts();

    void saveProduct(Product product);

    Product getProductById(long id);

    void deleteProductById(long id);
}
