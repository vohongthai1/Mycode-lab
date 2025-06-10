
package Thai;


public class KiemChungVien extends NhanVien{
    private int soLoiPhatHien;

    @Override
    public double getLuong() {
        return getLuongCoBan()+soLoiPhatHien*50000;
    }

    public KiemChungVien() {
    }

    public KiemChungVien(int soLoiPhatHien, String maNhanVien, String hoTen, String soDienThoai, String mail, Date ngaySinh, boolean gioiTinh, double luongCoBan) {
        super(maNhanVien, hoTen, soDienThoai, mail, ngaySinh, gioiTinh, luongCoBan);
        this.soLoiPhatHien = soLoiPhatHien;
    }

    public int getSoLoiPhatHien() {
        return soLoiPhatHien;
    }

    public void setSoLoiPhatHien(int soLoiPhatHien) {
        this.soLoiPhatHien = soLoiPhatHien;
    }

    @Override
    public String toString() {
        return "KiemChungVien -- "+super.toString() + ", soLoiPhatHien=" + soLoiPhatHien +", Luong: "+getLuong();    
    }
    
}
