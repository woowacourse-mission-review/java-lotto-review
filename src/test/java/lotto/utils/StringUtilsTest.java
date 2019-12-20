package lotto.utils;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StringUtilsTest {

    @Test
    void isNull_ShouldReturnTrue_ForNull() {
        assertTrue(StringUtils.isNull(null));
    }

    @Test
    void isNotNull_ShouldReturnFalse_ForNull() {
        assertFalse(StringUtils.isNotNull(null));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void isEmpty_ShouldReturnTrue_ForNullAndEmpty(String input) {
        assertTrue(StringUtils.isEmpty(input));
    }

    @Test
    void isEmpty_ShouldReturnFalse_ForBlank() {
        assertFalse(StringUtils.isEmpty(" "));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void isNotEmpty_ShouldReturnFalse_ForNullAndEmpty(String input) {
        assertFalse(StringUtils.isNotEmpty(input));
    }

    @Test
    void isNotEmpty_ShouldReturnTrue_ForBlank() {
        assertTrue(StringUtils.isNotEmpty(" "));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void isBlank_ShouldReturnTrue_ForNullAndEmpty(String input) {
        assertTrue(StringUtils.isBlank(input));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void isNotBlank_ShouldReturnFalse_ForNullAndEmpty(String input) {
        assertFalse(StringUtils.isNotBlank(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "\n", "\t"})
    void isNotBlank_ShouldReturnFalse_ForBlack(String input) {
        assertFalse(StringUtils.isNotBlank(input));
    }
}