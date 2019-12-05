package lotto.domain.lottogenerator;

import lotto.domain.lottoticket.LottoNumber;
import lotto.domain.lottoticket.LottoNumberPool;
import lotto.domain.lottoticket.LottoTicket;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoRandomGenerateStrategy implements LottoGenerateStrategy {

    private static final int FIRST_INDEX = 0;

    @Override
    public LottoTicket generate() {
        List<Integer> candidateNumbers = createCandidateNumbers();
        Collections.shuffle(candidateNumbers);

        List<LottoNumber> lottoNumbers = pickLottoNumbersIn(candidateNumbers);
        return LottoTicket.of(lottoNumbers);
    }

    private List<Integer> createCandidateNumbers() {
        return IntStream.range(LottoNumber.MIN_VALUE, LottoNumber.MAX_VALUE + 1)
                .boxed()
                .collect(Collectors.toList());
    }

    private List<LottoNumber> pickLottoNumbersIn(final List<Integer> candidateNumbers) {
        return pickNumbersIn(candidateNumbers)
                .stream()
                .map(LottoNumberPool::get)
                .collect(Collectors.toList());
    }

    private List<Integer> pickNumbersIn(final List<Integer> candidateNumbers) {
        return candidateNumbers.subList(FIRST_INDEX, LottoTicket.SIZE_OF_LOTTO_TICKETS);
    }
}
