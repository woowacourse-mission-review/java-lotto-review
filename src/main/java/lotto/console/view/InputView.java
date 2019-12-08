package lotto.console.view;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {
    private Scanner scanner = new Scanner(System.in);

    public String inputMoney() {
        return inputWithMessage("구입 금액을 입력해주세요.");
    }

    public String inputCountOfManualLotto() {
        return inputWithMessage("수동으로 구매할 로또 수를 입력해 주세요.");
    }

    public void inputManualLotto() {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    }

    public List<String> inputManualLotto(final int count) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        return IntStream.range(0, count)
                .mapToObj(x -> scanner.nextLine())
                .collect(Collectors.toList())
                ;
    }

    public String inputWinningLotto() {
        return inputWithMessage("지난 주 당첨 번호를 입력해 주세요.");
    }

    public String inputBonusNo() {
        return inputWithMessage("보너스 볼을 입력해 주세요.");
    }

    private String inputWithMessage(final String message) {
        System.out.println(message);
        return scanner.nextLine();
    }
}
