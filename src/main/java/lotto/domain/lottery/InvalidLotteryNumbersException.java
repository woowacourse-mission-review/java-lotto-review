package lotto.domain.lottery;

public class InvalidLotteryNumbersException extends RuntimeException {
    private static final String ERROR_MSG = "로또 번호의 수는 6개여야 합니다.";

    public InvalidLotteryNumbersException() {
        super(ERROR_MSG);
    }
}
