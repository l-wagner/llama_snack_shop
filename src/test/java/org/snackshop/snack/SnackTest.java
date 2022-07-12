package org.snackshop.snack;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.snackshop.snack.OrderSnack;
import org.snackshop.snack.Snack;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SnackTest {

    @Test
    public void snack_EqualsCorrect() {
        Snack fullS1 = (new Snack("Chips", 10, "Whole Groceries", 5));
        Snack fullS2 = (new Snack("Chips", 10, "Whole Groceries", 8));
        OrderSnack fullOS1 = (new OrderSnack(new Snack("Chips", 10, "Whole Groceries", 8),5));
        OrderSnack fullOS2 = (new OrderSnack(new Snack("Chips", 10, "Whole Groceries", 5),10));
        Snack empty1 = new Snack();
        Snack empty2 = new Snack();
        Snack emptyOS1 = new OrderSnack();
        Snack emptyOS2 = new OrderSnack();
        assertThat(fullS1).isEqualTo(fullS2);
        assertThat(fullS2).isEqualTo(fullS1);
        assertThat(fullOS1).isEqualTo(fullOS2);
        assertThat(fullOS2).isEqualTo(fullOS1);
        assertThat(empty1).isEqualTo(empty2);
        assertThat(emptyOS1).isEqualTo(emptyOS2);
        assertThat(fullS1).isNotEqualTo(empty1);
        assertThat(empty1).isNotEqualTo(fullS2);
        assertThat(fullOS1).isNotEqualTo(emptyOS1);
        assertThat(emptyOS1).isNotEqualTo(fullOS1);
    }
}
