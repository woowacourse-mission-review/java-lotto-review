package lotto.domain.lottery;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LotteryNumbers {
    public static final int NUM_OF_LOTTERY_NUMBERS = 6;
    private final List<LotteryNumber> numbers;

    public LotteryNumbers(List<LotteryNumber> numbers) {
        this.numbers = new ArrayList<>(numbers);
        validateCountOfNumbers(this.numbers);
        validateNoDuplicationInNumbers(this.numbers);
    }

    private void validateCountOfNumbers(List<LotteryNumber> numbers) {
        if (numbers.size() != NUM_OF_LOTTERY_NUMBERS) {
            throw new InvalidLotteryNumbersException();
        }
    }

    private void validateNoDuplicationInNumbers(List<LotteryNumber> numbers) {
        long numOfDistinctNumbers = numbers.stream()
                .distinct()
                .count();
        if (numOfDistinctNumbers != numbers.size()) {
            throw new DuplicatedLotteryNumbersException();
        }
    }

    public static LotteryNumbers of(List<LotteryNumber> numbers) {
        return new LotteryNumbers(numbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LotteryNumbers that = (LotteryNumbers) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
