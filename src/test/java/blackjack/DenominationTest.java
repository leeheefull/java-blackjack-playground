package blackjack;

import blackjack.domain.Denomination;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DenominationTest {
    @Test
    @DisplayName("데노미네이션 명이 맞는지")
    void denomination_name() {
        assertThat(Denomination.ACE.getName()).isEqualTo("A");
        assertThat(Denomination.TWO.getName()).isEqualTo("2");
        assertThat(Denomination.THREE.getName()).isEqualTo("3");
        assertThat(Denomination.FOUR.getName()).isEqualTo("4");
        assertThat(Denomination.FIVE.getName()).isEqualTo("5");
        assertThat(Denomination.SIX.getName()).isEqualTo("6");
        assertThat(Denomination.SEVEN.getName()).isEqualTo("7");
        assertThat(Denomination.EIGHT.getName()).isEqualTo("8");
        assertThat(Denomination.NINE.getName()).isEqualTo("9");
        assertThat(Denomination.TEN.getName()).isEqualTo("10");
        assertThat(Denomination.JACK.getName()).isEqualTo("J");
        assertThat(Denomination.QUEEN.getName()).isEqualTo("Q");
        assertThat(Denomination.KING.getName()).isEqualTo("K");
    }

    @Test
    @DisplayName("데노미네이션 값이 맞는지")
    void denomination_value() {
        assertThat(Denomination.ACE.getScore()).isEqualTo(1);
        assertThat(Denomination.TWO.getScore()).isEqualTo(2);
        assertThat(Denomination.THREE.getScore()).isEqualTo(3);
        assertThat(Denomination.FOUR.getScore()).isEqualTo(4);
        assertThat(Denomination.FIVE.getScore()).isEqualTo(5);
        assertThat(Denomination.SIX.getScore()).isEqualTo(6);
        assertThat(Denomination.SEVEN.getScore()).isEqualTo(7);
        assertThat(Denomination.EIGHT.getScore()).isEqualTo(8);
        assertThat(Denomination.NINE.getScore()).isEqualTo(9);
        assertThat(Denomination.TEN.getScore()).isEqualTo(10);
        assertThat(Denomination.JACK.getScore()).isEqualTo(10);
        assertThat(Denomination.QUEEN.getScore()).isEqualTo(10);
        assertThat(Denomination.KING.getScore()).isEqualTo(10);
    }

    @Test
    @DisplayName("데노미네이션 찾기")
    void denomination_getInstance() {
        assertThat(Denomination.getInstance("A")).isEqualTo(Denomination.ACE);
        assertThat(Denomination.getInstance("2")).isEqualTo(Denomination.TWO);
        assertThat(Denomination.getInstance("3")).isEqualTo(Denomination.THREE);
        assertThat(Denomination.getInstance("4")).isEqualTo(Denomination.FOUR);
        assertThat(Denomination.getInstance("5")).isEqualTo(Denomination.FIVE);
        assertThat(Denomination.getInstance("6")).isEqualTo(Denomination.SIX);
        assertThat(Denomination.getInstance("7")).isEqualTo(Denomination.SEVEN);
        assertThat(Denomination.getInstance("8")).isEqualTo(Denomination.EIGHT);
        assertThat(Denomination.getInstance("9")).isEqualTo(Denomination.NINE);
        assertThat(Denomination.getInstance("10")).isEqualTo(Denomination.TEN);
        assertThat(Denomination.getInstance("J")).isEqualTo(Denomination.JACK);
        assertThat(Denomination.getInstance("Q")).isEqualTo(Denomination.QUEEN);
        assertThat(Denomination.getInstance("K")).isEqualTo(Denomination.KING);
    }
}
