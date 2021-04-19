package com.example.demo;

import javax.persistence.*;

@Entity
@Table(name = "directors", schema = "test", catalog = "")
public class DirectorsEntity {
    private Long id;
    private String nume;
    private int idMovie;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nume")
    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    @Basic
    @Column(name = "id_movie")
    public int getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(int idMovie) {
        this.idMovie = idMovie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DirectorsEntity that = (DirectorsEntity) o;

        if (idMovie != that.idMovie) return false;
        if (nume != null ? !nume.equals(that.nume) : that.nume != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nume != null ? nume.hashCode() : 0;
        result = 31 * result + idMovie;
        return result;
    }
}
