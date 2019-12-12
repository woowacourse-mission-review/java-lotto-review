package lotto.domain.lottery;

import lotto.domain.rank.Rank;

public class WinningLottery {
    private final Lottery lottery;
    private final LotteryNumber bonusNumber;

    private WinningLottery(Lottery lottery, LotteryNumber bonusNumber) {
        validateLottery(lottery, bonusNumber);
        this.lottery = lottery;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLottery of(Lottery lottery, LotteryNumber bonusNumber) {
        return new WinningLottery(lottery, bonusNumber);
    }

    private void validateLottery(Lottery lottery, LotteryNumber bonusNumber) {
        if (lottery.has(bonusNumber)) {
            throw new DuplicatedBonusNumberException();
        }
    }

    public Rank evaluate(Lottery another) {
        return Rank.valueOf(lottery.matches(another), another.has(bonusNumber));
    }
}
