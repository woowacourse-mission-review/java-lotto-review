package lotto.view;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {

    private static final Pattern ONLY_INTEGER_PATTERN = Pattern.compile("^[0-9]+$");
    private static final String NOT_INTEGER_FORMAT_EXCEPTION_MESSAGE = "0~9까지 숫자의 조합만 입력 가능합니다.";
    private static final String NEW_LINE = "\n";
    private static final Scanner SCANNER = new Scanner(System.in);

    public int inputBudget() {
        System.out.println(NEW_LINE + "구입금액을 입력해 주세요.");
        String input = SCANNER.nextLine();
        return parseInteger(input);
    }

    public int inputManualPurchasingCount() {
        System.out.println(NEW_LINE + "수동으로 구매할 로또 수를 입력해 주세요.");
        String input = SCANNER.nextLine();
        return parseInteger(input);
    }

    private int parseInteger(final String input) {
        Matcher matcher = ONLY_INTEGER_PATTERN.matcher(input);
        if (matcher.matches()) {
            return Integer.parseInt(input);
        }
        throw new NumberFormatException(NOT_INTEGER_FORMAT_EXCEPTION_MESSAGE);
    }

    public List<String> inputManualLotto(final int manualCount) {
        List<String> inputs = Lists.newArrayList();
        System.out.println(NEW_LINE + "수동으로 구매할 번호를 입력해 주세요.");
        for (int i = 0; i < manualCount; i++) {
            inputs.add(SCANNER.nextLine());
        }
        return inputs;
    }

    public String inputWinningLottoNos() {
        System.out.println(NEW_LINE + "지난 주 당첨 번호를 입력해 주세요.");
        return SCANNER.nextLine();
    }

    public int inputBonusNo() {
        System.out.println(NEW_LINE + "보너스 볼을 입력해 주세요.");
        String input = SCANNER.nextLine();
        return parseInteger(input);
    }
}
