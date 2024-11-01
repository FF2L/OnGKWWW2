package Untils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Db_connect {
    private static EntityManagerFactory emf = null;
    static {
        try {
            emf = Persistence.createEntityManagerFactory("bank");

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static EntityManager  getEntityManager() {
        if (emf != null && emf.isOpen()) {
            return emf.createEntityManager();
        }else {
            throw new IllegalStateException("EntityManagerFactory not open");
        }
    }

    public static void close(){
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
