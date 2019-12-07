package lotto.domain;

import java.util.List;

public class WinningLotto {

    private final Lotto winningNo;
    private final LottoNo bonusNo;

    private WinningLotto(final Lotto winningNo, final LottoNo bonusNo) {
        validateWinningNoNotContains(winningNo, bonusNo);
        this.winningNo = winningNo;
        this.bonusNo = bonusNo;
    }

    public static WinningLotto of(final List<LottoNo> winningNo, final LottoNo bonusNo) {
        return new WinningLotto(Lotto.of(winningNo), bonusNo);
    }

    private void validateWinningNoNotContains(final Lotto winningNo, final LottoNo bonusNo) {
        if (winningNo.contains(bonusNo)) {
            throw new WinningNoContainsBonusNoException();
        }
    }
}
