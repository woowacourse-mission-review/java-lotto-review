package lotto.domain;

import java.math.BigInteger;

public class Money {
    private static final int MIN_AMOUNT = 0;
    private final BigInteger money;

    private Money(long money) {
        validateAmount(money);
        this.money = BigInteger.valueOf(money);
    }

    private void validateAmount(long money) {
        if (money < MIN_AMOUNT) {
            throw new MoneyLowerThanZeroException();
        }
    }

    public static Money from(long money) {
        return new Money(money);
    }
}
