package kiwi.model;

public class Actor {

    public String nume;
    public Integer id_movie;
    public String personaj;

    public Actor() {
    }

    public Actor(String nume, Integer id_movie, String personaj) {
        this.nume = nume;
        this.id_movie = id_movie;
        this.personaj = personaj;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "nume='" + nume + '\'' +
                ", id_movie=" + id_movie +
                ", personaj='" + personaj + '\'' +
                '}';
    }
}
