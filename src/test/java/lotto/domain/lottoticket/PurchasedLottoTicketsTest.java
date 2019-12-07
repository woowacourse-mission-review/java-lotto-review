package lotto.domain.lottoticket;

import lotto.domain.lottostatistics.LottoRank;
import lotto.domain.lottoticket.lottonumber.LottoNumber;
import lotto.domain.lottoticket.lottonumber.LottoNumberPool;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PurchasedLottoTicketsTest {

    List<LottoTicket> manualTickets;
    List<LottoTicket> autoTickets;

    @BeforeEach
    void setUp() {
        List<LottoNumber> lottoNumbers = Arrays.asList(LottoNumberPool.get(1), LottoNumberPool.get(2), LottoNumberPool.get(3)
                , LottoNumberPool.get(4), LottoNumberPool.get(5), LottoNumberPool.get(6));

        manualTickets = Arrays.asList(LottoTicket.of(lottoNumbers), LottoTicket.of(lottoNumbers), LottoTicket.of(lottoNumbers));
        autoTickets = Arrays.asList(LottoTicket.of(lottoNumbers), LottoTicket.of(lottoNumbers));
    }

    @Test
    void create() {
        PurchasedLottoTickets purchasedLottoTickets = new PurchasedLottoTickets();

        assertThat(purchasedLottoTickets).isNotNull();
        assertThat(purchasedLottoTickets.sizeOfManualLottoTickets()).isEqualTo(0);
        assertThat(purchasedLottoTickets.sizeOfAutoLottoTickets()).isEqualTo(0);
    }

    @Test
    void appendManualLottoTicketList_and_check_size() {
        PurchasedLottoTickets purchasedLottoTickets = new PurchasedLottoTickets();
        purchasedLottoTickets.appendManualLottoTickets(manualTickets);

        assertThat(purchasedLottoTickets.sizeOfManualLottoTickets()).isEqualTo(3);
        assertThat(purchasedLottoTickets.sizeOfAutoLottoTickets()).isEqualTo(0);
    }

    @Test
    void appendAutoLottoTicketList_and_check_size() {
        PurchasedLottoTickets purchasedLottoTickets = new PurchasedLottoTickets();
        purchasedLottoTickets.appendAutoLottoTickets(autoTickets);

        assertThat(purchasedLottoTickets.sizeOfManualLottoTickets()).isEqualTo(0);
        assertThat(purchasedLottoTickets.sizeOfAutoLottoTickets()).isEqualTo(2);
    }

    @Test
    void appendManualLottoTickets_and_check_size() {
        PurchasedLottoTickets purchasedLottoTickets = new PurchasedLottoTickets();
        purchasedLottoTickets.appendManualLottoTickets(LottoTickets.of(manualTickets));

        assertThat(purchasedLottoTickets.sizeOfManualLottoTickets()).isEqualTo(3);
        assertThat(purchasedLottoTickets.sizeOfAutoLottoTickets()).isEqualTo(0);
    }

    @Test
    void appendAutoLottoTickets_and_check_size() {
        PurchasedLottoTickets purchasedLottoTickets = new PurchasedLottoTickets();
        purchasedLottoTickets.appendAutoLottoTickets(LottoTickets.of(autoTickets));

        assertThat(purchasedLottoTickets.sizeOfManualLottoTickets()).isEqualTo(0);
        assertThat(purchasedLottoTickets.sizeOfAutoLottoTickets()).isEqualTo(2);
    }

    @Test
    void matchWith() {
        PurchasedLottoTickets purchasedLottoTickets = new PurchasedLottoTickets();
        purchasedLottoTickets.appendManualLottoTickets(manualTickets);
        purchasedLottoTickets.appendAutoLottoTickets(autoTickets);

        WinningLotto winningLotto = createWinningLotto();

        List<LottoRank> ranks = purchasedLottoTickets.matchWith(winningLotto);
        assertThat(ranks.size()).isEqualTo(5);
        for (LottoRank rank : ranks) {
            assertThat(rank).isEqualByComparingTo(LottoRank.SECOND);
        }
    }

    private WinningLotto createWinningLotto() {
        List<LottoNumber> winningNumbers = Arrays.asList(LottoNumberPool.get(1), LottoNumberPool.get(2), LottoNumberPool.get(3)
                , LottoNumberPool.get(4), LottoNumberPool.get(5), LottoNumberPool.get(7));
        LottoTicket winningLottoTicket = LottoTicket.of(winningNumbers);
        LottoNumber bonusBall = LottoNumberPool.get(6);

        return WinningLotto.of(winningLottoTicket, bonusBall);
    }
}