package blackjack;

import blackjack.domain.Card;
import blackjack.domain.Denomination;
import blackjack.domain.Suit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CardTest {
    @Test
    @DisplayName("카드가 잘 저장되는지")
    void save_card() {
        // given
        Card card = new Card(Denomination.ACE, Suit.CLUB);

        // when, then
        assertThat(card.getDenomination()).isEqualTo(Denomination.ACE);
        assertThat(card.getSuit()).isEqualTo(Suit.CLUB);
    }
}
