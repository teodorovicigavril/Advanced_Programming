package kiwi.model;

import java.util.Date;

public class Movie {

    private Integer id;
    private String title;
    private Date release_date;
    private Double duration;
    private Double score;

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

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Date getRelease_date() {
        return release_date;
    }

    public Double getDuration() {
        return duration;
    }

    public Double getScore() {
        return score;
    }
}



