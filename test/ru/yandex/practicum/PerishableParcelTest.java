package ru.yandex.practicum;

import org.junit.Test;
import ru.yandex.practicum.delivery.PerishableParcel;
import static org.junit.Assert.*;

public class PerishableParcelTest {
    private String description = "Delivery description";
    private int weight = 1;
    private String deliveryAddress = "ул. Пушкина";
    private int sendDay = 1;

    @Test
    public void isPerishableParcelExpired() {
        PerishableParcel perishableParcel = new PerishableParcel(description, weight, deliveryAddress, sendDay, 1);
        boolean isExpired = perishableParcel.isExpired(3);

        assertTrue(isExpired);
    }
    @Test
    public void isPerishableParcelNotExpired() {
        PerishableParcel perishableParcel = new PerishableParcel(description, weight, deliveryAddress, sendDay, 2);
        boolean isExpired = perishableParcel.isExpired(3);

        assertFalse(isExpired);
    }
}
