package game.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnective {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		String userName = "hasanhawar";
		String password = "123456789";
		String connectionUrl = "jdbc:sqlserver://sql.freeasphost.net\\MSSQL2016;databaseName=hasanhawar_Fiese15;";

		Connection con = null;
		Statement statemetn = null;
		ResultSet rs = null;

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl, userName, password);
			System.out.println("Connection Estabilshed");

			// create and excute
			String SQL = "SELECT * from Cards";
			statemetn = con.createStatement();
			rs = statemetn.executeQuery(SQL);

			while (rs.next()) {
				System.out.println(rs.getInt(1) + "  " + rs.getInt(2) + "  " + rs.getInt(3) + "  " + rs.getInt(4)
						+ "   " + rs.getInt(5) + "  " + rs.getInt(6) + "  " + rs.getInt(7) + "  " + rs.getInt(8));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl, userName, password);
			System.out.println("Connection Estabilshed");

			// create and excute
			String SQL = "SELECT * from CardsColor";
			statemetn = con.createStatement();
			rs = statemetn.executeQuery(SQL);

			while (rs.next()) {
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  "
						+ rs.getString(4) + "   " + rs.getString(5) + "  " + rs.getString(6) + "  " + rs.getString(7));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
