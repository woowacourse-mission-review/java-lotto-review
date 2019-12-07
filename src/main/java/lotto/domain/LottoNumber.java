package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class LottoNumber {
    static final int MIN_BOUNDARY = 1;
    static final int MAX_BOUNDARY = 45;
    static final String OUT_OF_BOUNDARY_MESSAGE = String.format("로또 번호는 %d~%d만 가능합니다.", MIN_BOUNDARY, MAX_BOUNDARY);

    private final int value;

    private LottoNumber(final int value) {
        validateRange(value);
        this.value = value;
    }

    private void validateRange(final int value) {
        if (value < MIN_BOUNDARY || value > MAX_BOUNDARY) {
            throw new IllegalArgumentException(OUT_OF_BOUNDARY_MESSAGE);
        }
    }

    public static LottoNumber of(final int value) {
        if (LottoNumberCache.CACHE.containsKey(value)) {
            return LottoNumberCache.CACHE.get(value);
        }
        return new LottoNumber(value);
    }

    public int value() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    private static class LottoNumberCache {
        private static final int LOW = 1;
        private static final int HIGH = 45;
        static final Map<Integer, LottoNumber> CACHE = new HashMap<>();

        static {
            IntStream.range(LOW, HIGH).forEach(number -> CACHE.put(number, LottoNumber.of(number)));
        }

    }
}
