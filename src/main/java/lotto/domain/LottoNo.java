package lotto.domain;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class LottoNo {

    public static final int MIN_LOTTO_NO = 1;
    public static final int MAX_LOTTO_NO = 45;

    private static final Map<Integer, LottoNo> LOTTO_NO_POOL = Maps.newHashMap();

    static {
        IntStream.range(MIN_LOTTO_NO, MAX_LOTTO_NO + 1)
                .forEach(number -> LOTTO_NO_POOL.put(number, new LottoNo(number)));
    }

    private final int lottoNo;

    private LottoNo(int lottoNo) {
        this.lottoNo = lottoNo;
    }

    public static LottoNo of(final int lottoNo) {
        if (lottoNo < MIN_LOTTO_NO || lottoNo > MAX_LOTTO_NO) {
            throw new InvalidRangeException();
        }
        return LOTTO_NO_POOL.get(lottoNo);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final LottoNo lottoNo1 = (LottoNo) o;
        return lottoNo == lottoNo1.lottoNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNo);
    }
}
