package lotto.constant;

public class ErrorMessage {
    public static final String INVALID_LOTTO_SIZE = "[ERROR] 로또 번호는 6개여야 합니다.";
    public static final String INVALID_LOTTO_MIN = "[ERROR] 로또 번호는 1이상 이어야 합니다.";
    public static final String INVALID_LOTTO_MAX = "[ERROR] 로또 번호는 45미만 이어야 합니다.";
    public static final String DUPLICATE_LOTTO_NUMBER = "[ERROR] 로또 번호는 중복되지 않아야 합니다.";

    public static final String INVALID_WINNING_SIZE = "[ERROR] 당첨 번호는 6개여야 합니다.";
    public static final String INVALID_WINNING_RANGE = "[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.";

    public static final String INVALID_BONUS_RANGE = "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String DUPLICATE_BONUS_NUMBER = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.";

    public static final String NEGATIVE_PURCHASE_AMOUNT = "[ERROR] 구입 금액은 음수일 수 없습니다.";
    public static final String ZERO_PURCHASE_AMOUNT = "[ERROR] 구입 금액은 0원일 수 없습니다.";
    public static final String INVALID_PURCHASE_UNIT = "[ERROR] 구입 금액은 1,000원 단위여야 합니다.";

    public static final String INVALID_PURCHASE_FORMAT = "[ERROR] 구입 금액은 숫자여야 합니다.";
    public static final String INVALID_WINNING_FORMAT = "[ERROR] 당첨 번호는 숫자여야 합니다.";
    public static final String INVALID_BONUS_FORMAT = "[ERROR] 보너스 번호는 숫자여야 합니다.";

    private ErrorMessage() {
    }
}
