package lotto.domain.lottoticket;

import lotto.domain.lottostatistics.LottoRank;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoTickets {

    private final List<LottoTicket> tickets = new ArrayList<>();

    public LottoTickets() {
    }

    private LottoTickets(final List<LottoTicket> tickets) {
        this.tickets.addAll(tickets);
    }

    public static LottoTickets of(final List<LottoTicket> tickets) {
        return new LottoTickets(tickets);
    }

    public int size() {
        return tickets.size();
    }

    public void append(List<LottoTicket> tickets) {
        this.tickets.addAll(tickets);
    }

    public LottoTickets append(LottoTicket ticket) {
        this.tickets.add(ticket);
        return this;
    }

    public List<LottoRank> matchWith(final WinningLotto winningLotto) {
        List<LottoRank> ranks = new ArrayList<>();
        tickets.forEach(ticket -> {
            LottoRank lottoRank = winningLotto.match(ticket);
            ranks.add(lottoRank);
        });
        return ranks;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final LottoTickets that = (LottoTickets) o;
        return Objects.equals(tickets, that.tickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tickets);
    }

    @Override
    public String toString() {
        return "LottoTickets{" +
                "tickets=" + tickets +
                '}';
    }
}
