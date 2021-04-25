package jdbc.model;

public class Actor {

    private String nume;
    private Integer id_movie;
    private String personaj;

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

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setId_movie(Integer id_movie) {
        this.id_movie = id_movie;
    }

    public void setPersonaj(String personaj) {
        this.personaj = personaj;
    }

    public String getNume() {
        return nume;
    }

    public Integer getId_movie() {
        return id_movie;
    }

    public String getPersonaj() {
        return personaj;
    }
}
