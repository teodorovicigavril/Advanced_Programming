package com.company;

/**
 *
 * @author Teodorovici Gavril-Anton
 */

public class optional {

    public static void main(String[] args) {

        // Optional
        // MV OPTIONS: -Xms8G -Xmx8G -Xss1024M

        long startTime = System.nanoTime();

        if(args.length < 1 )
        {
            System.out.println("Need to specify one argument!");
            System.exit(-1);
        }
        int n = Integer.parseInt(args[0]);
        if(n %2 == 0)
        {
            System.out.println("The argument need to be odd!");
            System.exit(-1);
        }


        int ii, jj;
        int[][] M= new int[n+1][n+1];
        for(ii=1; ii<= n; ii++) {
            for(jj=ii+1; jj<= n; jj++) {
                if (Math.random() < 0.5)
                {
                    M[ii][jj] = 0;
                    M[jj][ii] = 0;
                }else
                {
                    M[ii][jj] = 1;
                    M[jj][ii] = 1;
                }
            }
        }

        /*
        for(ii=1;ii<=n;ii++)
            {   for(jj=1;jj<=n;jj++)
                {
                    if(M[ii][jj] == 0)
                        System.out.print("\u25CB" + " ");
                    else
                        System.out.print("\u25CF" + " ");
                }
                System.out.println("");
            }
        */

        boolean[] vizitat = new boolean[n+1];
        int nr_cc = 0;


        for(ii=1; ii<=n; ii++) {
            if(vizitat[ii] == false) {
                nr_cc++;
                //System.out.print("\nComponenta conexa " + nr_cc + ": ");
                parcurgere_cc(ii,vizitat,M,n,nr_cc);
            }
        }

        for(ii=1;ii<=n;ii++)
            vizitat[ii] = false;

        int[][] Arobre_Partial = new int[n+1][n+1];

        if(nr_cc == 1) {
            parcurgere(1,vizitat,M,n,Arobre_Partial);

            /*
            System.out.println("\nArborele partial este: ");
            for(ii=1;ii<=n;ii++)
            {   for(jj=1;jj<=n;jj++)
                {
                    if(Arobre_Partial[ii][jj] == 0)
                        System.out.print("\u25CB" + " ");
                    else
                        System.out.print("\u25CF" + " ");
                }
                System.out.println("");
            }*/

        }else {
            System.out.println("\nGraful are " + nr_cc + " componente conexe!");
        }

        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("\nTimpul in nanosecunde: " + totalTime);
    }

    public static void parcurgere(int s, boolean[] vizitat,  int M[][], int n, int ArborePartial[][])
    {
        vizitat[s] = true;
        for(int ii=1;ii<=n;ii++) {
            if (M[s][ii] == 1) {
                if(vizitat[ii] == false) {
                    ArborePartial[s][ii] = 1;
                    ArborePartial[ii][s] = 1;
                    parcurgere(ii,vizitat,M,n, ArborePartial);
                }

            }
        }
    }

    public static void parcurgere_cc(int s, boolean[] vizitat,  int M[][], int n, int nr_cc) {
        if (vizitat[s] == false) {
            //System.out.print(s + " ");
            vizitat[s] = true;
        }
        for (int ii = 1; ii <= n; ii++) {
            if (M[s][ii] == 1) {
                if (vizitat[ii] == false)
                    parcurgere_cc(ii, vizitat, M, n, nr_cc);
            }
        }
    }
}
