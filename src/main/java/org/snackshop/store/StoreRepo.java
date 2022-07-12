package org.snackshop.store;


import java.util.ArrayList;
import java.util.List;

public class StoreRepo {

    List<Store> stores = new ArrayList<>();

    public StoreRepo() {
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }

    public List<Store> getStores() {
        return stores;
    }
}


