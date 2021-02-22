package com.company;


public class Main {


    public enum SourceType {
        WAREHOUSE, FACTORY;
    }

    public static void main(String[] args) {

        //initCosts(costuri);

        Source S1 = new Source();
        Source S2 = new Source();
        Source S3 = new Source();

        S1.setName("S1");
        S1.setSupply(10);
        S1.setType(SourceType.FACTORY);

        S2.setName("S2");
        S2.setSupply(35);
        S2.setType(SourceType.WAREHOUSE);

        S3.setName("S3");
        S3.setSupply(25);
        S3.setType(SourceType.WAREHOUSE);

        Destination D1 = new Destination();
        Destination D2 = new Destination();
        Destination D3 = new Destination();

        D1.setName("D1");
        D1.setDemand(20);

        D2.setName("D2");
        D2.setDemand(25);

        D3.setName("D3");
        D3.setDemand(25);


        Problem P13 = new Problem(S1,1,D3, 3,10,1);
        Problem P22 = new Problem(S2,2,D2, 2,25,4);
        Problem P23 = new Problem(S2,2,D3, 3,10,8);
        Problem P31 = new Problem(S3,3,D1, 1,20,5);
        Problem P33 = new Problem(S3,3,D3, 3,5,8);

        System.out.println(P13);
        System.out.println(P22);
        System.out.println(P23);
        System.out.println(P31);
        System.out.println(P33);

        System.out.println("Total cost: " + P13.costTotal);

    }

}
