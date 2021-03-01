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


        Solution Sol = new Solution(sources, destinations);
        Sol.printingInstance();
        Sol.feasibleSolution();
        System.out.println("Total cost: " + Sol.getCostTotal());


        Factory S1_0 = new Factory(10,"S1","Factory",0);
        Warehouse S1_1 = new Warehouse(35,"S2", "Factory", 1);
        Warehouse S1_2 = new Warehouse(25,"S3", "Warehouse", 2);
        Warehouse S1_3 = new Warehouse(25,"S4", "Warehouse", 3);

        Destination D1_0 = new Destination(20,"D1",0);
        Destination D1_1 = new Destination(25,"D2",1);
        Destination D1_2 = new Destination(25,"D3",2);
        //Destination D1_3 = new Destination(25,"D3",2);
        Destination D1_3 = new Destination(25,"D4",3);

        ArrayList<Source> sources1 = new ArrayList<Source>();
        ArrayList<Destination> destinations1 = new ArrayList<Destination>();

        sources1.add(S1_0);
        sources1.add(S1_1);
        sources1.add(S1_2);

        destinations1.add(D1_0);
        destinations1.add(D1_1);
        destinations1.add(D1_2);

        Solution Sol2 = new Solution(sources1,destinations1);

        Sol2.printingInstance();
        Sol2.vogelMethod();
        System.out.println("");
        //Sol2.printingInstance();
        System.out.println("Cost total: " + Sol2.getCostTotal());
    }

}
