import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class HelloJFace extends ApplicationWindow {
	private Text txtName;
	private Text txtPhone;

	/**
	 * Create the application window.
	 */
	public HelloJFace() {
		super(null);
		createActions();
		addToolBar(SWT.FLAT | SWT.WRAP);
		addMenuBar();
		addStatusLine();
	}

	/**
	 * Create contents of the application window.
	 * @param parent
	 */
	@Override
	protected Control createContents(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		
		Label lblName = new Label(container, SWT.NONE);
		lblName.setBounds(10, 10, 56, 15);
		lblName.setText("이름  : ");
		
		Label lblPhonelabel = new Label(container, SWT.NONE);
		lblPhonelabel.setBounds(10, 46, 68, 15);
		lblPhonelabel.setText("전화번호 : ");
		
		Label lblGubun = new Label(container, SWT.NONE);
		lblGubun.setText("구분 : ");
		lblGubun.setBounds(10, 78, 34, 15);
		
		txtName = new Text(container, SWT.BORDER);
		txtName.setBounds(72, 7, 126, 21);
		
		Combo cbGubun = new Combo(container, SWT.NONE);
		cbGubun.setItems(new String[] {"가족", "친구"});
		cbGubun.setBounds(72, 75, 126, 23);
		
		txtPhone = new Text(container, SWT.BORDER);
		txtPhone.setBounds(72, 40, 126, 21);
		
		Button btnAdd = new Button(container, SWT.NONE);
		btnAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println(
						"이름 : "+ txtName.getText()+","
						+ " 전화번호 : "+ txtPhone.getText()+", "
						+ "구분: "+ cbGubun.getItem(cbGubun.getSelectionIndex()));
			}
		});
		btnAdd.setBounds(72, 121, 76, 25);
		btnAdd.setText("추가");

		return container;
	}

	/**
	 * Create the actions.
	 */
	private void createActions() {
		// Create the actions
	}

	/**
	 * Create the menu manager.
	 * @return the menu manager
	 */
	@Override
	protected MenuManager createMenuManager() {
		MenuManager menuManager = new MenuManager("menu");
		return menuManager;
	}

	/**
	 * Create the toolbar manager.
	 * @return the toolbar manager
	 */
	@Override
	protected ToolBarManager createToolBarManager(int style) {
		ToolBarManager toolBarManager = new ToolBarManager(style);
		return toolBarManager;
	}

	/**
	 * Create the status line manager.
	 * @return the status line manager
	 */
	@Override
	protected StatusLineManager createStatusLineManager() {
		StatusLineManager statusLineManager = new StatusLineManager();
		return statusLineManager;
	}

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			HelloJFace window = new HelloJFace();
			window.setBlockOnOpen(true);
			window.open();
			Display.getCurrent().dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Configure the shell.
	 * @param newShell
	 */
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("주소록");
	}

	/**
	 * Return the initial size of the window.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(450, 300);
	}
}
