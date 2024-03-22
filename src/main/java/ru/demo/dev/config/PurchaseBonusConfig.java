package ru.demo.dev.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.demo.dev.context.PaymentContext;
import ru.demo.dev.context.states.PaymentNew;
import ru.demo.dev.enums.PointOfSailsType;
import ru.demo.dev.model.bank.Bank;
import ru.demo.dev.model.client.BankClient;
import ru.demo.dev.model.point_of_sales.Online;
import ru.demo.dev.model.point_of_sales.PointOfSails;
import ru.demo.dev.model.point_of_sales.Shop;

import java.util.Map;

@Configuration
public class PurchaseBonusConfig {

//    @Bean
//    public PaymentContext configureBankTransactionManager() {
//
//        PaymentContext paymentContext = new PaymentContext();
//
//        BankClient bankClient = new BankClient(1L, "Иванов Иван");
//        bankClient.setMoney(5000);
//
//        Bank bank = new Bank(1L, "ЮниБанк");
//
//        PointOfSails shop = new Shop(1L, "Магазин");
//        PointOfSails online = new Online(1L, "Онлайн покупки");
//        Map<PointOfSailsType, PointOfSails> pointsOfSales =
//                Map.of(PointOfSailsType.SHOP, shop, PointOfSailsType.ONLINE, online);
//
//        paymentContext.setBank(bank);
//        paymentContext.setBankClient(bankClient);
//        paymentContext.setPointsOfSales(pointsOfSales);
//        paymentContext.setPaymentState(new PaymentNew());
//
//        return paymentContext;
//    }
}
