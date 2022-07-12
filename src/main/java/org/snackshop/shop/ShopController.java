package org.snackshop.shop;


import org.snackshop.snack.OrderSnack;
import org.snackshop.snack.Snack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Set;

//Rest Controller to expose Shop, inventory, available stores/brands
// and best order for your budget
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Validated
public class ShopController {

    @Autowired
    private ShopService shopService;

    //TODO use llama name as param for customized order
    @RequestMapping("/")
    public ResponseEntity<Shop> getShop() {
        return ResponseEntity.ok(shopService.getShop());
    }

    // recommendation has two optional params, a budget limit and a preference score minium
    @RequestMapping("/recommendation")
    public ResponseEntity<List<OrderSnack>> getRecommended(
            @RequestParam(value = "budget", defaultValue = "100") @Min(0) Integer budget,
            @RequestParam(value = "preference", defaultValue = "0") @Min(0) Integer preference) {
        return ResponseEntity.ok(shopService.getRecommendation(budget, preference));
    }

    @RequestMapping("/inventory")
    public ResponseEntity<List<Snack>> getInventory() {
        return ResponseEntity.ok(shopService.getShop().getInventory());
    }

    @RequestMapping("/stores")
    public ResponseEntity<Set<String>> getStores() {
        return ResponseEntity.ok(shopService.getStoreNames());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);

    }
}