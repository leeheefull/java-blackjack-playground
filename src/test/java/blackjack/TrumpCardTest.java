package blackjack;

import blackjack.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TrumpCardTest {
    private TrumpCard trumpCard;

    @BeforeEach
    void setUp() {
        this.trumpCard = new TrumpCard();
    }

    @Test
    @DisplayName("52장의 트럼프 카드가 잘 만들어 졌는지")
    void shuffle() {
        // given
        this.trumpCard.shuffle();

        // when, then
        assertThat(this.trumpCard.getTrumpCard().size()).isEqualTo(52);
    }

    @Test
    @DisplayName("카드가 잘 저장되는지")
    void set_random_card() {
        // given
        Card card = this.trumpCard.drawRandomCard(() -> new Card(Denomination.ACE, Suit.CLUB));

        // when, then
        assertThat(card.getDenomination()).isEqualTo(Denomination.ACE);
        assertThat(card.getSuit()).isEqualTo(Suit.CLUB);
    }
}
