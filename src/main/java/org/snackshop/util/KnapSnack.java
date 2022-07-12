package org.snackshop.util;


import org.snackshop.snack.OrderSnack;
import org.snackshop.snack.Snack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Utility to find the Snacks combination with maximum total preference score within a set budget.
The inventory is not limited - Snacks with same preference score are not pre-chosen by price,
so that store or brand preferences could be part of future features. Duplicates are a non-issue,
there is always a default preference score of 0 for every Snack.
n = inventory.length
W = budget
O(nW)

KnapSnack is based on Aditya Kumar's Unbounded Knapsack
via https://www.geeksforgeeks.org/unbounded-knapsack-repetition-items-allowed/
 */
public class KnapSnack {


    // TODO find when price and value make it clear what will happen
    public static List<OrderSnack> unboundedKnapSNACK(int budget, int preference,
                                                      List<Snack> inventory) {
        // dp[i] is going to store maximum value for knapsacks with capacity i.
        int dp[] = new int[budget + 1];

        // array holding list of items/orders
        ArrayList<OrderSnack>[] orders = new ArrayList[budget + 1];
        Arrays.fill(orders, new ArrayList<OrderSnack>());

        // Fill dp[] and orders until budget is reached
        for (int i = 0; i <= budget; i++) {

            // iterate over Snacks
            for (Snack snackToCheck : inventory) {

                // is Snack tasty enough? default value is 0, all Snacks considered
                if (snackToCheck.getPreferenceScore() >= preference) {
                    // if Snack's price fits in current budget
                    if (snackToCheck.getPrice() <= i) {
                        // if my current budget/order's preference value is higher than the value in
                        // a Knapsack with smaller budget that can still fit this Snack - keep it (leaving for clarity)
                        if (dp[i] > dp[i - snackToCheck.getPrice()] +
                                snackToCheck.getPreferenceScore()) {
                            dp[i] = dp[i];
                            orders[i] = new ArrayList<>(orders[i]);

                            // if there is a Knapsack with smaller budget that has higher or equal
                            // pref value plus enough money left to pay for this Snack,
                            // take it and the contents of the smaller Knapsack
                        } else {
                            dp[i] = dp[i - snackToCheck.getPrice()] + snackToCheck.getPreferenceScore();
                            orders[i] = new ArrayList<>(orders[i - snackToCheck.getPrice()]);

                            OrderSnack containedSnack = new OrderSnack(snackToCheck);
                            // if current order already includes this Snack, increase its amount
                            if (orders[i].contains(containedSnack)) {
                                int indexOfOrderSnack = orders[i].indexOf(containedSnack);
                                orders[i].set(indexOfOrderSnack, new OrderSnack(containedSnack, orders[i].get(indexOfOrderSnack).getAmount() + 1));
                                // if it's a new Snac, add it
                            } else {
                                orders[i].add(new OrderSnack(containedSnack, 1));
                            }
                        }
                    }
                }

            }

        }
        // return the Snacks in the Knapsack with budget = budget
        return orders[budget];
    }
}
