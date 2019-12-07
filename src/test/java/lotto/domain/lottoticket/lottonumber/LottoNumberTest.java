package lotto.domain.lottoticket.lottonumber;

import lotto.domain.exception.InvalidLottoNumberCreationException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoNumberTest {

    @Test
    void create() {
        LottoNumber lottoNumber = LottoNumber.from(1);

        assertThat(lottoNumber).isNotNull();
    }

    @Test
    void equals() {
        LottoNumber lottoNumber = LottoNumber.from(1);

        assertThat(lottoNumber).isEqualTo(LottoNumber.from(1));
    }

    @Test
    void create_InvalidLottoNumberCreationException() {
        assertThrows(InvalidLottoNumberCreationException.class, () -> LottoNumber.from(LottoNumber.MIN_VALUE - 1));
        Exception exception = assertThrows(InvalidLottoNumberCreationException.class, () -> LottoNumber.from(LottoNumber.MAX_VALUE + 1));

        assertThat(exception.getMessage()).isEqualTo(InvalidLottoNumberCreationException.INVALID_LOTTO_NUMBER_CREATION_MESSAGE);
    }

    @Test
    void compareTo() {
        LottoNumber lottoNumber1 = LottoNumber.from(1);
        LottoNumber lottoNumber2 = LottoNumber.from(2);

        assertThat(lottoNumber1.compareTo(lottoNumber2)).isEqualTo(-1);
        assertThat(lottoNumber2.compareTo(lottoNumber1)).isEqualTo(1);
        assertThat(lottoNumber1.compareTo(LottoNumber.from(1))).isEqualTo(0);
    }
}