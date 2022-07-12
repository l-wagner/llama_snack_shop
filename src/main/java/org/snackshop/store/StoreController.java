package org.snackshop.store;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Set;

@Component
public class StoreController {

    private static final String STORE_URL = "http://45.55.41.44:8080/stores";
    private static final String SNACKSTORE_URL = "http://45.55.41.44:8080/snackStore";

    @Autowired
    private StoreService storeService = new StoreService();

    @PostConstruct
    public void init() {
        storeService.init(STORE_URL,SNACKSTORE_URL);
    }

    public List<Store> getStores() {
        return storeService.getStores();
    }

    public Set<String> getStoreNames() {
        return storeService.getStoreNames();
    }

}