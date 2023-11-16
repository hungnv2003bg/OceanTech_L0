package MangDong;


public class Validate {

    public boolean ktTen(String sc) {
        String validate = "^[a-zA-Z\\s]{1,100}$";
        return sc.matches(validate);
    }

    public boolean ktDiaChi(String sc) {
        String validate = "^[a-zA-Z0-9]{1,300}$";
        return sc.matches(validate);
    }

    public boolean kiemTraNgaySinh(String sc) {
        String validate = "^(19\\d{2}|20[0-2]\\d)-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$";
        return sc.matches(validate);
    }

    public boolean ktMa(String sc) {
        String validate = "^[a-zA-Z0-9]{10}$";
        return sc.matches(validate);
    }

    public boolean ktNam(String sc) {
        String validate = "^(19\\d{2}|20[0-9][0-9])$";
        return sc.matches(validate);
    }


}

