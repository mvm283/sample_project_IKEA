package io.wms.core.warehouse.model;

public class Element {
    private String artId;
    private String amountOf;

    public String getArtId() {
        return artId;
    }

    public void setArtId(String artId) {
        this.artId = artId;
    }

    public String getAmountOf() {
        return amountOf;
    }

    public void setAmountOf(String amountOf) {
        this.amountOf = amountOf;
    }

    @Override
    public String toString() {
        return "Element{" +
                "artId='" + artId + '\'' +
                ", amountOf='" + amountOf + '\'' +
                '}';
    }
}
