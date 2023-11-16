package MangDong;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DanhSachSinhVien dssv = new DanhSachSinhVien();
        Scanner sc = new Scanner(System.in);


        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            dssv.luuRaFile("sinh_vien.csv");
            System.out.println("Danh sach sinh vien da duoc luu ra file");
        }));
        try {
            while (true) {
                System.out.println("|        1. Nhap danh sach nhan vien tu ban phim             |");
                System.out.println("|        2. Xuat danh sach nhan vien tu ban phim             |");
                System.out.println("|        3. Xoa sinh vien theo id                            |");
                System.out.println("|        4. Tim kiem sinh vien theo id                       |");
                System.out.println("|        5. Cap nhat sinh vien theo id                       |");
                System.out.println("|        6. Xuat phan tram hoc luc cua sinh vien             |");
                System.out.println("Moi ban chon chuc nang: ");
                System.out.println("Bam 0 de dong chuong trinh ");
                int chon = sc.nextInt();
                sc.nextLine();
                if (chon == 0) {
                    System.exit(0);
                }
                switch (chon) {
                    case 1:
                        System.out.println("1. Nhap danh sach sinh vien tu ban phim  ");
                        dssv.nhap(sc);
                        break;
                    case 2:
                        System.out.println("2.Xuat danh sach nhan vien tu ban phim  ");
                        dssv.xuat();
                        break;
                    case 3:
                        System.out.println("3.Xoa sinh vien theo id  ");
                        dssv.xoaNhanVienTheoId(sc);
                        break;
                    case 4:
                        System.out.println("4.Tim sinh vien theo id  ");
                        dssv.timVaHienThiTheoId(sc);
                        break;
                    case 5:
                        System.out.println("5.Cap nhat sinh vien theo id  ");
                        dssv.capNhatTheoId(sc);
                        break;
                    case 6:
                        System.out.println("6. Xuat phan tram hoc luc cua sinh vien");
                        dssv.sapXepTheoHocLuc();
                        dssv.xuatPhanTramHocLuc();
                        break;
                }
                System.out.println("Nhan Enter de tiep tuc");

            }
        } catch (Exception ex) {
            System.out.print("Hay chon chuc nang\n");
        }finally {
            sc.close();
        }


    }
}
