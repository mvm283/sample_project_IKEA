package io.wms.core.warehouse.model;

import java.util.List;

public class Product {

    private String id;
    private String name;
    private List<Element> containArticles;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Element> getContainArticles() {
        return containArticles;
    }

    public void setContainArticles(List<Element> containArticles) {
        this.containArticles = containArticles;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", containArticles=" + containArticles +
                '}';
    }
}
