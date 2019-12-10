package lotto.domain;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class LotteryNumbersTest {
    @Test
    @DisplayName("로또 번호의 개수가 6개 미만일 경우 예외를 던진다.")
    void numberOfLotteryNumbersLoserThan6() {
       assertThrows(InvalidLotteryNumbersException.class,
               () -> LotteryNumbers.of(Lists.newArrayList(
                       LotteryNumber.from(1),
                       LotteryNumber.from(2),
                       LotteryNumber.from(3),
                       LotteryNumber.from(4),
                       LotteryNumber.from(5)
               ))
       );
    }

    @Test
    @DisplayName("로또 번호의 개수가 6개를 초과할 경우 예외를 던진다.")
    void numberOfLotteryNumbersBiggerThan6() {
        assertThrows(InvalidLotteryNumbersException.class,
                () -> LotteryNumbers.of(Lists.newArrayList(
                        LotteryNumber.from(1),
                        LotteryNumber.from(2),
                        LotteryNumber.from(3),
                        LotteryNumber.from(4),
                        LotteryNumber.from(5),
                        LotteryNumber.from(6),
                        LotteryNumber.from(7)
                ))
        );
    }

    @Test
    @DisplayName("로또 번호들 사이에 중복이 존재하면 예외를 던진다.")
    void noDuplicationInLotteryNumbers() {
        assertThrows(DuplicatedLotteryNumbersException.class,
                () -> LotteryNumbers.of(Lists.newArrayList(
                        LotteryNumber.from(1),
                        LotteryNumber.from(2),
                        LotteryNumber.from(3),
                        LotteryNumber.from(4),
                        LotteryNumber.from(5),
                        LotteryNumber.from(5)
                ))
        );
    }
}