package org.snackshop.shop;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.snackshop.snack.OrderSnack;
import org.snackshop.snack.Snack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopTest {

    @Autowired
    Shop shop;

    @Test
    public void shop_InitializesProperly() {
        assertThat(shop).isNotNull();
        assertThat(shop.getInventory()).isNotEmpty();
        assertThat(shop.getStores()).isNotEmpty();
    }

    @Test
    public void shop_hasStores() {
        assertThat(shop.getStores()).isNotEmpty();
    }

    @Test
    public void shop_hasInventory() {
        assertThat(shop.getInventory()).hasAtLeastOneElementOfType(Snack.class);
    }

    @Test
    public void shop_fetchesPreferences() {
        assertThat(shop.getInventory().get(0).getPreferenceScore()).isGreaterThan(0);
    }


}
