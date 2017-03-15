package com.ifyou.aroma.model;

/**
 * Created by Baranov on 10.03.2017.
 */

import java.util.HashMap;
import java.util.Map;

public class Props {

    private String supplier;
    private String value;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
