
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

 String sql = "SELECT id, username FROM users WHERE id = ?";
    List users = new ArrayList<>();
    try (Connection con = DriverManager.getConnection(myConnectionURL);
         PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setInt(1, userId);
        try (ResultSet rs = ps.executeQuery()) {
            while(rs.next()) {
                users.add(new User(rs.getInt("id"), rs.getString("name")));
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return users;

class WhatIsJdbc{
  public static void main(String[] args) {
    String url = "jdbc:sqlite:path-to-db/chinook/chinook.db";
    try (Connection conn = DriverManager.getConnection(url)){

      System.out.println("Got it!");

    } catch (SQLException e) {
      throw new Error("Problem", e);
    } 
  }
}