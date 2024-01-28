import javax.swing.*;

/**
 * App
 */
public class App {

    public static void main(String[] args) {
        JLabel  label1 = new JLabel("Username:");
        JLabel  label2 = new JLabel("Password:");

JLabel title = new JLabel("<html><font face=\"Times New Roman\" size = \"5\">LOGIN PAGE</font></html>");
        JFrame f= new JFrame("Login Portal");
        JButton sub = new JButton("Login");
        JTextField email = new JTextField();
        JPasswordField pass = new JPasswordField();
        email.setColumns(25);
        pass.setEchoChar('*');
        pass.setColumns(25);    

        //Adding components to the frame
        title.setBounds(200, 20, 300, 50);
        label1.setBounds(20,80, 80, 30);
        label2.setBounds(20,150, 80, 30);
        email.setBounds(200,80,150,30);
        pass.setBounds(200, 150 , 150,30);
       sub.setBounds(100,220,80,30);
       f.add(title);
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