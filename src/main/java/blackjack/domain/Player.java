package blackjack.domain;

public class Player {
    private final String name;
    private final Cards cards;
    private BetAmount betAmount;

    public Player(String name) {
        this.name = name;
        this.cards = new Cards();
        this.betAmount = new BetAmount(0);

        this.cards.hit(new RandomHitStrategy());
        this.cards.hit(new RandomHitStrategy());
    }

    public void setBetAmount(int betAmount) {
        this.betAmount = new BetAmount(betAmount);
    }

    public String getName() {
        return this.name;
    }

    public Cards getCards() {
        return this.cards;
    }

    public BetAmount getBetAmount() {
        return this.betAmount;
    }

    public void hit() {
        this.cards.hit(new RandomHitStrategy());
    }
}
