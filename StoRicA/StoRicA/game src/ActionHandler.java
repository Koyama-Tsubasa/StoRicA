import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

class ActionHandler implements ActionListener {
	/**
	 * ����s�Q���U��A�|���X�p�����A�T�{�O�_�n����ʧ@
	 */
	public void actionPerformed(ActionEvent e) {
		int a = JOptionPane.showConfirmDialog(null, "�T�w�n" + e.getActionCommand() + "��?", "�T�{�T��",
				JOptionPane.YES_NO_OPTION);
		if (a == JOptionPane.YES_OPTION) {
			firstpage f = new firstpage();
			f.open();
			StoRicA s = new StoRicA(1);
		}
	}
}
