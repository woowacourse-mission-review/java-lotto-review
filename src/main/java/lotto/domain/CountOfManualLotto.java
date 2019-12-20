package lotto.domain;

import java.util.Objects;

public class CountOfManualLotto {
    private final int value;

    private CountOfManualLotto(final int value, final int countOfPurchase) {
        validate(value, countOfPurchase);
        this.value = value;
    }

    public static CountOfManualLotto of(final int value, final int countOfPurchase) {
        return new CountOfManualLotto(value, countOfPurchase);
    }

    private void validate(final int countOfManual, final int countOfPurchase) {
        if (countOfManual < 0) {
            throw new IllegalArgumentException("수동 구매 횟수 음수 입력은 불가능합니다");
        }
        if (countOfManual > countOfPurchase) {
            throw new IllegalArgumentException("수동 구매 횟수는 총 구매 횟수보다 많으면 안됩니다.");
        }
    }

    public int value() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final CountOfManualLotto that = (CountOfManualLotto) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "CountOfManualLotto{" +
                "value=" + value +
                '}';
    }
}
