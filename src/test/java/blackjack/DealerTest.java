package blackjack;

import blackjack.domain.Dealer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DealerTest {
    private Dealer dealer;

    @BeforeEach
    void setUp() {
        this.dealer = new Dealer();
    }

    @Test
    @DisplayName("게임 시작 시 1장 받기")
    void one_card_receive() {
        assertThat(dealer.getCards().getCards().size()).isEqualTo(1);
    }

    @Test
    @DisplayName("hit 잘 되는지")
    void hit() {
        // given
        dealer.hit();

        // when, then
        assertThat(dealer.getCards().getCards().size()).isEqualTo(2);
    }
}
