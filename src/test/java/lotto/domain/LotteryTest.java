package lotto.domain;

import lotto.domain.lottery.Lottery;
import lotto.domain.lottery.LotteryNumber;
import lotto.domain.lottery.LotteryNumbers;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LotteryTest {
    @Test
    @DisplayName("로또 번호들의 리스트를 반환할 수 있다.")
    void getLotteryNumbersTest() {
        Lottery testLottery = Lottery.of(Lists.newArrayList(1, 2, 3, 4, 5, 6));
        assertThat(testLottery.getNumbers()).isEqualTo(LotteryNumbers.of(
                Lists.newArrayList(
                        LotteryNumber.from(1),
                        LotteryNumber.from(2),
                        LotteryNumber.from(3),
                        LotteryNumber.from(4),
                        LotteryNumber.from(5),
                        LotteryNumber.from(6)
                )
        ));
    }
}