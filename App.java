import java.awt.*;
import java.awt.print.Book;
import java.util.ArrayList;

import javax.swing.*;
import java.util.List;

/**
 * App
 */
public class App extends ActionListener {
    /**
     * @param args
     */
    public static void main(String[] args) {
        final Connecting_Database usingConnection = new Connecting_Database();
// Login bhaye paxi book gaarne portal 
       
        JFrame f= new JFrame("Login Portal");
        JFrame logged_in = new JFrame("Booking Portal");
        ImageIcon icon = new ImageIcon("C:\\Users\\ryzen 7\\Desktop\\JAVA_PROJECT_HOTEL-RESERVATION\\resource\\door.png");
        Image img = icon.getImage();

        Image resizedImage = img.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(resizedImage);
        JLabel book_title = new JLabel("<html><font face=\"Times New Roman\" size = \"8\">Rooms Availability</font></html>");
        logged_in.setSize(500,500);
        logged_in.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        

        List<JButton> buttons = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            JButton button = new JButton(icon);
            button.setContentAreaFilled(false);
            button.setBorderPainted(false);
            buttons.add(button);
            logged_in.add(button);
        }
JButton r1 = buttons.get(0);
JButton r2 = buttons.get(1);
JButton r3 = buttons.get(2);
JButton r4 = buttons.get(3);
JButton r5 = buttons.get(4);
JButton r6 = buttons.get(5);
JButton r7 = buttons.get(6);
JButton r8 = buttons.get(7);
JButton r9 = buttons.get(8);
        book_title.setBounds(150, 20, 300, 50);
        book_title.setForeground(Color.BLACK);
        logged_in.add(book_title);
        r1.setBounds(50, 100, 100, 100);
        r2.setBounds(200, 100, 100, 100);
        r3.setBounds(350, 100, 100, 100);
        r4.setBounds(50, 250, 100, 100);
        r5.setBounds(200, 250, 100, 100);
        r6.setBounds(350, 250, 100, 100);
        r7.setBounds(50, 400, 100, 100);
        r8.setBounds(200, 400, 100, 100);
        r9.setBounds(350, 400, 100, 100);
        logged_in.setSize(500,600);
        logged_in.setVisible(false);
        logged_in.setLayout(null);


// Login page ko 
JLabel  label1 = new JLabel("Username:");
JLabel  label2 = new JLabel("Password:");
JLabel title = new JLabel("<html><font face=\"Times New Roman\" size = \"5\">LOGIN PAGE</font></html>");
        JButton sub = new JButton("Login");
        JTextField email = new JTextField();
        JPasswordField pass = new JPasswordField();
        JButton fail = new JButton("Not a user? Register");
        email.setColumns(25);
        pass.setEchoChar('*');
        pass.setColumns(25);    

        //Adding components to the frame
        title.setBounds(200, 20, 300, 50);
        label1.setBounds(120,80, 80, 30);
        label2.setBounds(120,150, 80, 30);
        email.setBounds(200,80,150,30);
        pass.setBounds(200, 150 , 150,30);
       sub.setBounds(200,220,80,30);
       fail.setBounds(170,260,152,30);

       f.add(title);
        f.add(label1);

        f.add(email);
        
        f.add(label2);
        f.add(pass);


        f.add(sub);
        f.add(fail);
        f.setLayout(null);
        f.setSize(500,500);
        f.setVisible(true);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // login page ko sakiyo 
        // Ya bata login huda ko action listener ho 
        sub.addActionListener(e -> {
            if (e.getSource() == sub) {                
                String userName = email.getText().toString();
                String passWord = new String(pass.getPassword());
                try {
                    if (usingConnection.login_read(userName, passWord)) {
                        JOptionPane.showMessageDialog(f, "Successfully Logged In!");
                        logged_in.setVisible(true);
                        f.dispose();
                    }
                } catch (HeadlessException e1) {
                    // TODO  catch block
                    e1.printStackTrace();
                } catch (Exception e1) {
                    // TODO  catch block
                    e1.printStackTrace();
                }
            }
            else if (e.getSource()== fail){
                System.out.println("Failed Login Attempt!");
                

            }
        });
        
                
    }
}