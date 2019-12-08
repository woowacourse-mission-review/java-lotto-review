package lotto.exception;

public class NegativeBudgetException extends RuntimeException {

    public static final String NEGATIVE_BUDGET_EXCEPTION_MESSAGE = "음수의 돈을 가질 수 없습니다.";

    public NegativeBudgetException() {
        super(NEGATIVE_BUDGET_EXCEPTION_MESSAGE);
    }
}
