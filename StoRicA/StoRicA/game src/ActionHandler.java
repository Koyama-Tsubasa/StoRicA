import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

class ActionHandler implements ActionListener {
	/**
	 * 當按鈕被按下後，會跳出小視窗，確認是否要執行動作
	 */
	public void actionPerformed(ActionEvent e) {
		int a = JOptionPane.showConfirmDialog(null, "確定要" + e.getActionCommand() + "嗎?", "確認訊息",
				JOptionPane.YES_NO_OPTION);
		if (a == JOptionPane.YES_OPTION) {
			firstpage f = new firstpage();
			f.open();
			StoRicA s = new StoRicA(1);
		}
	}
}
