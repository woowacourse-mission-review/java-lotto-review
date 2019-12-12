package lotto.domain.lottery;

import java.util.List;
import java.util.stream.Collectors;

public class Lottery {
    private final LotteryNumbers numbers;

    private Lottery(LotteryNumbers numbers) {
        this.numbers = numbers;
    }

    public static Lottery of(List<Integer> numbers) {
        return new Lottery(LotteryNumbers.of(
                numbers.stream()
                        .map(LotteryNumber::from)
                        .collect(Collectors.toList())
        ));
    }

    public static Lottery from(LotteryCreationStrategy strategy) {
       return new Lottery(LotteryNumbers.of(strategy.create()));
    }

    public LotteryNumbers getNumbers() {
        return numbers;
    }
}
