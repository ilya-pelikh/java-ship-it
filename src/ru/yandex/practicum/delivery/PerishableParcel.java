package ru.yandex.practicum.delivery;

public class PerishableParcel extends Parcel {
    protected int timeToLive;

    public PerishableParcel(String description, int weight, String deliveryAddress, int sendDay, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }

    public boolean isExpired(int currentDay) {
        return currentDay > sendDay + timeToLive;
    }

    @Override
    protected int getDeliveryBaseValue() {
        return 3;
    }

}
