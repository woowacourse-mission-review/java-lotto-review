package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoTicket implements Iterable<LottoNumber> {
    public static final int COUNT_OF_LOTTO_NUMBERS = 6;
    static final String NOT_MATCH_COUNT_OF_NUMBERS_MESSAGE = "로또 번호는 6개야 합니다.";
    static String DUPLICATE_NUMBERS_MESSAGE = "로또 번호는 중복될 수 없습니다.";

    private final List<LottoNumber> lottoNumbers;

    private LottoTicket(final List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = sort(lottoNumbers);

        validateCountOfNumbers();
        validateDuplicate();
    }

    private List<LottoNumber> sort(final List<LottoNumber> lottoNumbers) {
        return lottoNumbers.stream()
                .sorted(Comparator.comparingInt(LottoNumber::value))
                .collect(Collectors.toList());
    }

    private void validateCountOfNumbers() {
        if (lottoNumbers.size() != COUNT_OF_LOTTO_NUMBERS) {
            throw new IllegalArgumentException(NOT_MATCH_COUNT_OF_NUMBERS_MESSAGE);
        }
    }

    private void validateDuplicate() {
        final HashSet<LottoNumber> set = new HashSet<>(lottoNumbers);
        if (set.size() != COUNT_OF_LOTTO_NUMBERS) {
            throw new IllegalArgumentException(DUPLICATE_NUMBERS_MESSAGE);
        }
    }

    public static LottoTicket of(final List<LottoNumber> lottoNumbers) {
        return new LottoTicket(lottoNumbers);
    }

    public int match(final LottoTicket other) {
        return (int) other.lottoNumbers.stream()
                .filter(this.lottoNumbers::contains)
                .count();
    }

    public boolean contains(final LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    @Override
    public Iterator<LottoNumber> iterator() {
        return new Iterator<LottoNumber>() {
            int cursor = 0;

            @Override
            public boolean hasNext() {
                return cursor < lottoNumbers.size();
            }

            @Override
            public LottoNumber next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return lottoNumbers.get(cursor++);
            }
        };
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final LottoTicket that = (LottoTicket) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumbers);
    }
}
