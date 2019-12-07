package lotto.domain.lottostatistics;

import lotto.domain.LottoPurchaseAmount;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsTest {

    Map<LottoRank, Long> statistics;

    @BeforeEach
    void setUp() {
        statistics = new HashMap<>();
        statistics.put(LottoRank.FIRST, 0L);
        statistics.put(LottoRank.SECOND, 0L);
        statistics.put(LottoRank.THIRD, 0L);
        statistics.put(LottoRank.FOURTH, 0L);
        statistics.put(LottoRank.FIFTH, 1L);
    }

    @Test
    void create() {
        LottoStatistics lottoStatistics = LottoStatistics.from(statistics);

        assertThat(lottoStatistics).isNotNull();
    }

    @Test
    void findMatchingCountBy() {
        LottoStatistics lottoStatistics = LottoStatistics.from(statistics);

        assertThat(lottoStatistics.findMatchingCountBy(LottoRank.FIRST)).isEqualTo(0L);
        assertThat(lottoStatistics.findMatchingCountBy(LottoRank.SECOND)).isEqualTo(0L);
        assertThat(lottoStatistics.findMatchingCountBy(LottoRank.THIRD)).isEqualTo(0L);
        assertThat(lottoStatistics.findMatchingCountBy(LottoRank.FOURTH)).isEqualTo(0L);
        assertThat(lottoStatistics.findMatchingCountBy(LottoRank.FIFTH)).isEqualTo(1L);
    }

    @Test
    void calculateYield() {
        LottoStatistics lottoStatistics = LottoStatistics.from(statistics);

        double yield = lottoStatistics.calculateYield(LottoPurchaseAmount.from(14000L));
        assertThat(yield).isCloseTo(0.36, Offset.offset(0.009));
    }

    @Test
    void calculateYieldByPercent() {
        LottoStatistics lottoStatistics = LottoStatistics.from(statistics);

        double yield = lottoStatistics.calculateYieldByPercent(LottoPurchaseAmount.from(14000L));
        assertThat(yield).isCloseTo(36, Offset.offset(0.9));
    }
}