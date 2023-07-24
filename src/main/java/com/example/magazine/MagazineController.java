package com.example.magazine;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/order")
public class MagazineController {

    private final ProductBasket productBasket;

    public MagazineController(ProductBasket productBasket) {
        this.productBasket = productBasket;
    }
    @GetMapping("/add")
    public String addProduct(@RequestParam String products){
        return productBasket.addProduct(products);
    }

    @GetMapping("/get")
    public String getProduct(){
        return productBasket.getProducts().toString();
    }

}
