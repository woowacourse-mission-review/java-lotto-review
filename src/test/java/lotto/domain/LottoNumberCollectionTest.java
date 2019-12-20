package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoNumberCollectionTest {

    @Test
    void 캐싱_확인() {
        assertSame(LottoNumberCollection.get(1), LottoNumberCollection.get(1));
    }

    @Test
    void contains() {
        assertTrue(LottoNumberCollection.containsKey(LottoNumber.MAX_BOUNDARY));
        assertFalse(LottoNumberCollection.containsKey(LottoNumber.MAX_BOUNDARY + 1));
    }

    @Test
    void copy() {
        final List<LottoNumber> lottoNumbers1 = LottoNumberCollection.copy();
        final List<LottoNumber> lottoNumbers2 = LottoNumberCollection.copy();

        assertNotSame(lottoNumbers1, lottoNumbers2);
        assertEquals(lottoNumbers1, lottoNumbers2);
    }
}