package jpa.entity;

import javax.persistence.*;
import java.util.Objects;

@NamedQueries(
        {
                @NamedQuery(name="genres.findByName", query = "SELECT g FROM GenresEntity g WHERE g.name = :inputname")
        }
)

@Entity
@Table(name = "GENRES", schema = "STUDENT")
public class GenresEntity {
    private Long id;
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

        GenresEntity that = (GenresEntity) o;

        if (id != that.id) return false;
        if (!Objects.equals(name, that.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "GenresEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
