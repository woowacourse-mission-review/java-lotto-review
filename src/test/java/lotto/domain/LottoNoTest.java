package lotto.domain;

import lotto.exception.InvalidRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.domain.LottoNo.MAX_LOTTO_NO;
import static lotto.domain.LottoNo.MIN_LOTTO_NO;
import static lotto.exception.InvalidRangeException.INVALID_RANGE_EXCEPTION_MESSAGE;
import static org.junit.jupiter.api.Assertions.*;

class LottoNoTest {

    @DisplayName("로또 번호 풀에서 최솟값을 정상적으로 꺼내오는지")
    @Test
    void generate_lotto_no_with_min_value() {
        assertDoesNotThrow(() -> LottoNo.of(MIN_LOTTO_NO));
    }

    @DisplayName("로또 번호 풀에서 최댓값을 정상적으로 꺼내오는지")
    @Test
    void generate_lotto_no_with_max_value() {
        assertDoesNotThrow(() -> LottoNo.of(MAX_LOTTO_NO));
    }

    @DisplayName("로또 번호 풀에서 최솟값보다 작은 값을 입력한 경우 에러가 발생하는지")
    @Test
    void generate_lotto_no_with_under_min_value() {
        InvalidRangeException e = assertThrows(InvalidRangeException.class, () -> LottoNo.of(MIN_LOTTO_NO - 1));
        assertEquals(e.getMessage(), INVALID_RANGE_EXCEPTION_MESSAGE);
    }

    @DisplayName("로또 번호 풀에서 최댓값보다 큰 값을 입력한 경우 에러가 발생하는지")
    @Test
    void generate_lotto_no_with_over_max_value() {
        InvalidRangeException e = assertThrows(InvalidRangeException.class, () -> LottoNo.of(MAX_LOTTO_NO + 1));
        assertEquals(e.getMessage(), INVALID_RANGE_EXCEPTION_MESSAGE);
    }

    @DisplayName("같은 숫자로 입력했을 때 같은 객체를 꺼내오는지")
    @Test
    void assert_same_object_between_same_number() {
        assertSame(LottoNo.of(MIN_LOTTO_NO), LottoNo.of(MIN_LOTTO_NO));
    }
}