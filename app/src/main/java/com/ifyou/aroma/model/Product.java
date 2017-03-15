package com.ifyou.aroma.model;

/**
 * Created by Baranov on 10.03.2017.
 */


import java.util.HashMap;
import java.util.Map;

public class Product {

    private String articul;
    private String nameOriginal;
    private Object img;
    private String nameRus;
    private Float price;
    private Integer actionDiscount;
    private String currency;
    private Props props;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getArticul() {
        return articul;
    }

    public void setArticul(String articul) {
        this.articul = articul;
    }

    public String getNameOriginal() {
        return nameOriginal;
    }

    public void setNameOriginal(String nameOriginal) {
        this.nameOriginal = nameOriginal;
    }

    public Object getImg() {
        return img;
    }

    public void setImg(Object img) {
        this.img = img;
    }

    public String getNameRus() {
        return nameRus;
    }

    public void setNameRus(String nameRus) {
        this.nameRus = nameRus;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getActionDiscount() {
        return actionDiscount;
    }

    public void setActionDiscount(Integer actionDiscount) {
        this.actionDiscount = actionDiscount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Props getProps() {
        return props;
    }

    public void setProps(Props props) {
        this.props = props;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
