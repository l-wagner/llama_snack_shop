package org.snackshop.shop;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.snackshop.snack.Snack;
import org.snackshop.store.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ShopControllerTest {
    @Autowired
    ShopService shopService;

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void shopService_exists() {
        assertThat(shopService).isNotNull();
    }

    @Test
    public void shopService_shopExists() {
        assertThat(shopService.getShop()).isNotNull();
    }

    @Test
    public void shopService_InitializesProperly() {
        assertThat(shopService.getStores()).hasAtLeastOneElementOfType(Store.class);

        assertThat(shopService.getShop().getInventory()).hasAtLeastOneElementOfType(Snack.class);
    }

    @Test
    public void shopService_shouldReturnShop() throws Exception {
        mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("stores")))
                .andExpect(content().string(containsString("inventory")));
    }

    @Test
    public void shopService_shouldReturnStores() throws Exception {
        mockMvc.perform(get("/stores")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Atlantis")));
    }


    @Test
    public void shopService_shouldReturnInventory() throws Exception {
        mockMvc.perform(get("/inventory")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Atlantis")));
    }

    @Test
    public void shopService_shouldReturnRecommendedOrderWithNoParameters() throws Exception {
        mockMvc.perform(get("/recommendation")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("amount")));

    }

    @Test
    public void shopService_shouldReturnRecommendedOrderWithParameters() throws Exception {
        mockMvc.perform(get("/recommendation").param("budget", "6")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("amount")));
    }

    @Test
    public void shopService_shouldValidateParametersForRecommendedOrder() throws Exception {
        mockMvc.perform(get("/recommendation").param("preference", "-10"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().string(containsString("greater than or equal to")));
        ;

    }


}