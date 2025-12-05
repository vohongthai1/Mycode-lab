# DoAnCaNhan - Quản Lý Nhân Viên

## Mô tả dự án
Đây là một ứng dụng Java Swing để quản lý nhân viên trong công ty, bao gồm hai loại nhân viên chính:
- **Lập trình viên**: Quản lý thông tin và giờ làm thêm
- **Kiểm chứng viên**: Quản lý thông tin và chỉ tiêu công việc

## Chức năng chính
- Quản lý thông tin nhân viên (mã, tên, SĐT, email, ngày sinh, giới tính, lương cơ bản)
- Thêm, sửa, xóa nhân viên
- Tìm kiếm nhân viên theo mã
- Hiển thị danh sách nhân viên
- Lưu và đọc dữ liệu từ file
- Tính lương theo loại nhân viên

## Cấu trúc project
```
src/
├── Thai/
│   ├── GUI.java              - Giao diện người dùng chính
│   ├── GUI.form              - File form thiết kế GUI
│   ├── QLNhanVien.java       - Class quản lý danh sách nhân viên
│   ├── NhanVien.java         - Class nhân viên cơ bản
│   ├── LapTrinhVien.java     - Class lập trình viên
│   ├── KiemChungVien.java    - Class kiểm chứng viên
│   ├── Date.java             - Class xử lý ngày tháng
│   └── QuanLyNhanVien.java   - Class quản lý chính
├── Image/
│   └── NhanVien1.png         - Hình ảnh nhân viên
```

## Công nghệ sử dụng
- **Ngôn ngữ**: Java
- **GUI Framework**: Java Swing
- **Build Tool**: Apache Ant
- **IDE**: NetBeans

## Cách chạy project
1. Mở project trong NetBeans IDE
2. Build project: `Build > Build Project`
3. Run project: `Run > Run Project`
4. Hoặc sử dụng command line:
   ```bash
   ant compile
   ant run
   ```

## Cấu trúc dữ liệu
- File `NhanVien.txt`: Lưu trữ thông tin nhân viên
- Định dạng dữ liệu: `mã, tên, sdt, email, ngày sinh, giới tính, lương cơ bản, thông tin riêng`

## Tác giả
- Họ tên: Võ Hồng Thái

## Yêu cầu hệ thống
- JDK 8 trở lên
- NetBeans IDE (khuyến nghị)
- Hệ điều hành: Windows/Linux/macOS
