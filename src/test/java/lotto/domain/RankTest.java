package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.domain.Rank.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RankTest {

    @DisplayName("FIRST 번호 일치 갯수와 같고 보너스볼이 일치하지 않는 경우 FIRST 리턴하는지")
    @Test
    void valueOf_FIRST_not_match_bonus() {
        int countOfMatch = FIRST.getCountOfMatch();
        boolean matchBonus = false;

        assertEquals(FIRST, Rank.valueOf(countOfMatch, matchBonus));
    }

    @DisplayName("FIRST 번호 일치 갯수와 같고 보너스볼이 일치하는 경우 에러가 발생하는지")
    @Test
    void valueOf_FIRST_match_bonus() {
        int countOfMatch = FIRST.getCountOfMatch();
        boolean matchBonus = true;

        RuntimeException e = assertThrows(IllegalArgumentException.class,
                () -> Rank.valueOf(countOfMatch, matchBonus));
        assertEquals(e.getMessage(), INVALID_FIRST_MATCH_EXCEPTION_MESSAGE);
    }

    @DisplayName("SECOND 번호 일치 갯수와 같고 보너스볼이 일치하는 경우 SECOND 리턴하는지")
    @Test
    void valueOf_SECOND_match_bonus() {
        int countOfMatch = SECOND.getCountOfMatch();
        boolean matchBonus = true;

        assertEquals(SECOND, Rank.valueOf(countOfMatch, matchBonus));
    }

    @DisplayName("THIRD 번호 일치 갯수와 같고 보너스볼이 일치하지 않는 경우 THIRD 리턴하는지")
    @Test
    void valueOf_THIRD_not_match_bonus() {
        int countOfMatch = THIRD.getCountOfMatch();
        boolean matchBonus = false;

        assertEquals(THIRD, Rank.valueOf(countOfMatch, matchBonus));
    }

    @DisplayName("FOURTH 번호 일치 갯수와 같고 보너스볼이 일치하지 않는 경우 FOURTH 리턴하는지")
    @Test
    void valueOf_FOURTH_not_match_bonus() {
        int countOfMatch = FOURTH.getCountOfMatch();
        boolean matchBonus = false;

        assertEquals(FOURTH, Rank.valueOf(countOfMatch, matchBonus));
    }

    @DisplayName("FOURTH 번호 일치 갯수와 같고 보너스볼이 일치하는 경우 FOURTH 리턴하는지")
    @Test
    void valueOf_FOURTH_match_bonus() {
        int countOfMatch = FOURTH.getCountOfMatch();
        boolean matchBonus = true;

        assertEquals(FOURTH, Rank.valueOf(countOfMatch, matchBonus));
    }

    @DisplayName("FIFTH 번호 일치 갯수와 같고 보너스볼이 일치하지 않는 경우 FIFTH 리턴하는지")
    @Test
    void valueOf_FIFTH_not_match_bonus() {
        int countOfMatch = FIFTH.getCountOfMatch();
        boolean matchBonus = false;

        assertEquals(FIFTH, Rank.valueOf(countOfMatch, matchBonus));
    }

    @DisplayName("FIFTH 번호 일치 갯수와 같고 보너스볼이 일치하는 경우 FIFTH 리턴하는지")
    @Test
    void valueOf_FIFTH_match_bonus() {
        int countOfMatch = FIFTH.getCountOfMatch();
        boolean matchBonus = true;

        assertEquals(FIFTH, Rank.valueOf(countOfMatch, matchBonus));
    }

    @DisplayName("FIFTH 번호 일치 갯수보다 적은 번호 일치 갯수를 가지고 보너스 볼 일치가 아닌 경우 MISS 리턴")
    @ParameterizedTest(name = "{arguments} 를 파라미터로 입력하는 경우")
    @ValueSource(ints = {0, 1, 2})
    void valueOf_MISS_not_match_bonus(int countOfMatch) {
        boolean matchBonus = false;

        assertEquals(MISS, Rank.valueOf(countOfMatch, matchBonus));
    }

    @DisplayName("FIFTH 번호 일치 갯수보다 적은 번호 일치 갯수를 가지고 보너스 볼 일치하는 경우 MISS 리턴")
    @ParameterizedTest(name = "{arguments} 를 파라미터로 입력하는 경우")
    @ValueSource(ints = {0, 1, 2})
    void valueOf_MISS_match_bonus(int countOfMatch) {
        boolean matchBonus = true;

        assertEquals(MISS, Rank.valueOf(countOfMatch, matchBonus));
    }

    @DisplayName("잘못된 번호 일치 갯수를 입력하는 경우 에러가 발생하는지")
    @ParameterizedTest(name = "{arguments} 를 파라미터로 입력하는 경우")
    @ValueSource(ints = {-1, 7})
    void valueOf_invalid_count_of_match(int countOfMatch) {
        RuntimeException e = assertThrows(IllegalArgumentException.class,
                () -> Rank.valueOf(countOfMatch, false));
        assertEquals(e.getMessage(), INVALID_COUNT_OF_MATCH_EXCEPTION_MESSAGE);
    }
}