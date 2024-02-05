import java.sql.*;


public class Connecting_Database {
    public static void main (String[] args) throws Exception {}
    /*   Connecting_Database(){
        String username = loadCredentials("username");
        String password = loadCredentials("password");
           try{ final String url = "jdbc:mysql://localhost:3306/users";
            Class.forName("com.mysql.cj.jdbc.Driver");

            cn = DriverManager.getConnection(url,username,password);
            System.out.println("Connection chai bhaisakyo");
        
    }catch (Exception exp) {
            System.out.println (exp.getMessage());
    }

}
    */



    /* */
    public boolean login_read(String username,String password) throws Exception{
    Connection cn = null;
       String server_username = "root"/*loadCredentials("username")*/;
        String server_password = ""/*loadCredentials("password")*/;
         final String url = "jdbc:mysql://localhost:3306/users";
            Class.forName("com.mysql.cj.jdbc.Driver");

            cn = DriverManager.getConnection(url,server_username,server_password);
            System.out.println("Connection chai bhaisakyo");



        PreparedStatement qs = cn.prepareStatement("SELECT email,password FROM  login_credentials WHERE email=?");
        qs.setString(1,username);
        ResultSet rs = qs.executeQuery();
        rs.next();
        String check_username = rs.getString ("email");
        String check_password = rs.getString("password");
        if (check_username.equalsIgnoreCase(username)){
            if (check_password.equals(password)){
                System.out.println("Login bhayo");
                return true;
            }
        }
        else {System.out.println("Username not found.");}
    cn.close();
            return false;


    }
    /* 
    private static String loadCredentials(String credentialName) {
        return "<securely-stored-credential>";
    } */

}

