import java.sql.*;


public class Connecting_Database {
    public static void main (String[] args) throws Exception {}

    public boolean login_read(String username,String password) throws Exception{
    Connection cn = null;
       String server_username = "root";
        String server_password = "";
         final String url = "jdbc:mysql://localhost:3306/users";
            Class.forName("com.mysql.cj.jdbc.Driver");

            cn = DriverManager.getConnection(url,server_username,server_password);



        PreparedStatement qs = cn.prepareStatement("SELECT email,password FROM  login_credentials WHERE email=?");
        qs.setString(1,username);
       try { ResultSet rs = qs.executeQuery();
        rs.next();
        String check_username = rs.getString ("email");
        String check_password = rs.getString("password");
        if (check_username.equalsIgnoreCase(username)){
            if (check_password.equals(password)){
                return true;
            }
        }
        else {System.out.println("Username not found.");}
    cn.close();
            return false;

       }
         catch (Exception e){
              return false;
         }
    
       
       
    }

    public boolean register_user(String username, String password) throws Exception{
        Connection cn = null;
        String server_username = "root";
        String server_password = "";
        Class.forName("com.mysql.cj.jdbc.Driver");
        final String url = "jdbc:mysql://localhost:3306/users";
        cn = DriverManager.getConnection(url,server_username,server_password);
        PreparedStatement qs = cn.prepareStatement("INSERT INTO login_credentials (email,password) VALUES (?,?)");
        qs.setString(1, username);
        qs.setString(2, password);
        int rs = qs.executeUpdate();
        if (rs > 0){
            cn.close();
            return true;
        }
        else {
            cn.close();
            return false;
        }

    
  

}}

