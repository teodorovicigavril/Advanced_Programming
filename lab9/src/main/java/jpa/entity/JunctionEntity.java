package jpa.entity;

import javax.persistence.*;

@Entity
@Table(name = "JUNCTION", schema = "STUDENT")
public class JunctionEntity {
    private long idMovies;
    private long idGenres;
    private Long id;

    @Basic
    @Column(name = "ID_MOVIES")
    public long getIdMovies() {
        return idMovies;
    }

    public void setIdMovies(long idMovies) {
        this.idMovies = idMovies;
    }

    @Basic
    @Column(name = "ID_GENRES")
    public long getIdGenres() {
        return idGenres;
    }

    public void setIdGenres(long idGenres) {
        this.idGenres = idGenres;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JunctionEntity that = (JunctionEntity) o;

        if (idMovies != that.idMovies) return false;
        if (idGenres != that.idGenres) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idMovies ^ (idMovies >>> 32));
        result = 31 * result + (int) (idGenres ^ (idGenres >>> 32));
        return result;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
