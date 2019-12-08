package lotto.domain;

import lotto.exception.NegativeBudgetException;
import lotto.exception.NoMoneyException;

import static lotto.domain.Lotto.LOTTO_PRICE;

public class Budget {

    private final int budget;

    private Budget(final int budget) {
        validateNonNegative(budget);
        this.budget = budget;
    }

    private static void validateNonNegative(final int budget) {
        if (budget < 0) {
            throw new NegativeBudgetException();
        }
    }

    private static void validateAffordabilityAtLeastOneLotto(final int budget) {
        if (budget < LOTTO_PRICE) {
            throw new NoMoneyException();
        }
    }

    public static Budget of(final int budget) {
        validateAffordabilityAtLeastOneLotto(budget);
        return new Budget(budget);
    }

    public void validateAffordabilityCountOf(final int sizeOFLotto) {
        if (cannotPurchaseLotto(sizeOFLotto)) {
            throw new NoMoneyException();
        }
    }

    private boolean cannotPurchaseLotto(final int sizeOfLotto) {
        return budget < (LOTTO_PRICE * sizeOfLotto);
    }

    public Budget pay(int sizeOfLotto) {
        return new Budget(budget - (LOTTO_PRICE * sizeOfLotto));
    }

    public int getAffordableLottoPurchasingCount() {
        return budget / LOTTO_PRICE;
    }

    public int budget() {
        return budget;
    }
}
