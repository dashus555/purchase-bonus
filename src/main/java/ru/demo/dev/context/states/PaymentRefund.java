package ru.demo.dev.context.states;

import lombok.extern.slf4j.Slf4j;
import ru.demo.dev.enums.PointOfSailsType;
import ru.demo.dev.enums.PurchaseStatus;
import ru.demo.dev.context.PaymentContext;
import ru.demo.dev.model.bank.Bank;

@Slf4j
public class PaymentRefund implements PaymentState {

    @Override
    public void process(PaymentContext paymentContext, PointOfSailsType pointOfSailsType, double amount) {
        log.info("Возврат...");

        Bank bank = paymentContext.getBank();

        //сумма начисленного бонуса
        double payedBonus = bank.calculateBonus(amount);

        //сумма переплаты по бонусу
        double overPayed = payedBonus*bank.getCommissionSize()/100;

        //снимаем сумму переплаты со счета точки продаж и начисляем на счет банка
        paymentContext.getPointsOfSales().get(pointOfSailsType).decreaseMoney(overPayed);
        bank.increaseBalance(overPayed);

        //следующий шаг - завершить платеж
        paymentContext.setPaymentState(new PaymentCompleted());
    }

    @Override
    public PurchaseStatus getPurchaseStatus() {
        return PurchaseStatus.REFUND;
    }
}
