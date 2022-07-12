package org.snackshop.shop;

import org.snackshop.snack.Snack;
import org.snackshop.store.Store;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

// Shop component
@Component
public class Shop {

    List<Store> stores = new ArrayList<>();
    List<Snack> inventory = new ArrayList<>(); // not a set because dif. brands/stores might be preference

    public Shop() {
    }

    public List<Store> getStores() {
        return stores;
    }

    public List<Snack> getInventory() {
        return inventory;
    }

}
