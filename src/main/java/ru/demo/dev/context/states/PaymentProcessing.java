package ru.demo.dev.context.states;

import lombok.extern.slf4j.Slf4j;
import ru.demo.dev.enums.PointOfSailsType;
import ru.demo.dev.enums.PurchaseStatus;
import ru.demo.dev.context.PaymentContext;
import ru.demo.dev.model.client.BankClient;
import ru.demo.dev.model.point_of_sales.PointOfSails;

@Slf4j
public class PaymentProcessing implements PaymentState {

    @Override
    public void process(PaymentContext paymentContext, PointOfSailsType pointOfSailsType, double amount) {
        log.info("Обработка платежа, сумма платежа {}", amount);

        //вычитаем сумму покупки из денег клиента
        BankClient bankClient = paymentContext.getBankClient();
        bankClient.decreaseMoneyForAmount(amount);

        //прибавляем сумму покупки к деньгам точки продаж
        PointOfSails pointOfSails = paymentContext.getPointsOfSales().get(pointOfSailsType);
        pointOfSails.increaseMoney(amount);

        //следующий шаг - начисление бонусов точке продажи
        paymentContext.setPaymentState(new PaymentPointOfSalesBonus());
    }

    @Override
    public PurchaseStatus getPurchaseStatus() {
        return PurchaseStatus.PROCESSING;
    }
}
