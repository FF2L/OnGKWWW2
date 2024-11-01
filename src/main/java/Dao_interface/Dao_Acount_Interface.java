package Dao_interface;

import Model.Account;

import java.util.List;

public interface Dao_Acount_Interface {
    List<Account> getAllAccount();

    List<String>getAllIDAccount();

    void addNewAddCount(Account account);

    List<Account> locTheoTieuChi(String truongDuLieu, String tieuChi);

}
