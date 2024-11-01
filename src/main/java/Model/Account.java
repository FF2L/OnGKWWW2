package Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Entity
@Table (name = "bank_account")
public class Account {

    @Id
    @Column(length = 10)
    private String account_ID;
    @Column(length = 155) //Cột trong cơ sở dữ liệu là 155
    @Size(max = 155) //Khi gán giá trị vuọt qua 155 thì tự động nhảy lỗi-> chưa lưu vào cơ sở dữl iệu
    private String account_name;
    private int card_Number;
    private String account_address;
    private float amount;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(account_ID, account.account_ID);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(account_ID);
    }

    public Account() {
    }

    public Account(String account_number, String acount_name, int card_Number, String account_address, float amount) {
        this.account_ID = account_number;
        this.account_name = acount_name;
        this.card_Number = card_Number;
        this.account_address = account_address;
        this.amount = amount;
    }

    public String getAccount_ID() {
        return account_ID;
    }

    public void setAccount_ID(String account_number) {
        this.account_ID = account_number;
    }

    public int getCard_Number() {
        return card_Number;
    }

    public void setCard_Number(int card_Number) {
        this.card_Number = card_Number;
    }

    public @Size(max = 155) String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(@Size(max = 155) String acount_name) {
        this.account_name = acount_name;
    }

    public String getAccount_address() {
        return account_address;
    }

    public void setAccount_address(String account_address) {
        this.account_address = account_address;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
