package dev.whiting.javatilegame.sound;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class AudioPlayer {
	
	private Clip clip;
	public AudioPlayer(String path){
		try{
			
			AudioInputStream ais = AudioSystem.getAudioInputStream(getClass().getResourceAsStream(path));
			AudioFormat baseFormat = ais.getFormat();
			AudioFormat decodeFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,baseFormat.getSampleRate(),16,baseFormat.getChannels(),baseFormat.getChannels() * 2,baseFormat.getSampleRate(),false);
			
			AudioInputStream dais = AudioSystem.getAudioInputStream(decodeFormat,ais);
			
			clip = AudioSystem.getClip();
			clip.open(dais);
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void setVolume(float volume){
		FloatControl gainControl = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
		gainControl.setValue(volume);
	}
	public void play(){
		if(clip == null)return;
		if(!clip.isRunning()){
			stop();
			clip.setFramePosition(0);
			clip.start();
		}
	}
	
	public void stop(){
		if(clip.isRunning()) clip.stop();
	}
	
	public void close(){
		stop();
		clip.close();
	}
}
