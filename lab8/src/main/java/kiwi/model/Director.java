package kiwi.model;

public class Director {

    public String nume;
    public Integer id_movie;

    public Director() {
    }

    public Director(String nume, Integer id_movie) {
        this.nume = nume;
        this.id_movie = id_movie;
    }

    @Override
    public String toString() {
        return "Director{" +
                "nume='" + nume + '\'' +
                ", id_movie=" + id_movie +
                '}';
    }
}
