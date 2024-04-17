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
@Table(name = "Artist")
public class Artist implements Serializable{
    private static final long serialVersionUID = 5054814556079295778L;

    @Id
    @Column(name = "artist_id")
    private String id;
    private String name;
    private String birthDate;
    private String url;

    @ManyToMany(mappedBy = "artists")
    private Set<Album> albums;

    public Artist(String id, String name, String birthDate, String url) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.url = url;
    }

    public Artist() {
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
