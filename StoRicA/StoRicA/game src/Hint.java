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
	 * ��b�C�����]�����Ӧ��`�A���s�ӹL��A��F���`�I�ɷ|�h�@��hint���s�A�䤤���p����
	 */
	public Hint() {
		JFrame.setDefaultLookAndFeelDecorated(true); // ������ɬݰ_�ӹ����˹��L
		JDialog.setDefaultLookAndFeelDecorated(true); // �T���ݰ_�Ӧ��˹��L
		H = new JFrame("Hint");
		H.setBounds(600, 25, 800, 120); // �����d��
		H.setResizable(false);
		H.setLocationRelativeTo(null);
		Container sc = H.getContentPane();
		
		H.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE); // �����F x ���_����e������
		
		H.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				H.setVisible(false);
			}
		});
		
		hint = new JLabel ("�Ы��ӭ^�嶶���ഫ���Ʀr");
		Font f = new Font("������", Font.BOLD, 60);
		hint.setBounds(0, 0, 800, 100);
		H.add(hint);
		hint.setFont(f);
		
	}
	/**
	 * ��ܤp����
	 */
	public void open() {
		H.setVisible(true);
	}
	
}
