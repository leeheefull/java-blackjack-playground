package blackjack.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cards {
    private final Set<Card> cards;

    public Cards() {
        this.cards = new HashSet<>();
    }

    public Set<Card> getCards() {
        return this.cards;
    }

    public List<Card> getCardList() {
        return new ArrayList<>(this.cards);
    }

    public void hit(HitStrategy HitStrategy) {
        int size = this.cards.size() + 1;
        while (this.cards.size() != size) {
            this.cards.add(HitStrategy.hitable());
        }
    }

    public int getCardScoreSum() {
        int score = getCardSumByAceOne();
        if (isAce() && score + 10 <= 21) {
            return score + 10;
        }
        return score;
    }

    public boolean isBlackjack() {
        return this.cards.size() == 2 && isTwentyOne();
    }

    public boolean isTwentyOne() {
        return this.cards.size() != 2 && getCardScoreSum() == 21;
    }

    public boolean isBurst() {
        return 21 < getCardScoreSum();
    }

    public boolean isNotBurstAndNotBlackjack() {
        return !isBlackjack() && !isBurst();
    }

    public boolean isNotBurstAndNotTwentyOne() {
        return !isTwentyOne() && !isBurst();
    }

    @Override
    public String toString() {
        return this.cards.stream()
                .map(Card::toString)
                .collect(Collectors.joining(", "));
    }

    private int getCardSumByAceOne() {
        return this.cards.stream()
                .map(card -> card.getDenomination().getScore())
                .mapToInt(Integer::intValue)
                .sum();
    }

    private boolean isAce() {
        return this.cards.stream()
                .anyMatch(card -> card.getDenomination().equals(Denomination.ACE));
    }
}
