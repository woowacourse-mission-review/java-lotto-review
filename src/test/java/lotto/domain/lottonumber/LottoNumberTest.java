package lotto.domain.lottonumber;

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
}