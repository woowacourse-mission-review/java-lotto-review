package lotto.domain.lottoticket;

import lotto.domain.exception.BonusBallCreationException;

import java.util.Objects;

public class WinningLotto {

    private final LottoTicket lottoTicket;
    private final LottoNumber bonusBall;

    private WinningLotto(final LottoTicket lottoTicket, final LottoNumber bonusBall) {
        if (lottoTicket.contains(bonusBall)) {
            throw new BonusBallCreationException();
        }

        this.lottoTicket = lottoTicket;
        this.bonusBall = bonusBall;
    }

    public static WinningLotto of(final LottoTicket lottoTicket, final LottoNumber bonusBall) {
        return new WinningLotto(lottoTicket, bonusBall);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final WinningLotto that = (WinningLotto) o;
        return Objects.equals(lottoTicket, that.lottoTicket) &&
                Objects.equals(bonusBall, that.bonusBall);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoTicket, bonusBall);
    }

    @Override
    public String toString() {
        return "WinningLotto{" +
                "lottoTicket=" + lottoTicket +
                ", bonusBall=" + bonusBall +
                '}';
    }
}
