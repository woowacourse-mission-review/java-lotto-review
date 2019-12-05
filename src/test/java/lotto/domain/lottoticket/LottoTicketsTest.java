package lotto.domain.lottoticket;

import lotto.domain.lottoticket.lottonumber.LottoNumber;
import lotto.domain.lottoticket.lottonumber.LottoNumberPool;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketsTest {

    List<LottoTicket> tickets;

    @BeforeEach
    void setUp() {
        List<LottoNumber> lottoNumbers = Arrays.asList(LottoNumberPool.get(1), LottoNumberPool.get(2), LottoNumberPool.get(3)
                , LottoNumberPool.get(4), LottoNumberPool.get(5), LottoNumberPool.get(6));
        tickets = Arrays.asList(LottoTicket.of(lottoNumbers), LottoTicket.of(lottoNumbers), LottoTicket.of(lottoNumbers));
    }

    @Test
    void create() {
        LottoTickets lottoTickets = LottoTickets.of(tickets);

        assertThat(lottoTickets).isNotNull();
    }

    @Test
    void equals() {
        LottoTickets lottoTickets = LottoTickets.of(tickets);

        assertThat(lottoTickets).isEqualTo(LottoTickets.of(tickets));
    }

    @Test
    void size() {
        LottoTickets lottoTickets = LottoTickets.of(tickets);

        assertThat(lottoTickets.size()).isEqualTo(3);
    }
}