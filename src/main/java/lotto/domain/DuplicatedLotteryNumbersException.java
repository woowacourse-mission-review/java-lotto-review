package lotto.domain;

public class DuplicatedLotteryNumbersException extends RuntimeException {
    private static final String ERROR_MSG = "로또 번호들 사이에 중복이 존재하면 안 됩니다.";

    public DuplicatedLotteryNumbersException() {
        super(ERROR_MSG);
    }
}
