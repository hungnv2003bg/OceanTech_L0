package MangDong;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Nguoi {
    private Integer id;
    private String ten;
    private String ngaySinh;
    private String diaChi;
    private Float chieuCao;
    private Float canNang;

    public Nguoi() {
    }

    public Nguoi(Integer id, String ten, String ngaySinh, String diaChi, Float chieuCao, Float canNang) {
        this.id = id;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.chieuCao = chieuCao;
        this.canNang = canNang;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Float getChieuCao() {
        return chieuCao;
    }

    public void setChieuCao(Float chieuCao) {
        this.chieuCao = chieuCao;
    }

    public Float getCanNang() {
        return canNang;
    }

    public void setCanNang(Float canNang) {
        this.canNang = canNang;
    }

    @Override
    public String toString() {
        return "Nguoi{" +
                "id='" + id + '\'' +
                ", ten='" + ten + '\'' +
                ", ngaySinh='" + ngaySinh + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", chieuCao=" + chieuCao +
                ", canNang=" + canNang +
                '}';
    }

    public void nhap(Scanner sc) {
        Validate kt = new Validate();
        do {
            System.out.println("Ho ten");
            ten = sc.nextLine();
            if (kt.ktTen(ten)) {
                break;
            }
            System.out.println("Ho ten khong hop le! Vui long nhap lai ");
        } while (true);

        do {
            System.out.println("Ngay sinh");
            ngaySinh = sc.nextLine();
            if (kt.kiemTraNgaySinh(ngaySinh)) {
                break;
            }
            System.out.println("Nhap ngay sinh tu nam 1900 (yyyy-mm-dd): ");
        } while (true);

        do {
            System.out.println("Dia chi");
            diaChi = sc.nextLine();
            if (kt.ktDiaChi(diaChi)) {
                break;
            }
            System.out.println("Dia chi khong hop le! Vui long nhap lai ");
        } while (true);

        do {
            try {
                System.out.println("Chieu cao (50 - 300 cm): ");
                chieuCao = sc.nextFloat();
                if (chieuCao >= 50 && chieuCao <= 300) {
                    break;
                } else {
                    System.out.println("Vui long nhap chieu cao tu 50 - 300cm");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Chieu cao phai la so");
                sc.next(); // Clear the invalid input
            }
        } while (true);

        do {
            try {
                System.out.println("Can nang (5 - 1000 kg): ");
                canNang = sc.nextFloat();
                if (canNang >= 5 && canNang <= 1000) {
                    break;
                } else {
                    System.out.println("Vui long nhap can nang tu 5 - 1000kg");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Can nang phai la so");
            }
        } while (true);
    }

    public void xuat() {
        System.out.printf("Id: %s  - Ten: %s - Ngay sinh: %s - Dia chi: %s - Can nang: %f - Chieu cao: %f \n", id, ten, ngaySinh, diaChi, canNang, chieuCao);
    }
}
