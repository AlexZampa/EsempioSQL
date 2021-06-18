package it.polito.tdp.esempioSQL.model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LeggiBabs {

	public void run() {
		String jdbcURL = "jdbc:mysql://localhost/babs?user=root&password=root";
		try {
			Connection connection = DriverManager.getConnection(jdbcURL);	
			String sql = "SELECT NAME FROM station WHERE landmark = ?";
			
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, "Palo Alto");
			ResultSet res = st.executeQuery();
			while(res.next()) {
				String nomeStazione = res.getString("name");
				System.out.println(nomeStazione);
			}
			st.close();
		
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	public static void main(String args[]) {
		LeggiBabs babs = new LeggiBabs();
		babs.run();
	}
}
