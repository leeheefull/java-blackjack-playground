package blackjack.domain;

public class Player extends Participant {
    private final String name;
    private final BetAmount betAmount;

    public Player(String name, int betAmount) {
        this.name = name;
        this.betAmount = new BetAmount(betAmount);
    }

    public String getName() {
        return this.name;
    }

    public BetAmount getBetAmount() {
        return this.betAmount;
    }

    @Override
    public String toString() {
        return this.name + "\t"
                + this.getDeck().getCardScoreSum() + "\t\t"
                + this.betAmount.getBetAmount() + "\t"
                + this.getDeck();
    }
}
