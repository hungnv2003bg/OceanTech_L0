package MangDong;



import java.util.InputMismatchException;
import java.util.Scanner;

public class SinhVien extends Nguoi {
    private String maSinhVien;
    private String tenTruong;
    private Integer namBatDau;
    private Float diemTrungBinh;
    private HocLuc hocLuc;




    public SinhVien() {
    }

    public SinhVien(String maSinhVien, String tenTruong, Integer namBatDau, Float diemTrungBinh, HocLuc hocLuc) {
        this.maSinhVien = maSinhVien;
        this.tenTruong = tenTruong;
        this.namBatDau = namBatDau;
        this.diemTrungBinh = diemTrungBinh;
        this.hocLuc = hocLuc;
    }

    public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getTenTruong() {
        return tenTruong;
    }

    public void setTenTruong(String tenTruong) {
        this.tenTruong = tenTruong;
    }

    public Integer getNamBatDau() {
        return namBatDau;
    }

    public void setNamBatDau(Integer namBatDau) {
        this.namBatDau = namBatDau;
    }

    public Float getDiemTrungBinh() {
        return diemTrungBinh;
    }

    public void setDiemTrungBinh(Float diemTrungBinh) {
        this.diemTrungBinh = diemTrungBinh;
        this.hocLuc = HocLuc.xepLoai(this.diemTrungBinh);
    }

    public HocLuc getHocLuc() {
        return hocLuc;
    }
    public void setHocLuc(HocLuc hocLuc) {
        this.hocLuc = hocLuc;
    }

    public SinhVien(Integer id, String ten, String ngaySinh, String diaChi, Float chieuCao, Float canNang, String maSinhVien, String tenTruong, Integer namBatDau, Float diemTrungBinh, HocLuc hocLuc) {
        super(id, ten, ngaySinh, diaChi, chieuCao, canNang);
        this.maSinhVien = maSinhVien;
        this.tenTruong = tenTruong;
        this.namBatDau = namBatDau;
        this.diemTrungBinh = diemTrungBinh;
        this.hocLuc = hocLuc;
    }

    public SinhVien(Integer id, String ten, String ngaySinh, String diaChi, Float chieuCao, Float canNang) {
        super(id, ten, ngaySinh, diaChi, chieuCao, canNang);
    }


    @Override
    public String toString() {
        return "SinhVien{" +
                "maSinhVien='" + maSinhVien + '\'' +
                ", tenTruong='" + tenTruong + '\'' +
                ", namBatDau=" + namBatDau +
                ", diemTrungBinh=" + diemTrungBinh +
                ", hocLuc=" + hocLuc +
                '}';
    }
    @Override
    public void nhap(Scanner sc) {
        super.nhap(sc);

        Validate kt = new Validate();
        do {
            System.out.println("Nhap ma sv dung 10 ki tu ");
            maSinhVien = sc.nextLine();
            if (kt.ktMa(maSinhVien)) {
                break;
            }

        } while (true);
        do {
            System.out.println("Ten truong ");
            tenTruong = sc.nextLine();
            if (kt.ktMa(maSinhVien)) {
                break;
            }
            System.out.println("Nhap ten toi da 200 ky tu ");
        } while (true);
        do {
            System.out.println("Nam bat dau (1900 - 2023): ");
            if (sc.hasNextInt()) {
                namBatDau = sc.nextInt();
                if (namBatDau >= 1900 && namBatDau <= 2023) {
                    break;
                } else {
                    System.out.println("Vui long nhap nam tu 1900 den 2023");
                }
            } else {
                System.out.println("Nam phai la so");
                sc.next();
            }
        } while (true);
        sc.nextLine();
        do {
            System.out.println("Diem trung binh ");
            try {
                diemTrungBinh = sc.nextFloat();
                if (diemTrungBinh >= 0 && diemTrungBinh <= 10) {
                    setDiemTrungBinh(diemTrungBinh);
                    break;
                } else {
                    System.out.println("Vui long nhap diem tu 0 - 10");
                }
            } catch (InputMismatchException e) {
                System.out.println("Vui long nhap so");
                sc.next(); // clear the wrong input from scanner
            }
        } while (true);
    }
    @Override
    public void xuat() {
        System.out.printf(
                "Id: %s - Ten: %s - Ngay sinh: %s - Dia chi: %s - Chieu cao: %f - Can nang: %f - Ma sv: %s - Truong: %s" +
                        " - Nam bat dau: %d - Diem TB: %f - Hoc luc: %s\n",
                getId(), getTen(), getNgaySinh(), getDiaChi(), getChieuCao(), getCanNang(), maSinhVien, tenTruong, namBatDau, diemTrungBinh, hocLuc
        );
    }

    public String toCSVString() {
        return getId() + "," + getTen() + "," + getNgaySinh() + "," + getDiaChi() + "," + getChieuCao() + "," + getCanNang() + "," +
                maSinhVien + "," + tenTruong + "," + namBatDau + "," + diemTrungBinh + "," + hocLuc;
    }

}
