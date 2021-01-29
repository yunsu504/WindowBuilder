import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import java.sql.*;
import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
public class Login {

	protected Shell shell;
	private Text textUserName;
	private Text textPassword;
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		Connection connection = null;
		
		try {
			connection = SqliteConnection.dbConnector();
			Login window = new Login();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		Label lblUserName = new Label(shell, SWT.NONE);
		lblUserName.setBounds(72, 69, 56, 15);
		lblUserName.setText("UserName");
		
		Label lblPassword = new Label(shell, SWT.NONE);
		lblPassword.setBounds(72, 134, 56, 15);
		lblPassword.setText("Password");
		
		textUserName = new Text(shell, SWT.BORDER);
		textUserName.setBounds(150, 53, 154, 46);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setBounds(72, 180, 232, 39);
		btnNewButton.setText("New Button");
		
		textPassword = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		textPassword.setBounds(150, 117, 154, 46);

	}
}
