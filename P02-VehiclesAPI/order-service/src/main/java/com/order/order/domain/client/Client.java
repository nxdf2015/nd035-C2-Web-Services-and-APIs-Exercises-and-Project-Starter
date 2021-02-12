package com.order.order.domain.client;

import com.order.order.domain.order.Order;
import com.order.order.domain.order.Status;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clients")

public class Client {

    @EmbeddedId
    Person person;

    @OneToMany
    private List<Order> orders;

    @Embedded
    private Status status;

    public Client() {

        status = new Status();
        orders = new ArrayList<>();
    }

    public static Client from(Person person) {
        Client client = new Client();
        client.setPerson(person);
        return client;
    }

    public void add(Order order){


        if (!orders.contains(order)){
            orders.add(order);
        }
        else {

            orders.remove(order);
            orders.add(order);
        }


    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }


    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }


    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void resetOrder() {
        orders = new ArrayList<>();
    }


}
