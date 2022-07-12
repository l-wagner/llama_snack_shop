package org.snackshop.snack;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

public class SnackControllerTest {
    private static final String LLAMA_URL = "http://45.55.41.44:8080/llama";

    private SnackService snackService = new SnackService();

    @Test
    public void snackController_FetchesPreferences() {
        List<Snack> snacks = new ArrayList<>();
        snacks.add(new Snack("Health Bars", 4, "Atlantis"));
        snacks.add(new Snack("Captain Crunch Munchers", 2, "Atlantis"));
        snacks.add(new Snack("Homemade Oreos", 9, "Artisanal Beards and Snacks"));

        snackService.setSnacks(snacks);
        snackService.fetchPreferences(LLAMA_URL);

        snackService.getSnacks().forEach(snack -> {
            assertThat(snack.getPreferenceScore()).isGreaterThan(0);
        });
    }

    @Test
    public void snackController_addsSnacksToRepo() {
        List<Snack> snacks = new ArrayList<>();
        snacks.add(new Snack("Health Bars", 4, "Atlantis"));
        snacks.add(new Snack("Captain Crunch Munchers", 2, "Atlantis"));
        snackService.setSnacks(snacks);
        assertThat(snackService.getSnacks().size()).isEqualTo(2);

        List<Snack> snacks2 = new ArrayList<>();
        snacks2.add(new Snack("Bananas", 4, "Mr Lemon"));
        snacks2.add(new Snack("Nectarines", 2, "Mr Lemon"));
        snackService.addSnacks(snacks2);
        assertThat(snackService.getSnacks().size()).isEqualTo(4);


    }
}
