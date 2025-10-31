package ru.yandex.practicum;

import org.junit.Test;
import ru.yandex.practicum.delivery.*;
import static org.junit.Assert.*;

public class DeliveryCostTest {
    private String description = "Delivery description";
    private int weight = 1;
    private String deliveryAddress = "ул. Пушкина";
    private int sendDay = 1;

    @Test
    public void standardParcelCost() {
        StandardParcel standardParcel = new StandardParcel(description, weight, deliveryAddress, sendDay);
        int cost = standardParcel.calculateDeliveryCost();

        assertEquals(2, cost);
    }

    @Test
    public void FragileParcelCost() {
        FragileParcel fragileParcel = new FragileParcel(description, weight, deliveryAddress, sendDay);
        int cost = fragileParcel.calculateDeliveryCost();

        assertEquals(4, cost);
    }
    @Test
    public void perishableParcelCost() {
        PerishableParcel perishableParcel = new PerishableParcel(description, weight, deliveryAddress, sendDay, 2);
        int cost = perishableParcel.calculateDeliveryCost();

        assertEquals(3, cost);
    }

}
