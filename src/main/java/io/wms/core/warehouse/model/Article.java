package io.wms.core.warehouse.model;

public class Article {
    private String externalId;
    private String Id;
    private String name;
    private String stock;

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Article{" +
                "externalId='" + externalId + '\'' +
                ", Id='" + Id + '\'' +
                ", name='" + name + '\'' +
                ", stock='" + stock + '\'' +
                '}';
    }
}
