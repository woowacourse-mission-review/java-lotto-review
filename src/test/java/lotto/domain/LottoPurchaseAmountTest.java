package lotto.domain;

import lotto.domain.exception.LackOfLottoPurchaseAmountException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoPurchaseAmountTest {

    @Test
    void create() {
        LottoPurchaseAmount lottoPurchaseAmount = LottoPurchaseAmount.from(3000L);

        assertThat(lottoPurchaseAmount).isNotNull();
    }

    @Test
    void create_LackOfLottoPurchaseAmountException() {
        assertThrows(LackOfLottoPurchaseAmountException.class, () -> LottoPurchaseAmount.from(LottoPurchaseAmount.MIN_AMOUNT_OF_LOTTO_TICKET - 1));
        assertDoesNotThrow(() -> LottoPurchaseAmount.from(LottoPurchaseAmount.MIN_AMOUNT_OF_LOTTO_TICKET));
    }
}