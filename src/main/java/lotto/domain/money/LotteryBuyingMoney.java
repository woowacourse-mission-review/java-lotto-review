package lotto.domain.money;

import lotto.domain.lottery.InvalidLotteryBuyingMoneyException;

public class LotteryBuyingMoney {
    private static final long LOTTERY_PRICE = 1000L;
    private final long amount;

    private LotteryBuyingMoney(long amount) {
        validateAmount(amount);
        this.amount = amount;
    }

    private void validateAmount(long amount) {
        if (isNotDivisibleByLotteryPrice(amount) || isLowerThanOrEqualToZero(amount)) {
            throw new InvalidLotteryBuyingMoneyException();
        }
    }

    private boolean isNotDivisibleByLotteryPrice(long amount) {
        return amount % LOTTERY_PRICE != 0;
    }

    private boolean isLowerThanOrEqualToZero(long amount) {
        return amount <= 0;
    }

    public static LotteryBuyingMoney from(long amount) {
        return new LotteryBuyingMoney(amount);
    }
}
