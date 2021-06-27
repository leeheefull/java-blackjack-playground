package blackjack.domain;

public class Player extends Participant {
    private final String name;
    private BetAmount betAmount;

    public Player(String name) {
        this.name = name;
        this.betAmount = new BetAmount(0);
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

    @Override
    public String toString() {
        return this.name + "\t"
                + this.getCards().getCardScoreSum() + "\t\t"
                + this.betAmount.getBetAmount() + "\t"
                + this.getCards();
    }
}
