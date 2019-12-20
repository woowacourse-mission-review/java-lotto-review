package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CountOfManualLottoTest {

    @Test
    void 수동구매_횟수가_구매금액_초과하면_예외처리() {
        assertThrows(IllegalArgumentException.class, () -> CountOfManualLotto.of(3, 2));
    }

    @Test
    void 수동구매_횟수_0미만_예외처리() {
        assertThrows(IllegalArgumentException.class, () -> CountOfManualLotto.of(-1, 2));
    }

    @Test
    void 논리적_동치성_테스트() {
        CountOfManualLotto countOfManualLotto1 = CountOfManualLotto.of(2, 3);
        CountOfManualLotto countOfManualLotto2 = CountOfManualLotto.of(2, 3);

        assertThat(countOfManualLotto1).isEqualTo(countOfManualLotto2);
    }
}