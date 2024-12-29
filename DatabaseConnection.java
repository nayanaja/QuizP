import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public static Connection getConnection() {
        Connection connection = null;
        try {
            String url = "jdbc:mysql://localhost:3306/QuizPlatform";
            String user = "root";  // Replace with your MySQL username
            String password = ""; // Replace with your MySQL password
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println("Database connection failed: " + e.getMessage());
        }
        return connection;
}
   public static void main(String[] args){
     Connection con = getConnection();
     if(con != null) {
         System.out.println("Connection established!");
}else {
         System.out.println("Failed to establish connection.");
     }
  }
}



