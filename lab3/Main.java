package com.company;

import java.util.ArrayList;
import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {

        Hotel v1 = new Hotel(23,3,17);
        Museum v2 = new Museum(LocalTime.parse("08:00"),LocalTime.parse("17:00"),24.99,2000,"archaeology");
        Museum v3 = new Museum();
        v3.setOpeningTime(LocalTime.of(9, 30));
        v3.setClosingTime(LocalTime.of(15, 30));
        v3.setTicketPrice(49.99);
        v3.setNumarExponate(550);
        v3.setDomeniu("archaeology");

        Church v4 = new Church(431,"Matei 5:4", LocalTime.of(9, 30), LocalTime.of(12, 00));
        Church v5 = new Church();
        v5.setNumarMembrii(240);
        v5.setVerset("Luca 6:17");
        v5.setOpeningTime(LocalTime.of(9, 30));
        v5.setClosingTime(LocalTime.of(12, 00));

        Restaurant v6 = new Restaurant(50,"ciorba raudateana, ficat de pui cu piure de cartofi, amandina",2);

        ArrayList<Location> locatii= new ArrayList<Location>();
        locatii.add(v1);
        locatii.add(v2);
        locatii.add(v3);
        locatii.add(v4);
        locatii.add(v5);
        locatii.add(v6);

        /*
        Museum m = new Museum();
        m.setOpeningTime(LocalTime.of(9, 30)); //9:30
        m.setClosingTime(LocalTime.parse("17:00"));
        m.setTicketPrice(20);
        Church c = new Church();
        c.setOpeningTime(LocalTime.of(7, 0));
        c.setClosingTime(LocalTime.MIDNIGHT);
        Visitable[] arr = {m, c};
         */

    }
}
