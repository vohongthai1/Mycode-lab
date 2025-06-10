
package Thai;

import java.io.File;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class QLNhanVien {
    private ArrayList<NhanVien> a = new ArrayList<>();

    public QLNhanVien() {
    }

    public ArrayList<NhanVien> getA() {
        return a;
    }

    public void setA(ArrayList<NhanVien> a) {
        this.a = a;
    }
    
    public void docFile(String tenFile) {
        try {
            File f = new File(tenFile);
            if (f.exists()) {
                System.out.println("OK");
                Scanner read = new Scanner(f);
               while(read.hasNext()){
                   String s[] = read.nextLine().split(", ");
                   String ma = s[0];
                   String ten = s[1];
                   String sdt = s[2];
                   String mail = s[3];
                   Date nt = new Date(s[4]);
                   boolean gt = Boolean.parseBoolean(s[5]);
                   double lcb = Double.parseDouble(s[6]);
                   if (ma.charAt(0) == 'L') {
                       int tanggio = Integer.parseInt(s[7]);
                        a.add(new LapTrinhVien(tanggio, ma, ten, sdt, mail, nt, gt, lcb));
                    } else {
                       int chitieu = Integer.parseInt(s[7]);
                       a.add(new KiemChungVien(chitieu, ma, ten, sdt, mail, nt, gt, lcb));
                    }
                   
               }
            } else {
                System.out.println("File ko co");
            }
        } catch (Exception e) {
        }
    }
//    public void ghiFile(String tenFile){
//        try(PrintWriter pw = new PrintWriter(tenFile)) {
//            for(NhanVien x : a){
//                
//                pw.print(x.getMaNhanVien()+", ");
//                pw.print(x.getHoTen()+", ");
//                pw.print(x.getSoDienThoai()+", ");
//                pw.print(x.getMail()+", ");
//                pw.print(x.getNgaySinh()+", ");
//                pw.print(x.isGioiTinh()+", ");
//                pw.print(x.getLuongCoBan()+", ");
//                if(x instanceof LapTrinhVien){
//                    pw.println(((LapTrinhVien) x).getSoGioTangCa());
//                }else if(x instanceof KiemChungVien){
//                    pw.println(((KiemChungVien) x).getSoLoiPhatHien());
//                }
//                
//            }
//        } catch (Exception e) {
//            e.printStackTrace(); 
//        }   
//    }
    public void ghiFile(String tenFile){
        try {
            File f = new File(tenFile);
            if(!f.exists()){
                PrintStream out = new PrintStream(f);
                for(NhanVien x: a){
                    if(x instanceof LapTrinhVien){
                        out.println(x.getMaNhanVien()+", "+x.getHoTen()+", "+x.getSoDienThoai()+", "+x.getMail()+", "+x.getNgaySinh()+", "+x.isGioiTinh()+", "
                        +x.getLuongCoBan()+", "+((LapTrinhVien) x).getSoGioTangCa());
                    }
                    if(x instanceof KiemChungVien){
                        out.println(x.getMaNhanVien()+", "+x.getHoTen()+", "+x.getSoDienThoai()+", "+x.getMail()+", "+x.getNgaySinh()+", "+x.isGioiTinh()+", "
                        +x.getLuongCoBan()+", "+((KiemChungVien) x).getSoLoiPhatHien());
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    public void xuat(ArrayList a, String nd) {
        System.out.println(nd);
        for (Object x : a) {
            System.out.println(x);
        }
        System.out.println("");
    }
    //Thêm
    public boolean them(NhanVien y){
        for(NhanVien x: a)
            if(x.getMaNhanVien().equalsIgnoreCase(y.getMaNhanVien()))
                return false;
        a.add(y);
        return true;
    }
    //Xóa
    public boolean xoaNhanVienTheoMa(String ma){
        for(NhanVien x : a){
            if(x.getMaNhanVien().equalsIgnoreCase(ma)){
                a.remove(x);
                return true;
            }
        }
        return false;
    }
    //Tách Nhân viên:
    public ArrayList tachNhanVien(String tenHinh) {
        ArrayList b = new ArrayList();
        for (NhanVien x : a) {
            if (x.getClass().getSimpleName().equals(tenHinh)) {
                b.add(x);
            }
        }
        return b;
    }
    //Thống kê số lượng
    public int thongKe(String tenLop){
        int d=0;
        for(NhanVien x: a){
            if(x.getClass().getSimpleName().equalsIgnoreCase(tenLop)){
                d=d+1;
            }
        }
        return d;
    }
    public double tongLuong(){
        double  tong = 0;
        for(NhanVien x:a){
            tong = (tong+x.getLuong());
        }
        return tong;
    }
    //tìm Lương cao nhất theo từng ngành:
    public ArrayList<NhanVien> maxLuongTheoTungLoai(String tenHinh) {
        ArrayList<NhanVien> b = tachNhanVien(tenHinh);
        NhanVien maxLuong = b.get(0);
        for (NhanVien x : b) {
            if(x.getLuong()>maxLuong.getLuong()){
                maxLuong=x;
            }
        }            
        ArrayList<NhanVien> c = new ArrayList<>();
        c.add(maxLuong);
        return c;
    }
    //Tìm luong NV cao nhất
    public ArrayList<NhanVien> LuongNVCaoNhat(){
        NhanVien luongLN = a.get(0);
        for(NhanVien x:a){
            if(x.getLuong() > luongLN.getLuong()){
                luongLN=x;
            }            
        }
        ArrayList<NhanVien> c = new ArrayList<>();
        c.add(luongLN);
        return c;
        
    }
    ///tìm kiếm
    public ArrayList<NhanVien> timNVTheoMa(String ma){
        NhanVien timMa = a.get(0);
        for(NhanVien x:a){
            if(x.getMaNhanVien().equalsIgnoreCase(ma)){
               timMa=x;
            }            
        }
        ArrayList<NhanVien> c = new ArrayList<>();
        c.add(timMa);
        return c;
        
    }
    //sắp xếp giảm
    public void sapXepGiamLuong(){
        for(int i=0; i<a.size()-1; i++){
            for(int j=i+1; j<a.size(); j++){
                if(a.get(i).getLuong()<a.get(j).getLuong()){
                    NhanVien x= a.get(i);
                    a.set(i, a.get(j));
                    a.set(j, x);
                }
            }
        }
    }
    //sắp xếp tăng
    public void sapXepTangLuong(){
        for(int i=0; i<a.size()-1; i++){
            for(int j=i+1; j<a.size(); j++){
                if(a.get(i).getLuong()>a.get(j).getLuong()){
                    NhanVien x= a.get(i);
                    a.set(i, a.get(j));
                    a.set(j, x);
                }
            }
        }
    }

    public void output(){
        Scanner kb= new Scanner(System.in);
        //docFile
        xuat(a,"Danh Sach Nhan Vien: ");
        xuat(tachNhanVien("LapTrinhVien"),"Nhan vien Lap Trinh");
        xuat(tachNhanVien("KiemChungVien"),"Nhan vien Kiem Chung");
        //them
        System.out.println("Nhap thong tin nhan vien:");
        System.out.print("Ma NV: "); String maNV = kb.nextLine();
        System.out.print("Ten NV: "); String tenNV = kb.nextLine();
        System.out.print("SDT NV: "); String sdtNV = kb.nextLine();
        System.out.print("Mail NV: "); String mailNV = kb.nextLine();
        System.out.print("Ngay sinh NV: "); Date ngaySinh = new Date(kb.nextLine());
        System.out.print("Chon gioi tinh (Nam/Nu): ");
        String gioiTinhStr = kb.nextLine();
        boolean gioiTinh;
        if (gioiTinhStr.equalsIgnoreCase("Nam")) {
        gioiTinh = true;
        } else if (gioiTinhStr.equalsIgnoreCase("Nu")) {
        gioiTinh = false;
        } else {
        gioiTinh = true;
    }
        System.out.print("Luong co ban: "); double lcb = kb.nextDouble();
        
        if(maNV.charAt(0)=='L'){
            System.out.print("So gio overtime: "); int sogio = kb.nextInt();
            a.add(new LapTrinhVien(sogio, maNV, tenNV, sdtNV, mailNV, ngaySinh, gioiTinh, lcb));
        }else{
            System.out.print("So loi phat hien: "); int soloi = kb.nextInt();
            a.add(new KiemChungVien(soloi, maNV, tenNV, sdtNV, mailNV, ngaySinh, gioiTinh, lcb));
        }
        xuat(a,"DS sau khi them:");
        //xoa
        Scanner kc= new Scanner(System.in);
        System.out.print("Nhap ma can xoa:"); String xoaMa = kc.nextLine();
        xoaNhanVienTheoMa(xoaMa);
        xuat(a,"Danh sach sau khi xoa: ");
        //Tach
//        xuat(tachNhanVien("LapTrinhVien"),"Nhan vien Lap Trinh");
//        xuat(tachNhanVien("KiemChungVien"),"Nhan vien Kiem Chung");
        //thongke
        System.out.println("So LTV: "+thongKe("LapTrinhVien"));
        System.out.println("So KCV: "+thongKe("KiemChungVien"));
        //tong luong
        System.out.println("Tong luong nhan vien trong CTY: "+tongLuong());
        //maxLuong theo loại nhân viên
        xuat(maxLuongTheoTungLoai("LapTrinhVien"), "Nhan vien LTV luong lon nhat: ");
        xuat(maxLuongTheoTungLoai("KiemChungVien"), "Nhan vien KCV luong lon nhat: ");
        //Tìm kiếm
        Scanner kd= new Scanner(System.in);
        System.out.print("Nhap ma nhan vien can tim: "); String timMa = kd.nextLine();
        xuat(timNVTheoMa(timMa),"Nhan Vien vua tim duoc");
        //Tìm lương cao nhất của công Ty:
        xuat(LuongNVCaoNhat(),"Nhan Vien co so tien luong cao nhat cua cong ty");
        // sắp xếp giảm theo thành tiền:
        sapXepGiamLuong();        
        xuat(a, "Sau khi sap xep luong giam dan");
        sapXepTangLuong();        
        xuat(a, "Sau khi sap xep luong tang dan");
        
        
    }
    public static void main(String[] args) {
        QLNhanVien a = new QLNhanVien();
        a.docFile("NhanVien.txt");
        a.output();
        //nhap ten file:
        Scanner sc= new Scanner(System.in);
        System.out.println("Nhap ten de luu file: ");
        String luu = sc.nextLine();
        a.ghiFile(luu+".txt");
        System.out.println("Luu file thanh cong");
        
    }
}
