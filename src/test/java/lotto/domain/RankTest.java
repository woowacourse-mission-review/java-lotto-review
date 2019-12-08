package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RankTest {

    @ParameterizedTest
    @EnumSource(value = Rank.class)
    void 유효한_값인지_확인_CountOfNumbers(final Rank rank) {
        final int countOfMatch = rank.getCountOfMatch();
        final boolean result = 0 <= countOfMatch && countOfMatch <= LottoTicket.COUNT_OF_LOTTO_NUMBERS;

        assertTrue(result);
    }

    @ParameterizedTest
    @MethodSource(value = "provideSample")
    void 등수_구하는_테스트(final Rank expected, final int countOfMatch, final boolean isMatchBonus) {
        final Rank actual = Rank.of(countOfMatch, isMatchBonus);

        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> provideSample() {
        return Stream.of(
                Arguments.of(Rank.FIRST, 6, true),
                Arguments.of(Rank.FIRST, 6, false),
                Arguments.of(Rank.SECOND, 5, true),
                Arguments.of(Rank.THIRD, 5, false),
                Arguments.of(Rank.FOURTH, 4, true),
                Arguments.of(Rank.FOURTH, 4, false),
                Arguments.of(Rank.FIFTH, 3, true),
                Arguments.of(Rank.FIFTH, 3, false),
                Arguments.of(Rank.MISS, 2, false)
        );
    }
}