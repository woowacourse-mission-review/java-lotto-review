package lotto.domain;

import lotto.domain.money.Money;
import lotto.domain.money.MoneyLowerThanZeroException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class MoneyTest {
    @Test
    @DisplayName("0 미만의 값이 생성자의 인자로 들어오면 예외를 던진다.")
    void moneyShouldBeBiggerThanOrEqualToZero() {
        assertThrows(MoneyLowerThanZeroException.class, () -> Money.from(-1));
    }
}