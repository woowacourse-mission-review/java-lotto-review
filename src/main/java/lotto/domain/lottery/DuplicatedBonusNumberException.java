package lotto.domain.lottery;

public class DuplicatedBonusNumberException extends RuntimeException {
    private static final String ERROR_MSG = "보너스 번호와 당첨 로또 번호가 중복되면 안 된다.";

    public DuplicatedBonusNumberException() {
        super(ERROR_MSG);
    }
}
