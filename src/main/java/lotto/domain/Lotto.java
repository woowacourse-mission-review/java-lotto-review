package lotto.domain;

import com.google.common.collect.Sets;
import lotto.exception.DuplicatedLottoNoException;
import lotto.exception.InvalidLottoNoSizeException;

import java.util.List;

public class Lotto {

    static final int LOTTO_PRICE = 1000;
    public static final int LOTTO_NO_SIZE = 6;

    private final List<LottoNo> lottoNos;

    private Lotto(final List<LottoNo> lottoNos) {
        validateLottoNoSize(lottoNos);
        validateNotDuplicated(lottoNos);
        this.lottoNos = lottoNos;
    }

    public static Lotto of(final List<LottoNo> lottoNos) {
        return new Lotto(lottoNos);
    }

    private void validateLottoNoSize(final List<LottoNo> lottoNos) {
        if (lottoNos.size() != LOTTO_NO_SIZE) {
            throw new InvalidLottoNoSizeException();
        }
    }

    private void validateNotDuplicated(final List<LottoNo> lottoNos) {
        if (lottoNos.size() != Sets.newHashSet(lottoNos).size()) {
            throw new DuplicatedLottoNoException();
        }
    }

    public boolean contains(final LottoNo lottoNo) {
        return lottoNos.contains(lottoNo);
    }

    int getMatchCount(final Lotto lotto) {
        return Math.toIntExact(lottoNos.stream()
                .filter(lotto::contains)
                .count());
    }
}
