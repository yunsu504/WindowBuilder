import javax.swing.JOptionPane;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
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
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;

public class NewJFace extends ApplicationWindow {
	private Text txtName;
	private Text txtPhone;
	private Text txt_1;
	private Text text;

	/**
	 * Create the application window.
	 */
	public NewJFace() {
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
		{
			Label lblName = new Label(container, SWT.NONE);
			lblName.setText("이름 : ");
			lblName.setBounds(10, 10, 56, 15);
		}
		{
			Label lblPhone = new Label(container, SWT.NONE);
			lblPhone.setText("전화번호 : ");
			lblPhone.setBounds(10, 41, 56, 15);
		}
		{
			txtName = new Text(container, SWT.BORDER);
			txtName.setBounds(72, 7, 110, 21);
		}
		{
			txtPhone = new Text(container, SWT.BORDER);
			txtPhone.setBounds(72, 41, 110, 21);
		}
		{
			Combo cbGubun = new Combo(container, SWT.NONE);
			cbGubun.setItems(new String[] {"가족", "친구"});
			cbGubun.setBounds(72, 77, 110, 23);
		}
		{
			Button btnAdd = new Button(container, SWT.NONE);
			btnAdd.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					JOptionPane.showMessageDialog(null, "Hi Message");
				}
			});
			btnAdd.setImage(SWTResourceManager.getImage(NewJFace.class, "/javax/swing/plaf/metal/icons/Question.gif"));
			
			btnAdd.setBounds(25, 106, 243, 73);
			btnAdd.setSize(136,49);
			btnAdd.setText("추가");
		}
		{
			Label lblGubun = new Label(container, SWT.NONE);
			lblGubun.setBounds(10, 77, 56, 15);
			lblGubun.setText("구분 :");
		}
		
		TabFolder tabFolder = new TabFolder(container, SWT.NONE);
		tabFolder.setBounds(224, 11, 149, 89);
		
		TabItem tbtm1 = new TabItem(tabFolder, SWT.NONE);
		tbtm1.setText("첫번쨰");
		{
			txt_1 = new Text(tabFolder, SWT.BORDER);
			txt_1.setText("1st");
			tbtm1.setControl(txt_1);
		}
		{
			TabItem tbtm2 = new TabItem(tabFolder, SWT.NONE);
			tbtm2.setText("두번째");
			
			Button btn2 = new Button(tabFolder, SWT.NONE);
			tbtm2.setControl(btn2);
			btn2.setText("2nd");
		}
		{
			TabItem tbtm3 = new TabItem(tabFolder, SWT.NONE);
			tbtm3.setText("세번째");
		}
		
		text = new Text(container, SWT.BORDER);
		text.setBounds(35, 157, 73, 21);
		
		ControlDecoration controlDecoration = new ControlDecoration(text, SWT.LEFT | SWT.TOP);
		controlDecoration.setDescriptionText("Some description");
		
		Image image = FieldDecorationRegistry.
	                getDefault().
	                getFieldDecoration(FieldDecorationRegistry.DEC_ERROR_QUICKFIX).
	                getImage();
	      
	      controlDecoration.setImage(image);
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
			NewJFace window = new NewJFace();
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
		newShell.setText("New Application");
	}

	/**
	 * Return the initial size of the window.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(450, 300);
	}
}
