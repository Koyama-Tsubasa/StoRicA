import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class CHA extends Back{
	/**
	 * �x�s�Ϥ����}�C
	 */
	private ImageIcon cha[];
	/**
	 * �հʤ����O(DEEP)���Ѽư����k
	 */
	public CHA(String name, int c) {
		super(name, c);
	}//�H��
	/**
	 * �x�s�ɮפ����Ϥ��A�����O�_���ҥ~
	 */
	protected void Input(String name, int c) {
		cha = new ImageIcon[c];
		/**
		 * �M��������ɮצW�١A�x�s�Ϥ�
		 */
				try {
					for (int i=0;i<c;i++) {
					cha[i] = new ImageIcon(ImageIO.read(StoRicA.class.getResource("/" + name + i + ".png")));
					}
					setIcon(cha[0]);
				} catch (IOException e) {
					System.out.println("No file");
				}
	
}
	/**
	 * �]�w�έ��i�Ϥ�
	 */
	public void setState(int a) {
		setIcon(cha[a]);
	}
	
}
