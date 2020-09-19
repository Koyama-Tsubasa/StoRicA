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
	 * ���o�I��or�H�����Ϥ�
	 */
	public DEEP (String name,int c) {
		this.name = name;
		Input(name,c);
	}

	/**
	 * �]�w�Ϥ����y�Ц�m
	 */
	public void setPos(int x,int y) {
		this.x = x;
		this.y = y;
		setBounds(x,y,getPreferredSize().width, getPreferredSize().height);
	}
	
}
