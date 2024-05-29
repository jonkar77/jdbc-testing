import java.sql.*;

public class Main{
    public static void main(String[] args) throws ClassNotFoundException {
        String url= "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "Joshi@87";
        String query="Select * from employees";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Drivers loaded successfully");
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }

        try (Connection connection = DriverManager.getConnection(url, username, password))
        {
            System.out.println("Connected to db!");
            // System.out.println(connection);
            Statement stmt= connection.createStatement();
            ResultSet rs= stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name= rs.getString("name");
                String Job= rs.getString("job_title");
                double salary= rs.getDouble("salary");
                System.out.println();
                System.out.println("================================");
                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Job: " + Job);
                System.out.println("salary: " + salary);
            }
            rs.close();
            stmt.close();
            connection.close();
            System.out.println("Connection closed successfully!!");

        } catch (SQLException e) {
            System.err.println("Connection failed: "+ e.getMessage());
        }
    }
}