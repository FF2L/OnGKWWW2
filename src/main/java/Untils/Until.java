package Untils;

import Dao_imp.Dao_Account_imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Until {
    public static String taoMaID() {
        Dao_Account_imp dao = new Dao_Account_imp();
        List<String> listID = dao.getAllIDAccount();
        List<Integer> maSoPhatSinh = new ArrayList<Integer>();
        Boolean ThucHienToiKhiDung = Boolean.TRUE;

        do {
            Random random = new Random();
            for (int i = 0; i < 10; i++) {
                int soNgauNhien = random.nextInt(10);
                maSoPhatSinh.add(soNgauNhien);
            }

            int tongSoLe = 0;
            int tongSoChang = 0;
            for (int i = 0; i < maSoPhatSinh.size(); i++) {
                int soXNaoDo = maSoPhatSinh.get(i);
                if (soXNaoDo == 1 && soXNaoDo % 2 != 0) {
                    int ketquaSauKhiNhan = soXNaoDo * 2;
                    if (ketquaSauKhiNhan > 9) {
                        int hangChuc = ketquaSauKhiNhan / 10;
                        int hangDonVi = ketquaSauKhiNhan % 10;
                        tongSoLe = tongSoLe + hangChuc + hangDonVi;
                    } else {
                        tongSoLe = tongSoLe + ketquaSauKhiNhan;
                    }
                } else if (soXNaoDo % 2 == 0) {
                    tongSoChang = tongSoChang + soXNaoDo;
                }
            }
            int Tong = tongSoLe + tongSoChang;
            if (Tong % 10 == 0) {
                ThucHienToiKhiDung = Boolean.FALSE;
            }
        } while (ThucHienToiKhiDung);
        StringBuilder sb = new StringBuilder();
        for (Integer s : maSoPhatSinh) {
            sb.append(s);
        }
        return sb.toString();
    }

}
