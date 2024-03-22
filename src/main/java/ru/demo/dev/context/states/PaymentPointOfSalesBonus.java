package ru.demo.dev.context.states;

import lombok.extern.slf4j.Slf4j;
import ru.demo.dev.context.bonus.BonusCalculator;
import ru.demo.dev.context.bonus.OnlineBonusCalculator;
import ru.demo.dev.context.bonus.ShopBonusCalculator;
import ru.demo.dev.enums.PointOfSailsType;
import ru.demo.dev.enums.PurchaseStatus;
import ru.demo.dev.model.bank.Bank;
import ru.demo.dev.model.point_of_sales.PointOfSails;
import ru.demo.dev.context.PaymentContext;

@Slf4j
public class PaymentPointOfSalesBonus implements PaymentState {


    @Override
    public void process(PaymentContext paymentContext, PointOfSailsType pointOfSailsType, double amount) {
        log.info("Начисление бонусов точке продаж ...");

        Bank bank = paymentContext.getBank();

        //Выбираем обработчик расчета бонусов исходя из типа точки продажи
        BonusCalculator bonusCalculator = switch (pointOfSailsType) {
            case SHOP -> new ShopBonusCalculator();
            case ONLINE -> new OnlineBonusCalculator();
        };
        bank.setBonusCalculator(bonusCalculator);

        //Рассчитываем сумму бонуса
        double bonus = bank.calculateBonus(amount);

        //вычитаем сумму бонуса с внутреннего счета банка
        bank.decreaseBalance(bonus);

        //прибавляем сумму бонуса к общим деньгам точки продажи
        PointOfSails pointOfSails = paymentContext.getPointsOfSales().get(pointOfSailsType);
        pointOfSails.increaseMoney(bonus);

        //следующий шаг - коммисия, либо бонусы в зависимости от суммы покупки, либо завершение обработки покупки
        if (amount < 20)
            paymentContext.setPaymentState(new PaymentCommission());
        else if (amount > 300)
            paymentContext.setPaymentState(new PaymentBankBonus());
        else
            paymentContext.setPaymentState(new PaymentCompleted());
    }

    @Override
    public PurchaseStatus getPurchaseStatus() {
        return PurchaseStatus.POINT_OF_SALES_BONUS;
    }
}
