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
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        String filepath = "warwick.wav";
        PlayMusic(filepath);
        JOptionPane.showMessageDialog(null, "warwic");
        

    }
    public static void PlayMusic(String location){
        try{
            File musicPath = new File(location);
            if(musicPath.exists()){
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
            }else{
                System.out.println("Can't find file...");
            }
                
            
        } catch(Exception e){
            System.out.println(e);
        }
    }
}
