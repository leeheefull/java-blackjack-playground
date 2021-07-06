package blackjack;

import blackjack.domain.Player;
import blackjack.domain.Players;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PlayersTest {
    private Players players;

    @BeforeEach
    void setUp() {
        this.players = new Players();
    }

    @Test
    @DisplayName("플레이어들이 잘 저장되는지")
    void save_players() {
        this.players.addPlayer(new Player("chan", 10000));
        assertThat(this.players.getPlayers().get(0).getName()).isEqualTo("chan");
    }
}
