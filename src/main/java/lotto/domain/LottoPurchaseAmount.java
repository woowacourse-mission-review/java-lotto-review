package lotto.domain;

import lotto.domain.exception.LackOfLottoPurchaseAmountException;

public class LottoPurchaseAmount {

    public static final long MIN_AMOUNT_OF_LOTTO_TICKET = 1000;

    private final long amount;

    private LottoPurchaseAmount(final long amount) {
        if (isLowerThanMinAmount(amount)) {
            throw new LackOfLottoPurchaseAmountException();
        }

        this.amount = amount;
    }

    private boolean isLowerThanMinAmount(final long amount) {
        return amount < MIN_AMOUNT_OF_LOTTO_TICKET;
    }

    public static LottoPurchaseAmount from(final long amount) {
        return new LottoPurchaseAmount(amount);
    }
}
