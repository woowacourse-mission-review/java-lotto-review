package lotto.domain.factory;

import lotto.domain.LottoNumber;

import java.util.List;

@FunctionalInterface
public interface ShuffleStrategy {
    List<LottoNumber> shuffle(final List<LottoNumber> lottoNumbers);
}
