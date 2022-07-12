package org.snackshop.store;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.snackshop.snack.Snack;

import java.util.Set;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Store {

    String storeName;
    // Set as Snacks are equal for price and name per store
     Set<Snack> snacks;

    protected Store() {
    }

    public Store(String storeName) {
        this.storeName = storeName;
    }

    public Store(String storeName, Set<Snack> snacks) {
        this.storeName = storeName;
        this.snacks = snacks;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Set<Snack> getSnacks() {
        return snacks;
    }

    public void setSnacks(Set<Snack> snacks) {
        this.snacks = snacks;
    }


}
