import javax.swing.*;
import java.awt.*;

public class bai4 {
    public static void main(String[] args) {
       
        JFrame frame = new JFrame("Image Viewer");
        
        String imagePath = "image.jpg"; 

        ImageIcon imageIcon = new ImageIcon(imagePath);
        

        if (imageIcon.getIconWidth() == -1) {
            System.out.println("Không tìm thấy hình ảnh tại: " + imagePath);
            System.out.println("Vui lòng kiểm tra đường dẫn file!");
            return;
        }
        

        JLabel imageLabel = new JLabel(imageIcon);
        
        frame.add(imageLabel);
        
        frame.pack();
        
        frame.setLocationRelativeTo(null);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setVisible(true);
    }
}