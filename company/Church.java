package com.company;

import java.time.LocalTime;

public class Church extends Location implements Visitable{
    private int numarMembrii;
    private String verset;
    private LocalTime openingTime, closingTime;

    public Church() {
        this.numarMembrii = 0;
        this.verset = "";
        this.openingTime = LocalTime.of(9, 00);
        this.closingTime = LocalTime.of(12, 00);
    }

    public Church(int numarMembrii, String verset, LocalTime openingTime, LocalTime closingTime) {
        this.numarMembrii = numarMembrii;
        this.verset = verset;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    @Override
    public String toString() {
        return "Church{" +
                "numarMembrii=" + numarMembrii +
                ", verset='" + verset + '\'' +
                ", openingTime=" + openingTime +
                ", closingTime=" + closingTime +
                '}';
    }

    public int getNumarMembrii() {
        return numarMembrii;
    }

    public String getVerset() {
        return verset;
    }

    public void setNumarMembrii(int numarMembrii) {
        this.numarMembrii = numarMembrii;
    }

    public void setVerset(String verset) {
        this.verset = verset;
    }

    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }

    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }

    @Override
    public LocalTime getOpeningTime() {
        return null;
    }

    @Override
    public LocalTime getClosingTime() {
        return null;
    }
}
