package blackjack.domain;

import java.util.List;

public class BlackjackGame {
    private final Dealer dealer;
    private final Players players;
    private final Cards trumpCard;
    private int cardNo = 0;

    public BlackjackGame(String playerNameInfo) {
        this.dealer = new Dealer();
        this.players = new Players(playerNameInfo);
        this.trumpCard = new Cards();
        shuffleCards();
    }

    public void setBetAmounts(List<Integer> betAmounts) {
        for (int i = 0; i < betAmounts.size(); i++) {
            this.players.getPlayers().get(i).setBetAmount(betAmounts.get(i));
        }
    }

    public void start() {
        this.dealer.addCard(selectCard());
        for (Player player : this.players.getPlayers()) {
            player.addCard(selectCard());
            player.addCard(selectCard());
        }
    }

    private void shuffleCards() {
        for (int i = 0; i < 52; i++) {
            this.trumpCard.hit(new RandomHitStrategy());
        }
    }

    private Card selectCard() {
        return this.trumpCard.getCardList().get(cardNo++);
    }
}
