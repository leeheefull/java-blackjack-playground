package blackjack.domain;

import java.util.List;

public class BlackjackGame {
    private final Dealer dealer;
    private final Players players;
    private final TrumpCard trumpCard;

    public BlackjackGame() {
        this.dealer = new Dealer();
        this.players = new Players();
        this.trumpCard = new TrumpCard();
        trumpCard.shuffle();
    }

    public Dealer getDealer() {
        return this.dealer;
    }

    public Players getPlayers() {
        return this.players;
    }

    public TrumpCard getTrumpCard() {
        return this.trumpCard;
    }

    public void placePlayers(List<String> names, List<Integer> betAmounts) {
        for (int i = 0; i < names.size(); i++) {
            players.addPlayer(new Player(names.get(i), betAmounts.get(i)));
        }
    }

    public void start() {
        this.dealer.addDeck(this.trumpCard.drawCard());
        for (Player player : this.players.getPlayers()) {
            player.addDeck(this.trumpCard.drawCard());
            player.addDeck(this.trumpCard.drawCard());
        }
    }

    public void result() {
        int revenueSum = 0;
        for (Player player : this.players.getPlayers()) {
            if (dealer.getDeck().isBlackjack() && player.getDeck().isSafe()) {
                player.setRevenue(-1 * player.getBetAmount().getBetAmount());
            }
            if (dealer.getDeck().isBlackjack() && player.getDeck().isBurst()) {
                player.setRevenue(-1 * player.getBetAmount().getBetAmount());
            }
            if (dealer.getDeck().isBurst() && player.getDeck().isBlackjack()) {
                player.setRevenue((int) (1.5 * player.getBetAmount().getBetAmount()));
            }
            if (dealer.getDeck().isBurst() && player.getDeck().isSafe()) {
                player.setRevenue((int) (1.5 * player.getBetAmount().getBetAmount()));
            }
            if (dealer.getDeck().isSafe() && player.getDeck().isBlackjack()) {
                player.setRevenue((int) (1.5 * player.getBetAmount().getBetAmount()));
            }
            if (dealer.getDeck().isSafe() && player.getDeck().isBurst()) {
                player.setRevenue(-1 * player.getBetAmount().getBetAmount());
            }
            if (dealer.getDeck().isSafe() && player.getDeck().isSafe()) {
                if (dealer.getDeck().getCardScoreSum() < player.getDeck().getCardScoreSum()) {
                    player.setRevenue((int) (1.5 * player.getBetAmount().getBetAmount()));
                }
                if (dealer.getDeck().getCardScoreSum() > player.getDeck().getCardScoreSum()) {
                    player.setRevenue(-1 * player.getBetAmount().getBetAmount());
                }
            }
            revenueSum -= player.getRevenue();
        }
        dealer.setRevenue(revenueSum);
    }
}
