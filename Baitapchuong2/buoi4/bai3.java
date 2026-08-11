import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class bai3 {
    public static void main(String[] args) {
        // Tạo JFrame
        JFrame frame = new JFrame("Exit Button App");
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton exitButton = new JButton("Exit");

        exitButton.setFont(new Font("Arial", Font.BOLD, 16));
    
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                System.exit(0);
            }
        });
        

        frame.setLayout(new GridBagLayout());
        frame.add(exitButton);

        frame.setVisible(true);
    }
}