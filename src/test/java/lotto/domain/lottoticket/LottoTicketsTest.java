package lotto.domain.lottoticket;

import lotto.domain.lottostatistics.LottoRank;
import lotto.domain.lottoticket.lottonumber.LottoNumber;
import lotto.domain.lottoticket.lottonumber.LottoNumberPool;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketsTest {

    LottoTicket ticket;
    List<LottoTicket> tickets;

    @BeforeEach
    void setUp() {
        List<LottoNumber> lottoNumbers = Arrays.asList(LottoNumberPool.get(1), LottoNumberPool.get(2), LottoNumberPool.get(3)
                , LottoNumberPool.get(4), LottoNumberPool.get(5), LottoNumberPool.get(6));
        ticket = LottoTicket.of(lottoNumbers);
        tickets = Arrays.asList(LottoTicket.of(lottoNumbers), LottoTicket.of(lottoNumbers), LottoTicket.of(lottoNumbers));
    }

    @Test
    void create() {
        LottoTickets lottoTickets = new LottoTickets();
        LottoTickets lottoTickets2 = LottoTickets.of(tickets);

        assertThat(lottoTickets).isNotNull();
        assertThat(lottoTickets2).isNotNull();

        assertThat(lottoTickets.size()).isEqualTo(0);
        assertThat(lottoTickets2.size()).isEqualTo(3);
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

    @Test
    void append() {
        LottoTickets lottoTickets = LottoTickets.of(tickets);
        lottoTickets.append(tickets);

        assertThat(lottoTickets.size()).isEqualTo(6);
    }

    @Test
    void append_one_ticket() {
        LottoTickets lottoTickets = LottoTickets.of(tickets);
        LottoTickets lottoTickets2 = lottoTickets.append(ticket);

        assertThat(lottoTickets == lottoTickets2).isTrue();
        assertThat(lottoTickets2.size()).isEqualTo(4);
    }

    @Test
    void matchWith() {
        LottoTickets lottoTickets = LottoTickets.of(tickets);

        WinningLotto winningLotto = createWinningLotto();

        List<LottoRank> ranks = lottoTickets.matchWith(winningLotto);
        assertThat(ranks.get(0)).isEqualByComparingTo(LottoRank.THIRD);
        assertThat(ranks.get(1)).isEqualByComparingTo(LottoRank.THIRD);
        assertThat(ranks.get(2)).isEqualByComparingTo(LottoRank.THIRD);
    }

    private WinningLotto createWinningLotto() {
        List<LottoNumber> winningNumbers = Arrays.asList(LottoNumberPool.get(1), LottoNumberPool.get(2), LottoNumberPool.get(3)
                , LottoNumberPool.get(4), LottoNumberPool.get(5), LottoNumberPool.get(8));
        LottoTicket winningTicket = LottoTicket.of(winningNumbers);
        LottoNumber bonusBall = LottoNumberPool.get(7);

        return WinningLotto.of(winningTicket, bonusBall);
    }
}