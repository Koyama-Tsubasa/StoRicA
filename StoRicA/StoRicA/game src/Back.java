import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Back extends DEEP{
	/**
	 * 儲存圖片的陣列
	 */
	private ImageIcon im[];
	/**
	 * 調動父類別(DEEP)的參數執行方法
	 */
	public Back(String name, int c) {
		super(name, c);
	}//背景

	@Override
	/**
	 * 儲存檔案中的圖片，偵測是否有例外
	 */
	protected void Input(String name, int c) {
			im = new ImageIcon[c];
			/**
			 * 尋找相應的檔案名稱，儲存圖片
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
	 * 設定用哪張圖片
	 */
	public void setState(int a) {
		setIcon(im[a]);
	}
	
}
