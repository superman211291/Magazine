package com.example.magazine;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@SessionScope
public class ProductBasket {

    private List<Integer> products = new ArrayList<>();

    public String addProduct (String products){
        try {
            List<Integer> products1 = Arrays.stream(products.split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            this.products.addAll(products1);
        }catch (IllegalArgumentException e){
            return "Illegal argument";
        }
        return "Product is added.";
    }

    public List<Integer> getProducts(){
        return products;
    }

}
