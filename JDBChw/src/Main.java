

public class Main {
    public static void main(String [] args) {
        try

        {
            JDBC jdbc = new JDBC();
            String[][] users;
            users = jdbc.getUsers("user");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
