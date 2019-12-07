package lotto.domain.exception;

public class DuplicateLottoNumbersException extends IllegalArgumentException {

    public static final String DUPLICATE_LOTTO_NUMBERS_MESSAGE = "로또 숫자는 중복이 없는 숫자여야 합니다.";

    public DuplicateLottoNumbersException() {
        super(DUPLICATE_LOTTO_NUMBERS_MESSAGE);
    }
}
