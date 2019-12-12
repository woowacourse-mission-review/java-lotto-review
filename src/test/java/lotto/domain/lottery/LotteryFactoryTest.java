package lotto.domain.lottery;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LotteryFactoryTest {
    @Test
    @DisplayName("수동 방식으로 로또를 생성할 수 있다.")
    void createManualLottery() {
        assertThat(LotteryFactory.createManualLottery(Lists.newArrayList(1, 2, 3, 4, 5, 6)).getNumbers()).isEqualTo(
                LotteryNumbers.of(
                        Lists.newArrayList(
                                LotteryNumber.from(1),
                                LotteryNumber.from(2),
                                LotteryNumber.from(3),
                                LotteryNumber.from(4),
                                LotteryNumber.from(5),
                                LotteryNumber.from(6)
                        )
                )
        );
    }
}