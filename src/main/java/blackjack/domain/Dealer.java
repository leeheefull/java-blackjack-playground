package blackjack.domain;

public class Dealer extends Participant {
    public Dealer() {
        this.getCards().hit(new RandomHitStrategy());
    }
}
