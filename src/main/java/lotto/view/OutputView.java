package lotto.view;

public class OutputView {

    private static final String EXCEPTION_MESSAGE_PREFIX = "ERROR : ";

    public void showMessageOfException(final Exception e) {
        System.out.println(EXCEPTION_MESSAGE_PREFIX + e.getMessage());
    }
}
