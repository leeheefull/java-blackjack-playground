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
        this.player = new Player("chan", 10000);
    }

    @Test
    @DisplayName("플레이어가 잘 저장되는지")
    void save_player() {
        assertThat(player.getName()).isEqualTo("chan");
    }

    @Test
    @DisplayName("베팅 금액이 잘 저장 되는지")
    void save_bet_amount() {
        assertThat(player.getBetAmount().getBetAmount()).isEqualTo(10000);
    }
}
