package lotto.domain.lottoticket;

import lotto.domain.exception.DuplicateLottoNumbersException;
import lotto.domain.exception.IllegalLottoSizeException;
import lotto.domain.lottoticket.lottonumber.LottoNumber;

import java.util.*;

public class LottoTicket {

    public static final int SIZE_OF_LOTTO_TICKETS = 6;
    private final List<LottoNumber> lottoNumbers;

    private LottoTicket(final List<LottoNumber> lottoNumbers) {
        if (mismatchLottoSize(lottoNumbers)) {
            throw new IllegalLottoSizeException();
        }

        if (hasDuplicateNumbersIn(lottoNumbers)) {
            throw new DuplicateLottoNumbersException();
        }

        Collections.sort(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private boolean mismatchLottoSize(final List<LottoNumber> lottoNumbers) {
        return lottoNumbers.size() != SIZE_OF_LOTTO_TICKETS;
    }

    private boolean hasDuplicateNumbersIn(final List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> lottoNumberSet = new HashSet<>(lottoNumbers);
        return lottoNumberSet.size() != SIZE_OF_LOTTO_TICKETS;
    }

    public static LottoTicket of(final List<LottoNumber> lottoNumbers) {
        return new LottoTicket(lottoNumbers);
    }

    public boolean contains(final LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public int match(final LottoTicket ticket) {
        long count = lottoNumbers.stream()
                .filter(ticket::contains)
                .count();

        return (int) count;
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
        return lottoNumbers.toString();
    }
}
