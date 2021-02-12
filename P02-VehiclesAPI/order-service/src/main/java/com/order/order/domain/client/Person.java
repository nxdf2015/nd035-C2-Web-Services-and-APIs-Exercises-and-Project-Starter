package com.order.order.domain.client;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class Person implements Serializable {

    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
