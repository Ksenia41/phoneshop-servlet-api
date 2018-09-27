package com.es.phoneshop.model.compare;

import com.es.phoneshop.model.Product;

import java.util.ArrayList;
import java.util.List;

public class Compare {
    private List<Product> compareProducts = new ArrayList<>();

    public List<Product> getCompareProducts() {
        return compareProducts;
    }

    public void setCompareProducts(List<Product> compareProducts) {
        this.compareProducts = compareProducts;
    }
}
