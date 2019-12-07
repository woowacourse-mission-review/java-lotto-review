package lotto.domain.lottoticket;

import lotto.domain.exception.DuplicateLottoNumbersException;
import lotto.domain.exception.IllegalLottoSizeException;
import lotto.domain.lottoticket.lottonumber.LottoNumber;
import lotto.domain.lottoticket.lottonumber.LottoNumberPool;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoTicketTest {

    List<LottoNumber> properLottoNumbers;
    List<LottoNumber> duplicateLottoNumbers;
    List<LottoNumber> illegalLottoSizeNumbers;

    @BeforeEach
    void setUp() {
        properLottoNumbers = Arrays.asList(LottoNumberPool.get(6), LottoNumberPool.get(5), LottoNumberPool.get(4)
                , LottoNumberPool.get(3), LottoNumberPool.get(2), LottoNumberPool.get(1));
        duplicateLottoNumbers = Arrays.asList(LottoNumberPool.get(1), LottoNumberPool.get(1), LottoNumberPool.get(3)
                , LottoNumberPool.get(4), LottoNumberPool.get(5), LottoNumberPool.get(6));
        illegalLottoSizeNumbers = Arrays.asList(LottoNumberPool.get(1), LottoNumberPool.get(2), LottoNumberPool.get(3)
                , LottoNumberPool.get(4), LottoNumberPool.get(5));
    }

    @Test
    void create() {
        LottoTicket lottoTicket = LottoTicket.of(properLottoNumbers);

        assertThat(lottoTicket).isNotNull();
    }

    @Test
    void equals() {
        LottoTicket lottoTicket = LottoTicket.of(properLottoNumbers);

        assertThat(lottoTicket).isEqualTo(LottoTicket.of(properLottoNumbers));
    }

    @Test
    void sort() {
        LottoTicket lottoTicket = LottoTicket.of(properLottoNumbers);

        assertThat(lottoTicket.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @Test
    void create_DuplicateLottoNumbersException() {
        Exception exception = assertThrows(DuplicateLottoNumbersException.class, () -> LottoTicket.of(duplicateLottoNumbers));

        assertThat(exception.getMessage()).isEqualTo(DuplicateLottoNumbersException.DUPLICATE_LOTTO_NUMBERS_MESSAGE);
    }

    @Test
    void create_IllegalLottoSizeException() {
        Exception exception = assertThrows(IllegalLottoSizeException.class, () -> LottoTicket.of(illegalLottoSizeNumbers));

        assertThat(exception.getMessage()).isEqualTo(IllegalLottoSizeException.ILLEGAL_LOTTO_SIZE_MESSAGE);
    }

    @Test
    void contains() {
        LottoTicket lottoTicket = LottoTicket.of(properLottoNumbers);

        for (LottoNumber lottoNumber : properLottoNumbers) {
            assertThat(lottoTicket.contains(lottoNumber)).isTrue();
        }
        assertThat(lottoTicket.contains(LottoNumberPool.get(7))).isFalse();
    }

    @Test
    void match() {
        LottoTicket winningTicket = LottoTicket.of(properLottoNumbers);

        List<LottoNumber> numbers = Arrays.asList(LottoNumberPool.get(1), LottoNumberPool.get(2), LottoNumberPool.get(3)
                , LottoNumberPool.get(4), LottoNumberPool.get(5), LottoNumberPool.get(7));
        LottoTicket lottoTicket = LottoTicket.of(numbers);

        assertThat(winningTicket.match(lottoTicket)).isEqualTo(5);
    }
}