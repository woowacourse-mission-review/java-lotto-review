package lotto.domain.exception;

public class BonusBallCreationException extends IllegalArgumentException {

    public static final String BONUS_BALL_CREATION_MESSAGE = "보너스 볼은 당첨 번호와 중복될 수 없습니다.";

    public BonusBallCreationException() {
        super(BONUS_BALL_CREATION_MESSAGE);
    }
}
