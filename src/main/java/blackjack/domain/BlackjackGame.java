package blackjack.domain;

import java.util.List;
import java.util.stream.Collectors;

public class BlackjackGame {
    private final Dealer dealer;
    private final Players players;
    private final Cards trumpCard;
    private int reward = 0;
    private int cardNo = 0;

    public BlackjackGame(String playerNameInfo) {
        this.dealer = new Dealer();
        this.players = new Players(playerNameInfo);
        this.trumpCard = new Cards();
        shuffleCards();
    }

    public Dealer getDealer() {
        return this.dealer;
    }

    public Players getPlayers() {
        return this.players;
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

    public Card selectCard() {
        return this.trumpCard.getCardList().get(cardNo++);
    }

    public void result() {
        getBurstPlayer().forEach(player -> this.reward += player.getBetAmount().getBetAmount());
        getBurstPlayer().forEach(player -> player.setRevenue(-player.getBetAmount().getBetAmount()));

        if (this.dealer.getCards().isBurst()) {
            getBlackjackPlayer().forEach(player -> this.reward -= player.getBetAmount().getBetAmount() * 0.5);
            getBlackjackPlayer().forEach(player -> player.setRevenue((int) (player.getBetAmount().getBetAmount() * 1.5)));

            int divideReward = (int) (this.reward * 1.0 / getNotBurstAndNotBlackjackPlayer().size());
            getNotBurstAndNotBlackjackPlayer().forEach(player -> this.reward -= divideReward);
            getNotBurstAndNotBlackjackPlayer().forEach(player -> player.setRevenue(divideReward));

            this.dealer.setRevenue(0);
            return;
        }
        if (!this.dealer.getCards().isBurst() && !this.dealer.getCards().isTwentyOne() && !this.dealer.getCards().isBlackjack()) {
            getBlackjackPlayer().forEach(player -> this.reward -= player.getBetAmount().getBetAmount() * 0.5);
            getBlackjackPlayer().forEach(player -> player.setRevenue((int) (player.getBetAmount().getBetAmount() * 1.5)));

            int divideReward = (int) (this.reward * 1.0 / (getNotBurstAndNotBlackjackPlayer().size() + 1));
            getNotBurstAndNotBlackjackPlayer().forEach(player -> this.reward -= divideReward);
            getNotBurstAndNotBlackjackPlayer().forEach(player -> player.setRevenue(divideReward));

            this.reward -= divideReward;
            this.dealer.setRevenue(divideReward);
            return;
        }
        if (this.dealer.getCards().isTwentyOne()) {
            getNotTwentyOnePlayers().forEach(player -> this.reward += player.getBetAmount().getBetAmount());
            getNotTwentyOnePlayers().forEach(player -> player.setRevenue(-player.getBetAmount().getBetAmount()));

            getBlackjackPlayer().forEach(player -> this.reward -= player.getBetAmount().getBetAmount() * 0.5);
            getBlackjackPlayer().forEach(player -> player.setRevenue((int) (player.getBetAmount().getBetAmount() * 1.5)));

            this.dealer.setRevenue(reward);
        }
    }

    private List<Player> getBlackjackPlayer() {
        return this.players.getPlayers()
                .stream()
                .filter(player -> player.getCards().isBlackjack())
                .collect(Collectors.toList());
    }

    private List<Player> getNotTwentyOnePlayers() {
        return this.players.getPlayers()
                .stream()
                .filter(player -> !player.getCards().isNotBurstAndNotTwentyOne())
                .collect(Collectors.toList());
    }

    private List<Player> getNotBurstAndNotBlackjackPlayer() {
        return this.players.getPlayers()
                .stream()
                .filter(player -> player.getCards().isNotBurstAndNotBlackjack())
                .collect(Collectors.toList());
    }

    private List<Player> getBurstPlayer() {
        return this.players.getPlayers()
                .stream()
                .filter(player -> player.getCards().isBurst())
                .collect(Collectors.toList());
    }

    private void shuffleCards() {
        for (int i = 0; i < 52; i++) {
            this.trumpCard.hit(new RandomHitStrategy());
        }
    }
}
