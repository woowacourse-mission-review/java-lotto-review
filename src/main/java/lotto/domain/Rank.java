package lotto.domain;

public enum Rank {
    FIRST(6, 2_000_000_000), // 1등
    SECOND(5, 30_000_000), // 2등
    THIRD(5, 1_500_000), // 3등
    FOURTH(4, 50_000), // 4등
    FIFTH(3, 5_000), // 5등
    MISS(0, 0);

    public static final String INVALID_FIRST_MATCH_EXCEPTION_MESSAGE =
            String.format("%d개의 번호 일치와 보너스볼 일치는 유효하지 않습니다.", FIRST.countOfMatch);
    public static final String INVALID_COUNT_OF_MATCH_EXCEPTION_MESSAGE =
            String.format("%d는 유효하지 않은 값입니다.", FIRST.countOfMatch);

    private static final int WINNING_MIN_COUNT = 3;

    private int countOfMatch;
    private int winningMoney;

    private Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        if (countOfMatch == FIRST.countOfMatch && matchBonus) {
            throw new IllegalArgumentException(INVALID_FIRST_MATCH_EXCEPTION_MESSAGE);
        }

        if (countOfMatch < WINNING_MIN_COUNT && countOfMatch >= 0) {
            return MISS;
        }

        if (SECOND.matchCount(countOfMatch)) {
            return (matchBonus ? SECOND : THIRD);
        }

        for (Rank rank : values()) {
            if (rank.matchCount(countOfMatch)) {
                return rank;
            }
        }

        throw new IllegalArgumentException(INVALID_COUNT_OF_MATCH_EXCEPTION_MESSAGE);
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    private boolean matchCount(int countOfMatch) {
        return this.countOfMatch == countOfMatch;
    }
}