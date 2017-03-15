package com.ifyou.aroma.model;

/**
 * Created by Baranov on 10.03.2017.
 */

import java.util.HashMap;
import java.util.Map;

public class TematicSet {

    private String img;
    private String description;
    private String id;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}