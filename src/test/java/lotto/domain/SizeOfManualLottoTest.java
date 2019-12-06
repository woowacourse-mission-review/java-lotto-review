package lotto.domain;

import lotto.domain.exception.LackOfManualLottoSizeException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SizeOfManualLottoTest {

    @Test
    void create() {
        SizeOfManualLotto sizeOfManualLotto = SizeOfManualLotto.from(3);

        assertThat(sizeOfManualLotto).isNotNull();
    }

    @Test
    void create_LackOfManualLottoSizeException() {
        assertThrows(LackOfManualLottoSizeException.class, () -> SizeOfManualLotto.from(SizeOfManualLotto.MIN_SIZE_OF_MANUAL_LOTTO - 1));
        assertDoesNotThrow(() -> SizeOfManualLotto.from(SizeOfManualLotto.MIN_SIZE_OF_MANUAL_LOTTO));
    }
}