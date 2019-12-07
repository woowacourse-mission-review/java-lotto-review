package lotto.domain;

import com.google.common.collect.Maps;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class LottoContainer {

    private final List<Lotto> lottos;

    public LottoContainer(final List<Lotto> lottos) {
        this.lottos = Collections.unmodifiableList(lottos);
    }

    public LottoContainer(final LottoContainer lottoContainer, final List<Lotto> lottos) {
        this.lottos = lottos;
        this.lottos.addAll(lottoContainer.lottos);
    }

    public WinningResult createResult(final WinningLotto winningLotto) {
        Map<Rank, Integer> result = initRankResult();
        for (Lotto lotto : lottos) {
            Rank rank = Rank.valueOf(winningLotto.getMatchCount(lotto), winningLotto.matchBonusNo(lotto));
            result.put(rank, result.get(rank) + 1);
        }
        return new WinningResult(result);
    }

    private Map<Rank, Integer> initRankResult() {
        Map<Rank, Integer> result = Maps.newHashMap();
        Arrays.stream(Rank.values())
                .forEach(rank -> result.put(rank, 0));
        return result;
    }
}
