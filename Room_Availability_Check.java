import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class Room_Availability_Check{

        public String room_availability_check(int room_no,int x) throws Exception{
        Connection cn = null;
        String server_username = "root";
        String server_password = "";
        Class.forName("com.mysql.cj.jdbc.Driver");
        final String url = "jdbc:mysql://localhost:3306/users";
        cn = DriverManager.getConnection(url,server_username,server_password);
        PreparedStatement qs = cn.prepareStatement("SELECT * FROM  rooms WHERE room_no=?");
        qs.setInt(1, room_no);
    ResultSet rs = qs.executeQuery();
    rs.next();
    String user = rs.getString("usermail");
    int room = rs.getInt("room_no");
    String check_availability = rs.getString ("booking_date");
    
   if (check_availability == null){
       return "Room no :" + room + " is available";
   }
   else {
       return "Room no :" + room + " is not available, it is booked by " + user;
   }
   
}
    public boolean room_availability_check(int room_no) throws Exception{
        Connection cn = null;
        String server_username = "username"; // Enter your database username here
        String server_password = "password"; // Enter your database password here
        Class.forName("com.mysql.cj.jdbc.Driver");
        final String url = "jdbc:mysql://localhost:3306/users"; // Enter your database url here
        cn = DriverManager.getConnection(url,server_username,server_password);
        PreparedStatement qs = cn.prepareStatement("SELECT booking_date FROM  rooms WHERE room_no=?");
        qs.setInt(1, room_no);
    ResultSet rs = qs.executeQuery();
    rs.next();
    
    String check_availability = rs.getString ("booking_date");
    
   if (check_availability == null){
   return false;
   }
   else {
       return true;
   }
  
   
   
}
public boolean room_availability_check(int room_no, String booking_date, String user) throws Exception{
    Connection cn = null;
    String server_username = "username"; // Enter your database username here
    String server_password = "password"; // Enter your database password here
    Class.forName("com.mysql.cj.jdbc.Driver");
    final String url = "jdbc:mysql://localhost:3306/users"; // Enter your database url here
    cn = DriverManager.getConnection(url,server_username,server_password);
    PreparedStatement qs = cn.prepareStatement("Update rooms SET booking_date = ?, usermail = ? WHERE room_no=?");
    qs.setString(1, booking_date);
    qs.setString(2, user);
    qs.setInt(3, room_no);
int rs = qs.executeUpdate();
if (rs > 0){
    return true;
}
else {
    return false;
}
}
public boolean clear_booking(int room_no) throws Exception{
    Connection cn = null;
    String server_username = "username"; // Enter your database username here
    String server_password = "password"; // Enter your database password here
    Class.forName("com.mysql.cj.jdbc.Driver");
    final String url = "jdbc:mysql://localhost:3306/users"; // Enter your database url here
    cn = DriverManager.getConnection(url,server_username,server_password);
    PreparedStatement qs = cn.prepareStatement("Update rooms SET booking_date = null, usermail = null WHERE room_no=?");
    qs.setInt(1, room_no);
int rs = qs.executeUpdate();
if (rs > 0){
    cn.close();
    return true;
}
else {
    cn.close();
    return false;
}

}
}