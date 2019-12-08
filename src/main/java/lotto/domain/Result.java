package lotto.domain;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Stream;

public class Result {
    private static final int INIT_COUNT = 0;
    private static final int UNIT_INCREASE = 1;

    private final Map<Rank, Integer> countOfRanks = new EnumMap<>(Rank.class);

    public Result() {
        for (final Rank value : Rank.values()) {
            countOfRanks.put(value, INIT_COUNT);
        }
    }

    public int countOfRank(final Rank rank) {
        return countOfRanks.get(rank);
    }

    public void add(final Rank rank) {
        countOfRanks.put(rank, countOfRanks.get(rank) + UNIT_INCREASE);
    }

    public double calculateReturnOfRate(final LottoMoney lottoMoney) {
        final int totalOfPrize = Stream.of(Rank.values())
                .map(rank -> rank.multiplyPrize(countOfRanks.get(rank)))
                .reduce(0, Integer::sum);

        return (double) totalOfPrize / lottoMoney.value() * 100;
    }
}
