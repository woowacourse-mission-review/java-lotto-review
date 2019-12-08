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

    private static void validateAffordability(final int budget) {
        if (budget < LOTTO_PRICE) {
            throw new NoMoneyException();
        }
    }

    public static Budget of(final int budget) {
        validateAffordability(budget);
        return new Budget(budget);
    }

    public boolean canPurchaseLotto(final int sizeOfLotto) {
        return budget > (LOTTO_PRICE * sizeOfLotto);
    }

    public Budget pay(int sizeOfLotto) {
        return new Budget(budget - (LOTTO_PRICE * sizeOfLotto));
    }

    public int getAffordableLottoPurchasingMoney() {
        return budget / LOTTO_PRICE;
    }

    public int budget() {
        return budget;
    }
}
