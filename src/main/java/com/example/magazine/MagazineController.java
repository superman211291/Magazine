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

        try {
            List<Integer> products1 = Arrays.stream(products.split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            productBasket.addProduct(products1);
        }catch (IllegalArgumentException e){
            return "Illegal argument";
        }
        return "Product is added.";
    }

    @GetMapping("/get")
    public String getProduct(){
        return productBasket.getProducts().toString();
    }

}
