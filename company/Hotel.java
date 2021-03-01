package com.company;

public class Hotel extends Location implements Clasifiable{
    private int numarCamere;
    private int numarStele;
    private int rank;

    public Hotel() {
        this.numarCamere = 0;
        this.numarStele = 0;
        this.rank = 0;
    }

    public Hotel(int numarCamere, int numarStele, int rank) {
        this.numarCamere = numarCamere;
        this.numarStele = numarStele;
        this.rank = rank;
    }

    public int getNumarCamere() {
        return numarCamere;
    }

    public int getNumarStele() {
        return numarStele;
    }

    public void setNumarCamere(int numarCamere) {
        this.numarCamere = numarCamere;
    }

    public void setNumarStele(int numarStele) {
        this.numarStele = numarStele;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "numarCamere=" + numarCamere +
                ", numarStele=" + numarStele +
                ", rank=" + rank +
                '}';
    }

    @Override
    public int getRank() {
        return rank;
    }
}
