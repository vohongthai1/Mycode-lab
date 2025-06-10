    
package Thai;


public class LapTrinhVien extends NhanVien{
    private int soGioTangCa;

    @Override
    public double getLuong() {
        return getLuongCoBan()+soGioTangCa*200000;
    }

    public LapTrinhVien() {
    }

    public LapTrinhVien(int soGioTangCa, String maNhanVien, String hoTen, String soDienThoai, String mail, Date ngaySinh, boolean gioiTinh, double luongCoBan) {
        super(maNhanVien, hoTen, soDienThoai, mail, ngaySinh, gioiTinh, luongCoBan);
        this.soGioTangCa = soGioTangCa;
    }

    public int getSoGioTangCa() {
        return soGioTangCa;
    }

    public void setSoGioTangCa(int soGioTangCa) {
        this.soGioTangCa = soGioTangCa;
    }

    @Override
    public String toString() {
        return "LapTrinhVien -- "+super.toString() + ", soGioTangCa=" + soGioTangCa +", Luong: " +getLuong();
    }
    
}
