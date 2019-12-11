package lotto.domain;

import lotto.domain.lottery.InvalidLotteryNumberException;
import lotto.domain.lottery.LotteryNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

class LotteryNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46, 50})
    @DisplayName("로또 번호는 1 이상 45 이하가 아닐 경우 예외를 던진다.")
    void lotteryNumberShouldBeIn1to45(int lotteryNumber) {
        assertThrows(InvalidLotteryNumberException.class, () -> LotteryNumber.from(lotteryNumber));
    }
}