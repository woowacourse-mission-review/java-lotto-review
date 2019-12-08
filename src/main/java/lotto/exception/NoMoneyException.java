package lotto.exception;

public class NoMoneyException extends RuntimeException {

    public static final String NO_MONEY_EXCEPTION_MESSAGE = "돈이 없어서 로또를 살 수 없습니다.";

    public NoMoneyException() {
        super(NO_MONEY_EXCEPTION_MESSAGE);
    }
}
