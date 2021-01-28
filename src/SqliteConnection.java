import java.sql.*;
import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;

public class SqliteConnection {
	Connection conn = null;
	public static Connection dbConnector(){
		try{
			//sqlite jarFile이 있어야함 https://javadoc.io/doc/org.xerial/sqlite-jdbc
			Class.forName("org.sqlite.JDBC"); 
			Connection conn = DriverManager.getConnection("jdbc:sqlite:‪C:\\Users\\user\\Desktop\\새 폴더\\OOPSW\\WindowBuilder\\src\\DB\\EmployeeDB.db");
			JOptionPane.showMessageDialog(null, "Connection Successful");
			return conn;
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
}
//with Login