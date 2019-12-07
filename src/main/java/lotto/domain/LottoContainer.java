package lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoContainer {

    private final List<Lotto> lottos;

    public LottoContainer(final List<Lotto> lottos) {
        this.lottos = Collections.unmodifiableList(lottos);
    }

    public LottoContainer(final LottoContainer lottoContainer, final List<Lotto> lottos) {
        this.lottos = lottos;
        this.lottos.addAll(lottoContainer.lottos);
    }
}
