package org.snackshop.snack;


import java.util.ArrayList;
import java.util.List;

public class SnackRepo {

    List<Snack> snacks = new ArrayList<>();

    public SnackRepo() {
    }

    public SnackRepo(List<Snack> snacks) {
        this.snacks = snacks;
    }

    public void addSnacks(List<Snack> snacks) {
        this.snacks.addAll(snacks);
    }


}


