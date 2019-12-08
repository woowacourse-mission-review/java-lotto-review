package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ResultTest {

    private Result result;

    @BeforeEach
    void setUp() {
        final List<LottoTicket> lottoTickets = List.of(
                createLottoTicket(1, 2, 3, 4, 5, 6),
                createLottoTicket(1, 2, 3, 4, 5, 7),
                createLottoTicket(1, 2, 3, 4, 5, 8),
                createLottoTicket(1, 2, 3, 4, 8, 9),
                createLottoTicket(1, 2, 3, 7, 8, 9),
                createLottoTicket(1, 2, 10, 7, 8, 9)
        );
        final WinningLotto winningLotto = WinningLotto.of(createLottoTicket(1, 2, 3, 4, 5, 6), LottoNumber.of(7));

        result = new Result();

        lottoTickets.forEach(x -> result.add(winningLotto.calculateRank(x)));
    }

    @Test
    void 당첨_랭크_추가_확인() {
        Stream.of(Rank.values()).forEach(rank -> assertThat(result.countOfRank(rank)).isEqualTo(1));
    }

    @Test
    void 수익률_계산() {
        // given
        final LottoMoney lottoMoney = LottoMoney.of(10000);
        final int totalOfPrize = Stream.of(Rank.values()).map(Rank::getPrize).reduce(0, Integer::sum);
        final double expected = (double) totalOfPrize / lottoMoney.value();

        // when
        final double actual = result.calculateReturnOfRate(lottoMoney);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private LottoTicket createLottoTicket(int... numbers) {
        return LottoTicket.of(IntStream.of(numbers).mapToObj(LottoNumber::of).collect(Collectors.toList()));
    }
}