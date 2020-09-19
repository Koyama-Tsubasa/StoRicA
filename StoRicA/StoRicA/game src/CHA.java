import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class CHA extends Back{
	/**
	 * 儲存圖片的陣列
	 */
	private ImageIcon cha[];
	/**
	 * 調動父類別(DEEP)的參數執行方法
	 */
	public CHA(String name, int c) {
		super(name, c);
	}//人物
	/**
	 * 儲存檔案中的圖片，偵測是否有例外
	 */
	protected void Input(String name, int c) {
		cha = new ImageIcon[c];
		/**
		 * 尋找相應的檔案名稱，儲存圖片
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
	 * 設定用哪張圖片
	 */
	public void setState(int a) {
		setIcon(cha[a]);
	}
	
}
