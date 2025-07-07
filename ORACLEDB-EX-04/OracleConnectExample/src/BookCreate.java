import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class BookCreate {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521/XE";
        String user = "sys as SYSDBA";
        String password = "ORACLE";

        String insertSql = "INSERT INTO BOOK (ID, NAME, ISBN) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(insertSql)) {

            conn.setAutoCommit(false);

            Random rand = new Random();
            for (int i = 1; i <= 100; i++) {
                pstmt.setInt(1, i);
                pstmt.setString(2, "Book_" + rand.nextInt(1000));
                pstmt.setString(3, "ISBN" + rand.nextInt(99999));
                pstmt.addBatch();
            }

            pstmt.executeBatch();
            conn.commit();

            System.out.println("100 books are successfully added");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

