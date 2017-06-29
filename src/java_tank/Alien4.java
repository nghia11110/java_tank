
package java_tank;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import javax.swing.ImageIcon;

public class Alien4 extends State implements Commons{
    private Bomb bomb;
    private  String shot = "hinhanh/E410.jpg";
    private final int UP = 0;
    private final int DOWN = 1;
    private final int LEFT = 2;
    private final int RIGHT = 3;
    private int blood=3; 
            
    public Alien4(int x, int y) {
        this.x = x;
        this.y = y;

        bomb = new Bomb(x, y);
        ImageIcon ii = new ImageIcon(shot);
        setImage(ii.getImage());
    }
    
    public void setBlood(){this.blood-=1;}
    
    public int getBlood(){return this.blood;}
    
    public void setShot(String shot){
      this.shot=shot;
    }
    public String getShot(){return shot;}  
    
    public void act(int direction,ArrayList walls,ArrayList steelwalls,ArrayList rivers,Player player,
            ArrayList aliens,ArrayList aliens1,ArrayList aliens2,ArrayList aliens3,ArrayList aliens4) {
       Random generator = new Random();
         if(direction==DOWN) 
         {
          this.y+=1;
         setShot("hinhanh/E410.jpg");
         ImageIcon ii = new ImageIcon(getShot());
         setImage(ii.getImage());
         }
         if(direction==UP) 
         {
          this.y-=1;
         setShot("hinhanh/E49.jpg");
         ImageIcon ii = new ImageIcon(getShot());
         setImage(ii.getImage());}
         if(direction==LEFT) 
         {
          this.x-=1;
         setShot("hinhanh/E411.jpg");
         ImageIcon ii = new ImageIcon(getShot());
         setImage(ii.getImage());
         }
         if(direction==RIGHT) 
         {
          this.x+=1;
         setShot("hinhanh/E412.jpg");
         ImageIcon ii = new ImageIcon(getShot());
         setImage(ii.getImage());
         }
         if (this.x  >= BOARD_WIDTH-24-BORDER_RIGHT  && direction == 3) {
                this.x=BOARD_WIDTH-24-BORDER_RIGHT;
                 while (direction ==3) direction=generator.nextInt(4);
                 }
            if (this.x <= 2 && direction == 2) {
                this.x=2;
                while(direction ==2) direction=generator.nextInt(4);
                }
            if(this.y >= (BOARD_HEIGHT - 50) && direction == 1){
                this.y=BOARD_HEIGHT-50;
             while(direction==1) direction=generator.nextInt(4);
            }
            
            if(this.y <= 2  && direction == 0){
                this.y=2;
             while(direction==0) direction=generator.nextInt(4);
            }
            
            if (this.x >= player.x-24 && this.x <= player.x+24 && this.y >= player.y-24 && this.y <= player.y+24 ) 
           {
            if(direction==UP) {this.y=this.y+1;while(direction==UP) direction=generator.nextInt(4);}
             else 
             {if(direction==DOWN) {this.y=this.y-1;while(direction==DOWN) direction=generator.nextInt(4);}
              else 
                {if(direction==LEFT) {this.x=this.x+1;while(direction==LEFT) direction=generator.nextInt(4);}
                  else 
                    if(direction==RIGHT) {this.x=this.x-1;while(direction==RIGHT) direction=generator.nextInt(4);}
                }
             }
            }
            
            Iterator it = walls.iterator();
        while (it.hasNext()){
          Wall wall=(Wall) it.next();  
        if (this.x >= wall.x-23 && this.x <= wall.x+23 && this.y >= wall.y-23 && this.y <= wall.y+23 && wall.isVisible()) 
           {
            if(direction==UP) {this.y=this.y+1;while(direction==UP) direction=generator.nextInt(4);break;}
            if(direction==DOWN) {this.y=this.y-1;while(direction==DOWN) direction=generator.nextInt(4);break;}
            if(direction==LEFT) {this.x=this.x+1;while(direction==LEFT) direction=generator.nextInt(4);break;}
            if(direction==RIGHT) {this.x=this.x-1;while(direction==RIGHT) direction=generator.nextInt(4);break;}
           
            }
       }
        
          Iterator it1 = steelwalls.iterator();
        while (it1.hasNext()){
          Steelwall steelwall=(Steelwall) it1.next();  
        if (this.x >= steelwall.x-23 && this.x <= steelwall.x+23 && this.y >= steelwall.y-23 && this.y <= steelwall.y+23 && steelwall.isVisible()) 
           {
            if(direction==UP) {this.y=this.y+1;while(direction==UP) direction=generator.nextInt(4);break;}
            if(direction==DOWN) {this.y=this.y-1;while(direction==DOWN) direction=generator.nextInt(4);break;}
            if(direction==LEFT) {this.x=this.x+1;while(direction==LEFT) direction=generator.nextInt(4);break;}
            if(direction==RIGHT) {this.x=this.x-1;while(direction==RIGHT) direction=generator.nextInt(4);break;}
            
             }
         }
        
        Iterator it2 = rivers.iterator();
        while (it2.hasNext()){
          River river=(River) it2.next();  
        if (this.x >= river.x-24 && this.x <= river.x+24 && this.y >= river.y-24 && this.y <= river.y+24 ) 
           {
            if(direction==UP) {this.y=this.y+1;while(direction==UP) direction=generator.nextInt(4);break;}
            if(direction==DOWN) {this.y=this.y-1;while(direction==DOWN) direction=generator.nextInt(4);break;}
            if(direction==LEFT) {this.x=this.x+1;while(direction==LEFT) direction=generator.nextInt(4);break;}
            if(direction==RIGHT) {this.x=this.x-1;while(direction==RIGHT) direction=generator.nextInt(4);break;}
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
                if (!this.equals(alien) && this.isVisible() && alien.isVisible()&&
                    this.x >= alien.x-25 && this.x <= alien.x+25 && this.y >= alien.y-25 && this.y <= alien.y+25 ) 
           {
            if(direction==UP) {this.y=this.y+1;while(direction==UP) direction=generator.nextInt(4);break;}
            if(direction==DOWN) {this.y=this.y-1;while(direction==DOWN) direction=generator.nextInt(4);break;}
            if(direction==LEFT) {this.x=this.x+1;while(direction==LEFT) direction=generator.nextInt(4);break;}
            if(direction==RIGHT) {this.x=this.x-1;while(direction==RIGHT) direction=generator.nextInt(4);break;}
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
                    if (!this.equals(alien) && this.isVisible() &&
                            this.x >= alien.x-25 && this.x <= alien.x+25 && this.y >= alien.y-25 && this.y <= alien.y+25 && alien.isVisible()) 
           {
            if(direction==UP) {this.y=this.y+1;while(direction==UP) direction=generator.nextInt(4);break;}
            if(direction==DOWN) {this.y=this.y-1;while(direction==DOWN) direction=generator.nextInt(4);break;}
            if(direction==LEFT) {this.x=this.x+1;while(direction==LEFT) direction=generator.nextInt(4);break;}
            if(direction==RIGHT) {this.x=this.x-1;while(direction==RIGHT) direction=generator.nextInt(4);break;}
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
          if (!this.equals(alien) && this.isVisible() &&
                  this.x >= alien.x-25 && this.x <= alien.x+25 && this.y >= alien.y-25 && this.y <= alien.y+25 && alien.isVisible() ) 
           {
            if(direction==UP) {this.y=this.y+1;while(direction==UP) direction=generator.nextInt(4);break;}
            if(direction==DOWN) {this.y=this.y-1;while(direction==DOWN) direction=generator.nextInt(4);break;}
            if(direction==LEFT) {this.x=this.x+1;while(direction==LEFT) direction=generator.nextInt(4);break;}
            if(direction==RIGHT) {this.x=this.x-1;while(direction==RIGHT) direction=generator.nextInt(4);break;}
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
                if (!this.equals(alien) && this.isVisible() &&
                        this.x >= alien.x-25 && this.x <= alien.x+25 && this.y >= alien.y-25 && this.y <= alien.y+25 && alien.isVisible()) 
           {
            if(direction==UP) {this.y=this.y+1;while(direction==UP) direction=generator.nextInt(4);break;}
            if(direction==DOWN) {this.y=this.y-1;while(direction==DOWN) direction=generator.nextInt(4);break;}
            if(direction==LEFT) {this.x=this.x+1;while(direction==LEFT) direction=generator.nextInt(4);break;}
            if(direction==RIGHT) {this.x=this.x-1;while(direction==RIGHT) direction=generator.nextInt(4);break;}
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
                if (!this.equals(alien) && this.isVisible() &&
                        this.x >= alien.x-25 && this.x <= alien.x+25 && this.y >= alien.y-25 && this.y <= alien.y+25 && alien.isVisible() ) 
           {
            if(direction==UP) {this.y=this.y+1;while(direction==UP) direction=generator.nextInt(4);break;}
            if(direction==DOWN) {this.y=this.y-1;while(direction==DOWN) direction=generator.nextInt(4);break;}
            if(direction==LEFT) {this.x=this.x+1;while(direction==LEFT) direction=generator.nextInt(4);break;}
            if(direction==RIGHT) {this.x=this.x-1;while(direction==RIGHT) direction=generator.nextInt(4);break;}
            }    
        }
        
    }
    public Bomb getBomb() {
        return bomb;
    }
    
    
    public  class Bomb extends State {

        private final String bomb = "hinhanh/bomb.png";
        private boolean destroyed;
        protected int duongbom;
        public Bomb(int x, int y) {
            setDestroyed(true);
            this.x = x;
            this.y = y;
            ImageIcon ii = new ImageIcon(bomb);
            setImage(ii.getImage());
        }

        public void setDestroyed(boolean destroyed) {
            this.destroyed = destroyed;
        }

        public boolean isDestroyed() {
            return destroyed;
        }
    }
}
