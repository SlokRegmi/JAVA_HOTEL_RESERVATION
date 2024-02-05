import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class testing_connection {
    public static void main(String[] args)  {
                String username = "root";
        String password = "";

        try { 
            String url = "jdbc:mysql://localhost:3306/class";
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM student";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("roll");
                String name = resultSet.getString("name");
                System.out.println("Id : " + id + " Name : " + name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
}