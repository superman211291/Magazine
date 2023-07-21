package com.example.magazine;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Repository
@SessionScope
public class ProductBasket {

    private List<Integer> products = new ArrayList<>();

    public void addProduct (List<Integer> products){
        this.products.addAll(products);
    }

    public List<Integer> getProducts(){
        return products;
    }

}
