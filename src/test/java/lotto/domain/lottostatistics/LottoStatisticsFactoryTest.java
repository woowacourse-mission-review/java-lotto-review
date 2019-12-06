package lotto.domain.lottostatistics;

import lotto.domain.lottoticket.LottoTicket;
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

    @BeforeEach
    void setUp() {
        List<LottoNumber> lottoNumbers = Arrays.asList(LottoNumberPool.get(1), LottoNumberPool.get(2), LottoNumberPool.get(3)
                , LottoNumberPool.get(4), LottoNumberPool.get(5), LottoNumberPool.get(6));
        LottoTicket lottoTicket = LottoTicket.of(lottoNumbers);
        LottoNumber bonusBall = LottoNumberPool.get(7);

        winningLotto = WinningLotto.of(lottoTicket, bonusBall);
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

        // TODO: 06/12/2019
    }
}