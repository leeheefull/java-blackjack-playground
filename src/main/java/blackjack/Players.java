package blackjack;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> players;

    public Players(String[] names) {
        this.players = convertPlayers(names);
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    private List<Player> convertPlayers(String[] names) {
        return Arrays.stream(names)
                .map(Player::new)
                .collect(Collectors.toList());
    }
}
