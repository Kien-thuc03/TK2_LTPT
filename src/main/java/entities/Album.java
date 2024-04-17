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
@Table(name = "Album")
@NamedQueries({
    @NamedQuery(name = "Album.updatePrice", query = "UPDATE Album a SET a.price = :price WHERE a.id = :id"),
    @NamedQuery(name = "Album.findAll", query = "SELECT a FROM Album a"),
    @NamedQuery(name = "Album.listAlbumByGenreAndYear", query = "SELECT a FROM Album a WHERE a.genre.name = :genreName AND a.yearOfRelease = :year")
})
public class Album implements Serializable {
    private static final long serialVersionUID = 5054814556079295778L;

    @Id
    @Column(name = "album_id")
    private String id;
    private String title;
    private Double price;
    private int yearOfRelease;
    private String downloadLink;

//    moi quan he nhieu nhieu voi Artist
    @ManyToMany
    @JoinTable(
            name = "albums_artists",
            joinColumns = @JoinColumn(name = "album_id"),
            inverseJoinColumns = @JoinColumn(name = "artist_id")
    )
    private Set<Artist> artists;

//    moi quan he nhieu nhieu voi Song
    @ManyToMany
    @JoinTable(
            name = "albums_songs",
            joinColumns = @JoinColumn(name = "album_id"),
            inverseJoinColumns = @JoinColumn(name = "song_id")
    )
    private Set<Song> songs;

//    moi quan he nhieu nhieu mot voi Genre
    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    public Album(String id, String title, Double price, int yearOfRelease, String downloadLink) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.yearOfRelease = yearOfRelease;
        this.downloadLink = downloadLink;
    }
    public Album() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public String getDownloadLink() {
        return downloadLink;
    }

    public void setDownloadLink(String downloadLink) {
        this.downloadLink = downloadLink;
    }
}
