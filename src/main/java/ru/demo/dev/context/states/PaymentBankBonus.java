package ru.demo.dev.context.states;

import lombok.extern.slf4j.Slf4j;
import ru.demo.dev.enums.PointOfSailsType;
import ru.demo.dev.enums.PurchaseStatus;
import ru.demo.dev.context.PaymentContext;

@Slf4j
public class PaymentBankBonus implements PaymentState {

    private final int bonus = 30;

    @Override
    public void process(PaymentContext paymentContext, PointOfSailsType pointOfSailsType, double amount) {
        log.info("Бонусы за сумму покупки...");

        double bonusSum = amount*bonus/100;

        paymentContext.getBank().increaseBankAccountOfEMoney(bonusSum);

        paymentContext.setPaymentState(new PaymentCompleted());
    }

    @Override
    public PurchaseStatus getPurchaseStatus() {
        return PurchaseStatus.BANK_BONUS;
    }
}
