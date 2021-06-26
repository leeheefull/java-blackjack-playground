package blackjack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GameTest {
    @Test
    @DisplayName("플레이어 이름을 쉼표로 구분하여 저장")
    void input_player_list() {
        String nameInfo = "chan,bin";
        Game game = new Game(nameInfo);
        assertThat(game.getPlayers().getPlayers().get(0).getName())
                .isEqualTo("chan");
        assertThat(game.getPlayers().getPlayers().get(1).getName())
                .isEqualTo("bin");
    }
}
