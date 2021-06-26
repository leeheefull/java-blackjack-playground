package blackjack;

import blackjack.domain.Suit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SuitTest {
    @Test
    @DisplayName("슈트 명이 맞는지")
    void suit_name() {
        assertThat(Suit.SPADE.getName()).isEqualTo("스페이드");
        assertThat(Suit.HEART.getName()).isEqualTo("하트");
        assertThat(Suit.DIAMOND.getName()).isEqualTo("다이아몬드");
        assertThat(Suit.CLUB.getName()).isEqualTo("클로버");
    }
}
