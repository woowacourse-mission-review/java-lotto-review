package lotto.domain.lottostatistics;

import java.util.Arrays;

public enum LottoRank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private int matchingCount;
    private long prize;

    LottoRank(final int matchingCount, final long prize) {
        this.matchingCount = matchingCount;
        this.prize = prize;
    }

    public static LottoRank valueOf(final int matchingCount, final boolean bonusBall) {
        return matchWithSecond(matchingCount, bonusBall) ? SECOND : findRankWithoutSecond(matchingCount);
    }

    private static boolean matchWithSecond(final int matchingCount, final boolean bonusBall) {
        return (matchingCount == LottoRank.SECOND.matchingCount) && bonusBall;
    }

    private static LottoRank findRankWithoutSecond(final int matchingCount) {
        return Arrays.stream(values())
                .filter(LottoRank::isNotSecond)
                .filter(rank -> rank.matchCount(matchingCount))
                .findFirst()
                .orElse(NONE);
    }

    private static boolean isNotSecond(final LottoRank lottoRank) {
        return !SECOND.equals(lottoRank);
    }

    public boolean matchCount(final int matchingCount) {
        return this.matchingCount == matchingCount;
    }
}
