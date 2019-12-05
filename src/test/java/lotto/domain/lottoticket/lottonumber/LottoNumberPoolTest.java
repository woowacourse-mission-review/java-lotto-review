package lotto.domain.lottoticket.lottonumber;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberPoolTest {

    @Test
    void caching() {
        LottoNumber lottoNumber = LottoNumberPool.get(1);

        assertThat(lottoNumber).isEqualTo(LottoNumber.from(1));
        assertThat(lottoNumber == LottoNumberPool.get(1)).isTrue();
    }
}