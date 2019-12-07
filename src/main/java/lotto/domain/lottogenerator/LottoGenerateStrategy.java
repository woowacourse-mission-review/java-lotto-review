package lotto.domain.lottogenerator;

import lotto.domain.lottoticket.LottoTicket;

public interface LottoGenerateStrategy {
    LottoTicket generate();
}
