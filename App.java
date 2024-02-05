import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;
import java.util.List;
import java.awt.event.*;

/**
 * App
 */
 class App  {
    /**
     * @param args
     */
    public static void main(String[] args) {
        final Connecting_Database usingConnection = new Connecting_Database();
        final Room_Availability_Check roomCheck = new Room_Availability_Check();
// Login bhaye paxi book gaarne portal 
       
        JFrame f= new JFrame("Login Portal");
        JFrame logged_in = new JFrame("Booking Portal");
        ImageIcon icon = new ImageIcon("C:\\Users\\ryzen 7\\Desktop\\JAVA_PROJECT_HOTEL-RESERVATION\\resource\\door.png");
        Image img = icon.getImage();

        Image resizedImage = img.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(resizedImage);
        JLabel book_title = new JLabel("<html><font face=\"Times New Roman\" size = \"8\">Rooms Availability</font></html>");
        logged_in.setSize(500,500);
        book_title.setBounds(140, 20, 300, 50);
        book_title.setForeground(Color.BLACK);
        logged_in.add(book_title);
logged_in.setSize(500,700);
        logged_in.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        List<JButton> buttons1 = new ArrayList<>();
        List<JLabel> room_no_label = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            JButton button = new JButton(icon);
            button.setContentAreaFilled(false);
            button.setBorderPainted(false);
            buttons1.add(button);
            
            logged_in.add(button);
            
            JLabel room_no = new JLabel("Room "+ (i+1));

            room_no_label.add(room_no);
            
            logged_in.add(room_no);
            
            
           
        }
        JButton r1 = buttons1.get(0);
        JButton r2 = buttons1.get(1);
        JButton r3 = buttons1.get(2);
        JButton r4 = buttons1.get(3);
        JButton r5 = buttons1.get(4);
        JButton r6 = buttons1.get(5);
        JButton r7 = buttons1.get(6);
        JButton r8 = buttons1.get(7);
        JButton r9 = buttons1.get(8);

 List<JButton> buttons = Arrays.asList(r1, r2, r3, r4, r5, r6, r7, r8, r9);

for (int i = 0; i < buttons.size(); i++) {
    int roomNumber = i + 1; // room numbers start from 1
    buttons.get(i).addActionListener(e -> {
        try {
            if (roomCheck.room_availability_check(roomNumber)) {
                JOptionPane.showMessageDialog(logged_in, "Room " + roomNumber + " is already booked!");
            } else {
                int ans = JOptionPane.showConfirmDialog(logged_in, " Room " + roomNumber + " is available! Do you want to book this room?");
                if (ans == JOptionPane.YES_OPTION) {
                    String booking_date = JOptionPane.showInputDialog(logged_in, "Enter the booking date in YYYY-MM-DD format:");
                    String user = JOptionPane.showInputDialog(logged_in, "Enter your name:");
                    if (roomCheck.room_availability_check(roomNumber, booking_date, user)) {
                        JOptionPane.showMessageDialog(logged_in, "Room " + roomNumber + " has been booked!");
                    } else {
                        JOptionPane.showMessageDialog(logged_in, "Room " + roomNumber + " could not be booked!");
                    }
                }
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    });
    JButton logout = new JButton("Logout");
    logout.setBounds(200, 600, 100, 30);
    logged_in.add(logout);
    logout.addActionListener(e -> {
        if (e.getSource() == logout) {
            f.setVisible(true);
            logged_in.dispose();
           
        }
    });
}



        for (int i = 0; i < 9; i++) {
            room_no_label.get(i).setBounds(75 + (i % 3) * 150, 215 + ((i / 3) * 150), 100, 100);
            buttons1.get(i).setBounds(50 + (i % 3) * 150, 150 + ((i / 3) * 150), 100, 100);
        }
        logged_in.setLayout(null);
        logged_in.setVisible(false);

// User register gaarna ko laagi 

        JFrame register = new JFrame("Register");
        JLabel regis_title = new JLabel("<html><font face=\"Times New Roman\" size = \"5\">REGISTER PAGE</font></html>");
        JLabel  regis_label = new JLabel("Username:");
        JLabel  regis_Label2 = new JLabel("Password:");
        JButton reg_sub = new JButton("Register");
        JTextField reg_email = new JTextField();
        JPasswordField reg_pass = new JPasswordField();
        reg_email.setColumns(25);
        reg_pass.setEchoChar('*');
        reg_pass.setColumns(25);
        regis_title.setBounds(200, 20, 300, 50);
        regis_label.setBounds(120,80, 80, 30);
        regis_Label2.setBounds(120,150, 80, 30);
        reg_email.setBounds(200,80,150,30);
        reg_pass.setBounds(200, 150 , 150,30);
        reg_sub.setBounds(200,220,80,30);
        register.add(regis_title);
        register.add(regis_Label2);
        register.add(reg_email);
        register.add(regis_label);
        register.add(reg_pass);
        register.add(reg_sub);
        register.setLayout(null);
        register.setSize(500,500);
        register.setVisible(false);
        register.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        reg_sub.addActionListener(e -> {
            if (e.getSource() == reg_sub) {
                String userName = reg_email.getText().toString();
                String passWord = new String(reg_pass.getPassword());
                try {
                    if (usingConnection.register_user(userName, passWord)) {
                        JOptionPane.showMessageDialog(register, "Successfully Registered!");
                        f.setVisible(true);
                        
                        register.dispose();
                    }
                    else {
                        JOptionPane.showMessageDialog(register, "Registration Failed!");
                        reg_email.setText("");
                        reg_pass.setText("");
                    }
                } catch (HeadlessException e1) {
                    e1.printStackTrace();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }});
            register.setVisible(false);

        
// Login page ko 
JLabel  label1 = new JLabel("Username:");
JLabel  label2 = new JLabel("Password:");
JLabel title = new JLabel("<html><font face=\"Times New Roman\" size = \"5\">LOGIN PAGE</font></html>");
        JButton sub = new JButton("Login");
        JTextField email = new JTextField();
        JPasswordField pass = new JPasswordField();
        email.setText("");
                        pass.setText("");
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
                    else {
                        JOptionPane.showMessageDialog(f, "Wrong Username/ Password");
                        email.setText("");
                        pass.setText("");}
                } catch (HeadlessException e1) {
                    // TODO  catch block
                    e1.printStackTrace();
                } catch (Exception e1) {
                    // TODO  catch block
                    e1.printStackTrace();
                }
            }});

            // Register button ko action  ho
          fail.addActionListener(e->{
            if (e.getSource()== fail){
                register.setVisible(true);
                f.dispose();
            
            }
        });
        
                
    }
}