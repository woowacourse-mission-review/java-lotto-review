package lotto.domain.lottery;

public class RandomLotteryNumberGenerator {
    public static LotteryNumber generate() {
        return LotteryNumber.from((int) (Math.random() * (LotteryNumber.MAX_NUMBER - LotteryNumber.MIN_NUMBER + 1))
                + LotteryNumber.MIN_NUMBER);
    }
}
