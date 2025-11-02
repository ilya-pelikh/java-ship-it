package ru.yandex.practicum.delivery;

import java.util.ArrayList;

public class ParcelBox<T extends Parcel> {
    private final int maxWeight;
    private final ArrayList<T> parcelList = new ArrayList<>();

    public ParcelBox(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public void addParcel (T newParcel) {
        int sum = 0;

        for(Parcel parcel : parcelList) {
            sum += parcel.getWeight();
        }

        int parcelWeight = newParcel.getWeight();

        if (sum + parcelWeight > maxWeight) {
            System.out.println("В текущей коробке недостаточно места.");
            return;
        }

        parcelList.add(newParcel);
    }

    public ArrayList<T> getAllParcels () {
        return parcelList;
    }

}
