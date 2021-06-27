package blackjack.domain;

public class Player extends Participant {
    private final String name;
    private BetAmount betAmount;

    public Player(String name) {
        this.name = name;
        this.betAmount = new BetAmount(0);

        this.getCards().hit(new RandomHitStrategy());
        this.getCards().hit(new RandomHitStrategy());
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
