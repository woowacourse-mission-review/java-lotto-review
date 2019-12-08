package lotto.domain;

import lotto.exception.DuplicatedLottoNoException;
import lotto.exception.InvalidLottoNoSizeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.exception.DuplicatedLottoNoException.DUPLICATED_LOTTO_NO_EXCEPTION_MESSAGE;
import static lotto.exception.InvalidLottoNoSizeException.INVALID_LOTTO_NO_SIZE_EXCEPTION_MESSAGE;
import static lotto.utils.LottoUtils.parse;
import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

    @DisplayName("로또 정상 생성")
    @Test
    void generate_lotto() {
        assertDoesNotThrow(() -> Lotto.of(parse(1, 2, 3, 4, 5, 6)));
    }

    @DisplayName("로또 번호의 갯수보다 적은 갯수를 입력하는 경우 로또 생성 에러")
    @Test
    void generate_lotto_with_under_lotto_no_size() {
        InvalidLottoNoSizeException e = assertThrows(InvalidLottoNoSizeException.class,
                () -> Lotto.of(parse(1, 2, 3, 4, 5)));
        assertEquals(e.getMessage(), INVALID_LOTTO_NO_SIZE_EXCEPTION_MESSAGE);
    }

    @DisplayName("로또 번호의 갯수보다 많은 갯수를 입력하는 경우 로또 생성 에러")
    @Test
    void generate_lotto_with_over_lotto_no_size() {
        InvalidLottoNoSizeException e = assertThrows(InvalidLottoNoSizeException.class,
                () -> Lotto.of(parse(1, 2, 3, 4, 5, 6, 7)));
        assertEquals(e.getMessage(), INVALID_LOTTO_NO_SIZE_EXCEPTION_MESSAGE);
    }

    @DisplayName("중복된 로또 번호를 입력하는 경우 로또 생성 에러")
    @Test
    void generate_lotto_with_duplicate_no() {
        DuplicatedLottoNoException e = assertThrows(DuplicatedLottoNoException.class,
                () -> Lotto.of(parse(1, 1, 2, 3, 4, 5)));
        assertEquals(e.getMessage(), DUPLICATED_LOTTO_NO_EXCEPTION_MESSAGE);
    }

    @DisplayName("특정 로또 번호를 가지고 있을 때 contains 메서드가 true 를 리턴하는지")
    @Test
    void contains_certain_lotto_no() {
        Lotto lotto = Lotto.of(parse(1, 2, 3, 4, 5, 6));
        assertTrue(lotto.contains(LottoNo.of(1)));
    }

    @DisplayName("특정 로또 번호를 가지고 있지 않을 때 contains 메서드가 false 를 리턴하는지")
    @Test
    void not_contains_certain_lotto_no() {
        Lotto lotto = Lotto.of(parse(1, 2, 3, 4, 5, 6));
        assertFalse(lotto.contains(LottoNo.of(7)));
    }

    @DisplayName("getLottos로 꺼내온 번호들이 입력할 때 받은 값들인지")
    @Test
    void getter() {
        int[] params = {1, 2, 3, 4, 5, 6};
        List<LottoNo> lottoNos = parse(params);
        Lotto lotto = Lotto.of(parse(params));
        lotto.getLottoNos().containsAll(lottoNos);
    }
}