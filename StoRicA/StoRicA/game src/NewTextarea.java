import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextArea;

public class NewTextarea extends JTextArea{
	/**
	 * 建立一個新的Textarea，設定Textarea透明度、字型、文字大小、文字顏色、Textarea顏色
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
