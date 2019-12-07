package lotto.domain;

import lotto.LottoNoTestUtils;
import lotto.exception.WinningNoContainsBonusNoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.exception.WinningNoContainsBonusNoException.WINNING_NO_CONTAINS_BONUS_NO_EXCEPTION_MESSAGE;
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

    @DisplayName("입력 받은 로또와 같은 번호를 몇 개 가지고 있는지")
    @Test
    void compare_match_no() {
        Lotto lotto = Lotto.of(generateLottoNoList(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = WinningLotto.of(generateLottoNoList(1, 2, 3, 4, 7, 8), LottoNo.of(10));

        assertEquals(winningLotto.getMatchCount(lotto), 4);
    }

    @DisplayName("보너스 번호를 입력받은 로또가 포함하고 있을 경우 matchBonusNo 메서드가 true 리턴하는지")
    @Test
    void match_bonus_no() {
        Lotto lotto = Lotto.of(generateLottoNoList(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = WinningLotto.of(generateLottoNoList(1, 2, 3, 4, 7, 8), LottoNo.of(6));

        assertTrue(winningLotto.matchBonusNo(lotto));
    }

    @DisplayName("보너스 번호를 입력받은 로또가 포함하지 않을 경우 matchBonusNo 메서드가 false 리턴하는지")
    @Test
    void not_match_bonus_no() {
        Lotto lotto = Lotto.of(generateLottoNoList(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = WinningLotto.of(generateLottoNoList(1, 2, 3, 4, 7, 8), LottoNo.of(9));

        assertFalse(winningLotto.matchBonusNo(lotto));
    }
}