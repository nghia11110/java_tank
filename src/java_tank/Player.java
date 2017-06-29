
package java_tank;
import java.awt.event.KeyEvent;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.ImageIcon;

public class Player extends State implements Commons{
    private final int START_Y = BOARD_HEIGHT-50; 
    private final int START_X = (BOARD_WIDTH-BORDER_RIGHT)/2-75;
    private int width;
    private int height;
    protected  int power,speed;
    protected static int life,level=1;
    protected static String playername="hinhanh/T1.jpg";
    public Player() {
       ImageIcon ii = new ImageIcon(playername);

        width = ii.getImage().getWidth(null); 
        height = ii.getImage().getHeight(null);  
        if("hinhanh/T1.jpg".equals(playername)){
        this.power=0;
        this.speed=0;
        }
        if("hinhanh/T13.jpg".equals(playername)){
        this.power=1;
        this.speed=3;
        }
        setImage(ii.getImage());
        setX(START_X);
        setY(START_Y);
    }
   
     public void act(ArrayList walls,ArrayList steelwalls,ArrayList rivers,ArrayList aliens,
             ArrayList aliens1,ArrayList aliens2,ArrayList aliens3,ArrayList aliens4) {
         //setPl(pl);
        this.x += this.dx;
        this.y +=this.dy;
        
        
        if (this.x <= 2) 
            this.x = 2;
        if (this.x >= BOARD_WIDTH -24-BORDER_RIGHT) 
            this.x = BOARD_WIDTH -24-BORDER_RIGHT;
        if (this.y <= 2) 
            this.y = 2;
        if (this.y >= BOARD_HEIGHT - 50) 
            this.y = BOARD_HEIGHT - 50;
        
        
        Iterator it = walls.iterator();
        while (it.hasNext()){
          Wall wall=(Wall) it.next();  
        if (this.x >= wall.x-22 && this.x <= wall.x+22 && this.y >= wall.y-22 && this.y <= wall.y+22 && wall.isVisible()) 
           {
            this.x -=this.dx;
            this.y-=this.dy;
            break;
            }
        }
        Iterator it1 = steelwalls.iterator();
        while (it1.hasNext()){
          Steelwall steelwall=(Steelwall) it1.next();  
        if (this.x >= steelwall.x-22 && this.x <= steelwall.x+22 && this.y >= steelwall.y-22 && this.y <= steelwall.y+22 && steelwall.isVisible() ) 
           {
            this.x -=this.dx;
            this.y-=this.dy;
            break;
            }
         }
        Iterator it2 = rivers.iterator();
        while (it2.hasNext()){
          River river=(River) it2.next();  
        if (this.x >= river.x-24 && this.x <= river.x+24 && this.y >= river.y-24 && this.y <= river.y+24 ) 
           {
            this.x -=this.dx;
            this.y-=this.dy;
            break;
            }
         }
        State alien=null;
        for(int i=0;i<aliens.size();i++) {
                if("Alien".equals(aliens.get(i).getClass().getSimpleName()))
                     alien = (Alien)aliens.get(i);
                if("Alien1".equals(aliens.get(i).getClass().getSimpleName()))
                 alien = (Alien1)aliens.get(i);
                if("Alien2".equals(aliens.get(i).getClass().getSimpleName()))
                 alien = (Alien2)aliens.get(i);
                if("Alien3".equals(aliens.get(i).getClass().getSimpleName()))
                 alien = (Alien3)aliens.get(i);
                if("Alien4".equals(aliens.get(i).getClass().getSimpleName()))
                 alien = (Alien4)aliens.get(i);
                if (this.x >= alien.x-24 && this.x <= alien.x+24 && this.y >= alien.y-24 && this.y <= alien.y+24 && alien.isVisible()) 
           {
            this.x -=this.dx;
            this.y-=this.dy;
            break;
            }
                
        }
        
        for(int i=0;i<aliens1.size();i++) {
                if("Alien".equals(aliens1.get(i).getClass().getSimpleName()))
                 alien = (Alien)aliens1.get(i);
                if("Alien1".equals(aliens1.get(i).getClass().getSimpleName()))
                 alien = (Alien1)aliens1.get(i);
                if("Alien2".equals(aliens1.get(i).getClass().getSimpleName()))
                 alien = (Alien2)aliens1.get(i);
                if("Alien3".equals(aliens1.get(i).getClass().getSimpleName()))
                 alien = (Alien3)aliens1.get(i);
                if("Alien4".equals(aliens1.get(i).getClass().getSimpleName()))
                 alien = (Alien4)aliens1.get(i);
                    if (this.x >= alien.x-24 && this.x <= alien.x+24 && this.y >= alien.y-24 && this.y <= alien.y+24 && alien.isVisible()) 
           {
            this.x -=this.dx;
            this.y-=this.dy;
            break;
            }
                
        }
     
        for(int i=0;i<aliens2.size();i++) {
                if("Alien".equals(aliens2.get(i).getClass().getSimpleName()))
                 alien = (Alien)aliens2.get(i);
                if("Alien1".equals(aliens2.get(i).getClass().getSimpleName()))
                 alien = (Alien1)aliens2.get(i);
                if("Alien2".equals(aliens2.get(i).getClass().getSimpleName()))
                 alien = (Alien2)aliens2.get(i);
                if("Alien3".equals(aliens2.get(i).getClass().getSimpleName()))
                 alien = (Alien3)aliens2.get(i);
                if("Alien4".equals(aliens2.get(i).getClass().getSimpleName()))
                 alien = (Alien4)aliens2.get(i);
          if (this.x >= alien.x-24 && this.x <= alien.x+24 && this.y >= alien.y-24 && this.y <= alien.y+24 && alien.isVisible() ) 
           {
            this.x -=this.dx;
            this.y-=this.dy;
            break;
            }       
        }
        
        for(int i=0;i<aliens3.size();i++) {
                if("Alien".equals(aliens3.get(i).getClass().getSimpleName()))
                 alien = (Alien)aliens3.get(i);
                if("Alien1".equals(aliens3.get(i).getClass().getSimpleName()))
                 alien = (Alien1)aliens3.get(i);
                if("Alien2".equals(aliens3.get(i).getClass().getSimpleName()))
                 alien = (Alien2)aliens3.get(i);
                if("Alien3".equals(aliens3.get(i).getClass().getSimpleName()))
                 alien = (Alien3)aliens3.get(i);
                if("Alien4".equals(aliens3.get(i).getClass().getSimpleName()))
                 alien = (Alien4)aliens3.get(i);
                if (this.x >= alien.x-24 && this.x <= alien.x+24 && this.y >= alien.y-24 && this.y <= alien.y+24 && alien.isVisible()) 
           {
            this.x -=this.dx;
            this.y-=this.dy;
            break;
            }    
        }
        
        for(int i=0;i<aliens4.size();i++) {
                if("Alien".equals(aliens4.get(i).getClass().getSimpleName()))
                 alien = (Alien)aliens4.get(i);
                if("Alien1".equals(aliens4.get(i).getClass().getSimpleName()))
                 alien = (Alien1)aliens4.get(i);
                if("Alien2".equals(aliens4.get(i).getClass().getSimpleName()))
                 alien = (Alien2)aliens4.get(i);
                if("Alien3".equals(aliens4.get(i).getClass().getSimpleName()))
                 alien = (Alien3)aliens4.get(i);
                if("Alien4".equals(aliens4.get(i).getClass().getSimpleName()))
                 alien = (Alien4)aliens4.get(i);
                if (this.x >= alien.x-24 && this.x <= alien.x+24 && this.y >= alien.y-24 && this.y <= alien.y+24 && alien.isVisible() ) 
           {
            this.x -=this.dx;
            this.y-=this.dy;
            break;
            }    
        }
    }
     
       public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_A)
        {    if(power==0)
             pl="hinhanh/T3.jpg";
             if(power==1)
             pl="hinhanh/T15.jpg";    
             ImageIcon ii = new ImageIcon(getPl());

        width = ii.getImage().getWidth(null); 
        height = ii.getImage().getHeight(null);  
        
        setImage(ii.getImage());
            dx = -1;
            dy=0;
        }

        if (key == KeyEvent.VK_D)
        {
            if(power==0)
             pl="hinhanh/T4.jpg";
             if(power==1)
             pl="hinhanh/T16.jpg";  
            ImageIcon ii = new ImageIcon(getPl());

        width = ii.getImage().getWidth(null); 
        height = ii.getImage().getHeight(null);  
        
        setImage(ii.getImage());
            dx = 1;
            dy=0;
        }
        
        if (key == KeyEvent.VK_S)
        {
            if(power==0)
             pl="hinhanh/T2.jpg";
             if(power==1)
             pl="hinhanh/T14.jpg";  
            ImageIcon ii = new ImageIcon(getPl());

        width = ii.getImage().getWidth(null); 
        height = ii.getImage().getHeight(null);  
        
        setImage(ii.getImage());
            dx = 0;
            dy=1;
        }
        
        if (key == KeyEvent.VK_W)
        {
             if(power==0)
             pl="hinhanh/T1.jpg";
             if(power==1)
             pl="hinhanh/T13.jpg";  
             ImageIcon ii = new ImageIcon(getPl());

        width = ii.getImage().getWidth(null); 
        height = ii.getImage().getHeight(null);  
        
        setImage(ii.getImage());
            dx = 0;
            dy=-1;
        }
    }
     
     public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_A)
        {  
            dx = 0;
        }

        if (key == KeyEvent.VK_D)
        {
            dx = 0;
        }
        
        if (key == KeyEvent.VK_S)
        {
            dy = 0;
        }
        
        if (key == KeyEvent.VK_W)
        {
            dy = 0;
        }
    }
}
