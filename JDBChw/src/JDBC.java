import java.net.MalformedURLException;
import java.net.URL;
import java.sql.*;


public class JDBC {

    public String [][] getUsers (String role)
    {
        String url = "jdbc:mysql://127.0.0.1/test";
        String login = "root";
        String password = "root";
        String[][] result = new String[2][];
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, login, password); //соединяемся с БД

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select login, password from peoples where role =" + "'" + role + "'");


            int i = 0;
            if (rs.next()) {
                result[0][i] = rs.getString("login");
                result[1][i] = rs.getString("password");
                i++;
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }
}
