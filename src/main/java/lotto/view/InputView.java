package lotto.view;

import static lotto.constant.ErrorMessage.INVALID_BONUS_FORMAT;
import static lotto.constant.ErrorMessage.INVALID_PURCHASE_FORMAT;
import static lotto.constant.ErrorMessage.INVALID_WINNING_FORMAT;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {

    private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String DELIMITER = ",";

    public static int readPurchaseAmount() {
        while (true) {
            try {
                System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
                String input = Console.readLine();
                return parseAmount(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int parseAmount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_PURCHASE_FORMAT);
        }
    }

    public static List<Integer> readWinningNumbers() {
        while (true) {
            try {
                System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);
                String input = Console.readLine();
                return parseWinningNumbers(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static List<Integer> parseWinningNumbers(String input) {
        String[] tokens = input.split(DELIMITER);
        List<Integer> numbers = new ArrayList<>();

        for (String token : tokens) {
            numbers.add(parseNumber(token.trim()));
        }

        return numbers;
    }

    private static int parseNumber(String token) {
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_WINNING_FORMAT);
        }
    }

    public static int readBonusNumber() {
        while (true) {
            try {
                System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
                String input = Console.readLine();
                return parseBonusNumber(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int parseBonusNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_BONUS_FORMAT);
        }
    }
}
