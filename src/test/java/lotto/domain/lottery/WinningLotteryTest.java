package lotto.domain.lottery;

import lotto.domain.rank.Rank;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WinningLotteryTest {
    @Test
    @DisplayName("생성자의 인자로 들어온 로또에 보너스 번호가 포함돼있으면 예외를 던진다.")
    void bonusNumberCannotBeInLotteryNumbers() {
        assertThrows(DuplicatedBonusNumberException.class, () -> WinningLottery.of(
                Lottery.of(Lists.newArrayList(1, 2, 3, 4, 5, 6)),
                LotteryNumber.from(1)
        ));
    }

    @Test
    @DisplayName("다른 로또를 평가해 랭크를 반환한다.")
    void evaluateAnotherLottery() {
        WinningLottery winningLottery = WinningLottery.of(
                Lottery.of(Lists.newArrayList(1, 2, 3, 4, 5, 6)),
                LotteryNumber.from(7)
        );
        Lottery testLottery = Lottery.of(Lists.newArrayList(1, 2, 3, 4, 5, 6));
        assertThat(winningLottery.evaluate(testLottery)).isEqualTo(Rank.FIRST);
    }
}