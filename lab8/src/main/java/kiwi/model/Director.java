package kiwi.model;

public class Director {

    private String nume;
    private Integer id_movie;

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

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setId_movie(Integer id_movie) {
        this.id_movie = id_movie;
    }

    public String getNume() {
        return nume;
    }

    public Integer getId_movie() {
        return id_movie;
    }
}
