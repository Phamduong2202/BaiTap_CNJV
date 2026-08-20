import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class bai1 extends JFrame {
    // === CÁC THÀNH PHẦN GIAO DIỆN ===
    JTextField txtSeconds = new JTextField(10);
    JButton btnStart = new JButton("Bắt đầu");
    JLabel lblTime = new JLabel("00:00");
    
    SwingWorker<Void, Integer> worker;
    
    public bai1() {
        // === TẠO GIAO DIỆN ===
        setTitle("Đồng hồ đếm ngược");
        setSize(350, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        
        // Định dạng đồng hồ
        lblTime.setFont(new Font("Arial", Font.BOLD, 40));
        
        // Thêm các thành phần
        add(new JLabel("Giây:"));
        add(txtSeconds);
        add(btnStart);
        add(lblTime);
        
        // === XỬ LÝ BẤM NÚT ===
        btnStart.addActionListener(e -> batDauDem());
    }
    
    // === HÀM BẮT ĐẦU ĐẾM ===
    void batDauDem() {
        try {
            int seconds = Integer.parseInt(txtSeconds.getText());
            
            if (seconds <= 0) {
                JOptionPane.showMessageDialog(this, "Nhập số > 0!");
                return;
            }
            
            // Reset
            btnStart.setEnabled(false);
            
            // === TẠO SWINGWORKER ===
            worker = new SwingWorker<Void, Integer>() {
                int remaining = seconds;
                
                @Override
                protected Void doInBackground() throws Exception {
                    while (remaining >= 0 && !isCancelled()) {
                        publish(remaining);
                        remaining--;
                        Thread.sleep(1000);
                    }
                    return null;
                }
                
                @Override
                protected void process(java.util.List<Integer> chunks) {
                    int value = chunks.get(chunks.size() - 1);
                    lblTime.setText(String.format("%02d:%02d", value/60, value%60));
                }
                
                @Override
                protected void done() {
                    btnStart.setEnabled(true);
                    if (!isCancelled()) {
                        JOptionPane.showMessageDialog(bai1.this, "Hết giờ!");
                    }
                }
            };
            
            worker.execute();
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Nhập số nguyên!");
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new bai1().setVisible(true));
    }
}