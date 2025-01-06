package databaseoperation;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

	private static Connection con;
	
	private DatabaseConnection() {};
	
	static {
		
		try {
			
			// Class Loading
			Class.forName(DatabaseInfo.driver);
			
			//Creating Connection
			con=DriverManager.getConnection(DatabaseInfo.dbUrl,DatabaseInfo.dbUName,DatabaseInfo.dbPassword);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	// Method For Returning Object of Connection
	public static Connection getConnection()
	{
		return con;
	}
}
