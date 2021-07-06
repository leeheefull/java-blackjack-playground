package blackjack.view;

import blackjack.domain.Participant;
import blackjack.domain.Player;

import java.io.PrintStream;

public class BlackjackView {
    private final PrintStream out = new PrintStream(System.out);

    public void showInputName() {
        out.print("* 참가할 선수의 이름을 입력하시오.(콤마로 구분)\n> ");
    }

    public void showInputBetAmount(String name) {
        out.print(name + "씨가 베팅할 금액 > ");
    }

    public void showTableAttribute() {
        out.println("\n이름\t결과\t금액\t카드");
    }

    public void showParticipantStatusTable(Participant participantResult) {
        out.println(participantResult);
    }

    public void showPlayerMoreCardMessage(Player player) {
        out.print("\n* " + player.getName() + "씨는 카드 한 장 더 받으실건가요? (y or n)\n> ");
    }

    public void showPlayerLoseMessage(Player player) {
        out.println("* " + player.getName() + "씨는 게임에서 패배 하셨습니다.");
    }

    public void showDealerMoreCardMessage() {
        out.println("* 딜러는 카드 한 장을 더 받았습니다.");
    }

    public void showDealerRevenue(int revenue) {
        out.println("\n딜러의 수익금 " + revenue);
    }

    public void showPlayerRevenue(String name, int revenue) {
        out.println("" + name + "의 수익금 " + revenue);
    }
}
