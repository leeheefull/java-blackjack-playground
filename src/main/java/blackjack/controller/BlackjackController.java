package blackjack.controller;

import blackjack.domain.BlackjackGame;
import blackjack.domain.Player;
import blackjack.view.BlackjackView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class BlackjackController {
    private final BlackjackGame game = new BlackjackGame();
    private final BlackjackView view = new BlackjackView();

    public void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            List<String> names = inputNames(br);
            List<Integer> betAmounts = inputBetAmounts(br, names);

            game.placePlayers(names, betAmounts);
            game.start();
            showStatusTable();

            drawPlayersCard(br);
            drawDealerCard();
            showStatusTable();

            game.result();
            showRevenueTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<Integer> inputBetAmounts(BufferedReader br, List<String> names) throws IOException {
        List<Integer> betAmounts = new ArrayList<>();
        for (String name : names) {
            view.showInputBetAmount(name);
            betAmounts.add(Integer.parseInt(br.readLine()));
        }
        return betAmounts;
    }

    private List<String> inputNames(BufferedReader br) throws IOException {
        view.showInputName();
        String nameInfo = br.readLine();
        return Arrays.stream(nameInfo.split(","))
                .collect(Collectors.toList());
    }

    private void showStatusTable() {
        view.showTableAttribute();
        view.showParticipantStatusTable(game.getDealer());
        for (Player player : game.getPlayers().getPlayers()) {
            view.showParticipantStatusTable(player);
        }
    }

    private void showRevenueTable() {
        view.showDealerRevenue(game.getDealer().getRevenue());
        for (Player player : game.getPlayers().getPlayers()) {
            view.showPlayerRevenue(player.getName(), player.getRevenue());
        }
    }

    private void drawDealerCard() {
        while (game.getDealer().getDeck().getCardScoreSum() < 17) {
            game.getDealer().addDeck(game.getTrumpCard().drawCard());
            view.showDealerMoreCardMessage();
        }
    }

    private void drawPlayersCard(BufferedReader br) throws IOException {
        for (Player player : game.getPlayers().getPlayers()) {
            view.showPlayerMoreCardMessage(player);
            while (br.readLine().equals("y")) {
                player.addDeck(game.getTrumpCard().drawCard());
                view.showTableAttribute();
                view.showParticipantStatusTable(player);
                if (player.getDeck().isBurst()) {
                    view.showPlayerLoseMessage(player);
                    break;
                }
                view.showPlayerMoreCardMessage(player);
            }
        }
    }
}
