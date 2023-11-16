package MangDong;

public enum HocLuc {
    KEM, YEU, TRUNG_BINH, KHA, GIOI, XUAT_SAC;

    public static HocLuc xepLoai(float diemTrungBinh) {
        if (diemTrungBinh < 3) return KEM;
        else if (diemTrungBinh < 5) return YEU;
        else if (diemTrungBinh < 6.5) return TRUNG_BINH;
        else if (diemTrungBinh < 7.5) return KHA;
        else if (diemTrungBinh < 9) return GIOI;
        else return XUAT_SAC;
    }
}