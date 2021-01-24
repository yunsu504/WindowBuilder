import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
 
public class HelloSWT {
 
    public static void main(String[] args) {
        /* 할당과 초기화
         * GUI가 기본 플랫폼 자원에 접근 가능하도록 하고 위젯을보여주는 기본윈도우 생성
         */
        Display display = new Display();
        Shell shell = new Shell(display);
        
        /* 쉘에 위젯 추가하기
         * 컨테이너 내에서 위젯과 위젯들의 묶음은 Shell의 하위 요소로 추가.
         * 각 위젯에 리스너와 이벤트를 장착하여 사용자가 동작 할 수 있게 함.
         * org.eclipse.swt.widgets.Control.pack() 메소드는 구성요소가 필요로 하는 만큼만 화면 크기를 할당
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
        
        
        /* GUI 작동
         * shell.open() 호출시 설정한 위젯 화면이 보여진다.
         * Display객체는 readAndDispatch() 메소드를 통해 플랫폼의 이벤트 대기열에 있는 사용자 이벤트 추적
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

