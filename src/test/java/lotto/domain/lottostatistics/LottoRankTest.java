package lotto.domain.lottostatistics;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankTest {

    @Test
    void values() {
        assertThat(LottoRank.valueOf(6, true)).isEqualByComparingTo(LottoRank.FIRST);
        assertThat(LottoRank.valueOf(5, true)).isEqualByComparingTo(LottoRank.SECOND);
        assertThat(LottoRank.valueOf(5, false)).isEqualByComparingTo(LottoRank.THIRD);
        assertThat(LottoRank.valueOf(4, true)).isEqualByComparingTo(LottoRank.FOURTH);
        assertThat(LottoRank.valueOf(3, true)).isEqualByComparingTo(LottoRank.FIFTH);

        assertThat(LottoRank.valueOf(2, true)).isEqualByComparingTo(LottoRank.NONE);
        assertThat(LottoRank.valueOf(1, true)).isEqualByComparingTo(LottoRank.NONE);
        assertThat(LottoRank.valueOf(0, true)).isEqualByComparingTo(LottoRank.NONE);
    }

    @Test
    void matchCount() {
        assertThat(LottoRank.FIRST.matchCount(6)).isTrue();
        assertThat(LottoRank.FIRST.matchCount(5)).isFalse();
    }
}