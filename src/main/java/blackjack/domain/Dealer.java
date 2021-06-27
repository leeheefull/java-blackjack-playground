package blackjack.domain;

public class Dealer extends Participant {
    @Override
    public String toString() {
        return "딜러" + "\t"
                + this.getCards().getCardScoreSum() + "\t\t\t\t"
                + this.getCards();
    }
}
