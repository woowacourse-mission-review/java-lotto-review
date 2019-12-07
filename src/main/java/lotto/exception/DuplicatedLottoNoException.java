package lotto.exception;

public class DuplicatedLottoNoException extends RuntimeException {

    public static final String DUPLICATED_LOTTO_NO_EXCEPTION_MESSAGE = "중복된 로또 번호가 존재합니다.";

    public DuplicatedLottoNoException() {
        super(DUPLICATED_LOTTO_NO_EXCEPTION_MESSAGE);
    }
}
