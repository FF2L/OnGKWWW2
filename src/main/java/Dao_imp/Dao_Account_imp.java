package Dao_imp;

import Dao_interface.Dao_Acount_Interface;
import Model.Account;
import Untils.Db_connect;
import jakarta.persistence.EntityManager;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.awt.*;
import java.util.List;


//@Path("api/Account")
//@Produces(MediaType.APPLICATION_JSON)
////Xác định kiểu dữ liệu mà phương thức hoặc lớp này trả về. Trong trường hợp này là application/json
//@Consumes(MediaType.APPLICATION_JSON)
////Xác định kiểu dữ liệu mà phương thức hoặc lớp này chấp nhận. Trong trường hợp này là application/json
////@GET @PUT @POST @DELETE xác định phương thức get lấy, put update, post creat, delete delete
////Này chưa làm được mà nói chung là viết xong mấy cái truy vấn rồi}
public class Dao_Account_imp implements Dao_Acount_Interface {


    @Override
    public List<Account> getAllAccount() {
        EntityManager em = Db_connect.getEntityManager();
        String sql = "select a from Account a";
        List<Account> accounts = null;
        try {
            accounts = em.createQuery(sql, Account.class).getResultList();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
        return accounts;
    }

    @Override
    public List<String> getAllIDAccount() {
        EntityManager em = Db_connect.getEntityManager();
        String sql = "select a.account_ID from Account a";
        List<String> accounts = null;
        try {
            accounts = em.createQuery(sql,String.class).getResultList();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
        return accounts;
    }

    @Override
    public void addNewAddCount(Account account) {
        EntityManager em = Db_connect.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(account);
            em.getTransaction().commit();
        }catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }
    }

    @Override
    public List<Account> locTheoTieuChi(String truongDuLieu, String tieuChi) {
        EntityManager em = Db_connect.getEntityManager();
        String jpql = "SELECT a from Account a WHERE a."+truongDuLieu+" LIKE :Pattern";
        List<Account> accounts = null;
        try {
            accounts = em.createQuery(jpql,Account.class)
                    .setParameter("Pattern","%" + tieuChi + "%")
                    .getResultList();
        }catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }
        return List.of();
    }


}
