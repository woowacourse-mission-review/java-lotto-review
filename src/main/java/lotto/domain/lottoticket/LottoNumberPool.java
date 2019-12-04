package lotto.domain.lottoticket;

import java.util.HashMap;
import java.util.Map;

public class LottoNumberPool {

    private static final Map<Integer, LottoNumber> LOTTO_NUMBERS = new HashMap<>();

    private LottoNumberPool() {
    }

    public static LottoNumber get(final int number) {
        if (LOTTO_NUMBERS.containsKey(number)) {
            return LOTTO_NUMBERS.get(number);
        }

        return createWithCaching(number);
    }

    private static LottoNumber createWithCaching(final int number) {
        LottoNumber newLottoNumber = LottoNumber.from(number);
        LOTTO_NUMBERS.put(number, newLottoNumber);

        return newLottoNumber;
    }
}
