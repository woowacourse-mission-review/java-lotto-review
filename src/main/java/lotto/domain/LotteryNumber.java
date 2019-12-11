package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LotteryNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final Map<Integer, LotteryNumber> CACHE = new HashMap<>();
    private final int number;

    static {
        for (int lotteryNumber = MIN_NUMBER; lotteryNumber < MAX_NUMBER; lotteryNumber++) {
            CACHE.put(lotteryNumber, new LotteryNumber(lotteryNumber));
        }
    }

    private LotteryNumber(int lotteryNumber) {
        this.number = lotteryNumber;
    }

    public static LotteryNumber from(int lotteryNumber) {
        validateLotteryNumber(lotteryNumber);
       return CACHE.get(lotteryNumber);
    }

    private static void validateLotteryNumber(int lotteryNumber) {
        if (lotteryNumber < MIN_NUMBER || lotteryNumber > MAX_NUMBER) {
            throw new InvalidLotteryNumberException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LotteryNumber that = (LotteryNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
