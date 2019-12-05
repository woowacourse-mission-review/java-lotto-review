package lotto.domain.lottoticket;

import java.util.List;
import java.util.Objects;

public class LottoTickets {

    private final List<LottoTicket> tickets;

    private LottoTickets(final List<LottoTicket> tickets) {
        this.tickets = tickets;
    }

    public static LottoTickets of(final List<LottoTicket> tickets) {
        return new LottoTickets(tickets);
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
