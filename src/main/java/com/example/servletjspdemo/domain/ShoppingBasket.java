package com.example.servletjspdemo.domain;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class ShoppingBasket {

    Map<Integer, Delivery> basketItems;

    public ShoppingBasket(){
        basketItems = new HashMap<Integer, Delivery>();

    }

    public Map<Integer, Delivery> getBasketItems(){
        return basketItems;
    }

    public void addToBasket(Integer id, Delivery del){
        basketItems.put(id, del);
    }

    public void removeFromBasket(Integer id) {
    	basketItems.remove(id);
    }
}
