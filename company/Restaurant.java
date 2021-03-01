package com.company;

public class Restaurant extends Location implements Clasifiable{
    private int numarMeniuri;
    private String meniulZilei;
    private int rank;

    public Restaurant(int numarMeniuri, String meniulZilei, int rank) {
        this.numarMeniuri = numarMeniuri;
        this.meniulZilei = meniulZilei;
        this.rank = rank;
    }

    public Restaurant() {
        this.numarMeniuri = 0;
        this.meniulZilei = "";
        this.rank = 0;
    }

    public int getNumarMeniuri() {
        return numarMeniuri;
    }

    public String getMeniulZilei() {
        return meniulZilei;
    }

    public void setNumarMeniuri(int numarMeniuri) {
        this.numarMeniuri = numarMeniuri;
    }

    public void setMeniulZilei(String meniulZilei) {
        this.meniulZilei = meniulZilei;
    }

    @Override
    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "numarMeniuri=" + numarMeniuri +
                ", meniulZilei='" + meniulZilei + '\'' +
                ", rank=" + rank +
                '}';
    }
}
