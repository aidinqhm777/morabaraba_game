package control;

import view.board;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class MoveSound extends Thread {
    public static synchronized void playSound(final String url) {
        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(board.class.getResourceAsStream(url));
            clip.open(inputStream);
            clip.start();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }


    public void run() {
        String url = "/Move.wav";
        playSound(url);
    }

}
