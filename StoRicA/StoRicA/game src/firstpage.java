
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class firstpage extends JFrame{
	/**
	 * 建立視窗，設定視窗的大小、位置、顯示、隱藏、執行動作
	 */
	JFrame S;
	/**
	 * 故事中的章節數、段落
	 */
	STORY s;
	/**
	 * 點擊次數
	 */
	private int t=-1;
	/**
	 * 章節數
	 */
	private int c=1;
	/**
	 * 讀取選第幾個選項
	 */
	private int pp=0;
	/**
	 * 正確選項
	 */
	private int TRUE=0;
	/**
	 * 解謎的地方用到的物件
	 */
	private int T=0;
	/**
	 * 解謎的地方，需要輸入幾個東西
	 */
	private int count=0;
	/**
	 * 會死亡的選項，有沒有至少2次
	 */
	private int run2=0;
	/**
	 * 章節的標題
	 */
	private JLabel cap;
	/**
	 * 下方的文字敘述
	 */
	private NewLabel sen1;
	/**
	 * 下方的文字敘述
	 */
	private NewLabel sen2;
	/**
	 * 變更章節時會跳出來大大的章節標題
	 */
	private NewLabel form;
	private NewTextarea cl;
	/**
	 * 壞結局的文字
	 */
	private NewLabel Bad_End1;
	/**
	 * 第1個壞結局
	 */
	private NewLabel Bad_End2;
	/**
	 * 第2個壞結局
	 */
	private NewLabel Bad_End3;
	/**
	 * 死亡後的黑畫面
	 */
	private NewLabel Bad;
	/**
	 * 背景圖片
	 */
	private Back bg;
	/**
	 * 人物圖片
	 */
	private CHA cha;
	/**
	 * 背景聲
	 */
	private MUSIC songb,cry;
	/**
	 * 崩塌聲
	 */
	private MUSIC bomb;
	/**
	 * 警告聲
	 */
	private MUSIC warn;
	/**
	 * 嗶嗶聲
	 */
	private MUSIC heart;
	/**
	 * 緊張聲
	 */
	private MUSIC tense;
	/**
	 * 下方的文字敘述塞不下，放到畫面中間
	 */
	private NewTextarea b;
	/**
	 * 解謎時用到的物件
	 */
	private NewTextarea bb;
	/**
	 * 最終結局
	 */
	private NewTextarea fi;
	/**
	 * 工作人員列表
	 */
	private NewTextarea whodo;
	/**
	 * 當你要作畫時要先放上畫布或畫紙，此為一樣道理
	 */
	private JLayeredPane p;

	public static void main(String[] args) {
		new firstpage();
	}
	/**
	 * 主程式畫面:<br/>
	 * 因為我們的遊戲沒有back，只有next，所以是藉由累積點擊next次數來run的<br/>
	 * 下面看起來很長其實大部分都是一樣的
	 */
	public firstpage() {
		JFrame.setDefaultLookAndFeelDecorated(true); // 視窗邊界看起來像有裝飾過
		JDialog.setDefaultLookAndFeelDecorated(true); // 訊息看起來有裝飾過
		S = new JFrame("GAME [StoRicA]");
		S.setBounds(25, 25, 1225, 750); // 視窗範圍
		S.setResizable(false);
		S.setLocationRelativeTo(null);
		Container sc = S.getContentPane();
        p = new JLayeredPane();
		setContentPane(p);
		sc.add(p);
		
		
		S.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE); // 讓按了 x 的否之後畫面不動

		S.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				int result = JOptionPane.showConfirmDialog(S, "確定要結束遊戲嗎?", "確認訊息", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		
		Font f = new Font("Serif", Font.BOLD, 35);
		
		JButton h = new JButton("Hint");
		h.setBounds(1000,25,150,50);
		addObj(h,3);
		h.setFont(f);
		h.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Hint hint = new Hint();
				hint.open();
			}
		});
		h.setVisible(false);
		
 		bg = new Back("bcg",11);
		bg.setPos(20,85);
		addObj(bg,0);
		
		cha = new CHA("cha",5);
		cha.setPos(250, 160);
		addObj(cha,1);
		
		songb = new MUSIC("/new_normal-1.wav");
		songb.setVolume(0.9f);
		songb.loop();
		cry = new MUSIC("/background.wav");
		cry.setVolume(0.9f);
		tense = new MUSIC("/緊張音樂.wav");
		tense.setVolume(0.9f);
		warn = new MUSIC("/warning.wav");
		warn.setVolume(0.7f);
		bomb = new MUSIC("/崩塌2.wav");
		bomb.setVolume(0.8f);
		heart = new MUSIC("/嗶嗶聲.wav");
		heart.setVolume(1.0f);
		
		JButton next = new JButton("Next");
		next.setBounds(1030,620,150,50);
		addObj(next,2);
		next.setFont(f);
		refresh();
		
		if (t==-1 && c==1) {
			form = new NewLabel("           Chapter 1 - 1:  < 意外 > ",false,"正黑體",Font.PLAIN,60,Color.WHITE,new Color(0,0,0,200));
			addObj(form,2);
			form.setBounds(100,275,1000,90);
			cha.setVisible(false);
		}
		
		s = new STORY(1);
		cap = new NewLabel("	Chapter 1 - 1:  < 意外 > ",false,"Serif",Font.PLAIN,35,Color.black,new Color(20, 180, 255, 110));
		cap.setBounds(20,25,1175,50);
		addObj(cap,1);
		cap.setFont(new Font("Serif", Font.PLAIN, 35));
		refresh();
		
		cl = new NewTextarea("",true,"正黑體",Font.PLAIN,30,Color.black,new Color(0,0,0,0));
		addObj(cl,2);
		cl.setBounds(20,85,1140,490);
		cl.setVisible(false);
		
		sen1 = new NewLabel(s.st(),false,"正黑體",Font.PLAIN,30,Color.black,new Color(255,255,255,220));
		addObj(sen1,2);
		sen1.setBounds(30,575,1155,50);
		sen2 = new NewLabel(s.st(),false,"正黑體",Font.PLAIN,30,Color.black,new Color(255,255,255,220));
		addObj(sen2,2);
		sen2.setBounds(30,625,1155,50);
		refresh();
		
		Bad_End1 = new NewLabel("               BAD END",false,"Serif",Font.PLAIN,100,Color.white,new Color(0,0,0,235));
		addObj(Bad_End1,2);
		Bad_End1.setBounds(20,85,1175,475);
		Bad_End2 = new NewLabel("                   命運的錯誤選擇",false,"Serif",Font.PLAIN,70,Color.white,new Color(0,0,0,235));
		addObj(Bad_End2,3);
		Bad_End2.setBounds(20,475,1175,100);
		Bad_End3 = new NewLabel("                      急躁的後果",false,"Serif",Font.PLAIN,70,Color.white,new Color(0,0,0,235));
		addObj(Bad_End3,4);
		Bad_End3.setBounds(20,475,1175,100);
		Bad_End1.setVisible(false);
		Bad_End2.setVisible(false);
		Bad_End3.setVisible(false);
		
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					t++;
					
					if (t==4 && c==1) cha.setState(2);
					else if (t==8 && c==1) cha.setState(0);
					else if (t==9 && c==1) cha.setState(4);
					else if (t==6 && c==11) cha.setState(1);
					else if (t==11 && c==13) cha.setState(1);
					else if (t==21 && c==13 && pp==1) cha.setState(1);
					else if (t==16 && c==13 && pp==3) cha.setState(3);
					else if (t==18 && c==13 && pp==3) cha.setState(1);
					else if (t==20 && c==13 && pp==3) cha.setState(4);
					else if (t==23 && c==13 && pp==3) cha.setState(1);
					else if (t==12 && c==2) cha.setState(3);
					else if (t==27 && c==2 && pp==2) {
						tense.stop();
						songb.replay();
						songb.loop();
						cha.setState(0);
					}
					else if (t==28 && c==2 && pp==2) cha.setState(1);
					else if (t==30 && c==2 && pp==2) cha.setState(2);
					else if (t==33 && c==2) cha.setState(4);
					else if (t==40 && c==2) cha.setState(0);
					else if (t==77 && c==2) {
						cha.setVisible(true);
						cha.setState(1);
					}
					else if (t==79 && c==2) cha.setState(1);
					else if (t==88 && c==2) cha.setState(0);
					else if (t==91 && c==2) cha.setState(4);
					else if (t==93 && c==2) cha.setState(0);
					else if (t==94 && c==2) cha.setState(2);
					else if (t==101 && c==2) cha.setState(4);
					else if (t==103 && c==2) cha.setState(1);
					else if (t==106 && c==2) cha.setState(0);
					else if (t==3 && c==3) cha.setState(4);
					else if (t==5 && c==3) cha.setState(0);
					else if (t==14 && c==3) cha.setState(2);
					
					if (t==31 && c==2) bg.setState(5);
					else if (t==46 && c==2) bg.setState(2);
					else if (t==57 && c==2) bg.setState(6);
					else if (t==75 && c==2) bg.setState(10);
					else if (t==109 && c==2) bg.setState(5);
					
					if (t==0 && c==1) {
						cha.setState(3);
						cha.setVisible(true);
						form.setVisible(false);
					}
					
					if (t==45 && c==13) {
						bg.setState(2);
						cry.stop();
						songb.replay();
						songb.loop();
						form.setText("	       Chapter 1 - 2:  < 倒數 > ");
						form.setVisible(true);
						cha.setState(0);
						cap.setText("Chapter 1 - 2:  < 倒數 > ");
						t=0;
						s.change(-1);
						s.change_CHAPTER(2);
						c=2;
						cha.setVisible(false);
					}
					if (t==1 && c==2) {
						cha.setVisible(true);
						form.setVisible(false);
					}
					
					if (c==2 && t==115) {
						bg.setState(7);
						s.change(-1);
						s.change_CHAPTER(3);
						t=0;
						form.setText("	       Chapter 1 - 3:  < 下一步 > ");
						form.setVisible(true);
						cap.setText("Chapter 1 - 3:  < 下一步 > ");
						c=3;
						cha.setVisible(false);
					}
					if (c==3 && t==1) {
						cha.setVisible(true);
						form.setVisible(false);
					}
					
					if (t==7 && c==1) {
						
						cha.setState(0);
						next.setVisible(false);
						JButton fc1 = new JButton(s.c());
						fc1.setBounds(100,230,700,50); // 按鈕範圍
						addObj(fc1,2);
						
						JButton fc2 = new JButton(s.c());
						fc2.setBounds(100,310,350,50); // 按鈕範圍
						addObj(fc2,2);
						
						JButton fc3 = new JButton(s.c());
						fc3.setBounds(100,390,300,50); // 按鈕範圍
						addObj(fc3,2);
						
						Font f = new Font("Serif", Font.BOLD, 30); // 改按鈕字體大小與字體
						fc1.setFont(f);
						fc2.setFont(f);
						fc3.setFont(f);
						
						fc1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								s.change(15);
								fc1.setVisible(false);
								fc2.setVisible(false);
								fc3.setVisible(false);
								sen1.setText(s.st());
								sen2.setText(s.st());
								refresh();
								s.change(23);
								next.setVisible(true);
								cha.setVisible(true);
							}
						});
						
						fc2.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								s.change(17);
								fc1.setVisible(false);
								fc2.setVisible(false);
								fc3.setVisible(false);
								sen1.setText(s.st());
								sen2.setText(s.st());
								refresh();
								s.change(23);
								next.setVisible(true);
								cha.setVisible(true);
							}
						});
						
						fc3.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								s.change(19);
								cha.setState(4);
								fc1.setVisible(false);
								fc2.setVisible(false);
								fc3.setVisible(false);
								sen1.setText(s.st());
								sen2.setText(s.st());
								refresh();
								s.change(23);
								next.setVisible(true);
								cha.setVisible(true);
							}
						});
						s.change(21);
					}
					
					if (t==11 && c==1) {
						
						cha.setVisible(false);
						
						next.setVisible(false);
						
						JButton fc1 = new JButton("<html>"+s.c()+"</html>");
						fc1.setBounds(100,240,1000,100); // 按鈕範圍
						addObj(fc1,2);
						
						JButton fc2 = new JButton(s.c());
						fc2.setBounds(100,390,1000,60); // 按鈕範圍
						addObj(fc2,2);
						
						Font f = new Font("Serif", Font.BOLD, 30); // 改按鈕字體大小與字體
						fc1.setFont(f);
						fc2.setFont(f);
						
						fc1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								cha.setState(0);
								c=11;
								t=0;
								s.change_CHAPTER(11);
								s.change(1);
								fc1.setVisible(false);
								fc2.setVisible(false);
								sen1.setText(s.st());
								sen2.setText(s.st());
								refresh();
								next.setVisible(true);
								cha.setVisible(true);
							}
						});
						
						fc2.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								c=12;
								t=0;
								s.change_CHAPTER(12);
								s.change(1);
								fc1.setVisible(false);
								fc2.setVisible(false);
								sen1.setText(s.st());
								sen2.setText(s.st());
								refresh();
								next.setVisible(true);
								cha.setVisible(true);
							}
						});
						s.change(29);
					}
					
					if (t==15 && c==13) {

						cha.setVisible(false);
						
						next.setVisible(false);
						JButton fc1 = new JButton(s.c());
						fc1.setBounds(100,230,460,50); // 按鈕範圍
						addObj(fc1,2);
						
						JButton fc2 = new JButton(s.c());
						fc2.setBounds(100,310,800,50); // 按鈕範圍
						addObj(fc2,2);
						
						JButton fc3 = new JButton(s.c());
						fc3.setBounds(100,390,600,50); // 按鈕範圍
						addObj(fc3,2);
						
						Font f = new Font("Serif", Font.BOLD, 30); // 改按鈕字體大小與字體
						fc1.setFont(f);
						fc2.setFont(f);
						fc3.setFont(f);
						
						fc1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								cha.setState(2);
								pp=1;
								s.change(13);
								fc1.setVisible(false);
								fc2.setVisible(false);
								fc3.setVisible(false);
								sen1.setText(s.st());
								sen2.setText(s.st());
								refresh();
								next.setVisible(true);
								cha.setVisible(true);
							}
						});
						
						fc2.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								cha.setState(1);
								pp=2;
								s.change(43);
								fc1.setVisible(false);
								fc2.setVisible(false);
								fc3.setVisible(false);
								sen1.setText(s.st());
								sen2.setText(s.st());
								refresh();
								next.setVisible(true);
								cha.setVisible(true);
							}
						});
						
						fc3.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								cha.setState(3);
								pp=3;
								s.change(67);
								fc1.setVisible(false);
								fc2.setVisible(false);
								fc3.setVisible(false);
								sen1.setText(s.st());
								sen2.setText(s.st());
								refresh();
								next.setVisible(true);
								cha.setVisible(true);
							}
						});
						s.change(84);
					}
					
                    if (t==21 && c==2) {
						
                    	cha.setVisible(false);
                    	
						next.setVisible(false);
						
						JButton fc1 = new JButton(s.c());
						fc1.setBounds(100,240,1000,60); // 按鈕範圍
						addObj(fc1,2);
						
						JButton fc2 = new JButton(s.c());
						fc2.setBounds(100,390,1000,60); // 按鈕範圍
						addObj(fc2,2);
						
						Font f = new Font("Serif", Font.BOLD, 30); // 改按鈕字體大小與字體
						fc1.setFont(f);
						fc2.setFont(f);
						
						fc1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								s.change(43);
								pp=1;
								fc1.setVisible(false);
								fc2.setVisible(false);
								sen1.setText(s.st());
								sen2.setText(s.st());
								refresh();
								next.setVisible(true);
								cha.setVisible(true);
							}
						});
						
						fc2.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								s.change(59);
								pp=2;
								fc1.setVisible(false);
								fc2.setVisible(false);
								sen1.setText(s.st());
								sen2.setText(s.st());
								refresh();
								next.setVisible(true);
								cha.setVisible(true);
							}
						});
						s.change(-1);
					}
                    
                    if (t==28 && c==2 && pp==1) {
                    	
                    	cha.setVisible(false);
                    	bomb.stop();
                    	
						next.setVisible(false);
						Bad_End1.setVisible(false);
						Bad_End2.setVisible(false);
						Bad_End3.setVisible(false);
						Bad = new NewLabel("",false,"Serif",Font.PLAIN,100,Color.white,new Color(0,0,0,235));
						addObj(Bad,2);
						Bad.setBounds(20,85,1175,575);
						
						JButton fc1 = new JButton("從  1 - 1 重新開始");
						fc1.setBounds(100,240,1000,90); // 按鈕範圍
						addObj(fc1,3);
						
						JButton fc2 = new JButton("從 1 - 2 重新開始");
						fc2.setBounds(100,350,1000,90); // 按鈕範圍
						addObj(fc2,3);
					
						JButton fc3 = new JButton("結束遊戲");
						fc3.setBounds(100,460,1000,90); // 按鈕範圍
						addObj(fc3,3);
						
						Font f = new Font("Serif", Font.BOLD, 60); // 改按鈕字體大小與字體
						fc1.setFont(f);
						fc2.setFont(f);
						fc3.setFont(f);
						
						fc1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								close();
								firstpage f = new firstpage();
								f.open();
								
							}
						});
						
						fc2.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								bg.setState(2);
								cha.setVisible(false);
								t=44;
								c=13;
								s.changeBG(6);
								s.changeChoice(7);
								fc1.setVisible(false);
								fc2.setVisible(false);
								fc3.setVisible(false);
								Bad.setVisible(false);
								refresh();
								next.setVisible(true);
								sen1.setText("             REDO CHAPTER 1 - 2");
								sen2.setText("");
							}
						});
						
						fc3.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								System.exit(0);
							}
						});
						s.change(-1);
					}
                    
                    if (t==47 && c==2) {
                    	
						next.setVisible(false);
						
						JButton fc1 = new JButton(s.c());
						fc1.setBounds(100,240,1000,60); // 按鈕範圍
						addObj(fc1,2);
						
						JButton fc2 = new JButton(s.c());
						fc2.setBounds(100,390,1000,60); // 按鈕範圍
						addObj(fc2,2);
						
						Font f = new Font("Serif", Font.BOLD, 30); // 改按鈕字體大小與字體
						fc1.setFont(f);
						fc2.setFont(f);
						
						fc1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								s.change(113);
								pp=1;
								fc1.setVisible(false);
								fc2.setVisible(false);
								sen1.setText(s.st());
								sen2.setText(s.st());
								refresh();
								next.setVisible(true);
								b.setText(s.b());
								addObj(b,2);
								b.setBounds(25,150,1160,400);
								b.setVisible(true);
								cl.setVisible(true);
							}
						});
						
						fc2.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								s.change(137);
								pp=2;
								fc1.setVisible(false);
								fc2.setVisible(false);
								sen1.setText(s.st());
								sen2.setText(s.st());
								refresh();
								bg.setState(6);
								next.setVisible(true);
								t=57;
								s.changeBG(10);
							}
						});
						s.change(-1);
					}
                    
                    if (t==48 && c==2 && pp==1) {
                    	
						next.setVisible(false);
						
						JButton fc1 = new JButton(s.c());
						fc1.setBounds(100,240,1000,60); // 按鈕範圍
						addObj(fc1,2);
						
						JButton fc2 = new JButton(s.c());
						fc2.setBounds(100,390,1000,60); // 按鈕範圍
						addObj(fc2,2);
						
						Font f = new Font("Serif", Font.BOLD, 30); // 改按鈕字體大小與字體
						fc1.setFont(f);
						fc2.setFont(f);
						
						fc1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								s.change(119);
								pp=1;
								fc1.setVisible(false);
								fc2.setVisible(false);
								sen1.setText(s.st());
								sen2.setText(s.st());
								refresh();
								next.setVisible(true);
							}
						});
						
						fc2.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								s.change(137);
								pp=2;
								fc1.setVisible(false);
								fc2.setVisible(false);
								sen1.setText(s.st());
								sen2.setText(s.st());
								refresh();
								next.setVisible(true);
								bg.setState(6);
								t=57;
								s.changeBG(10);
							}
						});
						s.change(117);
					}
					
                    if (t==49 && c==2 && pp==1) {
                    	
						next.setVisible(false);
						
						JButton fc1 = new JButton(s.c());
						fc1.setBounds(100,240,1000,60); // 按鈕範圍
						addObj(fc1,2);
						
						JButton fc2 = new JButton(s.c());
						fc2.setBounds(100,390,1000,60); // 按鈕範圍
						addObj(fc2,2);
						
						Font f = new Font("Serif", Font.BOLD, 30); // 改按鈕字體大小與字體
						fc1.setFont(f);
						fc2.setFont(f);
						
						fc1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								s.change(121);
								pp=1;
								fc1.setVisible(false);
								fc2.setVisible(false);
								sen1.setText(s.st());
								sen2.setText(s.st());
								refresh();
								next.setVisible(true);
							}
						});
						
						fc2.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								s.change(137);
								pp=2;
								fc1.setVisible(false);
								fc2.setVisible(false);
								sen1.setText(s.st());
								sen2.setText(s.st());
								refresh();
								next.setVisible(true);
								bg.setState(6);
								t=57;
								s.changeBG(10);
							}
						});
						s.change(-1);
					}
					
                    if (t==70 && c==2) {
                    	
                    	if (run2 == 1) h.setVisible(true);
						next.setVisible(false);
						s.changeChoice(15);
						
						JButton fc1 = new JButton(s.c());
						fc1.setBounds(100,220,1000,70); // 按鈕範圍
						addObj(fc1,2);
						
						JButton fc2 = new JButton(s.c());
						fc2.setBounds(100,340,1000,70); // 按鈕範圍
						addObj(fc2,2);
						
						JButton fc3 = new JButton(s.c());
						fc3.setBounds(100,460,1000,70); // 按鈕範圍
						addObj(fc3,2);
						
						Font f = new Font("Serif", Font.BOLD, 50); // 改按鈕字體大小與字體
						fc1.setFont(f);
						fc2.setFont(f);
						fc3.setFont(f);
						
						fc1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								TRUE=1;
								fc1.setVisible(false);
								fc2.setVisible(false);
								fc3.setVisible(false);
								sen1.setText(s.st());
								sen2.setText(s.st());
								refresh();
								next.setVisible(true);
							}
						});
						
						fc2.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								fc1.setVisible(false);
								fc2.setVisible(false);
								fc3.setVisible(false);
								sen1.setText(s.st());
								sen2.setText(s.st());
								refresh();
								next.setVisible(true);
							}
						});
						
						fc3.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								fc1.setVisible(false);
								fc2.setVisible(false);
								fc3.setVisible(false);
								sen1.setText(s.st());
								sen2.setText(s.st());
								refresh();
								next.setVisible(true);
							}
						});
					}
                    
                    if ((count==4 && TRUE==0) || T!=0) {
                    	Bad_End1.setVisible(true);
                    	Bad_End3.setVisible(true);
						t=27;
						c=2;
						pp=1;
						T=0;
						TRUE=0;
						count=0;
						s.change(-1);
						run2 = 1;
						songb.stop();
                    }
                    
                    if (t==71 && c==2) {
                    	
                    	h.setVisible(false);
						next.setVisible(false);
						count++;
						JButton fc1 = new JButton("5");
						fc1.setBounds(400,240,100,100); // 按鈕範圍
						addObj(fc1,2);
						
						JButton fc2 = new JButton("6");
						fc2.setBounds(700,240,100,100); // 按鈕範圍
						addObj(fc2,2);
						
						JButton fc3 = new JButton("7");
						fc3.setBounds(400,400,100,100); // 按鈕範圍
						addObj(fc3,2);
						
						JButton fc4 = new JButton("8");
						fc4.setBounds(700,400,100,100); // 按鈕範圍
						addObj(fc4,2);
						
						Font f = new Font("Serif", Font.BOLD, 80); // 改按鈕字體大小與字體
						fc1.setFont(f);
						fc2.setFont(f);
						fc3.setFont(f);
						fc4.setFont(f);
						
						fc1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								T=-1;
								s.change(173);
								fc1.setVisible(false);
								fc2.setVisible(false);
								fc3.setVisible(false);
								fc4.setVisible(false);
								sen1.setText(s.st());
								sen2.setText(s.st());
								refresh();
								next.setVisible(true);
							}
						});
						
						fc2.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								T=-1;
								s.change(173);
								fc1.setVisible(false);
								fc2.setVisible(false);
								fc3.setVisible(false);
								fc4.setVisible(false);
								sen1.setText(s.st());
								sen2.setText(s.st());
								refresh();
								next.setVisible(true);
							}
						});
						
						fc3.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								s.change(167);
								fc1.setVisible(false);
								fc2.setVisible(false);
								fc3.setVisible(false);
								fc4.setVisible(false);
								sen1.setText(s.st());
								sen2.setText(s.st());
								refresh();
								next.setVisible(true);
							}
						});
						
						fc4.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								T=-1;
								s.change(173);
								fc1.setVisible(false);
								fc2.setVisible(false);
								fc3.setVisible(false);
								fc4.setVisible(false);
								sen1.setText(s.st());
								sen2.setText(s.st());
								refresh();
								next.setVisible(true);
							}
						});
						s.change(-1);
					}
                    
                    if (t==72 && c==2) {
                    	
						next.setVisible(false);
						count++;
						JButton fc1 = new JButton("6");
						fc1.setBounds(400,240,100,100); // 按鈕範圍
						addObj(fc1,2);
						
						JButton fc2 = new JButton("7");
						fc2.setBounds(700,240,100,100); // 按鈕範圍
						addObj(fc2,2);
						
						JButton fc3 = new JButton("8");
						fc3.setBounds(400,400,100,100); // 按鈕範圍
						addObj(fc3,2);
						
						JButton fc4 = new JButton("9");
						fc4.setBounds(700,400,100,100); // 按鈕範圍
						addObj(fc4,2);
						
						Font f = new Font("Serif", Font.BOLD, 80); // 改按鈕字體大小與字體
						fc1.setFont(f);
						fc2.setFont(f);
						fc3.setFont(f);
						fc4.setFont(f);
						
						fc1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								T=-1;
								s.change(173);
								fc1.setVisible(false);
								fc2.setVisible(false);
								fc3.setVisible(false);
								fc4.setVisible(false);
								sen1.setText(s.st());
								sen2.setText(s.st());
								refresh();
								next.setVisible(true);
							}
						});
						
						fc2.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								T=-1;
								s.change(173);
								fc1.setVisible(false);
								fc2.setVisible(false);
								fc3.setVisible(false);
								fc4.setVisible(false);
								sen1.setText(s.st());
								sen2.setText(s.st());
								refresh();
								next.setVisible(true);
							}
						});
						
						fc3.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								s.change(169);
								fc1.setVisible(false);
								fc2.setVisible(false);
								fc3.setVisible(false);
								fc4.setVisible(false);
								sen1.setText(s.st());
								sen2.setText(s.st());
								refresh();
								next.setVisible(true);
							}
						});
						
						fc4.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								T=-1;
								s.change(173);
								fc1.setVisible(false);
								fc2.setVisible(false);
								fc3.setVisible(false);
								fc4.setVisible(false);
								sen1.setText(s.st());
								sen2.setText(s.st());
								refresh();
								next.setVisible(true);
							}
						});
						s.change(-1);
					}
                    
                    if (t==73 && c==2) {
                    	
						next.setVisible(false);
						count++;
						JButton fc1 = new JButton("0");
						fc1.setBounds(400,240,100,100); // 按鈕範圍
						addObj(fc1,2);
						
						JButton fc2 = new JButton("1");
						fc2.setBounds(700,240,100,100); // 按鈕範圍
						addObj(fc2,2);
						
						JButton fc3 = new JButton("2");
						fc3.setBounds(400,400,100,100); // 按鈕範圍
						addObj(fc3,2);
						
						JButton fc4 = new JButton("3");
						fc4.setBounds(700,400,100,100); // 按鈕範圍
						addObj(fc4,2);
						
						Font f = new Font("Serif", Font.BOLD, 80); // 改按鈕字體大小與字體
						fc1.setFont(f);
						fc2.setFont(f);
						fc3.setFont(f);
						fc4.setFont(f);
						
						fc1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								T=-1;
								s.change(173);
								fc1.setVisible(false);
								fc2.setVisible(false);
								fc3.setVisible(false);
								fc4.setVisible(false);
								sen1.setText(s.st());
								sen2.setText(s.st());
								refresh();
								next.setVisible(true);
							}
						});
						
						fc2.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								s.change(171);
								fc1.setVisible(false);
								fc2.setVisible(false);
								fc3.setVisible(false);
								fc4.setVisible(false);
								sen1.setText(s.st());
								sen2.setText(s.st());
								refresh();
								next.setVisible(true);
							}
						});
						
						fc3.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								T=-1;
								s.change(173);
								fc1.setVisible(false);
								fc2.setVisible(false);
								fc3.setVisible(false);
								fc4.setVisible(false);
								sen1.setText(s.st());
								sen2.setText(s.st());
								refresh();
								next.setVisible(true);
							}
						});
						
						fc4.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								T=-1;
								s.change(173);
								fc1.setVisible(false);
								fc2.setVisible(false);
								fc3.setVisible(false);
								fc4.setVisible(false);
								sen1.setText(s.st());
								sen2.setText(s.st());
								refresh();
								next.setVisible(true);
							}
						});
						s.change(-1);
					}
					
                    if (t==74 && c==2) {
                    	
						next.setVisible(false);
						count++;
						JButton fc1 = new JButton("5");
						fc1.setBounds(400,240,100,100); // 按鈕範圍
						addObj(fc1,2);
						
						JButton fc2 = new JButton("6");
						fc2.setBounds(700,240,100,100); // 按鈕範圍
						addObj(fc2,2);
						
						JButton fc3 = new JButton("7");
						fc3.setBounds(400,400,100,100); // 按鈕範圍
						addObj(fc3,2);
						
						JButton fc4 = new JButton("8");
						fc4.setBounds(700,400,100,100); // 按鈕範圍
						addObj(fc4,2);
						
						Font f = new Font("Serif", Font.BOLD, 80); // 改按鈕字體大小與字體
						fc1.setFont(f);
						fc2.setFont(f);
						fc3.setFont(f);
						fc4.setFont(f);
						
						fc1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								if (TRUE==1) s.change(175);
								else if (TRUE==0) s.change(173);
								fc1.setVisible(false);
								fc2.setVisible(false);
								fc3.setVisible(false);
								fc4.setVisible(false);
								sen1.setText(s.st());
								sen2.setText(s.st());
								refresh();
								next.setVisible(true);
							}
						});
						
						fc2.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								T=-1;
								s.change(173);
								fc1.setVisible(false);
								fc2.setVisible(false);
								fc3.setVisible(false);
								fc4.setVisible(false);
								sen1.setText(s.st());
								sen2.setText(s.st());
								refresh();
								next.setVisible(true);
							}
						});
						
						fc3.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								T=-1;
								s.change(173);
								fc1.setVisible(false);
								fc2.setVisible(false);
								fc3.setVisible(false);
								fc4.setVisible(false);
								sen1.setText(s.st());
								sen2.setText(s.st());
								refresh();
								next.setVisible(true);
							}
						});
						
						fc4.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								T=-1;
								s.change(173);
								fc1.setVisible(false);
								fc2.setVisible(false);
								fc3.setVisible(false);
								fc4.setVisible(false);
								sen1.setText(s.st());
								sen2.setText(s.st());
								refresh();
								next.setVisible(true);
							}
						});
						s.change(-1);
					}
                    
                    if (t==78 && c==2) {
                    	cha.setVisible(false);
                    	
						next.setVisible(false);
						
						JButton fc1 = new JButton("<html>"+s.c()+"</html>");
						fc1.setBounds(100,240,1000,100); // 按鈕範圍
						addObj(fc1,2);
						
						JButton fc2 = new JButton(s.c());
						fc2.setBounds(100,390,1000,60); // 按鈕範圍
						addObj(fc2,2);
						
						Font f = new Font("Serif", Font.BOLD, 30); // 改按鈕字體大小與字體
						fc1.setFont(f);
						fc2.setFont(f);
						
						fc1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								s.change(185);
								pp=1;
								fc1.setVisible(false);
								fc2.setVisible(false);
								sen1.setText(s.st());
								sen2.setText(s.st());
								refresh();
								next.setVisible(true);
								cha.setVisible(true);
								cha.setState(4);
							}
						});
						
						fc2.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								s.change(187);
								pp=2;
								fc1.setVisible(false);
								fc2.setVisible(false);
								sen1.setText(s.st());
								sen2.setText(s.st());
								refresh();
								next.setVisible(true);
								cha.setVisible(true);
							}
						});
						s.change(-1);
					}
                    
                    
					if ((c==11 && t==8) || (c==12 && t==6)) {
						s.change(-1);
						s.change_CHAPTER(13);
						bg.setState(1);
						c=13;
						t=8;
						cha.setState(0);
						heart.loop();
					}
					
					if ((c==13 && t==30 && pp==1) || (c==13 && t==27 && pp==2) || (c==13 && t==24 && pp==3)) {
						heart.stop();
						s.change(87);
						pp=0;
						t=26;
						bg.setState(2);
					}
					
					if (t==3 && c==1) {
						cha.setVisible(false);
						b = new NewTextarea(s.b(),false,"Serif",Font.PLAIN,35,Color.WHITE,new Color(0,0,0,230));
						addObj(b,2);
						b.setBounds(125,200,950,260);
						b.setEditable(false);
						cl.setVisible(true);
						refresh();
					}
					if (t==4 && c==1) {
						cha.setVisible(true);
						b.setVisible(false);
						cl.setVisible(false);
					}
					
					if ((c==1 && t==5) || (c==1 && t==6)) {
						cha.setVisible(false);
						b.setText(s.b());
						b.setBounds(130,200,950,260);
						b.setVisible(true);
						cl.setVisible(true);
					}
					if (t==7 && c==1) {
						b.setVisible(false);
						cl.setVisible(false);
					}
					
					if ((t==14 && c==13) || (t==13 && c==13)) {
						b.setText(s.b());
						b.setBounds(30,150,1155,325);
						b.setVisible(true);
						cl.setVisible(true);
					}
					if (t==15 && c==13) {
						cl.setVisible(false);
						b.setVisible(false);
					}
					
					if ((t==34 && c==13) || (t==35 && c==13)) {
						if (t==34) bg.setState(3);
						cha.setVisible(false);
						b.setText(s.b());
						b.setBounds(30,250,1155,225);
						b.setVisible(true);
						cl.setVisible(true);
						songb.stop();
						cry.replay();
						cry.loop();
					}
					if (t==36 && c==13) {
						cha.setVisible(true);
						cl.setVisible(false);
						b.setVisible(false);
					}
					
					if (t==14 && c==2) {
						cha.setVisible(false);
						b.setText(s.b());
						b.setBounds(25,150,1160,325);
						b.setVisible(true);
						cl.setVisible(true);
						warn.replay();
						songb.stop();
					}
					if (t==15 && c==2) {
						cha.setVisible(true);
						b.setVisible(false);
						cl.setVisible(false);
						warn.stop();
						tense.loop();
					}
					
					
					if (t==27 && c==2 && pp==1) {
						bg.setState(4);
						cha.setVisible(false);
						Bad_End1.setVisible(true);
						Bad_End2.setVisible(true);
						songb.stop();
						tense.stop();
						bomb.replay();
					}
					
					if (t==40 && c==2) {
						cha.setVisible(false);
						b.setText(s.b());
						b.setBounds(25,150,1160,360);
						b.setVisible(true);
						cl.setVisible(true);
					}
					if (t==41 && c==2) {
						cha.setVisible(true);
						b.setVisible(false);
						cl.setVisible(false);
					}
					
					if (t==45 && c==2) cha.setVisible(false);
					
					if (t==48 && c==2) {
						b.setVisible(false);
						cl.setVisible(false);
					} 
					
					if (t==53 && c==2 && pp==1) {
						bb = new NewTextarea(s.b(),false,"Serif",Font.PLAIN,35,Color.WHITE,new Color(0,0,0,180));
						addObj(bb,2);
						Font g = new Font("Serif", Font.BOLD, 100);
						bb.setFont(g);
						bb.setBounds(25,300,1160,130);
						bb.setVisible(true);
						cl.setVisible(true);
					}
					if (t==54 && c==2 && pp==1) {
						bb.setVisible(false);
						cl.setVisible(false);
					}
					
					if (t==58 && c==2) {
						b.setText(s.b());
						b.setBounds(25,150,1160,360);
						b.setVisible(true);
						cl.setVisible(true);
					}
					if (t==59 && c==2) {
						b.setVisible(false);
						cl.setVisible(false);
					}
					
					if (t==61 && c==2) {
						b.setText(s.b());
						b.setBounds(25,250,1160,200);
						b.setVisible(true);
						cl.setVisible(true);
					}
					if (t==62 && c==2) {
						b.setVisible(false);
						cl.setVisible(false);
					}
					
					if (t==68 && c==2) {
						b.setText(s.b());
						b.setBounds(25,250,1160,170);
						b.setVisible(true);
						cl.setVisible(true);
					}
					if (t==69 && c==2) {
						b.setVisible(false);
						cl.setVisible(false);
					}
					
					if (t==79 && c==2) {
						s.change(189);
					}
					
					if (t==88 && c==2) {
						cha.setVisible(false);
						b.setText(s.b());
						b.setBounds(25,200,1160,320);
						b.setVisible(true);
						cl.setVisible(true);
					}
					if (t==89 && c==2) {
						cha.setVisible(true);
						b.setVisible(false);
						cl.setVisible(false);
					}
					
					if (t==1 && c==3) {
						b.setText(s.b());
						b.setBounds(25,250,1160,200);
						b.setVisible(true);
						cl.setVisible(true);
						cha.setVisible(false);
					}
					if (t==2 && c==3) {
						b.setVisible(false);
						cl.setVisible(false);
						cha.setVisible(true);
					}
					
					if (t==7 && c==3) {
						bg.setState(8);
						b.setText(s.b());
						b.setBounds(25,150,1160,400);
						b.setVisible(true);
						cl.setVisible(true);
						cha.setVisible(false);
					}
					if (t==8 && c==3) {
						b.setVisible(false);
						cl.setVisible(false);
						cha.setVisible(true);
					}
					
					if ((t==9 && c==3) || (t==10 && c==3) || (t==11 && c==3)) {
						if (t==9) {
							songb.stop();
							cry.replay();
							cry.loop();
						}
						b.setText(s.b());
						b.setBounds(25,150,1160,400);
						b.setVisible(true);
						cl.setVisible(true);
						cha.setVisible(false);
					}
					if (t==12 && c==3) {
						b.setVisible(false);
						cl.setVisible(false);
						cha.setState(1);
						cha.setVisible(true);
					}
					
					if (t==19 && c==3) {
						bg.setState(9);
						fi = new NewTextarea(s.b(),false,"Serif",Font.PLAIN,50,Color.WHITE,new Color(0,0,0,180));
						addObj(fi,2);
						fi.setBounds(25,300,1160,150);
						fi.setEditable(false);
						cl.setVisible(true);
						refresh();
						cha.setVisible(false);
					}
					if (t==20 && c==3) {
						fi.setVisible(false);
						whodo = new NewTextarea(s.b(),false,"Serif",Font.PLAIN,50,Color.WHITE,new Color(0,0,0,255));
						addObj(whodo,2);
						whodo.setBounds(20,20,1180,705);
						whodo.setEditable(false);
						refresh();
						next.setBounds(965,615,200,50);
						addObj(next,3);
						sen1.setVisible(false);
						sen2.setVisible(false);
					}
					if (t==21 && c==3) {
						Font finish = new Font("Serif", Font.BOLD, 80);
						whodo.setText("\n\n\n        TO BE CONTINUED ......");
						whodo.setFont(finish);
						next.setText("結束遊戲");
					}
					if (t==22 && c==3) {
						cl.setVisible(false);
						close();
						StoRicA s = new StoRicA(2);
						cry.stop();
					}
					
					if (t>=0) {
					sen1.setText(s.st());
					sen2.setText(s.st());
					refresh();
					}
					//System.out.println(t);
				    }
		});
		
	}

	/**
	 * 畫面顯示
	 */
	public void open() {
		S.setVisible(true);
	}

	/**
	 * 畫面隱藏
	 */
	public void close() {
		S.setVisible(false);
	}
	/**
	 * 添加背景
	 */
	private void addObj(Back o,int layer) {
		p.add(o);
		p.setLayer(o,layer);
	}
	/**
	 * 添加按鈕
	 */
	private void addObj(JButton b,int layer) {
		p.add(b);
		p.setLayer(b,layer);
	}
	/**
	 * 添加標籤(顯示文字的地方)
	 */
	private void addObj(JLabel b,int layer) {
		p.add(b);
		p.setLayer(b,layer);
	}
	/**
	 * 添加Textarea
	 */
	private void addObj(JTextArea b,int layer) {
		p.add(b);
		p.setLayer(b,layer);
	}
	/**
	 * 畫面更新
	 */
	private void refresh() {
		p.revalidate();
		p.repaint();
	}
}