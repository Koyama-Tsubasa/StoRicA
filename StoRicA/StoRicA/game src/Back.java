import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Back extends DEEP{
	/**
	 * �x�s�Ϥ����}�C
	 */
	private ImageIcon im[];
	/**
	 * �հʤ����O(DEEP)���Ѽư����k
	 */
	public Back(String name, int c) {
		super(name, c);
	}//�I��

	@Override
	/**
	 * �x�s�ɮפ����Ϥ��A�����O�_���ҥ~
	 */
	protected void Input(String name, int c) {
			im = new ImageIcon[c];
			/**
			 * �M��������ɮצW�١A�x�s�Ϥ�
			 */
					try {
						for (int i=0;i<c;i++) {
						im[i] = new ImageIcon(ImageIO.read(StoRicA.class.getResource("/" + name + i + ".jpg")));
						}
						setIcon(im[0]);
					} catch (IOException e) {
						System.out.println("No file");
					}
		
	}
	/**
	 * �]�w�έ��i�Ϥ�
	 */
	public void setState(int a) {
		setIcon(im[a]);
	}
	
}
