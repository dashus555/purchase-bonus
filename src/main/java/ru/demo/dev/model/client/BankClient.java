package ru.demo.dev.model.client;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class BankClient {

    @Setter(AccessLevel.NONE)
    private final Long id;

    @Setter(AccessLevel.NONE)
    private final String name;

    private double money;

    private List<Double> amountsOfPurchases;

    public BankClient(Long id, String name) {
        this.id = id;
        this.name = name;
        this.amountsOfPurchases = new ArrayList<>(20);
    }

    public void decreaseMoneyForAmount(double amount) {
        money -= amount;
    }
}
