package com.company;

import java.time.Duration;
import java.time.LocalTime;

public interface Visitable {
    LocalTime getOpeningTime();

    LocalTime getClosingTime();

    default LocalTime openTime(){
        return LocalTime.parse("09:30");
    }
    default LocalTime closeTime(){
        return LocalTime.parse("20:00");
    }

     static Duration getVisitingDuration(LocalTime a, LocalTime b){
        return Duration.between(a,b);
    }
}
