import java.awt.Container;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class Hint extends JFrame{
	JFrame H;
	
	private JLabel hint;
	
	public static void main(String[] args) {
		new Hint();
	}
	/**
	 * 當在遊戲中因解謎而死亡，重新來過後，到達死亡點時會多一個hint按鈕，其中有小提示
	 */
	public Hint() {
		JFrame.setDefaultLookAndFeelDecorated(true); // 視窗邊界看起來像有裝飾過
		JDialog.setDefaultLookAndFeelDecorated(true); // 訊息看起來有裝飾過
		H = new JFrame("Hint");
		H.setBounds(600, 25, 800, 120); // 視窗範圍
		H.setResizable(false);
		H.setLocationRelativeTo(null);
		Container sc = H.getContentPane();
		
		H.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE); // 讓按了 x 的否之後畫面不動
		
		H.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				H.setVisible(false);
			}
		});
		
		hint = new JLabel ("請按照英文順序轉換成數字");
		Font f = new Font("正黑體", Font.BOLD, 60);
		hint.setBounds(0, 0, 800, 100);
		H.add(hint);
		hint.setFont(f);
		
	}
	/**
	 * 顯示小提示
	 */
	public void open() {
		H.setVisible(true);
	}
	
}
