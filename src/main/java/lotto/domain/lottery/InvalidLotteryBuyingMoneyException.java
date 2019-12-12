package lotto.domain.lottery;

public class InvalidLotteryBuyingMoneyException extends RuntimeException {
    private static final String ERROR_MSG = "로또 구입 금액은 로또 가격에 자연수를 곱한 값이어야 합니다.";

    public InvalidLotteryBuyingMoneyException() {
        super(ERROR_MSG);
    }
}
