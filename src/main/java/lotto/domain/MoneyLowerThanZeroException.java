package lotto.domain;

public class MoneyLowerThanZeroException extends RuntimeException {
    private static final String ERROR_MSG = "돈은 0 이상의 정수여야 합니다.";

    public MoneyLowerThanZeroException() {
        super(ERROR_MSG);
    }
}
