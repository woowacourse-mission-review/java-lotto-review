package lotto.domain.result;

import lotto.domain.lottery.Lottery;
import lotto.domain.lottery.WinningLottery;
import lotto.domain.rank.Rank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {
    private final Map<Rank, Long> result = new HashMap<>();

    public Result(WinningLottery winningLottery, List<Lottery> lotteries) {
        for (Rank rank : Rank.values()) {
            result.put(rank, 0L);
        }

        for (Lottery lottery : lotteries) {
            Rank rank = winningLottery.evaluate(lottery);
            result.put(rank, result.get(rank) + 1);
        }
    }

    public static Result of(WinningLottery winningLottery, List<Lottery> lotteries) {
        return new Result(winningLottery, lotteries);
    }

    public long get(Rank rank) {
        return result.get(rank);
    }
}
