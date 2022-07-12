package org.snackshop.store;

import org.snackshop.snack.Snack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
public class StoreService {

    private StoreRepo storeRepository = new StoreRepo();

     void init(String stores_url, String snackstore_url) {
        this.storeRepository.setStores(fetchStores(stores_url));
        this.storeRepository.stores.forEach(store -> fetchSnacks(snackstore_url, store));
    }

    private List<Store> fetchStores(String url) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Store>> response = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Store>>() {
        });
        return response.getBody();
    }

    // fetching Snacks from Stores
    public void fetchSnacks(String url, Store store) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Snack>> response =
                restTemplate.exchange
                        (url + "?name=" + store.getStoreName(),
                                HttpMethod.GET,
                                null,
                                new ParameterizedTypeReference<List<Snack>>() {
                                });

        Set<Snack> snackSet = new HashSet<Snack>();
        Objects.requireNonNull(response.getBody())
                .forEach(responseSnack -> snackSet
                        .add(new Snack(responseSnack, store.storeName)));
        store.setSnacks(snackSet);
    }

    public List<Store> getStores() {
        return storeRepository.getStores();
    }

    public Set<String> getStoreNames() {
        Set<String> nameSet = new HashSet<>();
        storeRepository.getStores().forEach(store -> nameSet.add(store.getStoreName()));
        return nameSet;
    }
}
