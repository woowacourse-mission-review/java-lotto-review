package lotto.domain;

import lotto.LottoNoTestUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static lotto.domain.Rank.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoContainerTest extends LottoNoTestUtils {

    @DisplayName("결과 생성 확인")
    @Test
    void create_result() {
        LottoContainer lottoContainer = new LottoContainer(Arrays.asList(
                Lotto.of(generateLottoNoList(1, 2, 3, 4, 5, 6)),
                Lotto.of(generateLottoNoList(38, 39, 40, 4, 5, 6)),
                Lotto.of(generateLottoNoList(24, 26, 28, 4, 5, 6))));
        WinningLotto winningLotto = WinningLotto.of(generateLottoNoList(1, 3, 4, 5, 6, 7), LottoNo.of(8));
        WinningResult winningResult = lottoContainer.createResult(winningLotto);

        assertEquals(winningResult.getCountOf(FIRST), 0);
        assertEquals(winningResult.getCountOf(SECOND), 0);
        assertEquals(winningResult.getCountOf(THIRD), 1);
        assertEquals(winningResult.getCountOf(FOURTH), 0);
        assertEquals(winningResult.getCountOf(FIFTH), 2);
        assertEquals(winningResult.getCountOf(MISS), 0);

        assertEquals(winningResult.getWinningMoney(), 1_510_000);

        assertEquals(winningResult.getEarningsRate(), 503);
    }
}