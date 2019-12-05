package lotto.domain.lottogenerator;

import lotto.domain.lottoticket.LottoTicket;
import lotto.domain.lottoticket.LottoTickets;

import java.util.ArrayList;
import java.util.List;

public class LottoTicketGenerator {

    private LottoTicketGenerator() {
    }

    public static LottoTicketGenerator getInstance() {
        return LazyHolder.INSTANCE;
    }

    public LottoTickets createLottoTickets(final long count, final LottoGenerateStrategy strategy) {
        List<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            tickets.add(strategy.generate());
        }
        return LottoTickets.of(tickets);
    }

    private static class LazyHolder {
        public static final LottoTicketGenerator INSTANCE = new LottoTicketGenerator();
    }
}
