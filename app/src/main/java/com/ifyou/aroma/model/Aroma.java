package com.ifyou.aroma.model;

/**
 * Created by Baranov on 10.03.2017.
 */

import java.util.HashMap;
import java.util.Map;

public class Aroma {

    private Catalog catalog;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}