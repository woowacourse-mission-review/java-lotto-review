package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.WinningLotto.BONUS_NUMBER_DUPLICATE_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WinningLottoTest {

    @Test
    void 우승번호와_보너스번호_일치_예외처리() {
        final LottoTicket lottoTicket = LottoTicket.of(createLottoNumbers(1, 2, 3, 4, 5, 6));
        final LottoNumber bonusNumber = LottoNumber.of(1);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> WinningLotto.of(lottoTicket, bonusNumber));
        assertThat(exception.getMessage()).isEqualTo(BONUS_NUMBER_DUPLICATE_MESSAGE);
    }

    @Test
    void Rank_반환_테스트() {
        // given
        final LottoTicket lottoTicket = LottoTicket.of(createLottoNumbers(1, 2, 3, 4, 5, 6));
        final LottoNumber bonusNumber = LottoNumber.of(7);
        final WinningLotto winningLotto = WinningLotto.of(lottoTicket, bonusNumber);

        final LottoTicket userLottoTicket = LottoTicket.of(createLottoNumbers(1, 2, 3, 4, 5, 7));

        // when
        final Rank rank = winningLotto.calculateRank(userLottoTicket);

        // then
        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    private List<LottoNumber> createLottoNumbers(final int... numbers) {
        return IntStream.of(numbers).mapToObj(LottoNumber::of).collect(Collectors.toList());
    }
}