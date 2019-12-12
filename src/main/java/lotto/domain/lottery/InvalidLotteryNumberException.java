package lotto.domain.lottery;

public class InvalidLotteryNumberException extends RuntimeException {
    private static final String ERROR_MSG = "로또 번호는 1 이상 45 이하여야 합니다.";

    public InvalidLotteryNumberException() {
        super(ERROR_MSG);
    }
}
