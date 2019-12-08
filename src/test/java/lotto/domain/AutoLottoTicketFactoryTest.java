package lotto.domain;

import lotto.domain.factory.AutoLottoTicketFactory;
import lotto.domain.factory.LottoTicketFactory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class AutoLottoTicketFactoryTest {
    @Test
    void 예외없이_LottoTicket_생성되는지_확인() {
        final LottoTicketFactory lottoTicketFactory = new AutoLottoTicketFactory((x) -> x);

        assertDoesNotThrow(lottoTicketFactory::create);
        assertThat(lottoTicketFactory.create()).isNotNull();
    }

    @Test
    void shuffle_제대로_되는지_확인() {
        final LottoTicketFactory lottoTicketFactory = new AutoLottoTicketFactory((x) -> x);
        final LottoTicket lottoTicket1 = lottoTicketFactory.create();
        final LottoTicket lottoTicket2 = lottoTicketFactory.create();

        assertThat(lottoTicket1).isEqualTo(lottoTicket2);
        assertThat(lottoTicket1).isNotSameAs(lottoTicket2);
    }
}