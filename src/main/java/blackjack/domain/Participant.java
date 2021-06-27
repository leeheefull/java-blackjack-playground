package blackjack.domain;

public class Participant {
    private final Cards cards;

    public Participant() {
        this.cards = new Cards();
    }

    public Cards getCards() {
        return this.cards;
    }

    public void addCard(Card card) {
        this.cards.getCards().add(card);
    }

    public int getCardScoreSum() {
        int score = getCardSumByAceOne();
        if (isAce() && score + 10 <= 21) {
            return score + 10;
        }
        return score;
    }

    public boolean isBurst() {
        return 21 < getCardScoreSum();
    }

    private int getCardSumByAceOne() {
        return this.cards.getCards()
                .stream()
                .map(card -> card.getDenomination().getScore())
                .mapToInt(Integer::intValue)
                .sum();
    }

    private boolean isAce() {
        return this.cards.getCards()
                .stream()
                .anyMatch(card -> card.getDenomination().equals(Denomination.ACE));
    }
}
