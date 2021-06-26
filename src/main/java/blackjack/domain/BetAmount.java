package blackjack.domain;

import blackjack.exception.InputBetAmountException;

public class BetAmount {
    private final int betAmount;

    public BetAmount(int betAmount) {
        validate(betAmount);
        this.betAmount = betAmount;
    }

    private void validate(int betAmount) {
        if (betAmount < 0) {
            throw new InputBetAmountException();
        }
    }

    public int getBetAmount() {
        return this.betAmount;
    }
}
