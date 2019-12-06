package lotto.domain;

import lotto.domain.exception.LackOfLottoPurchaseAmountException;

public class LottoPurchaseAmount {

    public static final long MIN_AMOUNT_OF_LOTTO_TICKET = 1000;

    private final long amount;

    private LottoPurchaseAmount(final long amount) {
        if (amount < MIN_AMOUNT_OF_LOTTO_TICKET) {
            throw new LackOfLottoPurchaseAmountException();
        }

        this.amount = amount;
    }

    public static LottoPurchaseAmount from(final long amount) {
        return new LottoPurchaseAmount(amount);
    }
}
