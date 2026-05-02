import java.sql.*;
import java.util.Scanner;

public class StudentCRUD {
    public static void main(String[] args) {

        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/college", "root", "password");

            Scanner sc = new Scanner(System.in);

            System.out.println("1.Insert 2.Update 3.Delete 4.Display");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter id name age: ");
                    int id = sc.nextInt();
                    String name = sc.next();
                    int age = sc.nextInt();

                    PreparedStatement ps1 = con.prepareStatement(
                            "INSERT INTO student VALUES (?, ?, ?)");
                    ps1.setInt(1, id);
                    ps1.setString(2, name);
                    ps1.setInt(3, age);
                    ps1.executeUpdate();
                    System.out.println("Inserted");
                    break;

                case 2:
                    System.out.print("Enter id to update: ");
                    int uid = sc.nextInt();
                    System.out.print("Enter new name: ");
                    String uname = sc.next();

                    PreparedStatement ps2 = con.prepareStatement(
                            "UPDATE student SET name=? WHERE id=?");
                    ps2.setString(1, uname);
                    ps2.setInt(2, uid);
                    ps2.executeUpdate();
                    System.out.println("Updated");
                    break;

                case 3:
                    System.out.print("Enter id to delete: ");
                    int did = sc.nextInt();

                    PreparedStatement ps3 = con.prepareStatement(
                            "DELETE FROM student WHERE id=?");
                    ps3.setInt(1, did);
                    ps3.executeUpdate();
                    System.out.println("Deleted");
                    break;

                case 4:
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM student");

                    while (rs.next()) {
                        System.out.println(
                                rs.getInt(1) + " " +
                                rs.getString(2) + " " +
                                rs.getInt(3));
                    }
                    break;
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}