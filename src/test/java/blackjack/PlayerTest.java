package blackjack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PlayerTest {

    @Test
    @DisplayName("플레이어가 잘 저장되는지")
    void save_player() {
        assertThat(new Player("chan").getName()).isEqualTo("chan");
    }
}
