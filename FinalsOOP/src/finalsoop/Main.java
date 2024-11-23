/*
League of Legends Team Manager Program

Made by:
Basit, Brian Joseph
Formilles, Julius Andrei
Makayan III, Amorsolo
Pitargue, Linus Abel
*/
package finalsoop;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;


public class Main {

    public static void main(String[] args) {
        System.out.println("warwic");
        try {
            // Load the audio file
            File audioFile = new File("src/warwick.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

            // Get the clip and open it with the audio stream
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            // Play the audio
            clip.start();

            // Keep the program running while the audio is playing
            System.in.read();
            clip.stop();
            clip.close();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
        

    }
    
}
