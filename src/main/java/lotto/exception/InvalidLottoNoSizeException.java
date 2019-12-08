package lotto.exception;

import static lotto.domain.Lotto.LOTTO_NO_SIZE;

public class InvalidLottoNoSizeException extends RuntimeException {

    public static final String INVALID_LOTTO_NO_SIZE_EXCEPTION_MESSAGE = String.format("로또 번호가 %d개가 아닙니다.", LOTTO_NO_SIZE);

    public InvalidLottoNoSizeException() {
        super(INVALID_LOTTO_NO_SIZE_EXCEPTION_MESSAGE);
    }
}
