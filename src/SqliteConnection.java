import java.sql.*;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;

public class SqliteConnection {
	Connection conn = null;
	public static Connection dbConnector(){
		try{
			//sqlite jarFile이 있어야함 
			//https://javadoc.io/doc/org.xerial/sqlite-jdbc
			//https://oss.sonatype.org/content/repositories/snapshots/org/xerial/sqlite-jdbc/
			Class.forName("org.sqlite.JDBC"); 
			String url = "jdbc:sqlite:C:\\Users\\user\\Desktop\\새 폴더\\OOPSW\\WindowBuilder\\src\\DB\\EmployeeDB.sqlite";
			Connection conn = DriverManager.getConnection(url);
			JOptionPane.showMessageDialog(null, "Connection Successful");
			
			//Statement stmt = conn.createStatement();
			//String sql = "INSERT INTO EmployeeInfo VALUES (3,'hello','boner','1','1',47)";
			//int rs = stmt.executeUpdate(sql);
			//JOptionPane.showMessageDialog(null, rs);
			return conn;
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
}
//with Login