import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;

import net.proteanit.sql.DbUtils;

import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import java.sql.*;
import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;

public class EmployeeInfo {

	protected Shell shell;
	private Table table;
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			EmployeeInfo window = new EmployeeInfo();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	
	private Connection connection = null;
	private TableColumn tblclmnNewColumn;
	private TableColumn tblclmnNewColumn_1;
	private TableColumn tblclmnNewColumn_2;
	private TableColumn tblclmnNewColumn_3;
	private TableColumn tblclmnNewColumn_4;
	
	private TableItem tableItem;
	public void open() {
		connection  = SqliteConnection.dbConnector();
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
		
		ScrolledComposite scrolledComposite = new ScrolledComposite(shell, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setBounds(26, 41, 373, 180);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		
		table = new Table(scrolledComposite, SWT.BORDER | SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(30);
		tblclmnNewColumn.setText("EID");
		
		tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(60);
		tblclmnNewColumn_1.setText("Name");
		
		tblclmnNewColumn_2 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_2.setWidth(60);
		tblclmnNewColumn_2.setText("Surname");
		
		tblclmnNewColumn_3 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_3.setWidth(50);
		tblclmnNewColumn_3.setText("Username");
		
		tblclmnNewColumn_4 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_4.setWidth(50);
		tblclmnNewColumn_4.setText("Age");
		
		Button btnLoadTable = new Button(shell, SWT.NONE);
		btnLoadTable.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					String sql = "select * from EmployeeInfo";
					PreparedStatement pstmt = connection.prepareStatement(sql);
					ResultSet rs = pstmt.executeQuery();
					System.out.println(rs.getString(1) + " and "+ rs.getString(2)+ " and "+ rs.getString(3)+ " and "+ rs.getString(4)+ " and "+ rs.getString(5));
					 
					while (rs.next()) {
						tableItem = new TableItem(table, SWT.NONE);
						tableItem.setText(0, rs.getString(1));
						tableItem.setText(1, rs.getString(2));
						tableItem.setText(2,rs.getString(3));
						tableItem.setText(3,rs.getString(4));
						tableItem.setText(4,rs.getString(6));
						scrolledComposite.setContent(table);
						scrolledComposite.setMinSize(table.computeSize(SWT.DEFAULT, SWT.DEFAULT));
					    }
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnLoadTable.setBounds(102, 10, 230, 25);
		btnLoadTable.setText("Load Employee Data");

	}
}
