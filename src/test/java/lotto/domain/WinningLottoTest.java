package lotto.domain;

import lotto.LottoNoTestUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.domain.WinningNoContainsBonusNoException.WINNING_NO_CONTAINS_BONUS_NO_EXCEPTION_MESSAGE;
import static org.junit.jupiter.api.Assertions.*;

class WinningLottoTest extends LottoNoTestUtils {

    @DisplayName("WinningLotto 생성")
    @Test
    void generate_winning_lotto() {
        assertDoesNotThrow(() -> WinningLotto.of(generateLottoNoList(1, 2, 3, 4, 5, 6), LottoNo.of(7)));
    }

    @DisplayName("당첨 번호가 보너스 번호를 포함하는 경우 에러 발생")
    @Test
    void generate_winning_lotto_winning_no_contains_bonus_no() {
        WinningNoContainsBonusNoException e = assertThrows(WinningNoContainsBonusNoException.class,
                () -> WinningLotto.of(generateLottoNoList(1, 2, 3, 4, 5, 6), LottoNo.of(6)));
        assertEquals(e.getMessage(), WINNING_NO_CONTAINS_BONUS_NO_EXCEPTION_MESSAGE);
    }
}