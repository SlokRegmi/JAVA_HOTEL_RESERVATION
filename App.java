import javax.swing.*;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import java.awt.*;

/**
 * App
 */
public class App {

    public static void main(String[] args) {
        JLabel  label1 = new JLabel("Username:");
        JLabel  label2 = new JLabel("Password:");

        JFrame f= new JFrame("Login Portal");
        JButton sub = new JButton("Login");
        JTextField email = new JTextField();
        JPasswordField pass = new JPasswordField();
        email.setColumns(25);
        pass.setEchoChar('*');
        pass.setColumns(25);
        label1.setBounds(20,80, 80, 30);
        label2.setBounds(20,150, 80, 30);
        email.setBounds(200,80,150,30);
        pass.setBounds(200, 150 , 150,30);
       sub.setBounds(100,220,80,30);
        f.add(label1);

        f.add(email);
        
        f.add(label2);
        f.add(pass);

        f.add(sub);
        f.setLayout(null);
        f.setSize(500,500);
        f.setVisible(true);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                
    }
}