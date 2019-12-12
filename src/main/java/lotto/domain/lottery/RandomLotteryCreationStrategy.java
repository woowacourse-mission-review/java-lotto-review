package lotto.domain.lottery;

import java.util.ArrayList;
import java.util.List;

public class RandomLotteryCreationStrategy implements LotteryCreationStrategy {
    private static final RandomLotteryCreationStrategy INSTANCE = new RandomLotteryCreationStrategy();

    private RandomLotteryCreationStrategy() {
    }

    @Override
    public List<LotteryNumber> create() {
        List<LotteryNumber> numbers = new ArrayList<>();
        for (int i = 0; i < LotteryNumbers.NUM_OF_LOTTERY_NUMBERS; i++) {
            numbers.add(RandomLotteryNumberGenerator.generate());
        }
        return numbers;
    }

    public static RandomLotteryCreationStrategy getInstance() {
        return INSTANCE;
    }
}
