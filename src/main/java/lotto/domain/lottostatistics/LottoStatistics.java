package lotto.domain.lottostatistics;

import lotto.domain.LottoPurchaseAmount;

import java.util.Map;

public class LottoStatistics {

    private static final long ERROR_VALUE_OF_CALCULATING_TOTAL_PRIZE = 0L;
    private Map<LottoRank, Long> statistics;

    private LottoStatistics(Map<LottoRank, Long> statistics) {
        this.statistics = statistics;
    }

    static LottoStatistics from(Map<LottoRank, Long> statistics) {
        return new LottoStatistics(statistics);
    }

    public long findWinningCountBy(final LottoRank lottoRank) {
        return statistics.get(lottoRank);
    }

    public double calculateYield(final LottoPurchaseAmount lottoPurchaseAmount) {
        long totalPrize = calculateTotalPrize();
        return calculateYieldWithTotalPrize(totalPrize, lottoPurchaseAmount);
    }

    private long calculateTotalPrize() {
        return statistics.entrySet().stream()
                .map(this::calculatePrizeOfLottoRank)
                .reduce(Long::sum)
                .orElse(ERROR_VALUE_OF_CALCULATING_TOTAL_PRIZE);
    }

    private long calculatePrizeOfLottoRank(final Map.Entry<LottoRank, Long> entry) {
        long prize = findPrizeFrom(entry);
        long winningCount = entry.getValue();

        return prize * winningCount;
    }

    private long findPrizeFrom(final Map.Entry<LottoRank, Long> entry) {
        LottoRank lottoRank = entry.getKey();
        return lottoRank.getPrize();
    }

    private double calculateYieldWithTotalPrize(final double totalPrize, final LottoPurchaseAmount lottoPurchaseAmount) {
        return totalPrize / lottoPurchaseAmount.getAmount();
    }
}
