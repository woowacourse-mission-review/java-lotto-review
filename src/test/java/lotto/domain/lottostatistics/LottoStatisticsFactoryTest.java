package lotto.domain.lottostatistics;

import lotto.domain.lottoticket.LottoTicket;
import lotto.domain.lottoticket.LottoTickets;
import lotto.domain.lottoticket.PurchasedLottoTickets;
import lotto.domain.lottoticket.WinningLotto;
import lotto.domain.lottoticket.lottonumber.LottoNumber;
import lotto.domain.lottoticket.lottonumber.LottoNumberPool;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsFactoryTest {

    WinningLotto winningLotto;
    PurchasedLottoTickets purchasedLottoTickets;

    @BeforeEach
    void setUp() {
        List<LottoNumber> winningNumbers = Arrays.asList(LottoNumberPool.get(1), LottoNumberPool.get(2), LottoNumberPool.get(3)
                , LottoNumberPool.get(4), LottoNumberPool.get(5), LottoNumberPool.get(6));
        LottoTicket winningTicket = LottoTicket.of(winningNumbers);
        LottoNumber bonusBall = LottoNumberPool.get(7);

        winningLotto = WinningLotto.of(winningTicket, bonusBall);

        List<LottoNumber> numbers = Arrays.asList(LottoNumberPool.get(1), LottoNumberPool.get(2), LottoNumberPool.get(3)
                , LottoNumberPool.get(4), LottoNumberPool.get(5), LottoNumberPool.get(7));
        List<LottoTicket> tickets = Arrays.asList(LottoTicket.of(numbers));
        LottoTickets lottoTickets = LottoTickets.of(tickets);

        purchasedLottoTickets = new PurchasedLottoTickets();
        purchasedLottoTickets.appendManualLottoTickets(lottoTickets);
    }

    @Test
    void create() {
        LottoStatisticsFactory lottoStatisticsFactory = LottoStatisticsFactory.getInstance();

        assertThat(lottoStatisticsFactory).isNotNull();
        assertThat(lottoStatisticsFactory).isEqualTo(LottoStatisticsFactory.getInstance());
    }

    @Test
    void calculateStatisticsWith() {
        LottoStatisticsFactory lottoStatisticsFactory = LottoStatisticsFactory.getInstance();

        LottoStatistics lottoStatistics = lottoStatisticsFactory.calculateStatisticsWith(winningLotto, purchasedLottoTickets);

        assertThat(lottoStatistics).isNotNull();
        assertThat(lottoStatistics.findMatchingCountBy(LottoRank.FIRST)).isEqualTo(0L);
        assertThat(lottoStatistics.findMatchingCountBy(LottoRank.SECOND)).isEqualTo(1L);
        assertThat(lottoStatistics.findMatchingCountBy(LottoRank.THIRD)).isEqualTo(0L);
        assertThat(lottoStatistics.findMatchingCountBy(LottoRank.FOURTH)).isEqualTo(0L);
        assertThat(lottoStatistics.findMatchingCountBy(LottoRank.FIFTH)).isEqualTo(0L);
    }
}