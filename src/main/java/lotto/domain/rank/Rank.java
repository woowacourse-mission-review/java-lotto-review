package lotto.domain.rank;

import java.util.Arrays;

public enum Rank {
    MISS(0, 0),
    FIFTH(3, 5_000), // 5등
    FOURTH(4, 50_000), // 4등
    THIRD(5, 1_500_000), // 3등
    SECOND(5, 30_000_000), // 2등
    FIRST(6, 2_000_000_000); // 1등

    private static final int WINNING_MIN_COUNT = 3;

    private int countOfMatch;
    private int winningMoney;

    Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        if (countOfMatch < WINNING_MIN_COUNT) {
            return MISS;
        }

        if (SECOND.matchCount(countOfMatch) && matchBonus) {
            return SECOND;
        }


        return Arrays.stream(values())
                .filter(rank -> rank.matchCount(countOfMatch) && rank != SECOND)
                .findAny()
                .orElseThrow(InvalidRankException::new);
    }

    private boolean matchCount(int countOfMatch) {
        return this.countOfMatch == countOfMatch;
    }
}
