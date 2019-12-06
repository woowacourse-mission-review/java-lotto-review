package lotto.domain.exception;

import lotto.domain.LottoPurchaseAmount;

public class LackOfLottoPurchaseAmountException extends IllegalArgumentException {

    public static final String LACK_OF_LOTTO_PURCHASE_AMOUNT_MESSAGE
            = String.format("로또 구입 금액은 최소 %d원입니다.", LottoPurchaseAmount.MIN_AMOUNT_OF_LOTTO_TICKET);

    public LackOfLottoPurchaseAmountException() {
        super(LACK_OF_LOTTO_PURCHASE_AMOUNT_MESSAGE);
    }
}
