package org.snackshop.snack;


import java.util.List;

public class SnackController {

    private static final String LLAMA_URL = "http://45.55.41.44:8080/llama";

    private SnackService snackService = new SnackService();

    public List<Snack> getSnacks() {
        return snackService.getSnacks();
    }

    public void setSnacks(List<Snack> snacks) {
        snackService.setSnacks(snacks);
    }

    public void addSnacks(List<Snack> snacks) {
        snackService.addSnacks(snacks);
    }

    public void fetchPreferences() {
        snackService.fetchPreferences(LLAMA_URL);
    }

}