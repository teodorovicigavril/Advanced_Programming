package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Problem {
    private ArrayList<Source> sources;
    private ArrayList<Destination> destinations;

    private int transportCost;
    private int nr_s;
    private int nr_d;

    private ArrayList<ArrayList<Integer>> costuri;

    private int costTotal = 0;

    /**
     * Constructorul clasei Problem primeste un Array de surse si unul de destinatii
     * Deasemenea va crea initializa nr_s si nr_d cu dimensiunea Array lor precizate mai sus
     * Va crea matricea de costuri, ca un Array de Array de int uri si va citi aceasta matrice
     * @param sources sursele
     * @param destinations destinatile
     */
    public Problem(ArrayList<Source> sources, ArrayList<Destination> destinations) {
        this.sources = sources;
        this.destinations = destinations;
        nr_s = sources.size();
        nr_d = destinations.size();
        costuri = new ArrayList<ArrayList<Integer>>();
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < nr_s; i++) {
            ArrayList<Integer> aux = new ArrayList<Integer>();
            for (int j = 0; j < nr_d; j++) {
                System.out.print("Costul pentru sursa: " + i + " si destinatia: " + j + ": ");
                aux.add(scan.nextInt());
            }
            costuri.add(aux);
        }
    }

    /**
     *
     * @param s Metoda adauga o sursa  noua in lista de surse ale problemei
     *          insa doar atunci cand aceasta nu exista deja, iar apoi va citi si completa
     *          matricea de costuri dupa adaugarea acestei surse.
     */
    public void addSource(Source s){
        boolean possibleToAdd = true;
        for(int i=0;i<nr_s;i++)
            if(sources.get(i).equals(s))
                possibleToAdd = false;
        if(possibleToAdd){
            nr_s++;
            ArrayList<Integer> aux = new ArrayList<Integer>();
            Scanner scan = new Scanner(System.in);
            for(int j=0;j<nr_d;j++){
                int index1=s.getIndex()+1;
                int index2=j+1;
                System.out.print("Costul pentru sursa: " + index1 + " si destinatia: " + index2 + ": ");
                aux.add(scan.nextInt());
            }
            costuri.add(aux);
            sources.add(s);
            System.out.println("Source " + s.getName() + " was sucessfully added!");
            return;
        }
        System.out.println("Source " + s.getName() + " already exists!");
    }

    /**
     *
     * @param d Metoda adauga o destinatie noua in lista de destinatii ale problemei
     *          insa doar atunci cand aceasta nu exista deja, iar apoi va citi si completa
     *          matricea de costuri dupa adaugarea acestei destinatii.
     */
    public void addDestination(Destination d){
        boolean possibleToAdd = true;
        for(int i=0;i<nr_d;i++)
            if(destinations.get(i).equals(d))
                possibleToAdd = false;
        if(possibleToAdd){
            nr_d++;
            Scanner scan = new Scanner(System.in);
            for(int j=0;j<nr_s;j++){
                int index1=d.getIndex()+1;
                int index2=j+1;
                System.out.print("Costul pentru sursa: " + index2 + " si destinatia: " + index1 + ": ");
                costuri.get(j).add(scan.nextInt());
            }
            destinations.add(d);
            System.out.println("Destination " + d.getName() + " was sucessfully added!");
            return;
        }
        System.out.println("Destination " + d.getName() + " already exists!");
    }

    /**
     * Metoda fara parametrii care va afisa instanta problemei curente:
     *      -tabelul de costuri alaturi de numele surselor si destinatiilor si
     *       supply urile si demand urile respective surselor, destinatiilor.
     */
    public void printingInstance(){
        System.out.print("\t\t");
        for(int i=0; i<destinations.size(); i++) {
            System.out.print("\t" + destinations.get(i).getName() + "\t");
        }
        System.out.println("\tSupply\t");

        for(int j=0;j<sources.size();j++) {
            System.out.print("\t" + sources.get(j).getName() + "\t");
            for (int i = 0; i < destinations.size(); i++) {
                System.out.print("\t" + costuri.get(j).get(i) + "\t");
            }
            System.out.println("\t" + sources.get(j).getSupply() + "\t");
        }

        System.out.print("\tDemand");
        for(int i=0; i<destinations.size(); i++) {
            System.out.print("\t" + destinations.get(i).getDemand() + "\t");
        }
        System.out.println("\t\t");

    }

    @Override
    public String toString() {
        return "Problem{" +
                "sources=" + sources +
                ", destinations=" + destinations +
                ", transportCost=" + transportCost +
                ", nr_s=" + nr_s +
                ", nr_d=" + nr_d +
                ", costuri=" + costuri +
                ", costTotal=" + costTotal +
                '}';
    }

    public ArrayList<ArrayList<Integer>> getCosturi() {
        return costuri;
    }


    public void setCosturi(ArrayList<ArrayList<Integer>> costuri) {
        this.costuri = costuri;
    }


    public int getTransportCost() {
        return transportCost;
    }

    public void setTransportCost(int transportCost) {
        this.transportCost = transportCost;
    }


    public int getNr_s() {
        return nr_s;
    }

    public void setNr_s(int nr_s) {
        this.nr_s = nr_s;
    }

    public int getNr_d() {
        return nr_d;
    }

    public void setNr_d(int nr_d) {
        this.nr_d = nr_d;
    }


    public int getCostTotal() {
        return costTotal;
    }

    public void setCostTotal(int costTotal) {
        this.costTotal = costTotal;
    }

    public ArrayList<Source> getSources() {
        return sources;
    }

    public void setSources(ArrayList<Source> sources) {
        this.sources = sources;
    }

    public ArrayList<Destination> getDestinations() {
        return destinations;
    }

    public void setDestinations(ArrayList<Destination> destinations) {
        this.destinations = destinations;
    }


}