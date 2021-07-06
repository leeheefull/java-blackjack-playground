package blackjack.domain;

public class Participant {
    private final Deck deck;
    private int revenue;

    public Participant() {
        this.deck = new Deck();
    }

    public Deck getDeck() {
        return this.deck;
    }

    public int getRevenue() {
        return this.revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public void addDeck(Card card) {
        this.deck.hit(card);
    }
}
