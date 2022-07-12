package org.snackshop.shop;


import org.snackshop.snack.OrderSnack;
import org.snackshop.snack.SnackController;
import org.snackshop.store.Store;
import org.snackshop.store.StoreController;
import org.snackshop.util.KnapSnack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ShopService {

    @Autowired
    private Shop shop;

    @Autowired
    private StoreController storeController;
    private SnackController snackController = new SnackController();

    public Shop getShop() {
        return shop;
    }

    // On construction, get stores, stock shelves and prepare recommended order.
    @PostConstruct
    public void init() {
        // send Snacks of available stores to SnackController
        storeController.getStores().forEach(store -> {
            snackController.addSnacks(new ArrayList<>(store.getSnacks()));
        });
        // add preferences to Snacks, decided to do this here instead of
        // snackController because a) it depends on the Snacks being fetched from the Stores
        // and b) I did not want to force a trigger within Snack-setting
        snackController.fetchPreferences();
        //set inventory and stores for Shop
        this.shop.inventory = snackController.getSnacks();
        this.shop.stores = storeController.getStores();
    }

    public List<OrderSnack> getRecommendation(int budget, int preference) {
        return KnapSnack.unboundedKnapSNACK(budget, preference, this.shop.inventory);
    }

    public List<Store> getStores() {
        return storeController.getStores();
    }

    public Set<String> getStoreNames() {
        Set<String> nameSet = new HashSet<>();
        this.getStores().forEach(store -> nameSet.add(store.getStoreName()));
        return nameSet;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

}

