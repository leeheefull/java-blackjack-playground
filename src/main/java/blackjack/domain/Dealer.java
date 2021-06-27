package blackjack.domain;

public class Dealer {
    private final Cards cards;

    public Dealer() {
        this.cards = new Cards();
        cards.hit(new RandomHitStrategy());
    }

    public Cards getCards() {
        return this.cards;
    }

    public void hit() {
        this.cards.hit(new RandomHitStrategy());
    }
}
