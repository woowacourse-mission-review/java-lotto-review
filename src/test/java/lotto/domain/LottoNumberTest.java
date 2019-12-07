package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.domain.LottoNumber.MAX_BOUNDARY;
import static lotto.domain.LottoNumber.MIN_BOUNDARY;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoNumberTest {

    @Test
    void 논리적_동치성_테스트() {
        assertThat(LottoNumber.of(15)).isEqualTo(LottoNumber.of(15));
    }

    @Test
    void 캐싱_테스트() {
        assertSame(LottoNumber.of(15), LottoNumber.of(15));
    }

    @ParameterizedTest
    @ValueSource(ints = {MIN_BOUNDARY - 1, MAX_BOUNDARY + 1})
    void 최소_최대값_초과_예외처리(final int input) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> LottoNumber.of(input));

        assertThat(exception.getMessage()).isEqualTo(LottoNumber.OUT_OF_BOUNDARY_MESSAGE);
    }
}