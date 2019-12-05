package lotto.domain.lottoticket;

import lotto.domain.exception.BonusBallCreationException;
import lotto.domain.lottoticket.lottonumber.LottoNumber;
import lotto.domain.lottoticket.lottonumber.LottoNumberPool;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WinningLottoTest {

    LottoTicket winningLottoTicket;
    LottoNumber properBonusBall;
    LottoNumber illegalBonusBall;

    @BeforeEach
    void setUp() {
        List<LottoNumber> lottoNumbers = Arrays.asList(LottoNumberPool.get(1), LottoNumberPool.get(2), LottoNumberPool.get(3)
                , LottoNumberPool.get(4), LottoNumberPool.get(5), LottoNumberPool.get(6));
        winningLottoTicket = LottoTicket.of(lottoNumbers);

        properBonusBall = LottoNumberPool.get(7);
        illegalBonusBall = LottoNumberPool.get(1);
    }

    @Test
    void create() {
        WinningLotto winningLotto = WinningLotto.of(winningLottoTicket, properBonusBall);

        assertThat(winningLotto).isNotNull();
    }

    @Test
    void equals() {
        WinningLotto winningLotto = WinningLotto.of(winningLottoTicket, properBonusBall);

        assertThat(winningLotto).isEqualTo(WinningLotto.of(winningLottoTicket, properBonusBall));
    }

    @Test
    void create_BonusBallCreationException() {
        Exception exception = assertThrows(BonusBallCreationException.class, () -> WinningLotto.of(winningLottoTicket, illegalBonusBall));

        assertThat(exception.getMessage()).isEqualTo(BonusBallCreationException.BONUS_BALL_CREATION_MESSAGE);
    }
}