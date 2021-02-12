package com.order.order.domain.order;

import javax.persistence.Embeddable;
import javax.persistence.SecondaryTable;
import java.io.Serializable;

@Embeddable
public class Status implements Serializable {
    private boolean checkout;
    private double value;

    public Status(boolean checkout, long total) {
        this.checkout = checkout;
        value = total;
    }

    public Status() {
        checkout = false;
        value = 0;
    }

    public boolean isCheckout() {
        return checkout;
    }

    public void setCheckout(boolean checkout) {
        this.checkout = checkout;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
