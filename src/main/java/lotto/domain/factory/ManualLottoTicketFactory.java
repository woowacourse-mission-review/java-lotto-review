package lotto.domain.factory;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;

import java.util.ArrayList;
import java.util.List;

public class ManualLottoTicketFactory implements LottoTicketFactory {
    private final List<LottoNumber> lottoNumbers;

    public ManualLottoTicketFactory(final List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = new ArrayList<>(lottoNumbers);
        validateEmpty();
    }

    private void validateEmpty() {
        if (lottoNumbers.isEmpty()) {
            throw new IllegalArgumentException("로또 번호를 입력해주세요");
        }
    }

    @Override
    public LottoTicket create() {
        return LottoTicket.of(lottoNumbers);
    }
}
