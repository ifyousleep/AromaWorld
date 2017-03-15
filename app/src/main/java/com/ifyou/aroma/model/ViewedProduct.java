package com.ifyou.aroma.model;

/**
 * Created by Baranov on 10.03.2017.
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ViewedProduct {

    private String section;
    private List<Product> products = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

