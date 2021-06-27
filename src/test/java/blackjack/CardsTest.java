package blackjack;

import blackjack.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CardsTest {
    private Cards cards;

    @BeforeEach
    void setUp() {
        cards = new Cards();
    }

    @Test
    @DisplayName("hit 잘 되는지")
    void hit() {
        // given
        cards.hit(() -> new Card(Denomination.ACE, Suit.CLUB));

        // when, then
        assertThat(cards.getCards().get(0).getDenomination()).isEqualTo(Denomination.ACE);
        assertThat(cards.getCards().get(0).getSuit()).isEqualTo(Suit.CLUB);
    }
}
