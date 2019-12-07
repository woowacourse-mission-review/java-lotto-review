package lotto.domain.lottoticket;

import lotto.domain.exception.BonusBallCreationException;
import lotto.domain.lottostatistics.LottoRank;
import lotto.domain.lottoticket.lottonumber.LottoNumber;

import java.util.Objects;

public class WinningLotto {

    private final LottoTicket winningLottoTicket;
    private final LottoNumber bonusBall;

    private WinningLotto(final LottoTicket winningLottoTicket, final LottoNumber bonusBall) {
        if (winningLottoTicket.contains(bonusBall)) {
            throw new BonusBallCreationException();
        }

        this.winningLottoTicket = winningLottoTicket;
        this.bonusBall = bonusBall;
    }

    public static WinningLotto of(final LottoTicket lottoTicket, final LottoNumber bonusBall) {
        return new WinningLotto(lottoTicket, bonusBall);
    }

    public LottoRank match(final LottoTicket ticket) {
        int matchingCount = winningLottoTicket.match(ticket);
        boolean hasBonusBall = ticket.contains(bonusBall);

        return LottoRank.valueOf(matchingCount, hasBonusBall);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final WinningLotto that = (WinningLotto) o;
        return Objects.equals(winningLottoTicket, that.winningLottoTicket) &&
                Objects.equals(bonusBall, that.bonusBall);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningLottoTicket, bonusBall);
    }

    @Override
    public String toString() {
        return "WinningLotto{" +
                "lottoTicket=" + winningLottoTicket +
                ", bonusBall=" + bonusBall +
                '}';
    }
}
