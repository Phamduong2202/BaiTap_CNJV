import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class bai2 {
    public static void main(String[] args) {
        // Tạo JFrame
        JFrame frame = new JFrame("Tính Tổng Hai Số");
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        
        // Tạo các component
        JLabel lblNumber1 = new JLabel("Số thứ nhất:");
        JTextField txtNumber1 = new JTextField(15);
        
        JLabel lblNumber2 = new JLabel("Số thứ hai:");
        JTextField txtNumber2 = new JTextField(15);
        
        JButton btnCalculate = new JButton("Tính Tổng");
        JLabel lblResult = new JLabel("Kết quả: ");
        lblResult.setFont(new Font("Arial", Font.BOLD, 16));
        
        // Xử lý sự kiện
        btnCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Lấy giá trị từ text field
                    double num1 = Double.parseDouble(txtNumber1.getText());
                    double num2 = Double.parseDouble(txtNumber2.getText());
                    
                    // Tính tổng
                    double sum = num1 + num2;
                    
                    // Hiển thị kết quả
                    lblResult.setText("Kết quả: " + num1 + " + " + num2 + " = " + sum);
                    
                } catch (NumberFormatException ex) {
                    // Xử lý lỗi nhập không phải số
                    JOptionPane.showMessageDialog(
                        frame,
                        "Vui lòng nhập số hợp lệ!",
                        "Lỗi nhập liệu",
                        JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });
        
        // Thêm các component vào frame
        gbc.gridx = 0; gbc.gridy = 0;
        frame.add(lblNumber1, gbc);
        gbc.gridx = 1;
        frame.add(txtNumber1, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1;
        frame.add(lblNumber2, gbc);
        gbc.gridx = 1;
        frame.add(txtNumber2, gbc);
        
        gbc.gridx = 0; gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        frame.add(btnCalculate, gbc);
        
        gbc.gridx = 0; gbc.gridy = 3;
        gbc.gridwidth = 2;
        frame.add(lblResult, gbc);
        
        // Hiển thị
        frame.setVisible(true);
    }
}