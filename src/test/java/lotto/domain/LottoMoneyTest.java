package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoMoneyTest {

    @ParameterizedTest
    @ValueSource(ints = {-10, 10, 0, 150, 999, 2050})
    void 금액_1000_단위_아니면_예외처리(final int input) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> LottoMoney.of(input));

        assertThat(exception.getMessage()).isEqualTo(LottoMoney.INVALID_PRICE_EXCEPTION_MESSAGE);
    }

    @Test
    void 논리적_동치성_테스트() {
        assertThat(LottoMoney.of(1000)).isEqualTo(LottoMoney.of(1000));
    }

    @Test
    void 구매갯수_구하기() {
        final int money = 10000;
        final LottoMoney lottoMoney = LottoMoney.of(money);
        final int countOfPurchase = lottoMoney.countOfPurchase();

        assertThat(countOfPurchase).isEqualTo(money / LottoMoney.PRICE_PER_LOTTO_TICKET);
    }
}