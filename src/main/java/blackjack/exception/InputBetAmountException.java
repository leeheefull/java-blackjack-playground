package blackjack.exception;

import java.util.InputMismatchException;

public class InputBetAmountException extends InputMismatchException {
    public InputBetAmountException() {
        super("잘못된 베팅 금액입니다.");
    }
}
