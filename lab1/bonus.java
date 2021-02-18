package com.company;

import java.util.Scanner;

public class bonus {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Number of nodes in the tree: ");
        int nodes= in.nextInt();

        int[][] arbore = new int[nodes+1][nodes+1];

        CreareFii(0,arbore,nodes,1);

        boolean[] vizitat = new boolean[nodes+1];


        afisare(arbore,nodes);
        ReprezentareTextualaArbore(0,arbore,nodes,0,vizitat);
    }

    public static boolean AreCopii(int nod, int[][] arbore, int numarNoduri){
        for(int iterator = nod+1; iterator < numarNoduri; iterator ++)
            if(arbore[nod][iterator] == 1)
                return true;
        return false;
    }

    public  static void ReprezentareTextualaArbore(int nodCurent, int[][] arbore, int numarNoduri, int adancime, boolean[] vizitat){
        vizitat[nodCurent] = true;
        for(int iterator = 1; iterator <= adancime; iterator ++)
            System.out.print("  ");
        if(AreCopii(nodCurent, arbore, numarNoduri))
            System.out.println("+node" + nodCurent);
        else
            System.out.println("-node" + nodCurent);
        for(int iterator = 0; iterator < numarNoduri; iterator ++) {
            if(arbore[nodCurent][iterator] == 1 && vizitat[iterator] == false) {
                adancime++;
                ReprezentareTextualaArbore(iterator, arbore, numarNoduri, adancime, vizitat);
                adancime--;
            }
        }
    }

    public static void CreareFii(int nodCurent, int[][] arbore, int numarNoduri, int numarCurentNoduri){
            int numarFii = (int)(Math.random() * (numarNoduri-numarCurentNoduri) + 1) ;
            if(numarFii != 0) {
                for(int iterator = 0; iterator < numarFii; iterator ++) {
                    arbore[nodCurent][numarCurentNoduri + iterator] = 1;
                    arbore[numarCurentNoduri + iterator][nodCurent] = 1;
                }
                numarCurentNoduri += numarFii;
                CreareFii(nodCurent+1,arbore,numarNoduri,numarCurentNoduri);
            }
    }

    public static void afisare(int[][] arbore, int nodes) {
        for(int iterator1 = 0; iterator1 < nodes; iterator1 ++ ) {
            for(int iterator2 = 0; iterator2 < nodes; iterator2 ++)
                System.out.print(arbore[iterator1][iterator2] + " ");
            System.out.println();
        }
    }

}
