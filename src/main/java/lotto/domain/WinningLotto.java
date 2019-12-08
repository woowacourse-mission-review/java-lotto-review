package lotto.domain;

public class WinningLotto {
    static final String BONUS_NUMBER_DUPLICATE_MESSAGE = "보너스 번호는 당첨 번호와 중복될 수 없습니다.";

    private final LottoTicket lottoTicket;
    private final LottoNumber bonusNumber;

    public WinningLotto(final LottoTicket lottoTicket, final LottoNumber bonusNumber) {
        validateDuplicate(lottoTicket, bonusNumber);
        this.lottoTicket = lottoTicket;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicate(final LottoTicket lottoTicket, final LottoNumber bonusNumber) {
        if (lottoTicket.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE_MESSAGE);
        }
    }

    public static WinningLotto of(final LottoTicket lottoTicket, final LottoNumber bonusNumber) {
        return new WinningLotto(lottoTicket, bonusNumber);
    }

    public Rank calculateRank(final LottoTicket userLottoTicket) {
        final int countOfMatch = userLottoTicket.match(this.lottoTicket);
        final boolean bonus = userLottoTicket.contains(this.bonusNumber);
        return Rank.of(countOfMatch, bonus);
    }
}
