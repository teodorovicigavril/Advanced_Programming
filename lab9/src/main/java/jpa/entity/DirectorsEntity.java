package jpa.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "DIRECTORS", schema = "STUDENT")
public class DirectorsEntity {
    private Long id;
    private long idMovie;
    private String name;

    @Id
    @Basic
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ID_MOVIE")
    public long getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(long idMovie) {
        this.idMovie = idMovie;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DirectorsEntity that = (DirectorsEntity) o;

        if (id != that.id) return false;
        if (idMovie != that.idMovie) return false;
        if (!Objects.equals(name, that.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (idMovie ^ (idMovie >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
