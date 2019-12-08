package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RandomLottoGeneratorTest {

    @DisplayName("입력 받은 갯수만큼 로또를 생성했는지")
    @Test
    void generate_random_lotto_size() {
        int expectedSize = 5;

        RandomLottoGenerator randomLottoGenerator = new RandomLottoGenerator();

        List<Lotto> lottos = randomLottoGenerator.generateLottos(expectedSize);
        assertEquals(lottos.size(), expectedSize);
    }
}