package lotto.domain.lottostatistics;

import java.util.Arrays;

public enum LottoRank {

    FIRST(6, false),
    SECOND(5, true),
    THIRD(5, false),
    FOURTH(4, false),
    FIFTH(3, false),
    NONE(0, false);

    private int matchingCount;
    private boolean bonusBall;

    LottoRank(final int matchingCount, final boolean bonusBall) {
        this.matchingCount = matchingCount;
        this.bonusBall = bonusBall;
    }

    public static LottoRank valueOf(final int matchingCount, final boolean bonusBall) {
        return isSecond(matchingCount, bonusBall) ? SECOND : findRankWithoutSecond(matchingCount);
    }

    private static boolean isSecond(final int matchingCount, final boolean bonusBall) {
        return (matchingCount == LottoRank.SECOND.matchingCount) && bonusBall;
    }

    private static LottoRank findRankWithoutSecond(final int matchingCount) {
        return Arrays.stream(values())
                .filter(LottoRank::isNotSecond)
                .filter(rank -> rank.matchCount(matchingCount))
                .findFirst()
                .orElse(NONE);
    }

    private static boolean isNotSecond(final LottoRank rank) {
        return !isSecond(rank.matchingCount, rank.bonusBall);
    }

    public boolean matchCount(final int matchingCount) {
        return this.matchingCount == matchingCount;
    }
}
