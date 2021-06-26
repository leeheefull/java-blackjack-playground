package blackjack.domain;

public class Player {
    private final String name;
    private BetAmount betAmount;

    public Player(String name) {
        this(name, 0);
    }

    public Player(String name, int betAmount) {
        this.name = name;
        this.betAmount = new BetAmount(betAmount);
    }

    public void setBetAmount(int betAmount) {
        this.betAmount = new BetAmount(betAmount);
    }

    public String getName() {
        return this.name;
    }

    public BetAmount getBetAmount() {
        return this.betAmount;
    }
}
