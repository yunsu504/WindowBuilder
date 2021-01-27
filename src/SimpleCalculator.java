import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

public class SimpleCalculator {

	protected Shell shell;
	private Text textField_1;
	private Text textField_2;
	private Text textAnswer;
	public float answer;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			SimpleCalculator window = new SimpleCalculator();
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
		shell.setSize(458, 333);
		shell.setText("SWT Application");
		
		textField_1 = new Text(shell, SWT.BORDER);
		textField_1.setBounds(10, 30, 193, 40);
		
		textField_2 = new Text(shell, SWT.BORDER);
		textField_2.setBounds(230, 30, 194, 40);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int num1, num2, answer;
				try{
					num1 = Integer.parseInt(textField_1.getText());
					num2 = Integer.parseInt(textField_2.getText());
					answer = num1 + num2 ;
					textAnswer.setText(Integer.toString(answer));
				}catch(Exception e1){
					JOptionPane.showMessageDialog(null, "Please inset valid number");
				}
				
			}
		});
		btnNewButton.setBounds(28, 116, 76, 25);
		btnNewButton.setText("ADD");
		
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int num1, num2, answer;
				try{
					num1 = Integer.parseInt(textField_1.getText());
					num2 = Integer.parseInt(textField_2.getText());
					answer = num1 - num2 ;
					textAnswer.setText(Integer.toString(answer));
				}catch(Exception e1){
					JOptionPane.showMessageDialog(null, "Please inset valid number");
				}
			}
		});
		btnNewButton_1.setBounds(214, 116, 76, 25);
		btnNewButton_1.setText("MINUS");
		
		textAnswer = new Text(shell, SWT.BORDER);
		
		textAnswer.setFont(SWTResourceManager.getFont("¸¼Àº °íµñ", 12, SWT.BOLD));
		textAnswer.setBounds(135, 213, 156, 33);
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("¸¼Àº °íµñ", 13, SWT.BOLD));
		lblNewLabel.setBounds(28, 214, 101, 46);
		lblNewLabel.setText("Answer :");
		
		

	}
}
