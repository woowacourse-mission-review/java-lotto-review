package lotto.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class LottoTickets implements Iterable<LottoTicket> {

    private final List<LottoTicket> lottoTicketList;

    public LottoTickets(final List<LottoTicket> lottoTicketList) {
        this.lottoTicketList = new ArrayList<>(lottoTicketList);
    }

    public static LottoTickets of(final List<LottoTicket> lottoTickets) {
        return new LottoTickets(lottoTickets);
    }

    public Result match(final WinningLotto winningLotto) {
        final Result result = new Result();
        final List<Rank> ranks = lottoTicketList.stream().map(winningLotto::calculateRank).collect(Collectors.toList());
        ranks.forEach(result::add);
        return result;
    }

    @Override
    public Iterator<LottoTicket> iterator() {
        return new Iterator<LottoTicket>() {
            int cursor = 0;

            @Override
            public boolean hasNext() {
                return cursor < lottoTicketList.size();
            }

            @Override
            public LottoTicket next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return lottoTicketList.get(cursor++);
            }
        };
    }
}
