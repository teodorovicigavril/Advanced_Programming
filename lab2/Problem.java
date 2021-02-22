package com.company;

public class Problem{
    private Source S1 = new Source();
    private Destination D1 = new Destination();
    private int cost;
    private int transportCost;
    private int transport;


    public static int[][] costuri = new int[4][4];
    public static int costTotal = 0;

    public String toString() {
        return String.format(S1.getName() + " -> " + D1.getName() + ": " + this.transport + " units * cost " + this.cost + " = " + this.transportCost);
    }

    Problem(Source S1, int pozitie1, Destination D1, int pozitie2, int transport, int cost){
        costuri[pozitie1][pozitie2] = cost;
        this.S1 = S1;
        this.D1 = D1;
        this.cost = costuri[pozitie1][pozitie2];
        this.transport = transport;
        this.transportCost = (Math.min(S1.getSupply(),Math.min(D1.getDemand(),this.transport))*this.cost);

        costTotal += transportCost;
    }

}
