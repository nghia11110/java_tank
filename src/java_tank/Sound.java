
package java_tank;


import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.*;


public class Sound extends Thread {
    
    private boolean isloop;
    AudioInputStream soundStream ;
    DataLine.Info info;
    Clip line;
     // format is an AudioFormat object
    public Sound(String SoundSrc){
        
        try {
            soundStream = AudioSystem.getAudioInputStream(new File(SoundSrc));
            info = new DataLine.Info(Clip.class, 
            soundStream.getFormat());
            if (!AudioSystem.isLineSupported(info)) {
                System.out.printf("Not supoted yet\n");
            }
            try {
            line = (Clip) AudioSystem.getLine(info);
                try {
                    line.open(soundStream);
                } catch (IOException ex) {
                    Logger.getLogger(Sound.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.printf("Can't find file Sound/Taunt001.wav\n");
                }
            } catch (LineUnavailableException ex) {
                 
            }
            
        } catch (UnsupportedAudioFileException ex ){
        
        }catch(IOException ex){
            Logger.getLogger(Sound.class.getName()).log(Level.SEVERE, null, ex);
             
        }
        

    }
    public void play(){
        isloop = false;
        new Thread(this).start();
        System.out.printf("Sound Play called!\n");
        
    }
    @Override
    public void run(){
        if(this.line.isActive()){
            this.line.stop();
        }
        this.line.setFramePosition(0);
       if(isloop){
           this.line.loop(Clip.LOOP_CONTINUOUSLY);
       }else{
            this.line.start();
       }
        
        //
        System.out.printf("Sound Play Run!\n");
    }
    public void loop(){
        isloop = true;
        new Thread(this).start();
    }
}

