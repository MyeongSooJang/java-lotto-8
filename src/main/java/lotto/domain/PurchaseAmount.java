package lotto.domain;

public class PurchaseAmount {
    private final int purchaseAmount;

    public PurchaseAmount(int purchaseAmount) {
        validateNegative(purchaseAmount);
        validateZero(purchaseAmount);
        validateThousandUnit(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    private void validateNegative(int purchaseAmount) {
        if (purchaseAmount < 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 음수일 수 없습니다.");
        }
    }

    private void validateZero(int purchaseAmount) {
        if (purchaseAmount == 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 0원일 수 없습니다.");
        }
    }

    private void validateThousandUnit(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    public int calculateLottoCount() {
        return purchaseAmount / 1000;
    }

    public int getAmount() {
        return purchaseAmount;
    }
}
