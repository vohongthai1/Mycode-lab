
package Thai;

import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyNhanVien {
    private ArrayList<NhanVien> a = new ArrayList<>();
    public void docFile(String tenFile) {
        try {
            File f = new File(tenFile);
            if(f.exists()){
                System.out.println("OK");
                Scanner read = new Scanner(f);
                while(read.hasNext()){
//                    String maNhanVien, String hoTen, String soDienThoai, String mail, Date ngaySinh, boolean gioiTinh, double luongCoBan
                    String s[] = read.nextLine().split(", ");
                    String ma = s[0];
                    String ht = s[1];
                    String sdt = s[2];
                    String mai = s[3];
                    Date nt = new Date(s[4]);
                    boolean gt = Boolean.parseBoolean(s[5]);
                    double lcb = Double.parseDouble(s[6]);
                    if(ma.charAt(0)=='L'){
                        int gio = Integer.parseInt(s[7]);
                        a.add(new LapTrinhVien(gio, ma, ht, sdt, mai, nt, gt, lcb));
                    }
                    if(ma.charAt(0)=='K'){
                        int loi = Integer.parseInt(s[7]);
                        a.add(new KiemChungVien(loi, ma, ht, sdt, mai, nt, gt, lcb));
                    }
                }
            }else System.out.println("ko co");
        } catch (Exception e) {
        }
    }
    public boolean them(NhanVien y){
        
        for (NhanVien x : a) {
            if(x.getMaNhanVien().equalsIgnoreCase(y.getMaNhanVien()))
            return false;
        }
        a.add(y);
        return true;
        
    }
//    public boolean xoaMa(String ma){
//        for (NhanVien x : a) {
//            if(x.getMaNhanVien().equalsIgnoreCase(ma))
//                a.remove(x);
//            return true;
//        }
//        return false;
//    }
    public ArrayList tach(String tenHinh) {
        ArrayList b = new ArrayList();
        for (NhanVien x : a) {
            if (x.getClass().getSimpleName().equals(tenHinh)) {
                b.add(x);
            }
        }
        ghiFile("filenew.txt");
        return b;
        
    }
    public void maxLuong(){
        NhanVien y = a.get(0);
        for(NhanVien x: a){
            if(y.getLuong() <= x.getLuong())
                y=x;
        }
        System.out.println(y);
    }
    public void sapxep(){
        for(int i =0 ; i<a.size()-1 ; i++){
            for (int j = i+1; j < a.size(); j++) {
                if(a.get(i).getLuong() > a.get(j).getLuong()){
                    NhanVien x = a.get(i);
                    a.set(i, a.get(j));
                    a.set(j, x);
                    
                }
            }
        }
    }
        public void ghiFile(String tenFile){
        try {
            File f = new File(tenFile);
            if(!f.exists()){
                PrintStream out = new PrintStream(f);
                for(NhanVien x: a){
                    if(x instanceof LapTrinhVien){
                        out.println();
                    }
                    if(x instanceof KiemChungVien){
                        out.println();
                    }
                }
            }
        } catch (Exception e) {
        }
    }
    public void xuat(ArrayList a, String nt){
        System.out.println(nt);
        for (Object x : a) {
            System.out.println(x);
        }
        System.out.println("");
    }
    
    public void output(){
        xuat(a,"DS");
        Scanner kb= new Scanner(System.in);
//            System.out.println("Nhap ma can xoa: "); String ma = kb.nextLine();
//            xoaMa(ma);
            xuat(a,"Xoa Thanh Cong");
            xuat(tach("LapTrinhVien"), "LTV:");
            ghiFile("Laptrinh.txt");
            xuat(tach("KiemChungVien"),"KCV");
            System.out.println("Tim max luong");
            maxLuong();
            sapxep();
            xuat(a, "SapXep");
    }
    public static void main(String[] args) {
        QuanLyNhanVien a = new QuanLyNhanVien();
        a.docFile("NhanVien.txt");
        a.output();
    }
}
