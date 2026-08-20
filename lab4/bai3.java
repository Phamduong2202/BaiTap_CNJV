import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class bai3 extends JFrame {
    // === CÁC THÀNH PHẦN GIAO DIỆN ===
    JTextField txtN = new JTextField(10);
    JButton btnTinh = new JButton("Tính");
    JLabel lblKetQua = new JLabel("Kết quả: ?");
    
    SwingWorker worker;
    
    public bai3() {
        // === TẠO GIAO DIỆN ĐƠN GIẢN ===
        setTitle("Tính tổng số nguyên tố");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        
        // Thêm các thành phần
        add(new JLabel("N = "));
        add(txtN);
        add(btnTinh);
        add(lblKetQua);
        
        // === XỬ LÝ BẤM NÚT ===
        btnTinh.addActionListener(e -> batDauTinh());
    }
    
    // === HÀM BẮT ĐẦU TÍNH ===
    void batDauTinh() {
        try {
            int N = Integer.parseInt(txtN.getText());
            
            if (N <= 2) {
                JOptionPane.showMessageDialog(this, "Nhập N > 2!");
                return;
            }
            
            // Reset giao diện
            lblKetQua.setText("Đang tính...");
            btnTinh.setEnabled(false);
            
            // === TẠO SWINGWORKER ===
            worker = new SwingWorker<Void, Void>() {
                int tong = 0;
                
                // Kiểm tra số nguyên tố
                boolean laNguyenTo(int num) {
                    if (num < 2) return false;
                    for (int i = 2; i * i <= num; i++) {
                        if (num % i == 0) return false;
                    }
                    return true;
                }
                
                // Chạy ngầm
                @Override
                protected Void doInBackground() throws Exception {
                    for (int i = 2; i <= N; i++) {
                        if (laNguyenTo(i)) {
                            tong += i;
                        }
                        Thread.sleep(1);
                    }
                    return null;
                }
                
                // Kết thúc
                @Override
                protected void done() {
                    btnTinh.setEnabled(true);
                    lblKetQua.setText("Tổng = " + tong);
                    JOptionPane.showMessageDialog(bai3.this, 
                        "Tổng các số nguyên tố < " + N + " = " + tong);
                }
            };
            
            worker.execute();
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Nhập số nguyên!");
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new bai3().setVisible(true));
    }
}