package lotto.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public String inputLottoPurchaseAmount() {
        return inputWithMessage("구입금액을 입력해 주세요.");
    }

    public String inputSizeOfManualLotto() {
        return inputWithMessage("수동으로 구매할 로또 수를 입력해 주세요.");
    }

    public void showInputMessageForManualLottoTickets() {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    }

    public String inputWinningTicket() {
        return inputWithMessage("지난 주 당첨 번호를 입력해 주세요.");
    }

    public String inputBonusBall() {
        return inputWithMessage("보너스 볼을 입력해 주세요.");
    }

    private String inputWithMessage(final String message) {
        System.out.println(message);

        return inputBasicString();
    }

    public String inputBasicString() {
        return SCANNER.nextLine();
    }
}
