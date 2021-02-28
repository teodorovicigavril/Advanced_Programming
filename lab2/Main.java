package com.company;

import java.util.ArrayList;

/**
 *
 * @author Teodorovici Gavril-Anton
 */

public class Main {

    public static void main(String[] args) {

        Factory S0 = new Factory(10,"S1","Factory",0);
        Warehouse S1 = new Warehouse(35,"S2", "Factory", 1);
        Warehouse S2 = new Warehouse(25,"S3", "Warehouse", 2);
        Warehouse S3 = new Warehouse(25,"S4", "Warehouse", 3);

        Destination D0 = new Destination(20,"D1",0);
        Destination D1 = new Destination(25,"D2",1);
        Destination D2 = new Destination(25,"D3",2);
        //Destination D3 = new Destination(25,"D3",2);
        Destination D3 = new Destination(25,"D4",3);

        ArrayList<Source> sources = new ArrayList<Source>();
        ArrayList<Destination> destinations = new ArrayList<Destination>();

        sources.add(S0);
        sources.add(S1);
        sources.add(S2);

        destinations.add(D0);
        destinations.add(D1);
        destinations.add(D2);

       // Problem P1 = new Problem(sources,destinations);
       // System.out.println(P1);

       // P1.printingInstance();
       // P1.addSource(S3);
       // P1.addDestination(D3);
       // P1.printingInstance();

        Solution Sol = new Solution(sources, destinations);
        Sol.printingInstance();
        Sol.feasibleSolution();
        System.out.println("Total cost: " + Sol.getCostTotal());
        Sol.vogelMethod();
        System.out.println("");
        //Sol.printingInstance();
        System.out.println("Cost total: " + Sol.getCostTotal());
    }

}
