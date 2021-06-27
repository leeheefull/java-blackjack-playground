package blackjack.domain;

public class Participant {
    private final Cards cards;
    private int revenue;

    public Participant() {
        this.cards = new Cards();
        this.revenue = 0;
    }

    public Cards getCards() {
        return this.cards;
    }

    public int getRevenue() {
        return this.revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public void addCard(Card card) {
        this.cards.getCards().add(card);
    }
}
