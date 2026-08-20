import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class bai2 extends JFrame {
    // === CÁC THÀNH PHẦN GIAO DIỆN ===
    JButton btnLoad = new JButton("Tải dữ liệu");
    JProgressBar progressBar = new JProgressBar(0, 100);
    JLabel lblStatus = new JLabel("Chưa bắt đầu");
    
    SwingWorker<Void, Integer> worker;
    
    public bai2() {
        // === TẠO GIAO DIỆN ===
        setTitle("Mô phỏng tải dữ liệu");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        
        // Thiết lập thanh tiến trình
        progressBar.setStringPainted(true);
        progressBar.setPreferredSize(new Dimension(250, 25));
        
        // Thêm các thành phần
        add(btnLoad);
        add(progressBar);
        add(lblStatus);
        
        // === XỬ LÝ KHI BẤM NÚT ===
        btnLoad.addActionListener(e -> batDauTai());
    }
    
    // === HÀM BẮT ĐẦU TẢI ===
    void batDauTai() {
        if (worker != null && !worker.isDone()) {
            JOptionPane.showMessageDialog(this, "Đang tải, vui lòng đợi!");
            return;
        }
        
        // Reset
        progressBar.setValue(0);
        lblStatus.setText("Đang tải...");
        btnLoad.setEnabled(false);
        
        // === TẠO SWINGWORKER ===
        worker = new SwingWorker<Void, Integer>() {
            int phanTram = 0;
            
            @Override
            protected Void doInBackground() throws Exception {
                while (phanTram <= 100) {
                    publish(phanTram);
                    phanTram += 5;
                    Thread.sleep(500);
                }
                return null;
            }
            
            @Override
            protected void process(java.util.List<Integer> chunks) {
                int value = chunks.get(chunks.size() - 1);
                progressBar.setValue(value);
                lblStatus.setText("Đang tải... " + value + "%");
            }
            
            @Override
            protected void done() {
                btnLoad.setEnabled(true);
                progressBar.setValue(100);
                lblStatus.setText("Tải thành công!");
                JOptionPane.showMessageDialog(bai2.this, "Tải dữ liệu hoàn tất!");
            }
        };
        
        worker.execute();
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new bai2().setVisible(true));
    }
}