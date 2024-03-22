package ru.demo.dev.model.point_of_sales;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class PointOfSails {

    @Setter(AccessLevel.NONE)
    private final Long id;

    @Setter(AccessLevel.NONE)
    private final String name;

    private double money;

    public PointOfSails(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void increaseMoney(double value) {
        money += value;
    }

    public void decreaseMoney(double value) {
        money -= value;
    }
}
