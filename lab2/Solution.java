package com.company;

import java.util.ArrayList;


public class Solution extends Problem {

    /**
     * Clasa Solution este o sublclasa a Problemei care vine cu un adaos:
     *  -o rezolvare a problemei care satisface supply ul si demand ul
     *  -o rezolvare de tipul Vogel's approximation explicata mai jos
     * Constructorul ne produce o problema la care voi adauga metode pentru a o rezolva
     * @param sources
     * @param destinations
     */
    public Solution(ArrayList<Source> sources, ArrayList<Destination> destinations) {
        super(sources, destinations);
    }

    /**
     *
     * @return functia returneaza elementul maxim din matricea costurilor
     */
    public int maxElement(){
        int maxim = getCosturi().get(0).get(0);
        for(int i=0;i<getCosturi().size();i++)
            for(int j=0;j<getCosturi().get(i).size();j++)
                if(maxim<getCosturi().get(i).get(j))
                    maxim=getCosturi().get(i).get(j);
        return maxim;
    }

    /**
     *
     * @param vector un vector de intregi
     * @param dimension lungimea vectorului
     * @return functia va returna indexul din vector al celei mai mici valori
     */
    public int minElement(ArrayList<Integer> vector, int dimension) {
        int min = vector.get(0);
        int index = 0;
        for (int i = 0; i < dimension; i++)
            if (min > vector.get(i)) {
                min = vector.get(i);
                index = i;
            }
        return index;
    }

    /**
     * O solutie fezabila, de tipul greedy in care atat timp cat am supply sau demand
     * voi alege din fiecare linie a matricei de costuri, costul cel mai mic si il voi inmulti
     * cu minim ul dintre supply(i) si demand(j), unde i si j sunt indecsii de identificare a elementului respectiv
     * in interiorul matricei. voi aduga rezultatul la calculul total iar apoi voi scadea din supply si demand folosite
     * minimul dintre ele si apoi voi schimba valoarea costului cu elementulMax din matrice + 1 pentru a nu fi ales din nou
     */
    public void feasibleSolution() {
        int sumCost = 0;
        int numarElemente = getSources().size()*getDestinations().size();
        //elementul maxim din matrice
        int maximElement = maxElement();
        //cat timp am supply sau demand
        while(existsSupplyDemand()>0){

            for(int i=0;i<getDestinations().size();i++) {
                // aleg minimul liniei
                int minFromLine = minElement(getCosturi().get(i), getCosturi().get(i).size());
                int minimSupplyDemand;
                // supply de 0 si demand de 0 nu luam in calcul pentru aflarea minimului dintre supply si demand
                if(getSources().get(i).getSupply() == 0)
                    minimSupplyDemand = getDestinations().get(minFromLine).getDemand();
                else if(getDestinations().get(minFromLine).getDemand() == 0)
                    minimSupplyDemand =getSources().get(i).getSupply();
                    else minimSupplyDemand = Math.min(getSources().get(i).getSupply(),getDestinations().get(minFromLine).getDemand());

                //daca am ramas cu un singur element atunci voi aduna supply ul si demandul elementului si voi inmulti cu valoarea elementului(costul)
                if(numarElemente == 1){
                    sumCost += getCosturi().get(i).get(minFromLine) * (getSources().get(i).getSupply()+getDestinations().get(minFromLine).getDemand());
                }else {
                    //daca nu, la costul total se adauga valoarea costului*minimul dintre supply si demand
                    sumCost += getCosturi().get(i).get(minFromLine) * minimSupplyDemand;
                }
                // schimb valoarea costului pentru elementul curent pentru a iesi din calcul
                getCosturi().get(i).set(minFromLine,maximElement+1);
                // actualizez supply ul si demand ul
                if(getSources().get(i).getSupply() != 0)
                    getSources().get(i).setSupply(getSources().get(i).getSupply()-minimSupplyDemand);
                if(getDestinations().get(minFromLine).getDemand() != 0)
                getDestinations().get(minFromLine).setDemand(getDestinations().get(minFromLine).getDemand()-minimSupplyDemand);

                numarElemente--;
            }
        }
        setCostTotal(sumCost);
    }

    /**
     *
     * @param vector este un array - o linie din matricea de costuri
     * @param dimension lungimea vectorului
     * @return se va returna pozitia celui mai mare Penalty, cu alte cuvinte
     * se va calcula maximul unui vector.
     */
    public int maxPenaltyPozition(ArrayList<Integer> vector, int dimension) {
        int max = vector.get(0);
        int index = 0;
        for (int i = 0; i < dimension; i++)
            if (max < vector.get(i)) {
                max = vector.get(i);
                index = i;
            }
        return index;
    }

    /**
     *
     * @param index index este indexul pentru a stii in ce linie din matrice cautam
     * @param dimension dimensiunea liniei din matrice
     * @return se va returna 0 daca e vorba doar despre un element pe linie sau
     *         cea mai mica diferenta dintre elementele liniei, adica Penalty ul liniei index
     */
    public int minDiffRow(int index, int dimension) {
        if(dimension == 1) return 0;
        int minDiff = Math.abs(getCosturi().get(index).get(0) - getCosturi().get(index).get(1));
        for (int i = 0; i < dimension-1; i++)
            for (int j = i + 1; j < dimension; j++) {
                if (Math.abs(getCosturi().get(index).get(i) - getCosturi().get(index).get(j)) < minDiff)
                    minDiff = Math.abs(getCosturi().get(index).get(i) - getCosturi().get(index).get(j));
            }
        return minDiff;
    }

    /**
     *
     * @param index index este indexul pentru a stii in ce coloana din matrice cautam
     * @param dimension dimensiunea coloanei din matrice
     * @return se va returna 0 daca e vorba doar despre un element pe coloana sau
     *         cea mai mica diferenta dintre elementele coloanei, adica Penalty ul coloanei index
     */
    public int minDiffColumn(int index, int dimension) {
        if(dimension == 1) return 0;
        int minDiff = Math.abs(getCosturi().get(0).get(index) - getCosturi().get(1).get(index));
        for (int i = 0; i < dimension-1; i++)
            for (int j = i + 1; j < dimension; j++) {
                if (Math.abs(getCosturi().get(i).get(index) - getCosturi().get(j).get(index)) < minDiff)
                    minDiff = Math.abs(getCosturi().get(i).get(index) - getCosturi().get(j).get(index));
            }
        return minDiff;
    }

    /**
     *
     * @param difference este un Array de lungime lines+columns
     *                   si va contine Penalty urile liniilor si coloanelor matricei
     * @param lines numarul de linii ale matrice
     * @param columns numarul de coloane ale matricei
     */
    void updateDiff(ArrayList<Integer> difference, int lines, int columns) {
        difference.clear();
        for (int i = 0; i < lines; i++){
            difference.add(i,minDiffRow(i, columns));}
        for (int i = lines; i < lines + columns; i++){
            difference.add(i,minDiffColumn(i - lines, lines));}
    }


    /**
     *
     * @param ii este indexul coloanei, sa stiu la ce coloana ma raportez
     * @param dimension este lungimea coloanei adica numarul de linii din matrice la momentul respectiv
     * @return se va returna primul index a celui mai mic cost din coloana ii
     */
    public int minColumn(int ii, int dimension) {
        int min = getCosturi().get(0).get(ii);
        int index = 0;
        for (int i = 0; i < dimension; i++) {
            if (min > getCosturi().get(i).get(ii)) {
                min = getCosturi().get(i).get(ii);
                index = i;
            }
        }
        return index;
    }

    /**
     *
     * @param maxPenalty este indexul coloanei, sa stiu la ce coloana ma raportez
     * @param dimension este lungimea coloanei adica numarul de linii din matrice la momentul respectiv
     * @return se va returna primul index a celui mai mic cost din coloana maxPenalty
     */
    public int indexOfMminVectorCol(int maxPenalty, int dimension) {
        int min = getCosturi().get(0).get(maxPenalty);
        int index = 0;
        for (int i = 0; i < dimension; i++)
            if (min > getCosturi().get(i).get(maxPenalty)) {
                min = getCosturi().get(i).get(maxPenalty);
                index = i;
            }
        return index;
    }

    /**
     *
     * @param vector este o linie din matricea de costuri
     * @param dimension este lungimea vectorului adica numarul de coloane din matrice la momentul respectiv
     * @return se va returna primul index a celui mai mic cost din linia primita ca parametru, din parametrul vector
     */
    public int indexOfMinVector(ArrayList<Integer> vector, int dimension) {
        int min = vector.get(0);
        int index = 0;
        for (int i = 0; i < dimension; i++)
            if (min > vector.get(i)) {
                min = vector.get(i);
                index = i;
            }
        return index;
    }

    /**
     *
     * @param maxPenalty este linia in care s-a gasit cel mai mare Penalty
     * @param dimension dimensiunea acelei linii
     * @return functia va returna minimul dintre supply ul liniei maxPenalty si demand ului coloanei unde s-a gasit cea mai
     * mica valoare din linia maxPenalty
     */
    public int minSupplyDemandLine(int maxPenalty, int dimension) {
        int index = indexOfMinVector(getCosturi().get(maxPenalty), dimension);
        return Math.min(getSources().get(maxPenalty).getSupply(), getDestinations().get(index).getDemand());
    }

    /**
     *
     * @param maxPenalty este coloana in care s-a gasit cel mai mare Penalty
     * @param dimension dimensiunea acelei coloane
     * @return functia va returna minimul dintre demandul ul coloanei maxPenalty si supply ul liniei
     * unde s-a gasit cea mai mica valoare din coloana maxPenalty
     */
    public int minSupplyDemandCol(int maxPenalty, int dimension) {
        int index = indexOfMminVectorCol(maxPenalty, dimension);
        return Math.min(getSources().get(index).getSupply(), getDestinations().get(maxPenalty).getDemand());
    }

    /**
     *
     * @return functia va intoarce true daca inca exista supply sau demand
     */
    public int existsSupplyDemand(){
        int sum = 0;
        for(int i=0;i<getSources().size();i++)
                sum += getSources().get(i).getSupply();
        for(int i=0;i<getDestinations().size();i++)
            sum += getDestinations().get(i).getDemand();
        return sum;
    }

    /**
     * Functia este inspirata de Vogel'approximation method si consta in urmatoarele:
     * Descriere in comentarii normale la fiecare pas.
     */
    public void vogelMethod() {
        int sumCost = 0;
        int lines = getNr_s();
        int columns = getNr_d();
        int nrElemente = lines*columns;
        ArrayList<Integer> difference= new ArrayList<Integer>();

        // Cat timp am supply sau demand continui
        while(existsSupplyDemand()>0){

            //Daca mai am doar un element, atunci voi aduna la costul total costul respectiv inmultit cu supply ul/demand ul respectiv
        if(nrElemente == 1){
            System.out.println(getSources().get(0).getName() + "->" + getDestinations().get(0).getName() + ": " + getSources().get(0).getSupply() + " units * cost " +  getCosturi().get(0).get(0) + " = " + getSources().get(0).getSupply() * getCosturi().get(0).get(0));
            sumCost += getSources().get(0).getSupply() * getCosturi().get(0).get(0);
            break;
        }
        // vectorul de Penalty este actualizat
        updateDiff(difference, lines, columns);

        // se alege maxPenalty
        int maxPenalty = maxPenaltyPozition(difference, lines + columns);
        int min;
        // variabila min va contine minimul dintre supply sau demand pentru elementul minim din linia/coloana
        // ce il contine pe maxPenalty
        if (maxPenalty < lines) {
            min = minSupplyDemandLine(maxPenalty, columns);
        } else {
            min = minSupplyDemandCol(maxPenalty - lines, lines);
        }

        int minim = min;

        // daca penalty a fost ales din cadrul liniilor
        if(maxPenalty < lines){
            // actualizez supply ul si demand ul scazand din ambele pe minimul dintre ele
            getSources().get(maxPenalty).setSupply(getSources().get(maxPenalty).getSupply()-minim);
            int index = indexOfMinVector(getCosturi().get(maxPenalty),lines);
            getDestinations().get(index).setDemand(getDestinations().get(index).getDemand()-minim);
            // actualizez costul total
            sumCost += minim * getCosturi().get(maxPenalty).get(index);
            System.out.println(getSources().get(maxPenalty).getName() + "->" + getDestinations().get(index).getName() + ": " + minim + " units * cost " +  getCosturi().get(maxPenalty).get(index) + " = " + getCosturi().get(maxPenalty).get(index)*minim);
            // daca am ramas cu doua elemente
            if(nrElemente <= 2){
                //elimin un element din nr total al elementelor
                getCosturi().get(maxPenalty).remove(index);
                nrElemente--;
                // daca sunt pe linii diferite inseamna ca elimin o linie
                if(columns == 1){
                    lines--;
                }
                // daca sunt pe aceasi linie inseamna ca elimin un element si astfel o coloana
                else
                {
                    getDestinations().remove(index);
                    columns--;
                }
                //daca sunt mai mult de doua elemente inseamna ca voi elimina o linie si sursa liniei respective
            }else {
                nrElemente -= getCosturi().get(maxPenalty).size();
                getCosturi().remove(maxPenalty);
                lines--;
                getSources().remove(maxPenalty);
            }

            }
        // daca Penalty a fost ales din cadrul coloanelor
        else{
            // actualizez supply si demand scazand din fiecare minimul dintre ele
            int index = minColumn(maxPenalty-lines,lines);
            getDestinations().get(maxPenalty-lines).setDemand(getDestinations().get(maxPenalty-lines).getDemand()-minim);
            getSources().get(index).setSupply(getSources().get(index).getSupply()-minim);
            // actualizez suma
            sumCost += minim*getCosturi().get(index).get(maxPenalty-lines);
            System.out.println( getSources().get(index).getName() + "->" +  getDestinations().get(maxPenalty-lines).getName() + ": " + minim + " units * cost " +  getCosturi().get(index).get(maxPenalty-lines) + " = " + getCosturi().get(index).get(maxPenalty-lines)*minim);

            // daca am doua sau mai putin de doua elemente ramase
            if(nrElemente <= 2){
                //elimin elementul
                getCosturi().get(index).remove(maxPenalty);
                nrElemente--;
                // daca nu sunt pe coloane diferite atunci elimin o coloana
                if(lines == 1){
                    columns--;
                }
                // daca sunt pe aceasi coloana atunci elimin o linie
                else
                {
                    getSources().remove(index);
                    lines--;
                }
                // daca am mai multe linii+coloane >=3 atunci voi elimina o coloana
            }else {
                columns--;
                getDestinations().remove(maxPenalty-lines);

                // eliminarea coloanei propriu-zis
                for(int i=0;i<lines;i++) {
                    getCosturi().get(i).remove(index+1);
                    nrElemente--;
                }
            }
            }
        }
        // actualizez variabila costTotal
        setCostTotal(sumCost);
    }
}
