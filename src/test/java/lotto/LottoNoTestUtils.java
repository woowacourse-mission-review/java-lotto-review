package lotto;

import lotto.domain.LottoNo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNoTestUtils {

    public List<LottoNo> generateLottoNoList(int... lottoNo) {
        return Arrays.stream(lottoNo)
                .mapToObj(LottoNo::of)
                .collect(Collectors.toList());
    }
}
