import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;

public class MUSIC {
	private Clip music;
	/**
	 * 儲存檔案中的音樂，偵測是否有例外
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
	 * 開始播放音樂
	 */
	public void play() {
		music.start();
	}
	/**
	 * 開始播放音樂
	 */
	public void replay() {
		music.setMicrosecondPosition(0);
		music.start();
	}
	/**
	 * 設定音樂播放從何時開始
	 */
	public void playFrom(double second) {
		music.setMicrosecondPosition((int)(second * 1000000));
		music.start();
	}
	/**
	 * 停止播放
	 */
	public void stop() {
		music.stop();
	}
	/**
	 * 設定音樂播放幾次
	 */
	public void loop(int count) {
		music.loop(count);
	}
	/**
	 * 單曲循環播放
	 */
	public void loop() {
		music.loop(music.LOOP_CONTINUOUSLY);
	}
	/**
	 * 設定音樂大小
	 */
	public void setVolume(float volume) {
		FloatControl gainControl = (FloatControl) music.getControl(FloatControl.Type.MASTER_GAIN);
		float max = gainControl.getMaximum();
		float min = gainControl.getMinimum();
		float db = volume * (max - min) + min;
		gainControl.setValue(db);
	}
	
}
