package HW7;

import javax.swing.*
import java.awt.*;
import java.applet.*;

/** @author Anthony Torns II 
 * Play Sound plays a clicking sound anythime a button is pressed
 * 
*/

public class PlaySound implements ActionListener {
      public PlaySound() {
        b1.ActionListener(PlaySound.this);
        b2.ActionListener(PlaySound.this);
        b3.ActionListener(PlaySound.this);
        b4.ActionListener(PlaySound.this);
        b5.ActionListener(PlaySound.this);
        b6.ActionListener(PlaySound.this);
        b7.ActionListener(PlaySound.this);
        b8.ActionListener(PlaySound.this);
        b9.ActionListener(PlaySound.this);
        beq.ActionListener(PlaySound.this);
        bdiv.ActionListener(PlaySound.this);
        badd.ActionListener(PlaySound.this);
        bsub.ActionListener(PlaySound.this);
        bmul.ActionListener(PlaySound.this);
        squ.ActionListener(PlaySound.this);
        sqrt.ActionListener(PlaySound.this);
        inv.ActionListener(PlaySound.this);
        bclr.ActionListener(PlaySound.this);
      
      }

      @Override 
      public void actionPerformed(ActionEvent e) {
        try
        {
        AudioInputStream sound = AudioSystem.getAudioInputStream(getClass().getResourceAsStream("Click.mp3"));
        Clip soundClip = AudioSystem.getClip();
        soundClip.open(sound);
        }catch(Exception ex){System.out.println("Fail to play sound");}
      }
}
