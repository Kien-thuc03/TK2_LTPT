package implement;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.rmi.RemoteException;

import static org.junit.jupiter.api.Assertions.*;

class AlbumIpmlTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void updatePriceOfAlbum() throws RemoteException {
        AlbumDao albumDao = new AlbumIpml();
        assertEquals(true, albumDao.updatePriceOfAlbum("1",500));
    }

    @Test
    void listAlbumByGenreAndYear() throws RemoteException {
        AlbumDao albumDao = new AlbumIpml();
        assertEquals(1, albumDao.listAlbumByGenreAndYear("Pop", 2020).size());
    }

    @Test
    void getNumberOfAlbumByGenre() throws RemoteException {
        AlbumDao albumDao = new AlbumIpml();
        assertEquals(3, albumDao.getNumberOfAlbumByGenre().size());
    }
}