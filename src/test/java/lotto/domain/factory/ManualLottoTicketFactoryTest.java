package lotto.domain.factory;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ManualLottoTicketFactoryTest {

    @Test
    void create_exception_empty() {
        assertThrows(IllegalArgumentException.class, () -> new ManualLottoTicketFactory(Collections.emptyList()));
    }

    @Test
    void create_exception_null() {
        assertThrows(NullPointerException.class, () -> new ManualLottoTicketFactory(null));
    }
}