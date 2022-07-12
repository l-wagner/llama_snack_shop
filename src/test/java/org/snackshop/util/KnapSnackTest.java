package org.snackshop.util;

import org.junit.Test;

import org.snackshop.snack.OrderSnack;
import org.snackshop.snack.Snack;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

public class KnapSnackTest {

    @Test
    public void knapSnack_shouldReturnOrder() throws Exception {
        List<Snack> inventory = new ArrayList<>();

        int budget = 42;
        int minPreference = 30;
        inventory.add(new Snack("Health Bars", 4, "Atlantis", 1));
        inventory.add(new Snack("Captain Crunch Munchers", 2, "Atlantis", 2));
        inventory.add(new Snack("Homemade Oreos", 9, "Artisanal Beards and Snacks", 3));
        inventory.add(new Snack("Acai Lolipops", 8, "Artisanal Beards and Snacks", 2));
        inventory.add(new Snack("Our Take on Gummy Bears", 14, "Artisanal Beards and Snacks", 40));

        List<OrderSnack> actual = KnapSnack.unboundedKnapSNACK(budget, minPreference, inventory);
        List<OrderSnack> expected = new ArrayList<>();
        expected.add(new OrderSnack(new Snack("Our Take on Gummy Bears", 14, "Artisanal Beards and Snacks", 40), 3));
        assertThat(actual).isEqualTo(expected);

        int budget2 = 51;
        int minPreference2 = 3;
        List<OrderSnack> expected2 = new ArrayList<>();
        List<OrderSnack> actual2 = KnapSnack.unboundedKnapSNACK(budget2, minPreference2, inventory);
        expected2.add(new OrderSnack(new Snack("Homemade Oreos", 9, "Artisanal Beards and Snacks", 3), 1));
        expected2.add(new OrderSnack(new Snack("Our Take on Gummy Bears", 14, "Artisanal Beards and Snacks", 40), 3));
        assertThat(actual2).isEqualTo(expected2);

    }


}
