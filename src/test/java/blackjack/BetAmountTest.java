package blackjack;

import blackjack.exception.InputBetAmountException;
import blackjack.domain.BetAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class BetAmountTest {
    @Test
    @DisplayName("베팅 금액이 음수일 경우")
    void minus_bet_amount() {
        assertThatThrownBy(() -> new BetAmount(-1)).isInstanceOf(InputBetAmountException.class);
    }
}
