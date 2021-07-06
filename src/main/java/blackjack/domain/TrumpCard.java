package blackjack.domain;

import java.util.*;

public class TrumpCard {
    private final Stack<Card> trumpCard;

    public TrumpCard() {
        this.trumpCard = new Stack<>();
    }

    public Stack<Card> getTrumpCard() {
        return this.trumpCard;
    }

    public void shuffle() {
        Set<Card> setCards = new HashSet<>();
        while (setCards.size() != 52) {
            Card card = drawRandomCard(new RandomHitStrategy());
            if (setCards.add(card)) {
                this.trumpCard.push(card);
            }
        }
    }

    public Card drawRandomCard(HitStrategy HitStrategy) {
        return HitStrategy.hitable();
    }

    public Card drawCard() {
        return this.trumpCard.pop();
    }
}
