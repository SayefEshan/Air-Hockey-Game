package game;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class GameSound {

	public static void puckHitSound(){
		try{
			File sound = new File("sounds//puckHit.wav");
			AudioInputStream ais = AudioSystem.getAudioInputStream(sound);
			Clip clip = AudioSystem.getClip();
			clip.open(ais);
			clip.start();
			
			
		}catch(Exception e){}
	}
	public static void goalSound(){
		try{
			File sound1 = new File("sounds//goal.wav");
			AudioInputStream ais = AudioSystem.getAudioInputStream(sound1);
			Clip clip = AudioSystem.getClip();
			clip.open(ais);
			clip.start();
			
			
		}catch(Exception e){}
	}
}
