package org.example;

import java.sql.*;
import java.util.Properties;

public class CallableStatementDemo {
	public static void main(String... args) {
		// Uncomment the following code only after
		// the database java and table person are created

/*
        String result = replace("That is original text",
                "original text", "the result");
        System.out.println(result);  //prints: That is the result
*/
	}

	private static String replace(String origText, String substr1, String substr2) {
		String result = "";
		String sql = "{ ? = call replace(?, ?, ? ) }";
		Connection conn = getConnection();
		try (conn; CallableStatement st = conn.prepareCall(sql)) {
			st.registerOutParameter(1, Types.VARCHAR);
			st.setString(2, origText);
			st.setString(3, substr1);
			st.setString(4, substr2);
			st.execute();
			result = st.getString(1);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	private static Connection getConnection() {
		String URL = "jdbc:postgresql://localhost/java";
		Properties prop = new Properties();
		prop.put("user", "student");
		// prop.put( "password", "secretPass123" );
		try {
			return DriverManager.getConnection(URL, prop);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
}