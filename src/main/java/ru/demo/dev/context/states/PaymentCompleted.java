package ru.demo.dev.context.states;

import lombok.extern.slf4j.Slf4j;
import ru.demo.dev.enums.PointOfSailsType;
import ru.demo.dev.enums.PurchaseStatus;
import ru.demo.dev.context.PaymentContext;

@Slf4j
public class PaymentCompleted implements PaymentState {


    @Override
    public void process(PaymentContext paymentContext, PointOfSailsType pointOfSailsType, double amount) {
        log.info("Обработка покупки на сумму {} успешно завершена", amount);

        paymentContext.setPaymentState(new PaymentNew());
    }

    @Override
    public PurchaseStatus getPurchaseStatus() {
        return PurchaseStatus.COMPLETED;
    }
}
