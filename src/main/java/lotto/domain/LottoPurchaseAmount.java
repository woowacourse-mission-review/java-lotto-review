package lotto.domain;

import lotto.domain.exception.LackOfLottoPurchaseAmountException;

public class LottoPurchaseAmount {

    public static final long PRICE_OF_LOTTO_TICKET = 1000;

    private final long amount;

    private LottoPurchaseAmount(final long amount) {
        if (isLowerThanMinAmount(amount)) {
            throw new LackOfLottoPurchaseAmountException();
        }

        this.amount = amount;
    }

    private boolean isLowerThanMinAmount(final long amount) {
        return amount < PRICE_OF_LOTTO_TICKET;
    }

    public static LottoPurchaseAmount from(final long amount) {
        return new LottoPurchaseAmount(amount);
    }

    public long calculateSizeOfTicketsAvailable() {
        return amount / PRICE_OF_LOTTO_TICKET;
    }

    public long getAmount() {
        return amount;
    }
}
