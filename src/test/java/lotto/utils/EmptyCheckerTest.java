package lotto.utils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

class EmptyCheckerTest {

    @ParameterizedTest
    @NullSource
    @EmptySource
    void check(String input) {
        assertThrows(IllegalArgumentException.class, () -> EmptyChecker.check(input));
    }
}