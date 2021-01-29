import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import java.sql.*;
import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
public class Login {

	protected Shell shell;
	private Text textUserName;
	private Text textPassword;
	
	/**
	 * Launch the application.
	 * @param args
	 */
	static Connection connection = null;
	
	public static void main(String[] args) {
	
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
		
		Button btnLogin = new Button(shell, SWT.NONE);
		btnLogin.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try{
					String sql = "select * from EmployeeInfo where UserName = ? and Password =?";
					PreparedStatement pstmt = connection.prepareStatement(sql);
					pstmt.setString(1,textUserName.getText());
					pstmt.setString(2,textPassword.getText());
					System.out.println("before");
					ResultSet rs = pstmt.executeQuery();
					System.out.println("after");
					int count = 0;
					while (rs.next()){
						count = count + 1;
					}
					if (count == 1){
						JOptionPane.showMessageDialog(null, "Login Successful");
					}else if (count > 1){
						JOptionPane.showMessageDialog(null, "Duplicate UserInfo");
					}else{
						JOptionPane.showMessageDialog(null, "Login Faild");
					}
					rs.close();
					pstmt.close();
				}catch(Exception e1){
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnLogin.setBounds(72, 180, 232, 39);
		btnLogin.setText("Login");
		
		textPassword = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		textPassword.setBounds(150, 117, 154, 46);

	}
}
