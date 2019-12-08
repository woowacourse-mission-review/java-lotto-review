package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Rank {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    MISS(0, 0, false);

    private static final int RANK_MIN_COUNT = 3;

    private final int countOfMatch;
    private final int prize;
    private final boolean isMatchBonus;

    Rank(final int countOfMatch, final int prize, final boolean isMatchBonus) {
        this.countOfMatch = countOfMatch;
        this.prize = prize;
        this.isMatchBonus = isMatchBonus;
    }

    // TODO: 2019/12/08 리팩토링
    public static Rank of(final int countOfMatch, final boolean isMatchBonus) {
        if (countOfMatch < RANK_MIN_COUNT) {
            return MISS;
        }

        final List<Rank> ranks = Stream.of(values())
                .filter(rank -> rank.countOfMatch == countOfMatch)
                .collect(Collectors.toList());

        if (ranks.size() == 1) {
            return ranks.get(0);
        }

        return ranks.stream()
                .filter(rank -> rank.isMatchBonus == isMatchBonus)
                .findAny()
                .orElseThrow(UnsupportedOperationException::new);
    }


    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getPrize() {
        return prize;
    }
}
