package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class LottoNumberCollection {
    private static final Map<Integer, LottoNumber> CACHE = new HashMap<>();

    static {
        IntStream.range(LottoNumber.MIN_BOUNDARY, LottoNumber.MAX_BOUNDARY + 1).forEach(number -> CACHE.put(number, LottoNumber.of(number)));
    }

    private LottoNumberCollection() {
    }

    public static LottoNumber get(final int value) {
        return CACHE.get(value);
    }

    public static boolean containsKey(final int value) {
        return CACHE.containsKey(value);
    }

    public static List<LottoNumber> copy() {
        return new ArrayList<>(CACHE.values());
    }
}
