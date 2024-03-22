package ru.demo.dev.model.bank;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import ru.demo.dev.context.bonus.BonusCalculator;
import ru.demo.dev.enums.PointOfSailsType;

@Getter
@Setter
public class Bank {

    @Setter(AccessLevel.NONE)
    private final Long id;

    @Setter(AccessLevel.NONE)
    private final String name;

    private final int commissionSize = 10;

    private double innerBalance = Integer.MAX_VALUE;

    private double bankAccountOfEMoney;

    private BonusCalculator bonusCalculator;

    public Bank(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public double calculateBonus(double amount) {
        return bonusCalculator.calculate(amount);
    }

    public void increaseBalance(double value) {
        innerBalance += value;
    }

    public void decreaseBalance(double value) {
        innerBalance -= value;
    }

    public void increaseBankAccountOfEMoney(double value) {
        bankAccountOfEMoney += value;
    }
}
