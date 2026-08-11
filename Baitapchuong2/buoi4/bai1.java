import javax.swing.*;
import java.awt.*;

public class bai1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Bai1");
        
        frame.setSize(400, 300);
        
        frame.setLocationRelativeTo(null);
        
        JLabel label = new JLabel("Hello World", SwingConstants.CENTER);
        
        label.setFont(new Font("Arial", Font.BOLD, 24));
        
        frame.add(label);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }
}