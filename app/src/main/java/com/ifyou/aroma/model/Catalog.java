package com.ifyou.aroma.model;

/**
 * Created by Baranov on 10.03.2017.
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Catalog {

    private List<Banner> banners = null;
    private List<Section> sections = null;
    private List<TematicSet> tematicSets = null;
    private List<BestDeal> bestDeals = null;
    private List<ViewedProduct> viewedProducts = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<Banner> getBanners() {
        return banners;
    }

    public void setBanners(List<Banner> banners) {
        this.banners = banners;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public List<TematicSet> getTematicSets() {
        return tematicSets;
    }

    public void setTematicSets(List<TematicSet> tematicSets) {
        this.tematicSets = tematicSets;
    }

    public List<BestDeal> getBestDeals() {
        return bestDeals;
    }

    public void setBestDeals(List<BestDeal> bestDeals) {
        this.bestDeals = bestDeals;
    }

    public List<ViewedProduct> getViewedProducts() {
        return viewedProducts;
    }

    public void setViewedProducts(List<ViewedProduct> viewedProducts) {
        this.viewedProducts = viewedProducts;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
