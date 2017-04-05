/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.whiting.javatilegame.sound;

/**
 *
 * @author 55johnslw26
 */
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;

public class Sound implements Runnable {

    private boolean running = false;
    private Thread thread;

    public Sound() {
        this.start();
    }

    public void start() {
        if (running) {
            return;
        }
        this.thread = new Thread(this);
        this.running = true;
        this.thread.start();
    }

    //
    private boolean playSong = false;
    private AudioInputStream inputStream = null;
    private String url;
    private Clip clip;

    @Override
    public void run() {
        
    }

    public void playBackGround(String urlstr) // call to play .wav file
    {
        if (this.clip != null) {
            this.clip.stop();
            this.clip.close();
        }
        try {
            this.clip = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        url = urlstr + ".wav";
        this.playSong = true;
        this.inputStream = null;

        
        //Add a debounce eventuall so that when the user pushes a key in constantly it will not freeze the sound queue. Also probably should consider
        //multi threaded sound engine :)
        if (inputStream == null && playSong) {
            this.playSong = false;
            try {

                this.inputStream = AudioSystem.getAudioInputStream(Sound.class.getResource(url));
                this.clip.open(inputStream);
                this.clip.loop(10);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void disposeSound() {
        if (this.clip != null) {
            this.clip.stop();
            this.clip.close();
        }
        this.clip = null;
        this.playSong = false;
        this.inputStream = null;
    }
}
