
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class conectaDAO {

    public Connection connectDB() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/uc11?useSSL=false&serverTimezone=UTC",
                "root",
                "01Jul1a23@"
            );
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(
                null,
                "Erro ao conectar no banco: " + erro.getMessage()
            );
        }

        return conn;
    }

}
     
