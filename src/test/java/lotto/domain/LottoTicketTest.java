package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoTicketTest {

    @Test
    void 숫자_중복_예외처리() {
        // given
        final List<LottoNumber> lottoNumbers = createLottoNumbers(15, 15, 25, 30, 33, 45);

        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> LottoTicket.of(lottoNumbers));
        assertThat(exception.getMessage()).isEqualTo(LottoTicket.DUPLICATE_NUMBERS_MESSAGE);
    }

    @ParameterizedTest
    @MethodSource(value = "provideIntegers")
    void 숫자_6개_아니면_예외처리(final int[] input) {
        // given
        final List<LottoNumber> lottoNumbers = createLottoNumbers(input);

        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> LottoTicket.of(lottoNumbers));
        assertThat(exception.getMessage()).isEqualTo(LottoTicket.NOT_MATCH_COUNT_OF_NUMBERS_MESSAGE);
    }

    private static Stream<int[]> provideIntegers() {
        return Stream.of(
                new int[]{1},
                new int[]{1, 2, 3},
                new int[]{15, 15, 25, 30, 45},
                new int[]{1, 2, 3, 4, 5, 6, 7}
        );
    }

    @Test
    void 로또_번호_오름차순_정렬_확인() {
        // given
        final List<LottoNumber> lottoNumbers = createLottoNumbers(6, 5, 4, 2, 1, 3);

        // when
        final LottoTicket lottoTicket = LottoTicket.of(lottoNumbers);
        final Iterator<LottoNumber> iterator = lottoTicket.iterator();

        // then
        assertThat(iterator.next()).isEqualTo(LottoNumber.of(1));
        assertThat(iterator.next()).isEqualTo(LottoNumber.of(2));
        assertThat(iterator.next()).isEqualTo(LottoNumber.of(3));
        assertThat(iterator.next()).isEqualTo(LottoNumber.of(4));
        assertThat(iterator.next()).isEqualTo(LottoNumber.of(5));
        assertThat(iterator.next()).isEqualTo(LottoNumber.of(6));
    }

    @Test
    void 번호_포함하는지_확인() {
        final LottoTicket lottoTicket = LottoTicket.of(createLottoNumbers(6, 5, 4, 2, 1, 3));

        assertTrue(lottoTicket.contains(LottoNumber.of(6)));
        assertTrue(lottoTicket.contains(LottoNumber.of(5)));
        assertFalse(lottoTicket.contains(LottoNumber.of(12)));
    }

    @Test
    void 다른_로또와_번호_일치_개수_확인() {
        // given
        final LottoTicket lottoTicket1 = LottoTicket.of(createLottoNumbers(6, 5, 4, 2, 1, 3));
        final LottoTicket lottoTicket2 = LottoTicket.of(createLottoNumbers(6, 5, 4, 45, 42, 3));

        // when
        int actual = lottoTicket1.match(lottoTicket2);

        // then
        assertThat(actual).isEqualTo(4);
    }

    private List<LottoNumber> createLottoNumbers(final int... numbers) {
        return IntStream.of(numbers).mapToObj(LottoNumber::of).collect(Collectors.toList());
    }
}