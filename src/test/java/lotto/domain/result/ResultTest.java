package lotto.domain.result;

import lotto.domain.lottery.Lottery;
import lotto.domain.lottery.LotteryNumber;
import lotto.domain.lottery.WinningLottery;
import lotto.domain.rank.Rank;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {
    @Test
    @DisplayName("로또 당첨 결과들을 집계한다.")
    void aggregateRanks() {
        WinningLottery winningLottery = WinningLottery.of(
                Lottery.of(Lists.newArrayList(1, 2, 3, 4, 5, 6)),
                LotteryNumber.from(7)
        );

        List<Lottery> lotteries = Lists.newArrayList(
                Lottery.of(Lists.newArrayList(1, 2, 3, 4, 5, 6)),
                Lottery.of(Lists.newArrayList(1, 2, 3, 4, 5, 6))
        );

       Result result = Result.of(winningLottery, lotteries);
       assertThat(result.get(Rank.FIRST)).isEqualTo(2L);
    }
}