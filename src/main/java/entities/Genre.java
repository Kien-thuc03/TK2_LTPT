package entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

/**
 * @description
 * @author: nktng,
 * @date:16/04/2024,
 */
@Entity
@Table(name = "Genre")
@NamedQueries({
    @NamedQuery(name = "Genre.findAll", query = "SELECT g FROM Genre g"),
    @NamedQuery(name = "Genre.findByName", query = "SELECT g FROM Genre g WHERE g.name = :name")
})
public class Genre implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "genre_id")
    private String id;
    private String name;
    private String description;

    public Genre() {
    }

//    moi quan he 1 nhieu voi Album
    @OneToMany(mappedBy = "genre", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Album> albums;
        public Genre(String id, String name, String description, Set<Album> albums) {
            this.id = id;
            this.name = name;
            this.description = description;
            this.albums = albums;
        }

        public Genre(Set<Album> albums) {
            this.albums = albums;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Set<Album> getAlbums() {
            return albums;
        }

        public void setAlbums(Set<Album> albums) {
            this.albums = albums;
        }

        @Override
        public String toString() {
            return String.format("Genre [id=%s, name=%s, description=%s]", id, name, description);
        }

}
