package kiwi.model;

public class Genre {

    public Integer id;
    public String name;

    public Genre() {
    }

    public Genre(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
