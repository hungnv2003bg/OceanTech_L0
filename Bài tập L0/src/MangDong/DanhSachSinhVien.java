package MangDong;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class DanhSachSinhVien {
    private ArrayList<SinhVien> list = new ArrayList<>();
    private static int IdIdentity = 0;

    public void nhap(Scanner sc) {
        //Id tự tăng khi nhập thông tin
        IdIdentity++;
        SinhVien sinhVien = new SinhVien();
        sinhVien.setId(IdIdentity);
        sinhVien.nhap(sc);
        list.add(sinhVien);
    }

    public void xuat() {
        if (list.isEmpty()) {
            System.out.println("Khong co sinh vien trong danh sach");
        } else {
            for (SinhVien sinhVien : list) {
                sinhVien.xuat();
            }
        }
    }

    public void xoaNhanVienTheoId(Scanner sc) {
        System.out.print("Nhap id sinh vien can xoa: ");
        int id = sc.nextInt();
        sc.nextLine();

        SinhVien tim = null;
        for (SinhVien sv : list) {
            if (sv.getId() == id) {
                tim = sv;
                break;
            }
        }
        if (tim != null) {
            list.remove(tim);
            System.out.println("Da xoa nhan vien");
        } else {
            System.out.printf("Khong tim thay nhan vien co id %d\n", id);
        }
    }


    public void timVaHienThiTheoId(Scanner sc) {
        System.out.println("Nhap id can tim: ");
        int id = sc.nextInt();
        sc.nextLine();

        SinhVien tim = null;
        for (SinhVien sv : list) {
            if (sv.getId() == id) {
                tim = sv;
                break;
            }
        }
        if (tim != null) {
            System.out.println("Thong tin nhan vien tim thay theo id: ");
            tim.xuat();
        } else {
            System.out.printf("Khong tim thay nhan vien co id %d\n", id);
        }
    }


    public void capNhatTheoId(Scanner sc) {
        System.out.print("Nhap id nhan vien can cap nhat thong tin: ");
        int id = sc.nextInt();
        sc.nextLine();

        SinhVien tim = null;
        for (SinhVien sv : list) {
            if (sv.getId() == id) {
                tim = sv;
                break;
            }
        }
        if (tim != null) {
            System.out.println("Nhap thong tin moi cho nhan vien can cap nhat: ");
            tim.nhap(sc);
        } else {
            System.out.printf("Khong tim thay nhan vien co id %d\n", id);
        }
    }


    public void xuatPhanTramHocLuc() {
        int tongSoSinhVien = list.size();
        if (tongSoSinhVien == 0) {
            System.out.println("Khong co sinh vien trong danh sach");
            return;
        }

        int[] demHocLuc = new int[HocLuc.values().length];
        for (SinhVien sv : list) {
            demHocLuc[sv.getHocLuc().ordinal()]++;
        }

        for (HocLuc hl : HocLuc.values()) {
            float phanTram = 100.0f * demHocLuc[hl.ordinal()] / tongSoSinhVien;
            System.out.printf("%s: %.2f%%\n", hl, phanTram);
        }
    }


    public void sapXepTheoHocLuc() {
        Collections.sort(list, (sv1, sv2) -> sv2.getHocLuc().compareTo(sv1.getHocLuc()));
    }

    public void luuRaFile(String tenFile) {
        try (FileWriter fw = new FileWriter(tenFile)) {
            for (SinhVien sv : list) {
                fw.write(sv.toCSVString() + System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("Khong the luu sinh vien: " + e.getMessage());
        }
    }
}
