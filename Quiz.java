import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Quiz {
    public static void startQuiz(String category) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM Questions WHERE category = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, category);
            ResultSet rs = stmt.executeQuery();

            Scanner scanner = new Scanner(System.in);
            int score = 0;
            while (rs.next()) {
                System.out.println(rs.getString("question"));
                System.out.println("1. " + rs.getString("option1"));
                System.out.println("2. " + rs.getString("option2"));
                System.out.println("3. " + rs.getString("option3"));
                System.out.println("4. " + rs.getString("option4"));
                System.out.print("Your answer: ");
                int answer = scanner.nextInt();

                if (answer == rs.getInt("correct_option")) {
                    System.out.println("Correct!");
                    score++;
                } else {
                    System.out.println("Wrong! The correct answer was option " + rs.getInt("correct_option"));
                }
            }
            System.out.println("Your total score: " + score);
        } catch (Exception e) {
            System.out.println("Error during quiz: " + e.getMessage());
        }
    }
   public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter quiz category: ");
        String category = scanner.nextLine();

        startQuiz(category);
    }
  
}
