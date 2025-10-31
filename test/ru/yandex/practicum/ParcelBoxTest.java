package ru.yandex.practicum;

import org.junit.Test;
import ru.yandex.practicum.delivery.ParcelBox;
import ru.yandex.practicum.delivery.StandardParcel;

import static org.junit.Assert.assertEquals;

public class ParcelBoxTest {
    private String description = "Delivery description";
    private int weight = 1;
    private String deliveryAddress = "ул. Пушкина";
    private int sendDay = 1;

    @Test
    public void successAddingParcelToBox () {
        ParcelBox<StandardParcel> parcelBox = new ParcelBox<>(2);
        StandardParcel standardParcel = new StandardParcel(description, weight, deliveryAddress, sendDay);
        parcelBox.addParcel(standardParcel);
        parcelBox.addParcel(standardParcel);

        int boxSize = parcelBox.getParcelList().size();
        assertEquals(2, boxSize);
    }
    @Test
    public void unSuccessAddingParcelToBox () {
        ParcelBox<StandardParcel> parcelBox = new ParcelBox<>(2);
        StandardParcel standardParcel = new StandardParcel(description, weight, deliveryAddress, sendDay);
        parcelBox.addParcel(standardParcel);
        parcelBox.addParcel(standardParcel);
        parcelBox.addParcel(standardParcel);

        int boxSize = parcelBox.getParcelList().size();
        assertEquals(2, boxSize);
    }


}
