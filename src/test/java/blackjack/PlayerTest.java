package blackjack;

import blackjack.domain.Card;
import blackjack.domain.Denomination;
import blackjack.domain.Player;
import blackjack.domain.Suit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PlayerTest {
    private Player player;

    @BeforeEach
    void setUp() {
        this.player = new Player("chan");
    }

    @Test
    @DisplayName("플레이어가 잘 저장되는지")
    void save_player() {
        assertThat(player.getName()).isEqualTo("chan");
    }

    @Test
    @DisplayName("베팅 금액이 잘 저장 되는지")
    void save_bet_amount() {
        // given
        player.setBetAmount(20000);

        // when, then
        assertThat(player.getBetAmount().getBetAmount()).isEqualTo(20000);
    }

    @Test
    @DisplayName("카드 추가")
    void add_card() {
        // given
        player.addCard(new Card(Denomination.ACE, Suit.CLUB));

        // when, then
        assertThat(player.getCards().getCards().size()).isEqualTo(1);
    }
}
