package lotto.domain.factory;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumberCollection;
import lotto.domain.LottoTicket;

import java.util.List;

public class AutoLottoTicketFactory implements LottoTicketFactory {
    private final ShuffleStrategy shuffleStrategy;

    public AutoLottoTicketFactory(final ShuffleStrategy shuffleStrategy) {
        this.shuffleStrategy = shuffleStrategy;
    }

    @Override
    public LottoTicket create() {
        final List<LottoNumber> lottoNumbers = LottoNumberCollection.copy();
        final List<LottoNumber> shuffled = shuffleStrategy.shuffle(lottoNumbers);
        final List<LottoNumber> lottoNumbersForLottoTicket = shuffled.subList(0, LottoTicket.COUNT_OF_LOTTO_NUMBERS);
        return LottoTicket.of(lottoNumbersForLottoTicket);
    }
}
