package lotto.domain.factory;

import lotto.domain.LottoNumber;

import java.util.Collections;
import java.util.List;

public class ShuffleRandomStrategy implements ShuffleStrategy {

    private ShuffleRandomStrategy() {
    }

    public static ShuffleRandomStrategy getInstance() {
        return LazyHolder.INSTANCE;
    }

    @Override
    public List<LottoNumber> shuffle(final List<LottoNumber> lottoNumbers) {
        Collections.shuffle(lottoNumbers);
        return lottoNumbers;
    }

    private static class LazyHolder {
        private static final ShuffleRandomStrategy INSTANCE = new ShuffleRandomStrategy();
    }
}
