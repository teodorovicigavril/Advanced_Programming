package com.company;

import java.time.LocalTime;

public class Museum extends Location implements Visitable,Payable{
    private int numarExponate;
    private String domeniu;
    private LocalTime openingTime, closingTime;
    private double ticketPrice;

    public int getNumarExponate() {
        return numarExponate;
    }

    public String getDomeniu() {
        return domeniu;
    }

    public void setNumarExponate(int numarExponate) {
        this.numarExponate = numarExponate;
    }

    public void setDomeniu(String domeniu) {
        this.domeniu = domeniu;
    }

    public Museum() {
        this.ticketPrice = 0;
        this.openingTime = LocalTime.of(9, 30);
        this.closingTime = LocalTime.of(17, 00);
        this.numarExponate = 0;
        this.domeniu = "";
    }

    public Museum(LocalTime openingTime, LocalTime closingTime, double ticketPrice, int numarExponate, String domeniu) {
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.ticketPrice = ticketPrice;
        this.numarExponate = numarExponate;
        this.domeniu = domeniu;
    }

    @Override
    public String toString() {
        return "Museum{" +
                "numarExponate=" + numarExponate +
                ", domeniu='" + domeniu + '\'' +
                ", openingTime=" + openingTime +
                ", closingTime=" + closingTime +
                ", ticketPrice=" + ticketPrice +
                '}';
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    @Override
    public LocalTime getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }

    @Override
    public LocalTime getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }

    @Override
    public double getTicketPrice() {
        return ticketPrice;
    }
}
