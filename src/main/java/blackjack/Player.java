package blackjack;

public class Player {
    private final String name;
    private final int cardSum;

    public Player(String name) {
        this(name, 0);
    }

    public Player(String name, int cardSum) {
        this.name = name;
        this.cardSum = cardSum;
    }

    public String getName() {
        return this.name;
    }

    public int getCardSum() {
        return this.cardSum;
    }
}
