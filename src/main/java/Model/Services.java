package Model;

import java.io.Serializable;

public abstract class Services implements Serializable {
    private Double price;
    private Double cost;

    //price getters and setters
    public Double getPrice() {
        return this.price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

    //cost getters and setters
    public Double getCost() {
        return this.cost;
    }
    public void setCost(Double cost) {
        this.cost = cost;
    }
}
