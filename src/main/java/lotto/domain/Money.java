package lotto.domain;

public class Money {
    private static final int MIN_AMOUNT = 0;
    private final int money;

    private Money(int money) {
        validateAmount(money);
        this.money = money;
    }

    private void validateAmount(int money) {
        if (money < MIN_AMOUNT) {
            throw new MoneyLowerThanZeroException();
        }
    }

    public static Money from(int money) {
        return new Money(money);
    }
}
