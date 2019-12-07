package lotto.domain.lottostatistics;

import lotto.domain.lottoticket.PurchasedLottoTickets;
import lotto.domain.lottoticket.WinningLotto;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoStatisticsFactory {

    private static final long INITIAL_COUNT_OF_RANK = 0L;

    private LottoStatisticsFactory() {
    }

    public static LottoStatisticsFactory getInstance() {
        return LazyHolder.INSTANCE;
    }

    public LottoStatistics calculateStatisticsWith(WinningLotto winningLotto, PurchasedLottoTickets purchasedLottoTickets) {
        List<LottoRank> ranks = purchasedLottoTickets.matchWith(winningLotto);

        Map<LottoRank, Long> statistics = createStatisticsByCounting(ranks);

        return LottoStatistics.from(statistics);
    }

    private Map<LottoRank, Long> createStatisticsByCounting(final List<LottoRank> ranks) {
        Map<LottoRank, Long> statistics = initiateStatistics();
        ranks.forEach(rank -> increaseCount(statistics, rank));

        return statistics;
    }

    private Map<LottoRank, Long> initiateStatistics() {
        Map<LottoRank, Long> statistics = new EnumMap<>(LottoRank.class);
        Arrays.stream(LottoRank.values())
                .forEach(lottoRank -> statistics.put(lottoRank, INITIAL_COUNT_OF_RANK));

        return statistics;
    }

    private void increaseCount(final Map<LottoRank, Long> statistics, final LottoRank rank) {
        Long countOfRank = statistics.get(rank);
        statistics.put(rank, countOfRank + 1);
    }

    private static class LazyHolder {
        private static final LottoStatisticsFactory INSTANCE = new LottoStatisticsFactory();
    }
}
