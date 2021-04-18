package kiwi.model;

import java.util.Date;

public class Movie {

    public Integer id;
    public String title;
    public Date release_date;
    public Double duration;
    public Double score;

    public Movie() {
    }

    public Movie(Integer id, String title, Date release_date, Double duration, Double score) {
        this.id = id;
        this.title = title;
        this.release_date = release_date;
        this.duration = duration;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", release_date=" + release_date +
                ", duration=" + duration +
                ", score=" + score +
                '}';
    }
}



