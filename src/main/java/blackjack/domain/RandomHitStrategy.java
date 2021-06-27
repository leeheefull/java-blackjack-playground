package blackjack.domain;

import java.util.Random;

public class RandomHitStrategy implements HitStrategy {
    @Override
    public Card hitable() {
        return new Card(
                Denomination.values()[new Random().nextInt(Denomination.values().length)],
                Suit.values()[new Random().nextInt(Suit.values().length)]
        );
    }
}
