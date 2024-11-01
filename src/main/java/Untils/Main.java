package Untils;

import jakarta.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {
        EntityManager em = Db_connect.getEntityManager();
        em.getTransaction().begin();
    }
}
