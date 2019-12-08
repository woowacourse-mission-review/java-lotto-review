package lotto.domain;

public class LotteryNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private final int number;

    private LotteryNumber(int lotteryNumber) {
        validateLotteryNumber(lotteryNumber);
        this.number = lotteryNumber;
    }

    private void validateLotteryNumber(int lotteryNumber) {
        if (lotteryNumber < MIN_NUMBER || lotteryNumber > MAX_NUMBER) {
            throw new InvalidLotteryNumberException();
        }
    }

    public static LotteryNumber from(int lotteryNumber) {
       return new LotteryNumber(lotteryNumber);
    }
}
