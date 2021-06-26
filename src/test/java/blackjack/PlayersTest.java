package blackjack;

import blackjack.domain.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PlayersTest {
    @Test
    @DisplayName("플레이어들이 잘 저장되는지")
    void save_players() {
        String nameInfo = "chan,bin";
        Players players = new Players(nameInfo);
        assertThat(players.getPlayers().get(0).getName()).isEqualTo("chan");
        assertThat(players.getPlayers().get(1).getName()).isEqualTo("bin");
    }
}
