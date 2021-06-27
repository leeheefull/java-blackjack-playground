package blackjack.domain;

@FunctionalInterface
public interface HitStrategy {
    Card hitable();
}
