import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextArea;

public class NewTextarea extends JTextArea{
	/**
	 * �إߤ@�ӷs��Textarea�A�]�wTextarea�z���סB�r���B��r�j�p�B��r�C��BTextarea�C��
	 */
	public NewTextarea (String text,boolean tra,String sen,int style,int fontsize,Color fontco,Color bg) {
		super(text);
		setText(text);
		setBackground(bg);
		setOpaque(!tra);
		setForeground(fontco);
		setFont(new Font(sen,style,fontsize));
	}

}
