package com.ifyou.aroma.model;

/**
 * Created by Baranov on 10.03.2017.
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Subsection {

    private String sectionID;
    private String name;
    private List<Item> items = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getSectionID() {
        return sectionID;
    }

    public void setSectionID(String sectionID) {
        this.sectionID = sectionID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
