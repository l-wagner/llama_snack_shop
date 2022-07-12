package org.snackshop.snack;

import org.springframework.stereotype.Component;

@Component
public class OrderSnack extends Snack {

    private int amount;

    public  OrderSnack(){
    }

    public OrderSnack(Snack snack) {
        super(snack);
    }

    public OrderSnack(Snack snack, int amount) {
        this(snack);
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}
