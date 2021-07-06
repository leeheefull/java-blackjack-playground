package blackjack.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Deck {
    private final List<Card> deck;

    public Deck() {
        this.deck = new ArrayList<>();
    }

    public List<Card> getDeck() {
        return this.deck;
    }

    public void hit(Card card) {
        this.deck.add(card);
    }

    public int getCardScoreSum() {
        int score = getCardSumByAceOne();
        if (isAce() && score + 10 <= 21) {
            return score + 10;
        }
        return score;
    }

    public boolean isBlackjack() {
        return getCardScoreSum() == 21;
    }

    public boolean isBurst() {
        return 21 < getCardScoreSum();
    }

    public boolean isSafe() {
        return getCardScoreSum() < 21;
    }

    private int getCardSumByAceOne() {
        return this.deck.stream()
                .map(card -> card.getDenomination().getScore())
                .mapToInt(Integer::intValue)
                .sum();
    }

    private boolean isAce() {
        return this.deck.stream()
                .anyMatch(card -> card.getDenomination().equals(Denomination.ACE));
    }

    @Override
    public String toString() {
        return this.deck.stream()
                .map(Card::toString)
                .collect(Collectors.joining(", "));
    }
}
