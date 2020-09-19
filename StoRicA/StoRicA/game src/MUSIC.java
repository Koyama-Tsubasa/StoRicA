import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;

public class MUSIC {
	private Clip music;
	/**
	 * �x�s�ɮפ������֡A�����O�_���ҥ~
	 */
	public MUSIC(String filepath) {
		try {
			AudioInputStream input = AudioSystem.getAudioInputStream(StoRicA.class.getResource(filepath));
			AudioFormat format = input.getFormat();
			DataLine.Info info = new DataLine.Info(Clip.class,format);
			music = (Clip) AudioSystem.getLine(info);
			music.open(input);
		}
		catch (Exception e) {
			System.out.println("No file");
		}
	}
	/**
	 * �}�l���񭵼�
	 */
	public void play() {
		music.start();
	}
	/**
	 * �}�l���񭵼�
	 */
	public void replay() {
		music.setMicrosecondPosition(0);
		music.start();
	}
	/**
	 * �]�w���ּ���q��ɶ}�l
	 */
	public void playFrom(double second) {
		music.setMicrosecondPosition((int)(second * 1000000));
		music.start();
	}
	/**
	 * �����
	 */
	public void stop() {
		music.stop();
	}
	/**
	 * �]�w���ּ���X��
	 */
	public void loop(int count) {
		music.loop(count);
	}
	/**
	 * �榱�`������
	 */
	public void loop() {
		music.loop(music.LOOP_CONTINUOUSLY);
	}
	/**
	 * �]�w���֤j�p
	 */
	public void setVolume(float volume) {
		FloatControl gainControl = (FloatControl) music.getControl(FloatControl.Type.MASTER_GAIN);
		float max = gainControl.getMaximum();
		float min = gainControl.getMinimum();
		float db = volume * (max - min) + min;
		gainControl.setValue(db);
	}
	
}
