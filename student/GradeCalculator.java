import java.util.ArrayList;
import java.util.Scanner;

public class GradeCalculator {

    ArrayList<Student> studentList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    

    void nhapSinhVien() {
        System.out.println("\n--- NHẬP THÔNG TIN SINH VIÊN ---");
        

        System.out.print("Nhập mã sinh viên: ");
        String maSV = scanner.nextLine();
        
        System.out.print("Nhập họ tên: ");
        String hoTen = scanner.nextLine();
        
   
        double diemCC = nhapDiem("Nhập điểm chuyên cần (0-10): ");
        double diemGK = nhapDiem("Nhập điểm giữa kỳ (0-10): ");
        double diemCK = nhapDiem("Nhập điểm cuối kỳ (0-10): ");
        

        Student sv = new Student(maSV, hoTen, diemCC, diemGK, diemCK);
        

        sv.totalScore = tinhDiemTongKet(sv);
        sv.grade = xepLoai(sv.totalScore);
        

        studentList.add(sv);
        
        System.out.println("Đã thêm sinh viên thành công!");
        System.out.println("Kết quả: " + maSV + " - " + hoTen + " - " + sv.totalScore + " - " + sv.grade);
    }
    
 
    double nhapDiem(String thongBao) {
        while (true) {
            System.out.print(thongBao);
            double diem = scanner.nextDouble();
            scanner.nextLine(); // Xóa bộ nhớ đệm
            
            if (diem >= 0 && diem <= 10) {
                return diem;
            } else {
                System.out.println("Điểm không hợp lệ! Vui lòng nhập từ 0-10.");
            }
        }
    }
    

    double tinhDiemTongKet(Student sv) {
        return sv.attendanceScore * 0.1 + 
               sv.midtermScore * 0.3 + 
               sv.finalScore * 0.6;
    }
    

    String xepLoai(double diem) {
        if (diem >= 8.5) return "A";
        if (diem >= 7.0) return "B";
        if (diem >= 5.5) return "C";
        if (diem >= 4.0) return "D";
        return "F";
    }
    

    void hienThiDanhSach() {
        if (studentList.isEmpty()) {
            System.out.println("\nChưa có sinh viên nào!");
            return;
        }
        
        System.out.println("\n--- DANH SÁCH SINH VIÊN ---");
        System.out.println("Mã SV | Họ tên | Điểm TK | Xếp loại");
        System.out.println("------------------------------------");
        
        for (Student sv : studentList) {
            System.out.println(sv.studentId + " | " + 
                             sv.fullName + " | " + 
                             sv.totalScore + " | " + 
                             sv.grade);
        }
        System.out.println("Tổng số: " + studentList.size() + " sinh viên");
    }
    

    void hienThiMenu() {
        System.out.println("\n========== MENU ==========");
        System.out.println("1. Nhập sinh viên");
        System.out.println("2. Xem danh sách");
        System.out.println("3. Thoát");
        System.out.println("===========================");
        System.out.print("Chọn: ");
    }
    

    void chay() {
        while (true) {
            hienThiMenu();
            int luaChon = scanner.nextInt();
            scanner.nextLine(); // Xóa bộ nhớ đệm
            
            if (luaChon == 1) {
                nhapSinhVien();
            } else if (luaChon == 2) {
                hienThiDanhSach();
            } else if (luaChon == 3) {
                System.out.println("Cảm ơn! Tạm biệt!");
                break;
            } else {
                System.out.println("Chọn sai! Vui lòng chọn 1-3.");
            }
        }
    }
}