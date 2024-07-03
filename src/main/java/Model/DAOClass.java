package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class DAOClass {
    private Connection con =null;
    private void init() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?user=root&password=sql@123");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // You can choose to throw a RuntimeException or handle this error based on your application's design
            throw new RuntimeException("Error initializing database connection", e);
        }
    }

    public int addName(String name) {

    	init();
        String query = "INSERT INTO userdetails (id, name) VALUES (?, ?)";
        int result = 0;
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, 0);
            ps.setString(2, name);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }




    public ArrayList<DTOClass> getUserDetails() {
    	init();
        java.sql.Statement stmt = null;
        ResultSet rs = null;
        ArrayList<DTOClass> userList = new ArrayList<>();
        String query = "SELECT * FROM userdetails";
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                DTOClass d1 = new DTOClass();
                d1.setId(id);
                d1.setName(name);

                userList.add(d1);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }

        return userList;
    }

	  public void closeConnection() {
	        try {
	            if (con != null && !con.isClosed()) {
	                con.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	public int updateUser(int id, String name) {
		PreparedStatement pstmt=null;
		int result=0;
		String query = "update table userdetails set name=? where id=?";

		try {
			pstmt=con.prepareStatement(query);
			pstmt.setString(1,name);
			pstmt.setInt(2, id);

			result=pstmt.executeUpdate();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
