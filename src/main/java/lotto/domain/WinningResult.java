package lotto.domain;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

import static lotto.domain.Lotto.LOTTO_PRICE;

public class WinningResult {

    private static final int DEFAULT_VALUE = 0;

    private final Map<Rank, Integer> result;

    public WinningResult(final Map<Rank, Integer> result) {
        this.result = Collections.unmodifiableMap(result);
    }

    public int getCountOf(Rank rank) {
        return result.getOrDefault(rank, DEFAULT_VALUE);
    }

    public BigInteger getWinningMoney() {
        return Arrays.stream(Rank.values())
                .map(rank -> BigInteger.valueOf(rank.getWinningMoney()).multiply(BigInteger.valueOf(result.get(rank))))
                .reduce(BigInteger::add)
                .get();
    }

    public BigInteger getEarningsRate() {
        int lottoCount = result.values().stream().reduce(0, Integer::sum);
        return getWinningMoney().divide(BigInteger.valueOf(LOTTO_PRICE * lottoCount));
    }
}
