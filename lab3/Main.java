package com.company;

import java.util.ArrayList;
import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {

        Hotel v1 = new Hotel(23, 3, 17);
        v1.setName("Hotel");
        Museum v2 = new Museum(LocalTime.parse("08:00"), LocalTime.parse("17:00"), 24.99, 2000, "archaeology");
        v2.setName("Museum A");
        Museum v3 = new Museum();
        v3.setName("Museum B");
        //v3.setOpeningTime(LocalTime.of(10, 30));
        //v3.setClosingTime(LocalTime.of(15, 30));
        //v3.setClosingTime();
        v3.setTicketPrice(49.99);
        v3.setNumarExponate(550);
        v3.setDomeniu("archaeology");

        Church v4 = new Church(431, "Matei 5:4", LocalTime.of(11, 30), LocalTime.of(12, 00));
        v4.setName("Church A");

        Church v5 = new Church();
        v5.setName("Church B");
        v5.setNumarMembrii(240);
        v5.setVerset("Luca 6:17");
        //v5.setOpeningTime(LocalTime.of(9, 30));
        //v5.setClosingTime(LocalTime.of(12, 00));

        Church v5_1 = new Church();
        v5_1.setName("Church 5_1");
        v5_1.setNumarMembrii(1000);
        v5_1.setVerset("Geneza 1:1");
        v5_1.setClosingTime(LocalTime.of(17, 00));

        Restaurant v6 = new Restaurant(50, "ciorba raudateana, ficat de pui cu piure de cartofi, amandina", 2);
        v6.setName("Restaurant");

        v1.setCost(v2, 10);
        v1.setCost(v3, 50);
        v2.setCost(v3, 20);
        v2.setCost(v4, 20);
        v2.setCost(v5, 10);
        v3.setCost(v4, 20);
        v3.setCost(v2, 20);
        v4.setCost(v5, 30);
        v4.setCost(v6, 10);
        v5.setCost(v6, 30);
        v5.setCost(v6, 20);

        System.out.println(v1.getCost().get(v2));

        ArrayList<Location> locatii = new ArrayList<Location>();
        locatii.add(v1);
        locatii.add(v2);
        locatii.add(v3);
        locatii.add(v4);
        locatii.add(v5);
        //locatii.add(v5_1);
        locatii.add(v6);

        City oras = new City(locatii);

        System.out.println(locatii);
        oras.displayVisitableNotPayableLocations();

        System.out.println(Visitable.getVisitingDuration(v2.getOpeningTime(), v2.getClosingTime()));

        TravelPlan planOne = new TravelPlan(oras);
        System.out.println(planOne);


        int[] path = new int[planOne.getCity().getNodes().size()];
        int[] dist = planOne.dijkstraDist(v1, path);
        final int infi = 1000000000;
        int s = 0;
        int finish = 3;

        for (int i = 0; i < dist.length; i++) {
            if (dist[i] == infi) {
                System.out.printf("%d and %d are not " + "connected\n", i, s);
                continue;
            }
            System.out.printf("Cel mai scurt drum de la %s la %s este: %d\n", planOne.getCity().getNodes().get(s).getName(), planOne.getCity().getNodes().get(i).getName(), dist[i]);
        }
        System.out.print("Cel mai scurt drum de la " + planOne.getCity().getNodes().get(s).getName() + " la " + planOne.getCity().getNodes().get(finish).getName() + " trece prin: ");
        printPath(path, finish, s, planOne);
    }

    public static int positionInCity(Location s, City city) {
        for (int i = 0; i < city.getNodes().size(); i++)
            if (city.getNodes().get(i) == s)
                return i;
        return -1;
    }


    public static void printPath(int[] path, int i, int s, TravelPlan planOne) {
        if (i != s) {
            if (path[i] == -1) {
                System.out.println("Path not found!!");
                return;
            }
            printPath(path, path[i], s, planOne);
            System.out.print(planOne.getCity().getNodes().get(i).getName() + ", ");
        }
    }
}
