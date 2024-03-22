package ru.demo.dev.context.bonus;

public class ShopBonusCalculator implements BonusCalculator {

    @Override
    public double calculate(double amount) {
        int bonusSize = 10;
        return amount * bonusSize / 100;
    }
}
