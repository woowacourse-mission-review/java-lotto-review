package lotto.domain;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.Lotto.LOTTO_NO_SIZE;

public class RandomLottoGenerator {

    private static final List<LottoNo> lottoNos = LottoNo.lottoNos();
    private static final int BASE_INDEX = 0;

    public List<Lotto> generateLottos(int lottoSize) {
        return IntStream.range(BASE_INDEX, lottoSize)
                .mapToObj(index -> generateLotto())
                .collect(Collectors.toList());
    }

    private Lotto generateLotto() {
        List<LottoNo> copy = Lists.newArrayList(lottoNos);
        Collections.shuffle(copy);
        return Lotto.of(copy.subList(BASE_INDEX, LOTTO_NO_SIZE));
    }
}
