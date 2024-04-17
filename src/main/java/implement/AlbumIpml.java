package implement;

import entities.Album;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @description
 * @author: nktng,
 * @date:16/04/2024,
 */
public class AlbumIpml extends UnicastRemoteObject implements AlbumDao{
    private static final long serialVersionUID = 1L;
    private EntityManager em;

    public AlbumIpml()  throws RemoteException{
        em = Persistence.createEntityManagerFactory("SQLDB").createEntityManager();
    }
    @Override
    public boolean updatePriceOfAlbum(String id, double newPrice) throws RemoteException {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Album album = em.find(Album.class, id);
        album.setPrice(newPrice);
        boolean status = em.merge(album) != null;
        tx.commit();
        return status;
    }

    @Override
    public List<Album> listAlbumByGenreAndYear(String genre, int year) throws RemoteException {
        return em.createNamedQuery("Album.listAlbumByGenreAndYear", Album.class)
                .setParameter("genreName", genre)
                .setParameter("year", year)
                .getResultList();
    }

    @Override
    public Map<String, Long> getNumberOfAlbumByGenre() throws RemoteException {
        List<Object[]> results = em.createQuery(
                "SELECT a.genre.name, COUNT(a) " +
                        "FROM Album a " +
                        "GROUP BY a.genre.name " +
                        "ORDER BY a.genre.name",
                Object[].class)
                .getResultList();
        Map<String, Long> map = new HashMap<>();
        for (Object[] result : results) {
            map.put((String) result[0], (Long) result[1]);
        }
        return map;
    }



}
