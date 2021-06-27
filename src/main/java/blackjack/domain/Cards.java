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

    public List<Card> getCards() {
        return new ArrayList<>(this.cards);
    }

    public void hit(HitStrategy HitStrategy) {
        int size = this.cards.size() + 1;
        while (this.cards.size() != size) {
            this.cards.add(HitStrategy.hitable());
        }
    }

    @Override
    public String toString() {
        return this.cards.stream()
                .map(Card::toString)
                .collect(Collectors.joining(", "));
    }
}
