package lotto.domain;

public class WinningNoContainsBonusNoException extends RuntimeException {

    public static final String WINNING_NO_CONTAINS_BONUS_NO_EXCEPTION_MESSAGE = "당첨 번호가 보너스 번호를 포함할 수 없습니다.";

    public WinningNoContainsBonusNoException() {
        super(WINNING_NO_CONTAINS_BONUS_NO_EXCEPTION_MESSAGE);
    }
}
