import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public abstract class DEEP extends JLabel{
	protected int x;
	protected int y;
	protected String name;
	protected ImageIcon im[];

	protected abstract void Input(String name,int c);
	/**
	 * 取得背景or人物的圖片
	 */
	public DEEP (String name,int c) {
		this.name = name;
		Input(name,c);
	}

	/**
	 * 設定圖片的座標位置
	 */
	public void setPos(int x,int y) {
		this.x = x;
		this.y = y;
		setBounds(x,y,getPreferredSize().width, getPreferredSize().height);
	}
	
}
