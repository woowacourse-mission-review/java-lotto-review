package lotto.domain.lottery;

import java.util.List;

public class LotteryFactory {
    public static Lottery createRandomLottery() {
        return Lottery.from(RandomLotteryCreationStrategy.getInstance());
    }

    public static Lottery createManualLottery(List<Integer> numbers) {
        return Lottery.of(numbers);
    }
}
