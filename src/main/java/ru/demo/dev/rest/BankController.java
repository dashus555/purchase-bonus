package ru.demo.dev.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.demo.dev.context.PaymentContext;

@RestController
@RequestMapping("/api")
public class BankController {

    private final PaymentContext paymentContext;

    public BankController(PaymentContext paymentContext) {
        this.paymentContext = paymentContext;
    }

    @GetMapping("/bankAccountOfEMoney")
    public double getBankAccountOfEMoney() {
        return paymentContext.getBank().getBankAccountOfEMoney();
    }
}
