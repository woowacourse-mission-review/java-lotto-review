package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LottoUtilsTest {
    @Test
    void 번호_생성_확인() {
        // given
        List<Integer> nums = List.of(8, 21, 23, 41, 42, 43);
        List<LottoNumber> actual = nums.stream().map(LottoNumber::of).collect(Collectors.toList());

        // when
        String input = "8, 21, 23, 41, 42, 43";
        List<LottoNumber> expected = LottoUtils.parseLottoNumbers(input);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}