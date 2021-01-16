package com.zilvinasTamosaitis.furnitureWebStore.controller;


import com.zilvinasTamosaitis.furnitureWebStore.model.Product;
import com.zilvinasTamosaitis.furnitureWebStore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class ProductController {

    @Autowired
    private ProductService productService;

    //  display list of products
    @RequestMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listProducts", productService.GetAllProducts());
        return "index";
    }


    //    show product form
    @GetMapping("/showNewProductForm")
    public String showNewProductForm(Model model) {

//        create model atribute to bind from data

        Product product = new Product();
        model.addAttribute("product", product);
        return "new_product";
    }

    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute("product") Product product) {
//        save product to database
        productService.saveProduct(product);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

//        get product from service
        Product product = productService.getProductById(id);

//        set product as a model attribute to pre-populate the form
        model.addAttribute("product", product);
        return "update_product";
    }

    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable(value = "id") long id) {

//        call delete product method
        this.productService.deleteProductById(id);
        return "redirect:/";

    }
}



