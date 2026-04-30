package com.shashank;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
// if we not use @Embeddable then hibernate cannot determine jdbc type of laptop
// Using embeddable it will merge the fields of employee and laptop and create a table
// note - still all those annotations of entity is valid like @Column
@Embeddable
public class Laptop {
    int lID;
//    @Column(name="laptop_model")
    String model;

    public int getlID() {
        return lID;
    }

    public void setlID(int lID) {
        this.lID = lID;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "lID=" + lID +
                ", model='" + model + '\'' +
                '}';
    }
}
