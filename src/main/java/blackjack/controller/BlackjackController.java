package blackjack.controller;

import blackjack.domain.BlackjackGame;
import blackjack.domain.Player;

import java.util.Arrays;
import java.util.Scanner;

public class BlackjackController {
    BlackjackGame blackjackGame = new BlackjackGame("chan,dong,bang,jung");

    public void run() {

        blackjackGame.setBetAmounts(Arrays.asList(10000, 20000, 30000, 20000));

        blackjackGame.start();

        System.out.println("\n이름\t결과\t금액\t카드");
        System.out.println(blackjackGame.getDealer());
        for (Player player : blackjackGame.getPlayers().getPlayers()) {
            System.out.println(player);
        }

        Scanner scanner = new Scanner(System.in);
        for (Player player : blackjackGame.getPlayers().getPlayers()) {
            System.out.print("* " + player.getName() + "씨는 카드 한 장 더 받으실건가요? (y or n): ");
            while (scanner.next().equals("y")) {
                player.addCard(blackjackGame.selectCard());
                System.out.println("\n이름\t결과\t금액\t카드");
                System.out.println(player);
                if (player.getCards().isBurst()) {
                    System.out.println("* " + player.getName() + "씨는 게임에서 패배 하셨습니다.");
                    break;
                }
                System.out.print("* " + player.getName() + "씨는 카드 한 장 더 받으실건가요? (y or n): ");
            }
        }

        while (blackjackGame.getDealer().getCards().getCardScoreSum() < 17) {
            blackjackGame.getDealer().addCard(blackjackGame.selectCard());
            System.out.println("* 딜러는 카드 한 장을 더 받았습니다.");
        }

        System.out.println("\n이름\t결과\t금액\t카드");
        System.out.println(blackjackGame.getDealer());
        for (Player player : blackjackGame.getPlayers().getPlayers()) {
            System.out.println(player);
        }

        blackjackGame.result();
        System.out.println("\n딜러의 수익금 " + blackjackGame.getDealer().getRevenue());
        for (Player player : blackjackGame.getPlayers().getPlayers()) {
            System.out.println(player.getName() + "의 수익금 " + player.getRevenue());
        }
    }
}
