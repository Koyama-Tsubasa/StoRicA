import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class StoRicA extends JFrame{
	/**
	 * �إߵ����A�]�w�������j�p�B��m�B��ܡB���áB����ʧ@
	 */
	static JFrame P;
	/**
	 * �إߤ@�ӼȮ��x�s���󪺦a��
	 */
	private Container sc;
	/**
	 * ��A�n�@�e�ɭn����W�e���εe�ȡA�����@�˹D�z
	 */
	private JLayeredPane a;
	/**
	 * �]�߭I��������A�H������Class BACK �����U�Ӥ�k
	 */
	private Back bg;
	/**
	 * ���񭵼֪�����A�H������ Class MUSIC �����U�Ӥ�k
	 */
	public static MUSIC song;

	public static void main(String[] args) {
		new StoRicA();
	}

	/**
	 * �]�p����
	 */
	public StoRicA() {
		JFrame.setDefaultLookAndFeelDecorated(true); // ������ɬݰ_�ӹ����˹��L
		JDialog.setDefaultLookAndFeelDecorated(true); // �T���ݰ_�Ӧ��˹��L
		P = new JFrame("GAME [StoRicA]");
		P.setBounds(25, 25, 1225, 750); // �����d��
		P.setResizable(false);
		P.setLocationRelativeTo(null);
		P.setVisible(true);
		sc = P.getContentPane();
		a = new JLayeredPane();
		setContentPane(a);
		sc.add(a);

		bg = new Back("bbb",1);
		bg.setPos(0,0);
		addObj(bg,0);
		
		song = new MUSIC("/music.wav");
		song.setVolume(0.95f);
		song.loop();
		
		JButton start = new JButton("�}�l�C��"); // ���s
		start.setBounds(400, 475, 450, 100); // ���s�d��
		addObj(start,1);
		start.addActionListener(new ActionHandler());

		Font f = new Font("Serif", Font.BOLD, 40); // ����s�r��j�p�P�r��
		start.setFont(f);

		JLabel l2 = new JLabel("S");
		l2.setBounds(250, 75, 750, 300);
		addObj(l2,1);

		JLabel l1 = new JLabel("toRicA"); // ��r
		l1.setBounds(400, 125, 750, 200); // ��r�d��(x�b,y�b,�e,��)
		addObj(l1,1);

		l2.setForeground(Color.blue); // ���r�C��
		l1.setForeground(Color.white);

		l2.setFont(new Font("Serif", Font.PLAIN, 300)); // ���r�j�p�P�r��
		l1.setFont(new Font("Serif", Font.PLAIN, 200));
		
		P.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE); // �����F x ���_����e������

		P.addWindowListener(new WindowAdapter() {
			/**
			 * �I���������s�ɡA���X�@�ӵ����A�T�{�O�_�n����ʧ@
			 */
			public void windowClosing(WindowEvent e) {
				int result = JOptionPane.showConfirmDialog(P, "�T�w�n�����C����?", "�T�{�T��", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					System.exit(0);
				}

			}
		});
	}
	
	/**
	 * �K�[���s
	 */
	private void addObj(JButton b,int layer) {
		a.add(b);
		a.setLayer(b,layer);
	}
	/**
	 * �K�[����(��ܤ�r���a��)
	 */
	private void addObj(JLabel b,int layer) {
		a.add(b);
		a.setLayer(b,layer);
	}
	/**
	 * StoRicA�������A��}�l�C����N�������ð_��
	 */
	public StoRicA(int num) {
		if (num==1) {
			StoRicA.P.setVisible(false);
			StoRicA.song.stop();
		}
		else if (num==2) {
			StoRicA.P.setVisible(true);
			StoRicA.song.loop();
		}
	}

}