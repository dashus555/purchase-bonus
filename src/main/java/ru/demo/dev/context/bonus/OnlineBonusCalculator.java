package ru.demo.dev.context.bonus;

public class OnlineBonusCalculator implements BonusCalculator {

    @Override
    public double calculate(double amount) {
        int bonusSize = 17;
        return amount * bonusSize / 100;
    }
}
