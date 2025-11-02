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
            throw new IllegalArgumentException();
        }
    }

    private void validateZero(int purchaseAmount) {
        if (purchaseAmount == 0) {
            throw new IllegalArgumentException();
        }
    }

    private void validateThousandUnit(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    public int calculateLottoCount() {
        return purchaseAmount / 1000;
    }

    public int getAmount() {
        return purchaseAmount;
    }
}
