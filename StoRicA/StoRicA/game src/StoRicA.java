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
	 * 建立視窗，設定視窗的大小、位置、顯示、隱藏、執行動作
	 */
	static JFrame P;
	/**
	 * 建立一個暫時儲存物件的地方
	 */
	private Container sc;
	/**
	 * 當你要作畫時要先放上畫布或畫紙，此為一樣道理
	 */
	private JLayeredPane a;
	/**
	 * 設立背景的物件，以此執行Class BACK 中的各個方法
	 */
	private Back bg;
	/**
	 * 撥放音樂的物件，以此執行 Class MUSIC 中的各個方法
	 */
	public static MUSIC song;

	public static void main(String[] args) {
		new StoRicA();
	}

	/**
	 * 設計首頁
	 */
	public StoRicA() {
		JFrame.setDefaultLookAndFeelDecorated(true); // 視窗邊界看起來像有裝飾過
		JDialog.setDefaultLookAndFeelDecorated(true); // 訊息看起來有裝飾過
		P = new JFrame("GAME [StoRicA]");
		P.setBounds(25, 25, 1225, 750); // 視窗範圍
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
		
		JButton start = new JButton("開始遊戲"); // 按鈕
		start.setBounds(400, 475, 450, 100); // 按鈕範圍
		addObj(start,1);
		start.addActionListener(new ActionHandler());

		Font f = new Font("Serif", Font.BOLD, 40); // 改按鈕字體大小與字體
		start.setFont(f);

		JLabel l2 = new JLabel("S");
		l2.setBounds(250, 75, 750, 300);
		addObj(l2,1);

		JLabel l1 = new JLabel("toRicA"); // 文字
		l1.setBounds(400, 125, 750, 200); // 文字範圍(x軸,y軸,寬,高)
		addObj(l1,1);

		l2.setForeground(Color.blue); // 改文字顏色
		l1.setForeground(Color.white);

		l2.setFont(new Font("Serif", Font.PLAIN, 300)); // 改文字大小與字體
		l1.setFont(new Font("Serif", Font.PLAIN, 200));
		
		P.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE); // 讓按了 x 的否之後畫面不動

		P.addWindowListener(new WindowAdapter() {
			/**
			 * 點選關閉按鈕時，跳出一個視窗，確認是否要執行動作
			 */
			public void windowClosing(WindowEvent e) {
				int result = JOptionPane.showConfirmDialog(P, "確定要結束遊戲嗎?", "確認訊息", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					System.exit(0);
				}

			}
		});
	}
	
	/**
	 * 添加按鈕
	 */
	private void addObj(JButton b,int layer) {
		a.add(b);
		a.setLayer(b,layer);
	}
	/**
	 * 添加標籤(顯示文字的地方)
	 */
	private void addObj(JLabel b,int layer) {
		a.add(b);
		a.setLayer(b,layer);
	}
	/**
	 * StoRicA為首頁，當開始遊戲後將首頁隱藏起來
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