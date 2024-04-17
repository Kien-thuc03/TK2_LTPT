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
@Table(name = "Song")
public class Song implements Serializable{
    @Id
    @Column(name = "song_id")
    private String id;
    private String name;
    private String runtime;
    private String lyric;
    private String fileLink;

//    moi quan he nhieu nhieu voi Album
    @ManyToMany(mappedBy = "songs")
    private Set<Album> albums;

    public Song(String id, String name, String runtime, String lyric, String fileLink) {
        this.id = id;
        this.name = name;
        this.runtime = runtime;
        this.lyric = lyric;
        this.fileLink = fileLink;
    }

    public Song() {
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

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getLyric() {
        return lyric;
    }

    public void setLyric(String lyric) {
        this.lyric = lyric;
    }

    public String getFileLink() {
        return fileLink;
    }

    public void setFileLink(String fileLink) {
        this.fileLink = fileLink;
    }
}
