package lotto.domain.rank;

public class InvalidRankException extends RuntimeException {
    private static final String ERROR_MSG = "올바르지 않은 로또 당첨 결과입니다.";

    public InvalidRankException() {
        super(ERROR_MSG);
    }
}
