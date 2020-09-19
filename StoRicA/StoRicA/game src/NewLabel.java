import java.awt.Color;
import java.awt.Font;

public class NewLabel extends DEEP{
	/**
	 * 建立一個新的label，設定label透明度、字型、文字大小、文字顏色、label顏色
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
