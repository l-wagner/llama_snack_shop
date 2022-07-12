package org.snackshop.snack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Service
public class SnackService {

    private SnackRepo snackRepo = new SnackRepo();

    public List<Snack> getSnacks() {
        return snackRepo.snacks;
    }

    void setSnacks(List<Snack> snacks) {
        snackRepo.snacks = snacks;
    }

     void addSnacks(List<Snack> snacks) {
        snackRepo.addSnacks(snacks);
    }

    void fetchPreferences(String url) {
        RestTemplate restTemplate = new RestTemplate();
        snackRepo.snacks.forEach(snack -> {
                    Snack response =
                            restTemplate.getForObject(
                                    url + "?snack=" + snack.getName(),
                                    Snack.class);
                    snack.setPreferenceScore(Objects.requireNonNull(response).getPreferenceScore());
                }
        );
    }
}
