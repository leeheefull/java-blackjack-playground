package blackjack;

import blackjack.domain.Card;
import blackjack.domain.Deck;
import blackjack.domain.Denomination;
import blackjack.domain.Suit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DeckTest {
    private Deck deck;

    @BeforeEach
    void setUp() {
        this.deck = new Deck();
    }

    @Test
    @DisplayName("hit이 잘 되는지")
    void hit_test() {
        // given
        this.deck.hit(new Card(Denomination.ACE, Suit.CLUB));

        // when, then
        assertThat(this.deck.getDeck().get(0).getDenomination()).isEqualTo(Denomination.ACE);
        assertThat(this.deck.getDeck().get(0).getSuit()).isEqualTo(Suit.CLUB);
    }

    @Test
    @DisplayName("카드 합이 잘 구해지는지")
    void get_card_sum_score() {
        // given
        this.deck.hit(new Card(Denomination.ACE, Suit.CLUB));
        this.deck.hit(new Card(Denomination.TEN, Suit.CLUB));

        // when, then
        assertThat(this.deck.getCardScoreSum()).isEqualTo(21);
    }

    @Test
    @DisplayName("카드 합에 대한 결과가 잘 나오는지")
    void card_result() {
        // given
        this.deck.hit(new Card(Denomination.EIGHT, Suit.CLUB));
        this.deck.hit(new Card(Denomination.TEN, Suit.CLUB));

        // when then
        assertThat(this.deck.isBlackjack()).isFalse();
        assertThat(this.deck.isBurst()).isFalse();
        assertThat(this.deck.isSafe()).isTrue();
    }
}
