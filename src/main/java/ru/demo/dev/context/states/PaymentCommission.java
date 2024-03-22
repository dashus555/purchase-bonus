package ru.demo.dev.context.states;

import lombok.extern.slf4j.Slf4j;
import ru.demo.dev.enums.PointOfSailsType;
import ru.demo.dev.enums.PurchaseStatus;
import ru.demo.dev.context.PaymentContext;
import ru.demo.dev.model.bank.Bank;
import ru.demo.dev.model.point_of_sales.PointOfSails;

@Slf4j
public class PaymentCommission implements PaymentState {

    @Override
    public void process(PaymentContext paymentContext, PointOfSailsType pointOfSailsType, double amount) {
        log.info("Взятие комиссии за сумму покупки....");

        Bank bank = paymentContext.getBank();

        double commissionSum = amount*bank.getCommissionSize()/100;

        PointOfSails pointOfSails = paymentContext.getPointsOfSales().get(pointOfSailsType);
        pointOfSails.decreaseMoney(commissionSum);

        bank.increaseBalance(commissionSum);

        paymentContext.setPaymentState(new PaymentRefund());
    }

    @Override
    public PurchaseStatus getPurchaseStatus() {
        return PurchaseStatus.COMMISSION;
    }
}
