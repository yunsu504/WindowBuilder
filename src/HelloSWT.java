import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
 
public class HelloSWT {
 
    public static void main(String[] args) {
        /* �Ҵ�� �ʱ�ȭ
         * GUI�� �⺻ �÷��� �ڿ��� ���� �����ϵ��� �ϰ� �����������ִ� �⺻������ ����
         */
        Display display = new Display();
        Shell shell = new Shell(display);
        
        /* ���� ���� �߰��ϱ�
         * �����̳� ������ ������ �������� ������ Shell�� ���� ��ҷ� �߰�.
         * �� ������ �����ʿ� �̺�Ʈ�� �����Ͽ� ����ڰ� ���� �� �� �ְ� ��.
         * org.eclipse.swt.widgets.Control.pack() �޼ҵ�� ������Ұ� �ʿ�� �ϴ� ��ŭ�� ȭ�� ũ�⸦ �Ҵ�
         */
        Text helloText = new Text(shell, SWT.CENTER);
        DateTime dateTime = new DateTime(shell,SWT.CALENDAR);
        String d = dateTime.getToolTipText();
        shell.setText("List ExamPle");
        shell.setBounds(100,100,1000,1000);
        shell.setLayout(new FillLayout());
        
        helloText.setText("Hello SWT");
        
        helloText.pack();
        shell.pack();
        
        
        /* GUI �۵�
         * shell.open() ȣ��� ������ ���� ȭ���� ��������.
         * Display��ü�� readAndDispatch() �޼ҵ带 ���� �÷����� �̺�Ʈ ��⿭�� �ִ� ����� �̺�Ʈ ����
         */
        
        shell.open();
        while (!shell.isDisposed()) {
            if(!display.readAndDispatch()) {
                display.sleep();
            }
        }
        
        display.dispose();
    }
}

