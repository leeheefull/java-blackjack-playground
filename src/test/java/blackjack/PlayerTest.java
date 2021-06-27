package blackjack;

import blackjack.domain.Player;
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
    @DisplayName("게임 시작 시 2장 받기")
    void two_card_receive() {
        assertThat(player.getCards().getCards().size()).isEqualTo(2);
    }

    @Test
    @DisplayName("Hit 잘 되는지")
    void hit() {
        // given
        player.hit();

        // when, then
        assertThat(player.getCards().getCards().size()).isEqualTo(3);
    }
}
