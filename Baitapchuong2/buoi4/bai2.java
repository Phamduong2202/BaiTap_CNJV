import javax.swing.*;
import java.awt.*;

public class bai2 {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Welcome");
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                int result = JOptionPane.showConfirmDialog(
                    frame, 
                    "Welcome to Java Swing", 
                    "Welcome", 
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE
                );
                
                
                if (result == JOptionPane.OK_OPTION) {
                    System.exit(0);
                }
            }
        });
    }
}