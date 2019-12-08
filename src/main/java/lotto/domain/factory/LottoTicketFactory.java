package lotto.domain.factory;

import lotto.domain.LottoTicket;

@FunctionalInterface
public interface LottoTicketFactory {
    LottoTicket create();
}
