package lotto.domain.money;

import lotto.domain.lottery.InvalidLotteryBuyingMoneyException;
import lotto.domain.money.LotteryBuyingMoney;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

class LotteryBuyingMoneyTest {
    @ParameterizedTest
    @ValueSource(longs = {-1000, -500, 0, 500, 1500})
    @DisplayName("로또 구입 금액이 로또 가격의 배수가 아닐 경우 예외를 던진다.")
    void lotteryBuyingMoneyShouldBeMultipleOfLotteryPrice(long amount) {
        assertThrows(InvalidLotteryBuyingMoneyException.class, () -> LotteryBuyingMoney.from(amount));
    }
}