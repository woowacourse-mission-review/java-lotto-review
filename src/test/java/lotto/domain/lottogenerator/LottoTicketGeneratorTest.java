package lotto.domain.lottogenerator;

import lotto.domain.lottoticket.LottoNumber;
import lotto.domain.lottoticket.LottoNumberPool;
import lotto.domain.lottoticket.LottoTicket;
import lotto.domain.lottoticket.LottoTickets;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketGeneratorTest {

    @Test
    void create() {
        LottoTicketGenerator lottoTicketGenerator = LottoTicketGenerator.getInstance();

        assertThat(lottoTicketGenerator).isEqualTo(LottoTicketGenerator.getInstance());
    }

    @Test
    void createLottoTickets() {
        LottoTicketGenerator lottoTicketGenerator = LottoTicketGenerator.getInstance();
        LottoTicket lottoTicket = createLottoTicket();

        LottoTickets lottoTickets = lottoTicketGenerator.createLottoTickets(3, () -> lottoTicket);

        assertThat(lottoTickets.size()).isEqualTo(3);
    }

    private LottoTicket createLottoTicket() {
        List<LottoNumber> lottoNumbers = Arrays.asList(LottoNumberPool.get(1), LottoNumberPool.get(2), LottoNumberPool.get(3)
                , LottoNumberPool.get(4), LottoNumberPool.get(5), LottoNumberPool.get(6));
        return LottoTicket.of(lottoNumbers);
    }
}