package lotto.domain.lottostatistics;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankTest {

    @ParameterizedTest
    @MethodSource("generateMatchingCountAndBonusBall")
    void valueOf(final int matchingCount, final boolean bonusBall, final LottoRank lottoRank) {
        assertThat(LottoRank.valueOf(matchingCount, bonusBall)).isEqualByComparingTo(lottoRank);
    }

    private static Stream<Arguments> generateMatchingCountAndBonusBall() {
        return Stream.of(
                Arguments.of(6, true, LottoRank.FIRST),
                Arguments.of(5, true, LottoRank.SECOND),
                Arguments.of(5, false, LottoRank.THIRD),
                Arguments.of(4, true, LottoRank.FOURTH),
                Arguments.of(3, true, LottoRank.FIFTH),
                Arguments.of(2, true, LottoRank.NONE),
                Arguments.of(1, true, LottoRank.NONE),
                Arguments.of(0, true, LottoRank.NONE)
        );
    }

    @Test
    void matchCount() {
        assertThat(LottoRank.FIRST.matchCount(6)).isTrue();
        assertThat(LottoRank.FIRST.matchCount(5)).isFalse();
    }
}