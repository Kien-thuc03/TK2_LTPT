package app;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.rmi.RemoteException;

/**
 * @description
 * @author: nktng,
 * @date:16/04/2024,
 */
public class Main {
    public static void main(String[] args) throws RemoteException{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SQLDB");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        tx.commit();
    }
}
