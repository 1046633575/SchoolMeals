package com.jh.user.cart;

import com.jh.entity.Food;
import com.jh.entity.Food;

import java.math.BigDecimal;

public class CartItem {

    private Food food;
    private int count;

    public double getSubtotal(){
        BigDecimal d1 = new BigDecimal(food.getPrice() + "");
        BigDecimal d2 = new BigDecimal(count + "");
        return d1.multiply(d2).doubleValue();
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
