import java.awt.*;
import javax.swing.*;

/**
 * App
 */
public class App extends ActionListener {
    public static void main(String[] args) {
        final Connecting_Database usingConnection = new Connecting_Database();

        JLabel  label1 = new JLabel("Username:");
        JLabel  label2 = new JLabel("Password:");

JLabel title = new JLabel("<html><font face=\"Times New Roman\" size = \"5\">LOGIN PAGE</font></html>");
        JFrame f= new JFrame("Login Portal");
        JFrame logged_in = new JFrame("Booking Portal");
        JButton sub = new JButton("Login");
        JTextField email = new JTextField();
        JPasswordField pass = new JPasswordField();
        JButton fail = new JButton("Forgot Password");
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
       fail.setBounds(170,260,140,30);

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