import java.awt.Color;
import java.awt.Font;

public class NewLabel extends DEEP{
	/**
	 * �إߤ@�ӷs��label�A�]�wlabel�z���סB�r���B��r�j�p�B��r�C��Blabel�C��
	 */
	public NewLabel (String text,boolean tra,String sen,int style,int fontsize,Color fontco,Color bg) {
		super(null,0);
		setText(text);
		setBackground(bg);
		setOpaque(!tra);
		setForeground(fontco);
		setFont(new Font(sen,style,fontsize));
	}

	@Override
	protected void Input(String name, int c) {
		
	}

}
