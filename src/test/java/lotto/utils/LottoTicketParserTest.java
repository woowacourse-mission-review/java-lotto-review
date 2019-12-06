package lotto.utils;

import lotto.domain.lottoticket.LottoTicket;
import lotto.domain.lottoticket.lottonumber.LottoNumber;
import lotto.domain.lottoticket.lottonumber.LottoNumberPool;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoTicketParserTest {

    @Test
    void pareLottoTicket() {
        LottoTicket lottoTicket = LottoTicketParser.parseToLottoTicket("1, 2, 3, 4, 5, 6");

        assertThat(lottoTicket).isNotNull();
        for (int number = 1; number <= 6; number++) {
            LottoNumber lottoNumber = LottoNumberPool.get(number);

            assertThat(lottoTicket.contains(lottoNumber)).isTrue();
        }
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    void parseLottoTicket_null_or_empty(String input) {
        assertThrows(IllegalArgumentException.class, () -> LottoTicketParser.parseToLottoTicket(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"q, 2, 3, 4, 5, 6", "1, 2, 3, 4, 5", "1, 1, 3, 4, 5, 6", "1, 2, 3, 4, 5, 46"})
    void parseLottoTicket_exceptions(String input) {
        assertThrows(IllegalArgumentException.class, () -> LottoTicketParser.parseToLottoTicket(input));
    }
}