package blackjack;

public class Player {
    private final String name;
    private final int cardSum;
    private int betAmount;

    public Player(String name) {
        this(name, 0, 0);
    }

    public Player(String name, int cardSum, int betAmount) {
        this.name = name;
        this.cardSum = cardSum;
        this.betAmount = betAmount;
    }

    public void setBetAmount(int betAmount) {
        this.betAmount = betAmount;
    }

    public String getName() {
        return this.name;
    }

    public int getCardSum() {
        return this.cardSum;
    }

    public int getBetAmount() {
        return betAmount;
    }
}
