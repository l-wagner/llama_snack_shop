package org.snackshop;

import org.snackshop.shop.ShopController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {

    @Bean
    public ShopController shopController(){
        return new ShopController();
    }

    public static void main(String args[]) {
        SpringApplication.run(App.class);
    }
}