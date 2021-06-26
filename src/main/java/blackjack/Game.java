package blackjack;

public class Game {
    private Players players;

    private static final String SEPARATOR = ",";

    public Game(String nameInfo) {
        this.players = new Players(nameInfo.split(SEPARATOR));
    }

    public Players getPlayers() {
        return this.players;
    }
}
