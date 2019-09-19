import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnective {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		// String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
		// "databaseName=Fiese15;integratedSecurity=true;";
		// String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
		// "databaseName=Fiese15;integratedSecurity=true;";
		// String connectionUrl =
		// "jdbc:sqlserver://sql.freeasphost.net\\MSSQL2016;databaseName=hasanhawar_Fiese15;integratedSecurity=true;uid=hasanhawar;pwd=;providerName=System.Data.SqlClient;username=;
		// password=;";

		String userName = "hasanhawar";
		String password = "123456789";

		// String url ="jdbc:sqlserver://myDB\\SQLServer;databaseName=name";

		// Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		// Connection conn = DriverManager.getConnection(url, userName, password);

		String connectionUrl = "jdbc:sqlserver://sql.freeasphost.net\\MSSQL2016;databaseName=hasanhawar_Fiese15;";

		// jdbc:sqlserver://[serverName[\instanceName][:portNumber]][;property=value[;property=value]]

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

	}

}
