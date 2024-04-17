package server;

import implement.AlbumDao;
import implement.AlbumIpml;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.rmi.registry.LocateRegistry;

/**
 * @description
 * @author: nktng,
 * @date:16/04/2024,
 */
public class Server {
    private static final String URL = "rmi://FIL:8611/";

    public static void main(String[] args) {
        try {
            Context context = new InitialContext();

            AlbumDao albumDao = new AlbumIpml();

            LocateRegistry.createRegistry(8611);

            context.bind(URL + "albumDao", albumDao);

            System.out.println("Server is running...");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
