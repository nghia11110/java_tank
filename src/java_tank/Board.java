
package java_tank;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Board extends JPanel implements Runnable, Commons {
    private Dimension d;
    private ArrayList aliens,aliens1,aliens2,aliens3,aliens4,walls,steelwalls,rivers,Alien;
    private Player player;
    private Shot shot;
   private Boss boss;
    private int direction,direction1,direction2,direction3,direction4 ;
    private int deaths = 0,control=0,dem=0,count=1,count1=1,count2=1,count3=1,count4=1;
    private Present present;
    private boolean ingame = true;
    JFrame fr;
    protected  final String expl = "hinhanh/explosion.png";
   
    protected  String message = "Game Over!";
    Sound fire  = new Sound("fire.wav");
    Sound exp  = new Sound("explo.wav");
    
    private Thread animator;
    
   public Board() 
    {

        addKeyListener(new TAdapter());
        setFocusable(true);
        d = new Dimension(BOARD_WIDTH-BORDER_RIGHT, BOARD_HEIGHT);
        setBackground(Color.black);
        gameInit();
        setDoubleBuffered(true);
    } 
   
   public void addNotify() {
        super.addNotify();
        gameInit();
    }
   
   public void gameInit() {
        Alien = new ArrayList();
        aliens1 = new ArrayList();
        aliens2= new ArrayList();
        aliens = new ArrayList();
        aliens3= new ArrayList();
        aliens4 = new ArrayList();
        walls=new ArrayList();
        steelwalls=new ArrayList();
        rivers=new ArrayList();
     
              
                Alien alien = new Alien(5, 5);
                aliens.add(alien);
                Alien.add(alien); 
               
                Alien1 alien1 = new Alien1(50, 5);
                aliens1.add(alien1);
                Alien.add(alien1);
               
                Alien2 alien2 = new Alien2(430, 5);
                aliens2.add(alien2);
                Alien.add(alien2);
                
                Alien3 alien3 = new Alien3(200, 5);
                aliens3.add(alien3);
                Alien.add(alien3);
                
                Alien4 alien4 = new Alien4(250, 5);
                aliens4.add(alien4);
                Alien.add(alien4);
     // ve thanh bao ve tuong     
       for (int i=0; i < 1; i++) {
            for (int j=0; j <2 ; j++) {
                Wall wall = new Wall((BOARD_WIDTH-BORDER_RIGHT)/2-25, BOARD_HEIGHT-50-25*j);
                 walls.add(wall);
            }
          }
        for (int i=0; i < 1; i++) {
            for (int j=0; j <1 ; j++) {
                Wall wall = new Wall( (BOARD_WIDTH-BORDER_RIGHT)/2,BOARD_HEIGHT-75 );
                 walls.add(wall);
            }
          }   
        for (int i=0; i < 1; i++) {
            for (int j=0; j <2 ; j++) {
                Wall wall = new Wall((BOARD_WIDTH-BORDER_RIGHT)/2+25,BOARD_HEIGHT-50-25*j );
                 walls.add(wall);
            }
          }
        //ket thuc ve thanh
        
        for (int i=0; i < 1; i++) {
            for (int j=0; j <16 ; j++) {
                Wall wall = new Wall(25+25*j,200);
                 walls.add(wall);
            }
          }
       for (int i=0; i < 5; i++) {
            for (int j=0; j <1 ; j++) {
                Steelwall steelwall = new Steelwall(200 +25*i, 90+25*j);
                steelwalls.add(steelwall);
            }
          }
       
       for (int i=0; i < 10; i++) {
            for (int j=0; j <1 ; j++) {
                River river= new River(150 +25*i, 145+25*j);
                 rivers.add(river);
            }
          }
       boss=new Boss((BOARD_WIDTH-BORDER_RIGHT)/2,BOARD_HEIGHT-50); 
       player = new Player();
       player.life=3;
       shot = new Shot();
       present=new Present();
        
        if (animator == null || !ingame) {
            animator = new Thread(this);
            animator.start();
        }
    }
   
   public void drawAliens(Graphics g) 
    {
        for(int i=0;i<aliens1.size();i++)
         {  if("Alien".equals(aliens1.get(i).getClass().getSimpleName()))
         {Alien alien=(Alien)aliens1.get(i);            
            if (alien.isVisible()) {
                g.drawImage(alien.getImage(), alien.getX(), alien.getY(), this);
              
               }

            if (alien.isDying()) {
                alien.die();
              }
            }
         
          if("Alien1".equals(aliens1.get(i).getClass().getSimpleName()))
             { Alien1 alien=(Alien1)aliens1.get(i);

            if (alien.isVisible()) {
                g.drawImage(alien.getImage(), alien.getX(), alien.getY(), this);
               
               }

            if (alien.isDying()) {
                alien.die();
              }
            }
          if("Alien2".equals(aliens1.get(i).getClass().getSimpleName()))
             { Alien2 alien=(Alien2)aliens1.get(i);

            if (alien.isVisible()) {
                g.drawImage(alien.getImage(), alien.getX(), alien.getY(), this);
                
               }

            if (alien.isDying()) {
                alien.die();
              }
            }
          if("Alien3".equals(aliens1.get(i).getClass().getSimpleName()))
             { Alien3 alien=(Alien3)aliens1.get(i);

            if (alien.isVisible()) {
                g.drawImage(alien.getImage(), alien.getX(), alien.getY(), this);
                               }

            if (alien.isDying()) {
                alien.die();
              }
            }
          if("Alien4".equals(aliens1.get(i).getClass().getSimpleName()))
             { Alien4 alien=(Alien4)aliens1.get(i);

            if (alien.isVisible()) {
                g.drawImage(alien.getImage(), alien.getX(), alien.getY(), this);
                
               }

            if (alien.isDying()) {
                alien.die();
              }
            }
        } 
        
         for(int i=0;i<aliens2.size();i++)
         {  if("Alien".equals(aliens2.get(i).getClass().getSimpleName()))
             { Alien alien=(Alien)aliens2.get(i);

            if (alien.isVisible()) {
                g.drawImage(alien.getImage(), alien.getX(), alien.getY(), this);
                
               }

            if (alien.isDying()) {
                alien.die();
              }
            }
          if("Alien1".equals(aliens2.get(i).getClass().getSimpleName()))
             { Alien1 alien=(Alien1)aliens2.get(i);

            if (alien.isVisible()) {
                g.drawImage(alien.getImage(), alien.getX(), alien.getY(), this);
                
               }

            if (alien.isDying()) {
                alien.die();
              }
            }
          if("Alien2".equals(aliens2.get(i).getClass().getSimpleName()))
             { Alien2 alien=(Alien2)aliens2.get(i);

            if (alien.isVisible()) {
                g.drawImage(alien.getImage(), alien.getX(), alien.getY(), this);
                
               }

            if (alien.isDying()) {
                alien.die();
              }
            }
          if("Alien3".equals(aliens2.get(i).getClass().getSimpleName()))
             { Alien3 alien=(Alien3)aliens2.get(i);

            if (alien.isVisible()) {
                g.drawImage(alien.getImage(), alien.getX(), alien.getY(), this);
                
               }

            if (alien.isDying()) {
                alien.die();
              }
            }
          if("Alien4".equals(aliens2.get(i).getClass().getSimpleName()))
             { Alien4 alien=(Alien4)aliens2.get(i);

            if (alien.isVisible()) {
                g.drawImage(alien.getImage(), alien.getX(), alien.getY(), this);
                
               }

            if (alien.isDying()) {
                alien.die();
              }
            }
        }
          for(int i=0;i<aliens3.size();i++)
         {  if("Alien".equals(aliens3.get(i).getClass().getSimpleName()))
             { Alien alien=(Alien)aliens3.get(i);

            if (alien.isVisible()) {
                g.drawImage(alien.getImage(), alien.getX(), alien.getY(), this);
                
               }

            if (alien.isDying()) {
                alien.die();
              }
            }
          if("Alien1".equals(aliens3.get(i).getClass().getSimpleName()))
             { Alien1 alien=(Alien1)aliens3.get(i);

            if (alien.isVisible()) {
                g.drawImage(alien.getImage(), alien.getX(), alien.getY(), this);
                
               }

            if (alien.isDying()) {
                alien.die();
              }
            }
          if("Alien2".equals(aliens3.get(i).getClass().getSimpleName()))
             { Alien2 alien=(Alien2)aliens3.get(i);

            if (alien.isVisible()) {
                g.drawImage(alien.getImage(), alien.getX(), alien.getY(), this);
                
               }

            if (alien.isDying()) {
                alien.die();
              }
            }
          if("Alien3".equals(aliens3.get(i).getClass().getSimpleName()))
             { Alien3 alien=(Alien3)aliens3.get(i);

            if (alien.isVisible()) {
                g.drawImage(alien.getImage(), alien.getX(), alien.getY(), this);
                
               }

            if (alien.isDying()) {
                alien.die();
              }
            }
          if("Alien4".equals(aliens3.get(i).getClass().getSimpleName()))
             { Alien4 alien=(Alien4)aliens3.get(i);

            if (alien.isVisible()) {
                g.drawImage(alien.getImage(), alien.getX(), alien.getY(), this);
                
               }

            if (alien.isDying()) {
                alien.die();
              }
            }
        } 
          for(int i=0;i<aliens4.size();i++)
         {  if("Alien".equals(aliens4.get(i).getClass().getSimpleName()))
             { Alien alien=(Alien)aliens4.get(i);

            if (alien.isVisible()) {
                g.drawImage(alien.getImage(), alien.getX(), alien.getY(), this);
                
               }

            if (alien.isDying()) {
                alien.die();
              }
            }
          if("Alien1".equals(aliens4.get(i).getClass().getSimpleName()))
             { Alien1 alien=(Alien1)aliens4.get(i);

            if (alien.isVisible()) {
                g.drawImage(alien.getImage(), alien.getX(), alien.getY(), this);
                             }

            if (alien.isDying()) {
                alien.die();
              }
            }
          if("Alien2".equals(aliens4.get(i).getClass().getSimpleName()))
             { Alien2 alien=(Alien2)aliens4.get(i);

            if (alien.isVisible()) {
                g.drawImage(alien.getImage(), alien.getX(), alien.getY(), this);
                  }

            if (alien.isDying()) {
                alien.die();
              }
            }
          if("Alien3".equals(aliens4.get(i).getClass().getSimpleName()))
             { Alien3 alien=(Alien3)aliens4.get(i);

            if (alien.isVisible()) {
                g.drawImage(alien.getImage(), alien.getX(), alien.getY(), this);
                       }

            if (alien.isDying()) {
                alien.die();
              }
            }
          if("Alien4".equals(aliens4.get(i).getClass().getSimpleName()))
             { Alien4 alien=(Alien4)aliens4.get(i);

            if (alien.isVisible()) {
                g.drawImage(alien.getImage(), alien.getX(), alien.getY(), this);
                               }

            if (alien.isDying()) {
                alien.die();
              }
            }
        } 
          for(int i=0;i<aliens.size();i++)
         {  if("Alien".equals(aliens.get(i).getClass().getSimpleName()))
             { Alien alien=(Alien)aliens.get(i);

            if (alien.isVisible()) {
                g.drawImage(alien.getImage(), alien.getX(), alien.getY(), this);
                   }

            if (alien.isDying()) {
                alien.die();
              }
            }
          if("Alien1".equals(aliens.get(i).getClass().getSimpleName()))
             { Alien1 alien=(Alien1)aliens.get(i);

            if (alien.isVisible()) {
                g.drawImage(alien.getImage(), alien.getX(), alien.getY(), this);
                
               }

            if (alien.isDying()) {
                alien.die();
              }
            }
          if("Alien2".equals(aliens.get(i).getClass().getSimpleName()))
             { Alien2 alien=(Alien2)aliens.get(i);

            if (alien.isVisible()) {
                g.drawImage(alien.getImage(), alien.getX(), alien.getY(), this);
                
               }

            if (alien.isDying()) {
                alien.die();
              }
            }
          if("Alien3".equals(aliens.get(i).getClass().getSimpleName()))
             { Alien3 alien=(Alien3)aliens.get(i);

            if (alien.isVisible()) {
                g.drawImage(alien.getImage(), alien.getX(), alien.getY(), this);
                   }

            if (alien.isDying()) {
                alien.die();
              }
            }
          if("Alien4".equals(aliens.get(i).getClass().getSimpleName()))
             { Alien4 alien=(Alien4)aliens.get(i);

            if (alien.isVisible()) {
                g.drawImage(alien.getImage(), alien.getX(), alien.getY(), this);
                 }

            if (alien.isDying()) {
                alien.die();
              }
            }
        }  
    }
   public void drawWall(Graphics g){
       Iterator it =walls.iterator();

        while (it.hasNext()) {
            Wall wall = (Wall) it.next();

            if (wall.isVisible()) {
                g.drawImage(wall.getImage(), wall.getX(), wall.getY(), this);
            }

            if (wall.isDying()) {
                wall.die();
            }
        }
   }
   
   public void drawSteelWall(Graphics g){
       Iterator it =steelwalls.iterator();

        while (it.hasNext()) {
            Steelwall wall = (Steelwall) it.next();

            if (wall.isVisible()) {
                g.drawImage(wall.getImage(), wall.getX(), wall.getY(), this);
            }

            if (wall.isDying()) {
                wall.die();
            }
        }
   }
   
   public void drawRiver(Graphics g){
       Iterator it =rivers.iterator();

        while (it.hasNext()) {
            River wall = (River) it.next();

            if (wall.isVisible()) {
                g.drawImage(wall.getImage(), wall.getX(), wall.getY(), this);
            }

            if (wall.isDying()) {
                wall.die();
            }
        }
   }
   
    public void drawPlayer(Graphics g) {

        if (player.isVisible()) {
            g.drawImage(player.getImage(), player.getX(), player.getY(), this);
               }

        if (player.isDying()) {
            player.die();
            ingame = false;
        }
    }
   public void drawBoss(Graphics g) {

        if (boss.isVisible()) {
            g.drawImage(boss.getImage(), boss.getX(), boss.getY(), this);
               }

        if (boss.isDying()) {
            boss.die();
            ingame = false;
        }
    }
    public void drawPresent(Graphics g) {

        if (present.isVisible()) {
            g.drawImage(present.getImage(), present.getX(), present.getY(), this);
        }

        if (present.isDying()) {
            present.die();
        }
    }
    
    public void drawShot(Graphics g) {
        if (shot.isVisible())
            g.drawImage(shot.getImage(), shot.getX(), shot.getY(), this);
    }
    
    public void drawBombing(Graphics g) {

         for(int i=0;i<aliens1.size();i++)
         {  if("Alien".equals(aliens1.get(i).getClass().getSimpleName()))
             { Alien alien=(Alien)aliens1.get(i);  
              Alien.Bomb b = alien.getBomb();
            if (!b.isDestroyed()) {
                g.drawImage(b.getImage(), b.getX(), b.getY(), this); 
                }
             }
          if("Alien1".equals(aliens1.get(i).getClass().getSimpleName()))
             { Alien1 alien=(Alien1)aliens1.get(i);              
                Alien1.Bomb b = alien.getBomb();
            if (!b.isDestroyed()) {
                g.drawImage(b.getImage(), b.getX(), b.getY(), this); 
               }
                         
            }
          if("Alien2".equals(aliens1.get(i).getClass().getSimpleName()))
             { Alien2 alien=(Alien2)aliens1.get(i);    
                Alien2.Bomb b = alien.getBomb();
            if (!b.isDestroyed()) {
                g.drawImage(b.getImage(), b.getX(), b.getY(), this); 
            }
              }
            
          if("Alien3".equals(aliens1.get(i).getClass().getSimpleName()))
             { Alien3 alien=(Alien3)aliens1.get(i);            
                Alien3.Bomb b = alien.getBomb();
            if (!b.isDestroyed()) {
                g.drawImage(b.getImage(), b.getX(), b.getY(), this); 
              }           
            }
          if("Alien4".equals(aliens1.get(i).getClass().getSimpleName()))
             { Alien4 alien=(Alien4)aliens1.get(i);            
                Alien4.Bomb b = alien.getBomb();
            if (!b.isDestroyed()) {
                g.drawImage(b.getImage(), b.getX(), b.getY(), this); 
              }            
            }
        } 
        
         for(int i=0;i<aliens2.size();i++)
         {  if("Alien".equals(aliens2.get(i).getClass().getSimpleName()))
             { Alien alien=(Alien)aliens2.get(i);        
                Alien.Bomb b = alien.getBomb();
            if (!b.isDestroyed()) {
                g.drawImage(b.getImage(), b.getX(), b.getY(), this); 
              }                         
            }
          if("Alien1".equals(aliens2.get(i).getClass().getSimpleName()))
             { Alien1 alien=(Alien1)aliens2.get(i);           
                Alien1.Bomb b = alien.getBomb();

            if (!b.isDestroyed()) {
                g.drawImage(b.getImage(), b.getX(), b.getY(), this); 
              }
            }
          if("Alien2".equals(aliens2.get(i).getClass().getSimpleName()))
             { Alien2 alien=(Alien2)aliens2.get(i);           
                Alien2.Bomb b = alien.getBomb();
            if (!b.isDestroyed()) {
                g.drawImage(b.getImage(), b.getX(), b.getY(), this); 
              } 
            }
          if("Alien3".equals(aliens2.get(i).getClass().getSimpleName()))
             { Alien3 alien=(Alien3)aliens2.get(i);
                Alien3.Bomb b = alien.getBomb();

            if (!b.isDestroyed()) {
                g.drawImage(b.getImage(), b.getX(), b.getY(), this); 
              }   
            }
          if("Alien4".equals(aliens2.get(i).getClass().getSimpleName()))
             { Alien4 alien=(Alien4)aliens2.get(i);            
                Alien4.Bomb b = alien.getBomb();

            if (!b.isDestroyed()) {
                g.drawImage(b.getImage(), b.getX(), b.getY(), this); 
              }             
            }
        }
          for(int i=0;i<aliens3.size();i++)
         {  if("Alien".equals(aliens3.get(i).getClass().getSimpleName()))
             { Alien alien=(Alien)aliens3.get(i);
                Alien.Bomb b = alien.getBomb();

            if (!b.isDestroyed()) {
                g.drawImage(b.getImage(), b.getX(), b.getY(), this); 
             }            
            }
          if("Alien1".equals(aliens3.get(i).getClass().getSimpleName()))
             { Alien1 alien=(Alien1)aliens3.get(i);
             Alien1.Bomb b = alien.getBomb();

            if (!b.isDestroyed()) {
                g.drawImage(b.getImage(), b.getX(), b.getY(), this); 
               }
             }
          if("Alien2".equals(aliens3.get(i).getClass().getSimpleName()))
             { Alien2 alien=(Alien2)aliens3.get(i);
                Alien2.Bomb b = alien.getBomb();

            if (!b.isDestroyed()) {
                g.drawImage(b.getImage(), b.getX(), b.getY(), this); 
            }
               }
            
            
          if("Alien3".equals(aliens3.get(i).getClass().getSimpleName()))
             { Alien3 alien=(Alien3)aliens3.get(i);
          
                Alien3.Bomb b = alien.getBomb();

            if (!b.isDestroyed()) {
                g.drawImage(b.getImage(), b.getX(), b.getY(), this); 
            }
               }

           
          if("Alien4".equals(aliens3.get(i).getClass().getSimpleName()))
             { Alien4 alien=(Alien4)aliens3.get(i);

            
                Alien4.Bomb b = alien.getBomb();

            if (!b.isDestroyed()) {
                g.drawImage(b.getImage(), b.getX(), b.getY(), this); 
            }
               }

           
        } 
          for(int i=0;i<aliens4.size();i++)
         {  if("Alien".equals(aliens4.get(i).getClass().getSimpleName()))
             { Alien alien=(Alien)aliens4.get(i);

                Alien.Bomb b = alien.getBomb();

            if (!b.isDestroyed()) {
                g.drawImage(b.getImage(), b.getX(), b.getY(), this); 
            }
               }
         
          if("Alien1".equals(aliens4.get(i).getClass().getSimpleName()))
             { Alien1 alien=(Alien1)aliens4.get(i);
               Alien1.Bomb b = alien.getBomb();

            if (!b.isDestroyed()) {
                g.drawImage(b.getImage(), b.getX(), b.getY(), this); 
            }
               }

          if("Alien2".equals(aliens4.get(i).getClass().getSimpleName()))
             { Alien2 alien=(Alien2)aliens4.get(i);           
                Alien2.Bomb b = alien.getBomb();

            if (!b.isDestroyed()) {
                g.drawImage(b.getImage(), b.getX(), b.getY(), this); 
            }
               }
         
          if("Alien3".equals(aliens4.get(i).getClass().getSimpleName()))
             { Alien3 alien=(Alien3)aliens4.get(i);

            
                Alien3.Bomb b = alien.getBomb();

            if (!b.isDestroyed()) {
                g.drawImage(b.getImage(), b.getX(), b.getY(), this); 
            }
               }

            
          if("Alien4".equals(aliens4.get(i).getClass().getSimpleName()))
             { Alien4 alien=(Alien4)aliens4.get(i);
            
                Alien4.Bomb b = alien.getBomb();

            if (!b.isDestroyed()) {
                g.drawImage(b.getImage(), b.getX(), b.getY(), this); 
            }
               }

            
        } 
          for(int i=0;i<aliens.size();i++)
         {  if("Alien".equals(aliens.get(i).getClass().getSimpleName()))
             { Alien alien=(Alien)aliens.get(i);
               Alien.Bomb b = alien.getBomb();

            if (!b.isDestroyed()) {
                g.drawImage(b.getImage(), b.getX(), b.getY(), this); 
            }
               }
          
          if("Alien1".equals(aliens.get(i).getClass().getSimpleName()))
             { Alien1 alien=(Alien1)aliens.get(i);
        
                Alien1.Bomb b = alien.getBomb();

            if (!b.isDestroyed()) {
                g.drawImage(b.getImage(), b.getX(), b.getY(), this); 
            }
               }

            
          if("Alien2".equals(aliens.get(i).getClass().getSimpleName()))
             { Alien2 alien=(Alien2)aliens.get(i);
          
                Alien2.Bomb b = alien.getBomb();

            if (!b.isDestroyed()) {
                g.drawImage(b.getImage(), b.getX(), b.getY(), this); 
            }
               }

            
          if("Alien3".equals(aliens.get(i).getClass().getSimpleName()))
             { Alien3 alien=(Alien3)aliens.get(i);           
                Alien3.Bomb b = alien.getBomb();

            if (!b.isDestroyed()) {
                g.drawImage(b.getImage(), b.getX(), b.getY(), this); 
            }
               }

            
          if("Alien4".equals(aliens.get(i).getClass().getSimpleName()))
             { Alien4 alien=(Alien4)aliens.get(i);           
                Alien4.Bomb b = alien.getBomb();

            if (!b.isDestroyed()) {
                g.drawImage(b.getImage(), b.getX(), b.getY(), this); 
            }
               }

            
        }
    }
    
    public void paint(Graphics g)
    {
      super.paint(g);

      g.setColor(Color.black);
      g.fillRect(0, 0, d.width, d.height);
      g.setColor(new Color(0, 32, 48));
      g.fillRect(BOARD_WIDTH-BORDER_RIGHT, 0, BORDER_RIGHT, BOARD_HEIGHT);
      g.setColor(Color.white);
       g.drawString("remain:",BOARD_WIDTH-BORDER_RIGHT+1 ,30);
      g.drawString(String.valueOf(20-deaths),BOARD_WIDTH-BORDER_RIGHT+10 ,45);
      g.drawString("Misson1",BOARD_WIDTH-BORDER_RIGHT+1 , 10);
      g.drawString("Life: "+ String.valueOf(player.life),BOARD_WIDTH-BORDER_RIGHT+5 , BOARD_HEIGHT/2);
       g.setColor(Color.green);   

      if (ingame) {

        g.drawLine(BOARD_WIDTH-BORDER_RIGHT, 0, BOARD_WIDTH-BORDER_RIGHT, BOARD_HEIGHT);
         drawBoss(g); 
        drawAliens(g);
        drawWall(g);
        drawSteelWall(g);
        drawRiver(g);
        drawPlayer(g);
        drawShot(g);
        drawBombing(g);
        drawPresent(g);
      }

      Toolkit.getDefaultToolkit().sync();
      g.dispose();
    }
    
    public void gameOver()
    {

        Graphics g = this.getGraphics();

        g.setColor(Color.black);
        g.fillRect(0, 0, BOARD_WIDTH, BOARD_HEIGHT);

        g.setColor(new Color(0, 32, 48));
        g.fillRect(50, BOARD_WIDTH/2 - 30, BOARD_WIDTH-100, 50);
        g.setColor(Color.white);
        g.drawRect(50, BOARD_WIDTH/2 - 30, BOARD_WIDTH-100, 50);
        g.setColor(Color.white);
        g.drawString(message, BOARD_WIDTH /2 - 40, 
            BOARD_WIDTH/2);
    }
    
     public void animationCycle()  {

        if (deaths >= NUMBER_OF_ALIENS_TO_DESTROY) {
            ingame = false;
            message = "Mission complete!";
            player.level=2;
          //  gameOver();
        }
       
        // player
      if(control!=6)
    {   
        player.act(walls,steelwalls,rivers,aliens,aliens1,aliens2,aliens3,aliens4);
       
        
      // shot
        //array1
        if (shot.isVisible() ) {
            int shotX = shot.getX();
            int shotY = shot.getY();
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
                {
                int aX = alien.getX();
                int aY = alien.getY();

                if (alien.isVisible() && shot.isVisible()) {
                    if (shotX >= (aX) && 
                        shotX <= (aX + 2*ALIEN_WIDTH) &&
                        shotY >= (aY) &&
                        shotY <= (aY+2*ALIEN_HEIGHT) ) {
                                           
                            alien.setBlood();
                            if(alien.getBlood()==0)
                        {
                            ImageIcon ii1 = 
                                new ImageIcon(expl);
                            alien.setImage(ii1.getImage());
                            alien.setDying(true);
                            exp.play();
                            deaths++;
                            
                        }
                            shot.die();
                            
                        }
                }
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
                {
                int aX = alien.getX();
                int aY = alien.getY();

                if (alien.isVisible() && shot.isVisible()) {
                    if (shotX >= (aX) && 
                        shotX <= (aX + 2*ALIEN_WIDTH) &&
                        shotY >= (aY) &&
                        shotY <= (aY+2*ALIEN_HEIGHT) ) {
                                           
                           alien.setBlood();
                            if(alien.getBlood()==0)
                        {
                            ImageIcon ii1 = 
                                new ImageIcon(expl);
                            alien.setImage(ii1.getImage());
                            alien.setDying(true);
                            exp.play();
                            deaths++;
                            
                        }
                            shot.die();
                            
                        }
                }
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
                {
                int aX = alien.getX();
                int aY = alien.getY();

                if (alien.isVisible() && shot.isVisible()) {
                    if (shotX >= (aX) && 
                        shotX <= (aX + 2*ALIEN_WIDTH) &&
                        shotY >= (aY) &&
                        shotY <= (aY+2*ALIEN_HEIGHT) ) {
                                           
                            alien.setBlood();
                            if(alien.getBlood()==0)
                        {
                            ImageIcon ii1 = 
                                new ImageIcon(expl);
                            alien.setImage(ii1.getImage());
                            alien.setDying(true);
                            exp.play();
                            deaths++;
                            
                        }
                            shot.die();
                            
                        }
                }
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
                {
                int aX = alien.getX();
                int aY = alien.getY();

                if (alien.isVisible() && shot.isVisible()) {
                    if (shotX >= (aX) && 
                        shotX <= (aX + 2*ALIEN_WIDTH) &&
                        shotY >= (aY) &&
                        shotY <= (aY+2*ALIEN_HEIGHT) ) {
                                           
                            alien.setBlood();
                            if(alien.getBlood()==0)
                        {
                            ImageIcon ii1 = 
                                new ImageIcon(expl);
                            alien.setImage(ii1.getImage());
                            alien.setDying(true);
                            exp.play();
                            deaths++;
                            
                        }
                            shot.die();
                            
                        }
                }
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
                {
                int aX = alien.getX();
                int aY = alien.getY();

                if (alien.isVisible() && shot.isVisible()) {
                    if (shotX >= (aX) && 
                        shotX <= (aX + 2*ALIEN_WIDTH) &&
                        shotY >= (aY) &&
                        shotY <= (aY+2*ALIEN_HEIGHT) ) {
                            alien.setBlood();
                            if(alien.getBlood()==0)
                        {
                            ImageIcon ii1 = 
                                new ImageIcon(expl);
                            alien.setImage(ii1.getImage());
                            alien.setDying(true);
                            exp.play();
                            deaths++;
                            
                        }
                            shot.die();
                            
                        }
                }
             }
                
            }
            Iterator w = walls.iterator();
            while (w.hasNext()) {
                Wall wall = (Wall) w.next();
                int aX = wall.getX();
                int aY = wall.getY();

                if (wall.isVisible() && shot.isVisible()) {
                    if (shotX >= (aX) && 
                        shotX <= (aX + 2*ALIEN_WIDTH) &&
                        shotY >= (aY) &&
                        shotY <= (aY+2*ALIEN_HEIGHT) ) {
                            wall.setDying(true);
                            shot.die();
                           
                        }
                }
            }
            
            Iterator s = steelwalls.iterator();
            while (s.hasNext()) {
                Steelwall wall = (Steelwall) s.next();
                int aX = wall.getX();
                int aY = wall.getY();

                if (wall.isVisible() && shot.isVisible()) {
                    if (shotX >= (aX) && 
                        shotX <= (aX + 2*ALIEN_WIDTH) &&
                        shotY >= (aY) &&
                        shotY <= (aY+2*ALIEN_HEIGHT) ) {
                        if(player.power==0)  
                        {ImageIcon ii1 = 
                                new ImageIcon(expl);
                            shot.setImage(ii1.getImage());
                           shot.die();
                        }
                        if(player.power==1){
                            wall.setDying(true);
                            shot.die();
                           }
                        }
                   }
            }
            if (boss.isVisible() && shot.isVisible()) {
                    if (shotX >= (boss.getX()) && 
                        shotX <= (boss.getX() + 2*ALIEN_WIDTH) &&
                        shotY >= (boss.getY()) &&
                        shotY <= (boss.getY()+2*ALIEN_HEIGHT) ) {
                            boss.setDying(true);
                             exp.play();
                            shot.die();
                           ingame=false;
                        }
                }
            
            int y = shot.getY();
            int x=shot.getX();
            int z=shot.duongdan;
           if(z==1)
            {
                y -= (2.5 + player.speed);
             if (y < 0)
             shot.die();
            else shot.setY(y);
            } 
            
          if(z==2) 
          {
              y += (2.5 + player.speed);
              if(y>BOARD_HEIGHT - 30)
                 shot.die();
              else shot.setY(y);
            }   
           if(z==3)
          {   
              x -= (2.5 + player.speed);
              if(x<0)
                 shot.die();
              else shot.setX(x);
            }  
          if(z==4) 
          {
             x += (3 + player.speed);
             if(x>BOARD_WIDTH-BORDER_RIGHT )
                 shot.die();
             else shot.setX(x);
            }
        }
    
          // aliens
if(control!=3){
 
         Random generator1 = new Random();
         for(int i=0;i<aliens.size();i++) {
                if("Alien".equals(aliens.get(i).getClass().getSimpleName()))
              {Alien alien = (Alien)aliens.get(i);
                if(alien.isVisible()){
                    if((int)(Math.random()*10) > 8)
                     direction=generator1.nextInt(10);
           if(direction>7) direction=1;     
         alien.act(direction,walls,steelwalls,rivers,player,aliens,aliens1,aliens2,aliens3,aliens4);
                }
              }
                if("Alien1".equals(aliens.get(i).getClass().getSimpleName()))
                {Alien1 alien = (Alien1)aliens.get(i);
                if(alien.isVisible()){
                if((int)(Math.random()*10) > 8)
              direction=generator1.nextInt(10);
               if(direction>7) direction=1;
                alien.act(direction,walls,steelwalls,rivers,player,aliens,aliens1,aliens2,aliens3,aliens4);
                }
                }
                if("Alien2".equals(aliens.get(i).getClass().getSimpleName()))
                {Alien2 alien = (Alien2)aliens.get(i);
                if(alien.isVisible()){
                if((int)(Math.random()*10) > 8)
           direction=generator1.nextInt(10);
                if(direction>7) direction=1;
         alien.act(direction,walls,steelwalls,rivers,player,aliens,aliens1,aliens2,aliens3,aliens4);
                }}
                if("Alien3".equals(aliens.get(i).getClass().getSimpleName()))
                {Alien3 alien = (Alien3)aliens.get(i);
                if(alien.isVisible()){
                if((int)(Math.random()*10) > 8)
           direction=generator1.nextInt(10);
                if(direction>7) direction=1;
         alien.act(direction,walls,steelwalls,rivers,player,aliens,aliens1,aliens2,aliens3,aliens4);
                }}
                if("Alien4".equals(aliens.get(i).getClass().getSimpleName()))
                {Alien4 alien = (Alien4)aliens.get(i); 
                if(alien.isVisible()){
                if((int)(Math.random()*10) > 8)
                 direction=generator1.nextInt(10);
                if(direction>7) direction=1;
         alien.act(direction,walls,steelwalls,rivers,player,aliens,aliens1,aliens2,aliens3,aliens4);
                }      
               }        
             }
         
         for(int i=0;i<aliens1.size();i++) {
                if("Alien".equals(aliens1.get(i).getClass().getSimpleName()))
                {Alien alien = (Alien)aliens1.get(i);
                if(alien.isVisible()){
                if((int)(Math.random()*10) > 8)
           direction1=generator1.nextInt(10);
                if(direction1>7) direction1=1;
         alien.act(direction1,walls,steelwalls,rivers,player,aliens,aliens1,aliens2,aliens3,aliens4);
                }}
                if("Alien1".equals(aliens1.get(i).getClass().getSimpleName()))
                {Alien1 alien = (Alien1)aliens1.get(i);
                if(alien.isVisible()){
                if((int)(Math.random()*10) > 8)
              direction1=generator1.nextInt(10);
                 if(direction1>7) direction1=1;
                alien.act(direction1,walls,steelwalls,rivers,player,aliens,aliens1,aliens2,aliens3,aliens4);
                }}
                if("Alien2".equals(aliens1.get(i).getClass().getSimpleName()))
                {Alien2 alien = (Alien2)aliens1.get(i);
                if(alien.isVisible()){
                if((int)(Math.random()*10) > 8)
           direction1=generator1.nextInt(10);
                 if(direction1>7) direction1=1;
         alien.act(direction1,walls,steelwalls,rivers,player,aliens,aliens1,aliens2,aliens3,aliens4);
                }}
                if("Alien3".equals(aliens1.get(i).getClass().getSimpleName()))
                {Alien3 alien = (Alien3)aliens1.get(i);
                if(alien.isVisible()){
                if((int)(Math.random()*10) > 8)
           direction1=generator1.nextInt(10);
                 if(direction1>7) direction1=1;
         alien.act(direction1,walls,steelwalls,rivers,player,aliens,aliens1,aliens2,aliens3,aliens4);
                }}
                if("Alien4".equals(aliens1.get(i).getClass().getSimpleName()))
                {Alien4 alien = (Alien4)aliens1.get(i);
                if(alien.isVisible()){
                if((int)(Math.random()*10) > 8)
           direction1=generator1.nextInt(10);
                 if(direction1>7) direction1=1;
         alien.act(direction1,walls,steelwalls,rivers,player,aliens,aliens1,aliens2,aliens3,aliens4);
                }        
                }
             }
         for(int i=0;i<aliens2.size();i++) {
                if("Alien".equals(aliens2.get(i).getClass().getSimpleName()))
                {Alien alien = (Alien)aliens2.get(i);
                if(alien.isVisible()){
                if((int)(Math.random()*10) > 8)
           direction2=generator1.nextInt(10);
                 if(direction2>7) direction2=1;
         alien.act(direction2,walls,steelwalls,rivers,player,aliens,aliens1,aliens2,aliens3,aliens4);
                }}
                if("Alien1".equals(aliens2.get(i).getClass().getSimpleName()))
                {Alien1 alien = (Alien1)aliens2.get(i);
                if(alien.isVisible()){
                if((int)(Math.random()*10) > 8)
              direction2=generator1.nextInt(10);
                if(direction2>7) direction2=1;
                alien.act(direction2,walls,steelwalls,rivers,player,aliens,aliens1,aliens2,aliens3,aliens4);
                }}
                if("Alien2".equals(aliens2.get(i).getClass().getSimpleName()))
                {Alien2 alien = (Alien2)aliens2.get(i);
                if(alien.isVisible()){
                if((int)(Math.random()*10) > 8)
           direction2=generator1.nextInt(10);
                if(direction2>7) direction2=1;
         alien.act(direction2,walls,steelwalls,rivers,player,aliens,aliens1,aliens2,aliens3,aliens4);
                }}
                if("Alien3".equals(aliens2.get(i).getClass().getSimpleName()))
                {Alien3 alien = (Alien3)aliens2.get(i);
                if(alien.isVisible()){
                if((int)(Math.random()*10) > 8)
           direction2=generator1.nextInt(10);
               if(direction2>7) direction2=1;
         alien.act(direction2,walls,steelwalls,rivers,player,aliens,aliens1,aliens2,aliens3,aliens4);
                }}
                if("Alien4".equals(aliens2.get(i).getClass().getSimpleName()))
                {Alien4 alien = (Alien4)aliens2.get(i); 
                if(alien.isVisible()){
                if((int)(Math.random()*10) > 8)
           direction2=generator1.nextInt(10);
                if(direction2>7) direction2=1;
         alien.act(direction2,walls,steelwalls,rivers,player,aliens,aliens1,aliens2,aliens3,aliens4);
                }              
                }
             }
         for(int i=0;i<aliens3.size();i++) {
                if("Alien".equals(aliens3.get(i).getClass().getSimpleName()))
                {Alien alien = (Alien)aliens3.get(i);
                if(alien.isVisible()){
                if((int)(Math.random()*10) > 8)
           direction3=generator1.nextInt(10);
                if(direction3>7) direction3=1;
         alien.act(direction3,walls,steelwalls,rivers,player,aliens,aliens1,aliens2,aliens3,aliens4);
                }}
                if("Alien1".equals(aliens3.get(i).getClass().getSimpleName()))
                {Alien1 alien = (Alien1)aliens3.get(i);
                if(alien.isVisible()){
                if((int)(Math.random()*10) > 8)
              direction3=generator1.nextInt(10);
               if(direction3>7) direction3=1;
                alien.act(direction3,walls,steelwalls,rivers,player,aliens,aliens1,aliens2,aliens3,aliens4);
                }}
                if("Alien2".equals(aliens3.get(i).getClass().getSimpleName()))
                {Alien2 alien = (Alien2)aliens3.get(i);
                if(alien.isVisible()){
                if((int)(Math.random()*10) > 8)
           direction3=generator1.nextInt(10);
                if(direction3>7) direction3=1;
         alien.act(direction3,walls,steelwalls,rivers,player,aliens,aliens1,aliens2,aliens3,aliens4);
                }}
                if("Alien3".equals(aliens3.get(i).getClass().getSimpleName()))
                {Alien3 alien = (Alien3)aliens3.get(i);
                if(alien.isVisible()){
                if((int)(Math.random()*10) > 8)
           direction3=generator1.nextInt(10);
                if(direction3>7) direction3=1;
         alien.act(direction3,walls,steelwalls,rivers,player,aliens,aliens1,aliens2,aliens3,aliens4);
                }}
                if("Alien4".equals(aliens3.get(i).getClass().getSimpleName()))
                {Alien4 alien = (Alien4)aliens3.get(i); 
                if(alien.isVisible()){
                if((int)(Math.random()*10) > 8)
           direction3=generator1.nextInt(10);
                if(direction3>7) direction3=1;
         alien.act(direction3,walls,steelwalls,rivers,player,aliens,aliens1,aliens2,aliens3,aliens4);
                }    
                }
             }
         for(int i=0;i<aliens4.size();i++) {
                if("Alien".equals(aliens4.get(i).getClass().getSimpleName()))
                {Alien alien = (Alien)aliens4.get(i);
                if(alien.isVisible()){
                if((int)(Math.random()*10) > 8)
           direction4=generator1.nextInt(10);
                if(direction4>7) direction4=1;
         alien.act(direction4,walls,steelwalls,rivers,player,aliens,aliens1,aliens2,aliens3,aliens4);
                }}
                if("Alien1".equals(aliens4.get(i).getClass().getSimpleName()))
                {Alien1 alien = (Alien1)aliens4.get(i);
                if(alien.isVisible()){
                if((int)(Math.random()*10) > 8)
              direction4=generator1.nextInt(10);
                if(direction4>7) direction4=1;
                alien.act(direction4,walls,steelwalls,rivers,player,aliens,aliens1,aliens2,aliens3,aliens4);
                }}
                if("Alien2".equals(aliens4.get(i).getClass().getSimpleName()))
                {Alien2 alien = (Alien2)aliens4.get(i);
                if(alien.isVisible()){
                if((int)(Math.random()*10) > 8)
           direction4=generator1.nextInt(10);
               if(direction4>7) direction4=1;
         alien.act(direction4,walls,steelwalls,rivers,player,aliens,aliens1,aliens2,aliens3,aliens4);
                }}
                if("Alien3".equals(aliens4.get(i).getClass().getSimpleName()))
                {Alien3 alien = (Alien3)aliens4.get(i);
                if(alien.isVisible()){
                if((int)(Math.random()*10) > 8)
           direction4=generator1.nextInt(10);
                if(direction4>7) direction4=1;
         alien.act(direction4,walls,steelwalls,rivers,player,aliens,aliens1,aliens2,aliens3,aliens4);
                }}
                if("Alien4".equals(aliens4.get(i).getClass().getSimpleName()))
                {Alien4 alien = (Alien4)aliens4.get(i); 
                if(alien.isVisible()){
                if((int)(Math.random()*10) > 8)
           direction4=generator1.nextInt(10);
                if(direction4>7) direction4=1;
         alien.act(direction4,walls,steelwalls,rivers,player,aliens,aliens1,aliens2,aliens3,aliens4);
                }           
                }
             }

        // bombs
//array
                 
        Random gene = new Random();

        for(int i=0;i<aliens.size();i++) {
            if("Alien".equals(aliens.get(i).getClass().getSimpleName()))
            {
            int shot1 = gene.nextInt(15);
            Alien a = (Alien)aliens.get(i);
            Alien.Bomb b = a.getBomb();
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E22.jpg".equals(a.getShot())) {
                b.duongbom=2;
                b.setDestroyed(false);
                b.setX(a.getX()+11);
                b.setY(a.getY());   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E23.jpg".equals(a.getShot())) {
                b.duongbom=3;
                b.setDestroyed(false);
                b.setX(a.getX());
                b.setY(a.getY()+6);   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E24.jpg".equals(a.getShot())) {
                b.duongbom=4;
                b.setDestroyed(false);
                b.setX(a.getX());
                b.setY(a.getY()+6);   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E21.jpg".equals(a.getShot())) {
                b.duongbom=1;
                b.setDestroyed(false);
                b.setX(a.getX()+11);
                b.setY(a.getY());   
            }

            int bombX = b.getX();
            int bombY = b.getY();
            int playerX = player.getX();
            int playerY = player.getY();

            if (player.isVisible() && !b.isDestroyed()) {
                if ( bombX >= (playerX) && 
                    bombX <= (playerX+PLAYER_WIDTH) &&
                    bombY >= (playerY) && 
                    bombY <= (playerY+PLAYER_HEIGHT) ) {
                        ImageIcon ii1 = 
                            new ImageIcon(expl);
                        player.setImage(ii1.getImage());
                         exp.play();
                        player.life--;
                        if(player.life==0)
                        player.setDying(true);
                        else {
                            ImageIcon ii = new ImageIcon("hinhanh/T1.jpg");
                          player.power=0;
                          player.speed=0;
                          player.setImage(ii.getImage());
                          player.setPl("hinhanh/T1.jpg");
                          player.setY(BOARD_HEIGHT/2+125);
                          player.setX(BOARD_WIDTH/2-100);
                          player.playername="hinhanh/T1.jpg";
                        }
                        b.setDestroyed(true);
                    }
            }
            if (boss.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (boss.getX()) && 
                        bombX <= (boss.getX() + 2*ALIEN_WIDTH) &&
                        bombY >= (boss.getY()) &&
                        bombY <= (boss.getY()+2*ALIEN_HEIGHT) ) {
                            boss.setDying(true);
                             exp.play();
                            b.setDestroyed(true);
                           ingame=false;
                        }
                }
           if (shot.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (shot.getX()) && bombX <= (shot.getX()+2*BOMB_HEIGHT) 
                            && bombY >= (shot.getY()) && bombY <= (shot.getY()+2*BOMB_HEIGHT) ) 
                       {
                          //  shot.setDying(true);
                            shot.die();
                            b.setDestroyed(true);
                        }
                }
           Iterator s = steelwalls.iterator();
            while (s.hasNext()) {
                Steelwall wall = (Steelwall) s.next();
                int aX = wall.getX();
                int aY = wall.getY();

                if (wall.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (aX) && 
                        bombX <= (aX + 2*ALIEN_WIDTH) &&
                        bombY >= (aY) &&
                        bombY <= (aY+2*ALIEN_HEIGHT) ) {
                           b.setDestroyed(true);
                            }
                }
            }
            
            Iterator w = walls.iterator();
            while (w.hasNext()) {
                Wall wall = (Wall) w.next();
                int aX = wall.getX();
                int aY = wall.getY();

                if (wall.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (aX) && 
                        bombX <= (aX + 2*ALIEN_WIDTH) &&
                        bombY >= (aY) &&
                        bombY <= (aY+2*ALIEN_HEIGHT) ) {
                           wall.setDying(true);
                        b.setDestroyed(true);
                            }
                }
            }
            if (!b.isDestroyed()) {
                if(b.duongbom==2){
                    b.setY(b.getY() + 2);   
                    if (b.getY() >= BOARD_HEIGHT)
                    b.setDestroyed(true);
                 }
                if(b.duongbom==1){
                   b.setY(b.getY()- 2);
                   if(b.getY()<0) b.setDestroyed(true);
                }
               if(b.duongbom==3){
                   b.setX(b.getX()- 2);
                   if(b.getX()<0) b.setDestroyed(true);
               }
               if(b.duongbom==4){
                   b.setX(b.getX()+ 2);
                   if(b.getX()>BOARD_WIDTH-BORDER_RIGHT ) b.setDestroyed(true);
               }
            }
        }
           Random gene1 = new Random();
            if("Alien1".equals(aliens.get(i).getClass().getSimpleName())){
               int shot1 = gene1.nextInt(15);
            Alien1 a = (Alien1)aliens.get(i);
            Alien1.Bomb b = a.getBomb();
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E26.jpg".equals(a.getShot())) {
                b.duongbom=2;
                b.setDestroyed(false);
                b.setX(a.getX()+11);
                b.setY(a.getY());   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E27.jpg".equals(a.getShot())) {
                b.duongbom=3;
                b.setDestroyed(false);
                b.setX(a.getX());
                b.setY(a.getY()+6);   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E28.jpg".equals(a.getShot())) {
                b.duongbom=4;
                b.setDestroyed(false);
                b.setX(a.getX());
                b.setY(a.getY()+6);   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E25.jpg".equals(a.getShot())) {
                b.duongbom=1;
                b.setDestroyed(false);
                b.setX(a.getX()+11);
                b.setY(a.getY());   
            }

            int bombX = b.getX();
            int bombY = b.getY();
            int playerX = player.getX();
            int playerY = player.getY();

            if (player.isVisible() && !b.isDestroyed()) {
                if ( bombX >= (playerX) && 
                    bombX <= (playerX+PLAYER_WIDTH) &&
                    bombY >= (playerY) && 
                    bombY <= (playerY+PLAYER_HEIGHT) ) {
                        ImageIcon ii1 = 
                            new ImageIcon(expl);
                        player.setImage(ii1.getImage());
                         exp.play();
                        player.life--;
                        if(player.life==0)
                        player.setDying(true);
                        else {
                            ImageIcon ii = new ImageIcon("hinhanh/T1.jpg");
                          player.power=0;
                          player.speed=0;
                          player.setImage(ii.getImage());
                          player.setPl("hinhanh/T1.jpg");
                          player.setY(BOARD_HEIGHT/2+125);
                          player.setX(BOARD_WIDTH/2-100);
                          player.playername="hinhanh/T1.jpg";
                        }
                        b.setDestroyed(true);
                    }
            }
          if (boss.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (boss.getX()) && 
                        bombX <= (boss.getX() + 2*ALIEN_WIDTH) &&
                        bombY >= (boss.getY()) &&
                        bombY <= (boss.getY()+2*ALIEN_HEIGHT) ) {
                            boss.setDying(true);
                             exp.play();
                            b.setDestroyed(true);
                           ingame=false;
                        }
                }
          if (shot.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (shot.getX()) && bombX <= (shot.getX()+2*BOMB_HEIGHT) 
                            && bombY >= (shot.getY()) && bombY <= (shot.getY()+2*BOMB_HEIGHT) ) 
                      {
                            shot.die();
                            b.setDestroyed(true);
                        }
                }
             Iterator s = steelwalls.iterator();
            while (s.hasNext()) {
                Steelwall wall = (Steelwall) s.next();
                int aX = wall.getX();
                int aY = wall.getY();

                if (wall.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (aX) && 
                        bombX <= (aX + 2*ALIEN_WIDTH) &&
                        bombY >= (aY) &&
                        bombY <= (aY+2*ALIEN_HEIGHT) ) {
                           b.setDestroyed(true);
                            }
                }
            }
            
            Iterator w = walls.iterator();
            while (w.hasNext()) {
                Wall wall = (Wall) w.next();
                int aX = wall.getX();
                int aY = wall.getY();

                if (wall.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (aX) && 
                        bombX <= (aX + 2*ALIEN_WIDTH) &&
                        bombY >= (aY) &&
                        bombY <= (aY+2*ALIEN_HEIGHT) ) {
                           wall.setDying(true);
                        b.setDestroyed(true);
                            }
                }
            }
            if (!b.isDestroyed()) {
                if(b.duongbom==2){
                    b.setY(b.getY() + 2);   
                    if (b.getY() >= BOARD_HEIGHT)
                    b.setDestroyed(true);
                 }
                if(b.duongbom==1){
                   b.setY(b.getY()-2);
                   if(b.getY()<0) b.setDestroyed(true);
                }
               if(b.duongbom==3){
                   b.setX(b.getX()-2);
                   if(b.getX()<0) b.setDestroyed(true);
               }
               if(b.duongbom==4){
                   b.setX(b.getX()+2);
                   if(b.getX()>BOARD_WIDTH-BORDER_RIGHT ) b.setDestroyed(true);
               }
            }
          }  
            Random gene2 = new Random();
            if("Alien2".equals(aliens.get(i).getClass().getSimpleName())){
                 int shot1 = gene2.nextInt(15);
            Alien2 a = (Alien2)aliens.get(i);
            Alien2.Bomb b = a.getBomb();
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E42.jpg".equals(a.getShot())) {
                b.duongbom=2;
                b.setDestroyed(false);
                b.setX(a.getX()+11);
                b.setY(a.getY());   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E43.jpg".equals(a.getShot())) {
                b.duongbom=3;
                b.setDestroyed(false);
                b.setX(a.getX());
                b.setY(a.getY()+6);   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E44.jpg".equals(a.getShot())) {
                b.duongbom=4;
                b.setDestroyed(false);
                b.setX(a.getX());
                b.setY(a.getY()+6);   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E41.jpg".equals(a.getShot())) {
                b.duongbom=1;
                b.setDestroyed(false);
                b.setX(a.getX()+11);
                b.setY(a.getY());   
            }

            int bombX = b.getX();
            int bombY = b.getY();
            int playerX = player.getX();
            int playerY = player.getY();

            if (player.isVisible() && !b.isDestroyed()) {
                if ( bombX >= (playerX) && 
                    bombX <= (playerX+PLAYER_WIDTH) &&
                    bombY >= (playerY) && 
                    bombY <= (playerY+PLAYER_HEIGHT) ) {
                        ImageIcon ii1 = 
                            new ImageIcon(expl);
                        player.setImage(ii1.getImage());
                         exp.play();
                        player.life--;
                        if(player.life==0)
                        player.setDying(true);
                        else {
                            ImageIcon ii = new ImageIcon("hinhanh/T1.jpg");
                          player.power=0;
                          player.speed=0;
                          player.setImage(ii.getImage());
                          player.setPl("hinhanh/T1.jpg");
                          player.setY(BOARD_HEIGHT/2+125);
                          player.setX(BOARD_WIDTH/2-100);
                          player.playername="hinhanh/T1.jpg";
                        }
                        b.setDestroyed(true);
                    }
            }
          if (boss.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (boss.getX()) && 
                        bombX <= (boss.getX() + 2*ALIEN_WIDTH) &&
                        bombY >= (boss.getY()) &&
                        bombY <= (boss.getY()+2*ALIEN_HEIGHT) ) {
                            boss.setDying(true);
                             exp.play();
                            b.setDestroyed(true);
                           ingame=false;
                        }
                }
          if (shot.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (shot.getX()) && bombX <= (shot.getX()+2*BOMB_HEIGHT) 
                            && bombY >= (shot.getY()) && bombY <= (shot.getY()+2*BOMB_HEIGHT) ) 
                      {
                            shot.die();
                            b.setDestroyed(true);
                        }
                }
             Iterator s = steelwalls.iterator();
            while (s.hasNext()) {
                Steelwall wall = (Steelwall) s.next();
                int aX = wall.getX();
                int aY = wall.getY();

                if (wall.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (aX) && 
                        bombX <= (aX + 2*ALIEN_WIDTH) &&
                        bombY >= (aY) &&
                        bombY <= (aY+2*ALIEN_HEIGHT) ) {
                           b.setDestroyed(true);
                            }
                }
            }
            
            Iterator w = walls.iterator();
            while (w.hasNext()) {
                Wall wall = (Wall) w.next();
                int aX = wall.getX();
                int aY = wall.getY();

                if (wall.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (aX) && 
                        bombX <= (aX + 2*ALIEN_WIDTH) &&
                        bombY >= (aY) &&
                        bombY <= (aY+2*ALIEN_HEIGHT) ) {
                           wall.setDying(true);
                        b.setDestroyed(true);
                            }
                }
            }
            if (!b.isDestroyed()) {
                if(b.duongbom==2){
                    b.setY(b.getY() + 2);   
                    if (b.getY() >= BOARD_HEIGHT)
                    b.setDestroyed(true);
                 }
                if(b.duongbom==1){
                   b.setY(b.getY()-2);
                   if(b.getY()<0) b.setDestroyed(true);
                }
               if(b.duongbom==3){
                   b.setX(b.getX()-2);
                   if(b.getX()<0) b.setDestroyed(true);
               }
               if(b.duongbom==4){
                   b.setX(b.getX()+2);
                   if(b.getX()>BOARD_WIDTH-BORDER_RIGHT ) b.setDestroyed(true);
               }
            }
            }
          Random gene3 = new Random();
            if("Alien3".equals(aliens.get(i).getClass().getSimpleName()))  {
                int shot1 = gene3.nextInt(15);
            Alien3 a = (Alien3)aliens.get(i);
            Alien3.Bomb b = a.getBomb();
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E46.jpg".equals(a.getShot())) {
                b.duongbom=2;
                b.setDestroyed(false);
                b.setX(a.getX()+11);
                b.setY(a.getY());   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E47.jpg".equals(a.getShot())) {
                b.duongbom=3;
                b.setDestroyed(false);
                b.setX(a.getX());
                b.setY(a.getY()+6);   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E48.jpg".equals(a.getShot())) {
                b.duongbom=4;
                b.setDestroyed(false);
                b.setX(a.getX());
                b.setY(a.getY()+6);   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E45.jpg".equals(a.getShot())) {
                b.duongbom=1;
                b.setDestroyed(false);
                b.setX(a.getX()+11);
                b.setY(a.getY());   
            }

            int bombX = b.getX();
            int bombY = b.getY();
            int playerX = player.getX();
            int playerY = player.getY();

            if (player.isVisible() && !b.isDestroyed()) {
                if ( bombX >= (playerX) && 
                    bombX <= (playerX+PLAYER_WIDTH) &&
                    bombY >= (playerY) && 
                    bombY <= (playerY+PLAYER_HEIGHT) ) {
                        ImageIcon ii1 = 
                            new ImageIcon(expl);
                        player.setImage(ii1.getImage());
                         exp.play();
                        player.life--;
                        if(player.life==0)
                        player.setDying(true);
                        else {
                         ImageIcon ii = new ImageIcon("hinhanh/T1.jpg");
                          player.power=0;
                          player.speed=0;
                          player.setImage(ii.getImage());
                          player.setPl("hinhanh/T1.jpg");
                          player.setY(BOARD_HEIGHT/2+125);
                          player.setX(BOARD_WIDTH/2-100);
                          player.playername="hinhanh/T1.jpg";
                        }
                        b.setDestroyed(true);
                    }
            }
          if (boss.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (boss.getX()) && 
                        bombX <= (boss.getX() + 2*ALIEN_WIDTH) &&
                        bombY >= (boss.getY()) &&
                        bombY <= (boss.getY()+2*ALIEN_HEIGHT) ) {
                            boss.setDying(true);
                             exp.play();
                            b.setDestroyed(true);
                           ingame=false;
                        }
                }
          if (shot.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (shot.getX()) && bombX <= (shot.getX()+2*BOMB_HEIGHT) 
                            && bombY >= (shot.getY()) && bombY <= (shot.getY()+2*BOMB_HEIGHT)  ) 
                      {
                            shot.die();
                            b.setDestroyed(true);
                        }
                }
             Iterator s = steelwalls.iterator();
            while (s.hasNext()) {
                Steelwall wall = (Steelwall) s.next();
                int aX = wall.getX();
                int aY = wall.getY();

                if (wall.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (aX) && 
                        bombX <= (aX + 2*ALIEN_WIDTH) &&
                        bombY >= (aY) &&
                        bombY <= (aY+2*ALIEN_HEIGHT) ) {
                           b.setDestroyed(true);
                            }
                }
            }
            
            Iterator w = walls.iterator();
            while (w.hasNext()) {
                Wall wall = (Wall) w.next();
                int aX = wall.getX();
                int aY = wall.getY();

                if (wall.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (aX) && 
                        bombX <= (aX + 2*ALIEN_WIDTH) &&
                        bombY >= (aY) &&
                        bombY <= (aY+2*ALIEN_HEIGHT) ) {
                           wall.setDying(true);
                        b.setDestroyed(true);
                            }
                }
            }
            if (!b.isDestroyed()) {
                if(b.duongbom==2){
                    b.setY(b.getY() + 2);   
                    if (b.getY() >= BOARD_HEIGHT)
                    b.setDestroyed(true);
                 }
                if(b.duongbom==1){
                   b.setY(b.getY()-2);
                   if(b.getY()<0) b.setDestroyed(true);
                }
               if(b.duongbom==3){
                   b.setX(b.getX()-2);
                   if(b.getX()<0) b.setDestroyed(true);
               }
               if(b.duongbom==4){
                   b.setX(b.getX()+2);
                   if(b.getX()>BOARD_WIDTH-BORDER_RIGHT ) b.setDestroyed(true);
               }
            }
            }
            Random gene4 = new Random();
            if("Alien4".equals(aliens.get(i).getClass().getSimpleName())) {
                 int shot1 = gene4.nextInt(15);
            Alien4 a = (Alien4)aliens.get(i);
            Alien4.Bomb b = a.getBomb();
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E410.jpg".equals(a.getShot())) {
                b.duongbom=2;
                b.setDestroyed(false);
                b.setX(a.getX()+11);
                b.setY(a.getY());   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E411.jpg".equals(a.getShot())) {
                b.duongbom=3;
                b.setDestroyed(false);
                b.setX(a.getX());
                b.setY(a.getY()+6);   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E412.jpg".equals(a.getShot())) {
                b.duongbom=4;
                b.setDestroyed(false);
                b.setX(a.getX());
                b.setY(a.getY()+6);   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E49.jpg".equals(a.getShot())) {
                b.duongbom=1;
                b.setDestroyed(false);
                b.setX(a.getX()+11);
                b.setY(a.getY());   
            }

            int bombX = b.getX();
            int bombY = b.getY();
            int playerX = player.getX();
            int playerY = player.getY();

            if (player.isVisible() && !b.isDestroyed()) {
                if ( bombX >= (playerX) && 
                    bombX <= (playerX+PLAYER_WIDTH) &&
                    bombY >= (playerY) && 
                    bombY <= (playerY+PLAYER_HEIGHT) ) {
                        ImageIcon ii1 = 
                            new ImageIcon(expl);
                        player.setImage(ii1.getImage());
                         exp.play();
                        player.life--;
                        if(player.life==0)
                        player.setDying(true);
                        else {
                          ImageIcon ii = new ImageIcon("hinhanh/T1.jpg");
                          player.power=0;
                          player.speed=0;
                          player.setImage(ii.getImage());
                          player.setPl("hinhanh/T1.jpg");
                          player.setY(BOARD_HEIGHT/2+125);
                          player.setX(BOARD_WIDTH/2-100);
                          player.playername="hinhanh/T1.jpg";
                        }
                        b.setDestroyed(true);
                        
                    }
            }
          if (boss.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (boss.getX()) && 
                        bombX <= (boss.getX() + 2*ALIEN_WIDTH) &&
                        bombY >= (boss.getY()) &&
                        bombY <= (boss.getY()+2*ALIEN_HEIGHT) ) {
                            boss.setDying(true);
                             exp.play();
                            b.setDestroyed(true);
                           ingame=false;
                        }
                }
          if (shot.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (shot.getX()) && bombX <= (shot.getX()+2*BOMB_HEIGHT) 
                            && bombY >= (shot.getY()) && bombY <= (shot.getY()+2*BOMB_HEIGHT) ) 
                      {
                            shot.die();
                            b.setDestroyed(true);
                        }
                }
             Iterator s = steelwalls.iterator();
            while (s.hasNext()) {
                Steelwall wall = (Steelwall) s.next();
                int aX = wall.getX();
                int aY = wall.getY();

                if (wall.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (aX) && 
                        bombX <= (aX + 2*ALIEN_WIDTH) &&
                        bombY >= (aY) &&
                        bombY <= (aY+2*ALIEN_HEIGHT) ) {
                           b.setDestroyed(true);
                            }
                }
            }
            
            Iterator w = walls.iterator();
            while (w.hasNext()) {
                Wall wall = (Wall) w.next();
                int aX = wall.getX();
                int aY = wall.getY();

                if (wall.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (aX) && 
                        bombX <= (aX + 2*ALIEN_WIDTH) &&
                        bombY >= (aY) &&
                        bombY <= (aY+2*ALIEN_HEIGHT) ) {
                           wall.setDying(true);
                        b.setDestroyed(true);
                            }
                }
            }
            if (!b.isDestroyed()) {
                if(b.duongbom==2){
                    b.setY(b.getY() + 2);   
                    if (b.getY() >= BOARD_HEIGHT)
                    b.setDestroyed(true);
                 }
                if(b.duongbom==1){
                   b.setY(b.getY()-2);
                   if(b.getY()<0) b.setDestroyed(true);
                }
               if(b.duongbom==3){
                   b.setX(b.getX()-2);
                   if(b.getX()<0) b.setDestroyed(true);
               }
               if(b.duongbom==4){
                   b.setX(b.getX()+2);
                   if(b.getX()>BOARD_WIDTH-BORDER_RIGHT ) b.setDestroyed(true);
               }
            }
         }
     } 
 
         Random gen = new Random();

        for(int i=0;i<aliens1.size();i++) {
            if("Alien".equals(aliens1.get(i).getClass().getSimpleName()))
            {
            int shot1 = gen.nextInt(15);
            Alien a = (Alien)aliens1.get(i);
            Alien.Bomb b = a.getBomb();
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E22.jpg".equals(a.getShot())) {
                b.duongbom=2;
                b.setDestroyed(false);
                b.setX(a.getX()+11);
                b.setY(a.getY());   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E23.jpg".equals(a.getShot())) {
                b.duongbom=3;
                b.setDestroyed(false);
                b.setX(a.getX());
                b.setY(a.getY()+6);   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E24.jpg".equals(a.getShot())) {
                b.duongbom=4;
                b.setDestroyed(false);
                b.setX(a.getX());
                b.setY(a.getY()+6);   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E21.jpg".equals(a.getShot())) {
                b.duongbom=1;
                b.setDestroyed(false);
                b.setX(a.getX()+11);
                b.setY(a.getY());   
            }

            int bombX = b.getX();
            int bombY = b.getY();
            int playerX = player.getX();
            int playerY = player.getY();

            if (player.isVisible() && !b.isDestroyed()) {
                if ( bombX >= (playerX) && 
                    bombX <= (playerX+PLAYER_WIDTH) &&
                    bombY >= (playerY) && 
                    bombY <= (playerY+PLAYER_HEIGHT) ) {
                        ImageIcon ii1 = 
                            new ImageIcon(expl);
                        player.setImage(ii1.getImage());
                         exp.play();
                        player.life--;
                        if(player.life==0)
                        player.setDying(true);
                        else {
                            ImageIcon ii = new ImageIcon("hinhanh/T1.jpg");
                          player.power=0;
                          player.speed=0;
                          player.setImage(ii.getImage());
                          player.setPl("hinhanh/T1.jpg");
                          player.setY(BOARD_HEIGHT/2+125);
                          player.setX(BOARD_WIDTH/2-100);
                          player.playername="hinhanh/T1.jpg";
                        }
                        b.setDestroyed(true);
                    }
            }
            if (boss.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (boss.getX()) && 
                        bombX <= (boss.getX() + 2*ALIEN_WIDTH) &&
                        bombY >= (boss.getY()) &&
                        bombY <= (boss.getY()+2*ALIEN_HEIGHT) ) {
                            boss.setDying(true);
                             exp.play();
                            b.setDestroyed(true);
                           ingame=false;
                        }
                }
           if (shot.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (shot.getX()) && bombX <= (shot.getX()+2*BOMB_HEIGHT) 
                            && bombY >= (shot.getY()) && bombY <= (shot.getY()+2*BOMB_HEIGHT) ) 
                       {
                          //  shot.setDying(true);
                            shot.die();
                            b.setDestroyed(true);
                        }
                }
           Iterator s = steelwalls.iterator();
            while (s.hasNext()) {
                Steelwall wall = (Steelwall) s.next();
                int aX = wall.getX();
                int aY = wall.getY();

                if (wall.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (aX) && 
                        bombX <= (aX + 2*ALIEN_WIDTH) &&
                        bombY >= (aY) &&
                        bombY <= (aY+2*ALIEN_HEIGHT) ) {
                           b.setDestroyed(true);
                            }
                }
            }
            
            Iterator w = walls.iterator();
            while (w.hasNext()) {
                Wall wall = (Wall) w.next();
                int aX = wall.getX();
                int aY = wall.getY();

                if (wall.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (aX) && 
                        bombX <= (aX + 2*ALIEN_WIDTH) &&
                        bombY >= (aY) &&
                        bombY <= (aY+2*ALIEN_HEIGHT) ) {
                           wall.setDying(true);
                        b.setDestroyed(true);
                            }
                }
            }
            if (!b.isDestroyed()) {
                if(b.duongbom==2){
                    b.setY(b.getY() + 2);   
                    if (b.getY() >= BOARD_HEIGHT)
                    b.setDestroyed(true);
                 }
                if(b.duongbom==1){
                   b.setY(b.getY()- 2);
                   if(b.getY()<0) b.setDestroyed(true);
                }
               if(b.duongbom==3){
                   b.setX(b.getX()- 2);
                   if(b.getX()<0) b.setDestroyed(true);
               }
               if(b.duongbom==4){
                   b.setX(b.getX()+ 2);
                   if(b.getX()>BOARD_WIDTH-BORDER_RIGHT ) b.setDestroyed(true);
               }
            }
        }
           Random gen1 = new Random();
            if("Alien1".equals(aliens1.get(i).getClass().getSimpleName())){
               int shot1 = gen1.nextInt(15);
            Alien1 a = (Alien1)aliens1.get(i);
            Alien1.Bomb b = a.getBomb();
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E26.jpg".equals(a.getShot())) {
                b.duongbom=2;
                b.setDestroyed(false);
                b.setX(a.getX()+11);
                b.setY(a.getY());   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E27.jpg".equals(a.getShot())) {
                b.duongbom=3;
                b.setDestroyed(false);
                b.setX(a.getX());
                b.setY(a.getY()+6);   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E28.jpg".equals(a.getShot())) {
                b.duongbom=4;
                b.setDestroyed(false);
                b.setX(a.getX());
                b.setY(a.getY()+6);   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E25.jpg".equals(a.getShot())) {
                b.duongbom=1;
                b.setDestroyed(false);
                b.setX(a.getX()+11);
                b.setY(a.getY());   
            }

            int bombX = b.getX();
            int bombY = b.getY();
            int playerX = player.getX();
            int playerY = player.getY();

            if (player.isVisible() && !b.isDestroyed()) {
                if ( bombX >= (playerX) && 
                    bombX <= (playerX+PLAYER_WIDTH) &&
                    bombY >= (playerY) && 
                    bombY <= (playerY+PLAYER_HEIGHT) ) {
                        ImageIcon ii1 = 
                            new ImageIcon(expl);
                        player.setImage(ii1.getImage());
                         exp.play();
                        player.life--;
                        if(player.life==0)
                        player.setDying(true);
                        else {
                            ImageIcon ii = new ImageIcon("hinhanh/T1.jpg");
                          player.power=0;
                          player.speed=0;
                          player.setImage(ii.getImage());
                          player.setPl("hinhanh/T1.jpg");
                          player.setY(BOARD_HEIGHT/2+125);
                          player.setX(BOARD_WIDTH/2-100);
                          player.playername="hinhanh/T1.jpg";
                        }
                        b.setDestroyed(true);
                    }
            }
          if (boss.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (boss.getX()) && 
                        bombX <= (boss.getX() + 2*ALIEN_WIDTH) &&
                        bombY >= (boss.getY()) &&
                        bombY <= (boss.getY()+2*ALIEN_HEIGHT) ) {
                            boss.setDying(true);
                             exp.play();
                            b.setDestroyed(true);
                           ingame=false;
                        }
                }
          if (shot.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (shot.getX()) && bombX <= (shot.getX()+2*BOMB_HEIGHT) 
                            && bombY >= (shot.getY()) && bombY <= (shot.getY()+2*BOMB_HEIGHT) ) 
                      {
                            shot.die();
                            b.setDestroyed(true);
                        }
                }
             Iterator s = steelwalls.iterator();
            while (s.hasNext()) {
                Steelwall wall = (Steelwall) s.next();
                int aX = wall.getX();
                int aY = wall.getY();

                if (wall.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (aX) && 
                        bombX <= (aX + 2*ALIEN_WIDTH) &&
                        bombY >= (aY) &&
                        bombY <= (aY+2*ALIEN_HEIGHT) ) {
                           b.setDestroyed(true);
                            }
                }
            }
            
            Iterator w = walls.iterator();
            while (w.hasNext()) {
                Wall wall = (Wall) w.next();
                int aX = wall.getX();
                int aY = wall.getY();

                if (wall.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (aX) && 
                        bombX <= (aX + 2*ALIEN_WIDTH) &&
                        bombY >= (aY) &&
                        bombY <= (aY+2*ALIEN_HEIGHT) ) {
                           wall.setDying(true);
                        b.setDestroyed(true);
                            }
                }
            }
            if (!b.isDestroyed()) {
                if(b.duongbom==2){
                    b.setY(b.getY() + 2);   
                    if (b.getY() >= BOARD_HEIGHT)
                    b.setDestroyed(true);
                 }
                if(b.duongbom==1){
                   b.setY(b.getY()-2);
                   if(b.getY()<0) b.setDestroyed(true);
                }
               if(b.duongbom==3){
                   b.setX(b.getX()-2);
                   if(b.getX()<0) b.setDestroyed(true);
               }
               if(b.duongbom==4){
                   b.setX(b.getX()+2);
                   if(b.getX()>BOARD_WIDTH-BORDER_RIGHT ) b.setDestroyed(true);
               }
            }
          }  
            Random gen2 = new Random();
            if("Alien2".equals(aliens1.get(i).getClass().getSimpleName())){
                 int shot1 = gen2.nextInt(15);
            Alien2 a = (Alien2)aliens1.get(i);
            Alien2.Bomb b = a.getBomb();
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E42.jpg".equals(a.getShot())) {
                b.duongbom=2;
                b.setDestroyed(false);
                b.setX(a.getX()+11);
                b.setY(a.getY());   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E43.jpg".equals(a.getShot())) {
                b.duongbom=3;
                b.setDestroyed(false);
                b.setX(a.getX());
                b.setY(a.getY()+6);   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E44.jpg".equals(a.getShot())) {
                b.duongbom=4;
                b.setDestroyed(false);
                b.setX(a.getX());
                b.setY(a.getY()+6);   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E41.jpg".equals(a.getShot())) {
                b.duongbom=1;
                b.setDestroyed(false);
                b.setX(a.getX()+11);
                b.setY(a.getY());   
            }

            int bombX = b.getX();
            int bombY = b.getY();
            int playerX = player.getX();
            int playerY = player.getY();

            if (player.isVisible() && !b.isDestroyed()) {
                if ( bombX >= (playerX) && 
                    bombX <= (playerX+PLAYER_WIDTH) &&
                    bombY >= (playerY) && 
                    bombY <= (playerY+PLAYER_HEIGHT) ) {
                        ImageIcon ii1 = 
                            new ImageIcon(expl);
                        player.setImage(ii1.getImage());
                         exp.play();
                        player.life--;
                        if(player.life==0)
                        player.setDying(true);
                        else {
                            ImageIcon ii = new ImageIcon("hinhanh/T1.jpg");
                          player.power=0;
                          player.speed=0;
                          player.setImage(ii.getImage());
                          player.setPl("hinhanh/T1.jpg");
                          player.setY(BOARD_HEIGHT/2+125);
                          player.setX(BOARD_WIDTH/2-100);
                          player.playername="hinhanh/T1.jpg";
                        }
                        b.setDestroyed(true);
                    }
            }
          if (boss.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (boss.getX()) && 
                        bombX <= (boss.getX() + 2*ALIEN_WIDTH) &&
                        bombY >= (boss.getY()) &&
                        bombY <= (boss.getY()+2*ALIEN_HEIGHT) ) {
                            boss.setDying(true);
                             exp.play();
                            b.setDestroyed(true);
                           ingame=false;
                        }
                }
          if (shot.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (shot.getX()) && bombX <= (shot.getX()+2*BOMB_HEIGHT) 
                            && bombY >= (shot.getY()) && bombY <= (shot.getY()+2*BOMB_HEIGHT) ) 
                      {
                            shot.die();
                            b.setDestroyed(true);
                        }
                }
             Iterator s = steelwalls.iterator();
            while (s.hasNext()) {
                Steelwall wall = (Steelwall) s.next();
                int aX = wall.getX();
                int aY = wall.getY();

                if (wall.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (aX) && 
                        bombX <= (aX + 2*ALIEN_WIDTH) &&
                        bombY >= (aY) &&
                        bombY <= (aY+2*ALIEN_HEIGHT) ) {
                           b.setDestroyed(true);
                            }
                }
            }
            
            Iterator w = walls.iterator();
            while (w.hasNext()) {
                Wall wall = (Wall) w.next();
                int aX = wall.getX();
                int aY = wall.getY();

                if (wall.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (aX) && 
                        bombX <= (aX + 2*ALIEN_WIDTH) &&
                        bombY >= (aY) &&
                        bombY <= (aY+2*ALIEN_HEIGHT) ) {
                           wall.setDying(true);
                        b.setDestroyed(true);
                            }
                }
            }
            if (!b.isDestroyed()) {
                if(b.duongbom==2){
                    b.setY(b.getY() + 2);   
                    if (b.getY() >= BOARD_HEIGHT)
                    b.setDestroyed(true);
                 }
                if(b.duongbom==1){
                   b.setY(b.getY()-2);
                   if(b.getY()<0) b.setDestroyed(true);
                }
               if(b.duongbom==3){
                   b.setX(b.getX()-2);
                   if(b.getX()<0) b.setDestroyed(true);
               }
               if(b.duongbom==4){
                   b.setX(b.getX()+2);
                   if(b.getX()>BOARD_WIDTH-BORDER_RIGHT ) b.setDestroyed(true);
               }
            }
            }
          Random gen3 = new Random();
            if("Alien3".equals(aliens1.get(i).getClass().getSimpleName()))  {
                int shot1 = gen3.nextInt(15);
            Alien3 a = (Alien3)aliens1.get(i);
            Alien3.Bomb b = a.getBomb();
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E46.jpg".equals(a.getShot())) {
                b.duongbom=2;
                b.setDestroyed(false);
                b.setX(a.getX()+11);
                b.setY(a.getY());   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E47.jpg".equals(a.getShot())) {
                b.duongbom=3;
                b.setDestroyed(false);
                b.setX(a.getX());
                b.setY(a.getY()+6);   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E48.jpg".equals(a.getShot())) {
                b.duongbom=4;
                b.setDestroyed(false);
                b.setX(a.getX());
                b.setY(a.getY()+6);   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E45.jpg".equals(a.getShot())) {
                b.duongbom=1;
                b.setDestroyed(false);
                b.setX(a.getX()+11);
                b.setY(a.getY());   
            }

            int bombX = b.getX();
            int bombY = b.getY();
            int playerX = player.getX();
            int playerY = player.getY();

            if (player.isVisible() && !b.isDestroyed()) {
                if ( bombX >= (playerX) && 
                    bombX <= (playerX+PLAYER_WIDTH) &&
                    bombY >= (playerY) && 
                    bombY <= (playerY+PLAYER_HEIGHT) ) {
                        ImageIcon ii1 = 
                            new ImageIcon(expl);
                        player.setImage(ii1.getImage());
                         exp.play();
                        player.life--;
                        if(player.life==0)
                        player.setDying(true);
                        else {
                         ImageIcon ii = new ImageIcon("hinhanh/T1.jpg");
                          player.power=0;
                          player.speed=0;
                          player.setImage(ii.getImage());
                          player.setPl("hinhanh/T1.jpg");
                          player.setY(BOARD_HEIGHT/2+125);
                          player.setX(BOARD_WIDTH/2-100);
                          player.playername="hinhanh/T1.jpg";
                        }
                        b.setDestroyed(true);
                    }
            }
          if (boss.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (boss.getX()) && 
                        bombX <= (boss.getX() + 2*ALIEN_WIDTH) &&
                        bombY >= (boss.getY()) &&
                        bombY <= (boss.getY()+2*ALIEN_HEIGHT) ) {
                            boss.setDying(true);
                             exp.play();
                            b.setDestroyed(true);
                           ingame=false;
                        }
                }
          if (shot.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (shot.getX()) && bombX <= (shot.getX()+2*BOMB_HEIGHT) 
                            && bombY >= (shot.getY()) && bombY <= (shot.getY()+2*BOMB_HEIGHT)  ) 
                      {
                            shot.die();
                            b.setDestroyed(true);
                        }
                }
             Iterator s = steelwalls.iterator();
            while (s.hasNext()) {
                Steelwall wall = (Steelwall) s.next();
                int aX = wall.getX();
                int aY = wall.getY();

                if (wall.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (aX) && 
                        bombX <= (aX + 2*ALIEN_WIDTH) &&
                        bombY >= (aY) &&
                        bombY <= (aY+2*ALIEN_HEIGHT) ) {
                           b.setDestroyed(true);
                            }
                }
            }
            
            Iterator w = walls.iterator();
            while (w.hasNext()) {
                Wall wall = (Wall) w.next();
                int aX = wall.getX();
                int aY = wall.getY();

                if (wall.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (aX) && 
                        bombX <= (aX + 2*ALIEN_WIDTH) &&
                        bombY >= (aY) &&
                        bombY <= (aY+2*ALIEN_HEIGHT) ) {
                           wall.setDying(true);
                        b.setDestroyed(true);
                            }
                }
            }
            if (!b.isDestroyed()) {
                if(b.duongbom==2){
                    b.setY(b.getY() + 2);   
                    if (b.getY() >= BOARD_HEIGHT)
                    b.setDestroyed(true);
                 }
                if(b.duongbom==1){
                   b.setY(b.getY()-2);
                   if(b.getY()<0) b.setDestroyed(true);
                }
               if(b.duongbom==3){
                   b.setX(b.getX()-2);
                   if(b.getX()<0) b.setDestroyed(true);
               }
               if(b.duongbom==4){
                   b.setX(b.getX()+2);
                   if(b.getX()>BOARD_WIDTH-BORDER_RIGHT ) b.setDestroyed(true);
               }
            }
            }
            Random gen4 = new Random();
            if("Alien4".equals(aliens1.get(i).getClass().getSimpleName())) {
                 int shot1 = gen4.nextInt(15);
            Alien4 a = (Alien4)aliens1.get(i);
            Alien4.Bomb b = a.getBomb();
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E410.jpg".equals(a.getShot())) {
                b.duongbom=2;
                b.setDestroyed(false);
                b.setX(a.getX()+11);
                b.setY(a.getY());   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E411.jpg".equals(a.getShot())) {
                b.duongbom=3;
                b.setDestroyed(false);
                b.setX(a.getX());
                b.setY(a.getY()+6);   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E412.jpg".equals(a.getShot())) {
                b.duongbom=4;
                b.setDestroyed(false);
                b.setX(a.getX());
                b.setY(a.getY()+6);   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E49.jpg".equals(a.getShot())) {
                b.duongbom=1;
                b.setDestroyed(false);
                b.setX(a.getX()+11);
                b.setY(a.getY());   
            }

            int bombX = b.getX();
            int bombY = b.getY();
            int playerX = player.getX();
            int playerY = player.getY();

            if (player.isVisible() && !b.isDestroyed()) {
                if ( bombX >= (playerX) && 
                    bombX <= (playerX+PLAYER_WIDTH) &&
                    bombY >= (playerY) && 
                    bombY <= (playerY+PLAYER_HEIGHT) ) {
                        ImageIcon ii1 = 
                            new ImageIcon(expl);
                        player.setImage(ii1.getImage());
                         exp.play();
                        player.life--;
                        if(player.life==0)
                        player.setDying(true);
                        else {
                          ImageIcon ii = new ImageIcon("hinhanh/T1.jpg");
                          player.power=0;
                          player.speed=0;
                          player.setImage(ii.getImage());
                          player.setPl("hinhanh/T1.jpg");
                          player.setY(BOARD_HEIGHT/2+125);
                          player.setX(BOARD_WIDTH/2-100);
                          player.playername="hinhanh/T1.jpg";
                        }
                        b.setDestroyed(true);
                        
                    }
            }
          if (boss.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (boss.getX()) && 
                        bombX <= (boss.getX() + 2*ALIEN_WIDTH) &&
                        bombY >= (boss.getY()) &&
                        bombY <= (boss.getY()+2*ALIEN_HEIGHT) ) {
                            boss.setDying(true);
                             exp.play();
                            b.setDestroyed(true);
                           ingame=false;
                        }
                }
          if (shot.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (shot.getX()) && bombX <= (shot.getX()+2*BOMB_HEIGHT) 
                            && bombY >= (shot.getY()) && bombY <= (shot.getY()+2*BOMB_HEIGHT) ) 
                      {
                            shot.die();
                            b.setDestroyed(true);
                        }
                }
             Iterator s = steelwalls.iterator();
            while (s.hasNext()) {
                Steelwall wall = (Steelwall) s.next();
                int aX = wall.getX();
                int aY = wall.getY();

                if (wall.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (aX) && 
                        bombX <= (aX + 2*ALIEN_WIDTH) &&
                        bombY >= (aY) &&
                        bombY <= (aY+2*ALIEN_HEIGHT) ) {
                           b.setDestroyed(true);
                            }
                }
            }
            
            Iterator w = walls.iterator();
            while (w.hasNext()) {
                Wall wall = (Wall) w.next();
                int aX = wall.getX();
                int aY = wall.getY();

                if (wall.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (aX) && 
                        bombX <= (aX + 2*ALIEN_WIDTH) &&
                        bombY >= (aY) &&
                        bombY <= (aY+2*ALIEN_HEIGHT) ) {
                           wall.setDying(true);
                        b.setDestroyed(true);
                            }
                }
            }
            if (!b.isDestroyed()) {
                if(b.duongbom==2){
                    b.setY(b.getY() + 2);   
                    if (b.getY() >= BOARD_HEIGHT)
                    b.setDestroyed(true);
                 }
                if(b.duongbom==1){
                   b.setY(b.getY()-2);
                   if(b.getY()<0) b.setDestroyed(true);
                }
               if(b.duongbom==3){
                   b.setX(b.getX()-2);
                   if(b.getX()<0) b.setDestroyed(true);
               }
               if(b.duongbom==4){
                   b.setX(b.getX()+2);
                   if(b.getX()>BOARD_WIDTH-BORDER_RIGHT ) b.setDestroyed(true);
               }
            }
         }
     } 
        Random ge = new Random();

        for(int i=0;i<aliens2.size();i++) {
            if("Alien".equals(aliens2.get(i).getClass().getSimpleName()))
            {
            int shot1 = ge.nextInt(15);
            Alien a = (Alien)aliens2.get(i);
            Alien.Bomb b = a.getBomb();
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E22.jpg".equals(a.getShot())) {
                b.duongbom=2;
                b.setDestroyed(false);
                b.setX(a.getX()+11);
                b.setY(a.getY());   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E23.jpg".equals(a.getShot())) {
                b.duongbom=3;
                b.setDestroyed(false);
                b.setX(a.getX());
                b.setY(a.getY()+6);   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E24.jpg".equals(a.getShot())) {
                b.duongbom=4;
                b.setDestroyed(false);
                b.setX(a.getX());
                b.setY(a.getY()+6);   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E21.jpg".equals(a.getShot())) {
                b.duongbom=1;
                b.setDestroyed(false);
                b.setX(a.getX()+11);
                b.setY(a.getY());   
            }

            int bombX = b.getX();
            int bombY = b.getY();
            int playerX = player.getX();
            int playerY = player.getY();

            if (player.isVisible() && !b.isDestroyed()) {
                if ( bombX >= (playerX) && 
                    bombX <= (playerX+PLAYER_WIDTH) &&
                    bombY >= (playerY) && 
                    bombY <= (playerY+PLAYER_HEIGHT) ) {
                        ImageIcon ii1 = 
                            new ImageIcon(expl);
                        player.setImage(ii1.getImage());
                         exp.play();
                        player.life--;
                        if(player.life==0)
                        player.setDying(true);
                        else {
                            ImageIcon ii = new ImageIcon("hinhanh/T1.jpg");
                          player.power=0;
                          player.speed=0;
                          player.setImage(ii.getImage());
                          player.setPl("hinhanh/T1.jpg");
                          player.setY(BOARD_HEIGHT/2+125);
                          player.setX(BOARD_WIDTH/2-100);
                          player.playername="hinhanh/T1.jpg";
                        }
                        b.setDestroyed(true);
                    }
            }
            if (boss.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (boss.getX()) && 
                        bombX <= (boss.getX() + 2*ALIEN_WIDTH) &&
                        bombY >= (boss.getY()) &&
                        bombY <= (boss.getY()+2*ALIEN_HEIGHT) ) {
                            boss.setDying(true);
                             exp.play();
                            b.setDestroyed(true);
                           ingame=false;
                        }
                }
           if (shot.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (shot.getX()) && bombX <= (shot.getX()+2*BOMB_HEIGHT) 
                            && bombY >= (shot.getY()) && bombY <= (shot.getY()+2*BOMB_HEIGHT) ) 
                       {
                          //  shot.setDying(true);
                            shot.die();
                            b.setDestroyed(true);
                        }
                }
           Iterator s = steelwalls.iterator();
            while (s.hasNext()) {
                Steelwall wall = (Steelwall) s.next();
                int aX = wall.getX();
                int aY = wall.getY();

                if (wall.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (aX) && 
                        bombX <= (aX + 2*ALIEN_WIDTH) &&
                        bombY >= (aY) &&
                        bombY <= (aY+2*ALIEN_HEIGHT) ) {
                           b.setDestroyed(true);
                            }
                }
            }
            
            Iterator w = walls.iterator();
            while (w.hasNext()) {
                Wall wall = (Wall) w.next();
                int aX = wall.getX();
                int aY = wall.getY();

                if (wall.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (aX) && 
                        bombX <= (aX + 2*ALIEN_WIDTH) &&
                        bombY >= (aY) &&
                        bombY <= (aY+2*ALIEN_HEIGHT) ) {
                           wall.setDying(true);
                        b.setDestroyed(true);
                            }
                }
            }
            if (!b.isDestroyed()) {
                if(b.duongbom==2){
                    b.setY(b.getY() + 2);   
                    if (b.getY() >= BOARD_HEIGHT)
                    b.setDestroyed(true);
                 }
                if(b.duongbom==1){
                   b.setY(b.getY()- 2);
                   if(b.getY()<0) b.setDestroyed(true);
                }
               if(b.duongbom==3){
                   b.setX(b.getX()- 2);
                   if(b.getX()<0) b.setDestroyed(true);
               }
               if(b.duongbom==4){
                   b.setX(b.getX()+ 2);
                   if(b.getX()>BOARD_WIDTH-BORDER_RIGHT ) b.setDestroyed(true);
               }
            }
        }
           Random ge1 = new Random();
            if("Alien1".equals(aliens2.get(i).getClass().getSimpleName())){
               int shot1 = ge1.nextInt(15);
            Alien1 a = (Alien1)aliens2.get(i);
            Alien1.Bomb b = a.getBomb();
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E26.jpg".equals(a.getShot())) {
                b.duongbom=2;
                b.setDestroyed(false);
                b.setX(a.getX()+11);
                b.setY(a.getY());   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E27.jpg".equals(a.getShot())) {
                b.duongbom=3;
                b.setDestroyed(false);
                b.setX(a.getX());
                b.setY(a.getY()+6);   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E28.jpg".equals(a.getShot())) {
                b.duongbom=4;
                b.setDestroyed(false);
                b.setX(a.getX());
                b.setY(a.getY()+6);   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E25.jpg".equals(a.getShot())) {
                b.duongbom=1;
                b.setDestroyed(false);
                b.setX(a.getX()+11);
                b.setY(a.getY());   
            }

            int bombX = b.getX();
            int bombY = b.getY();
            int playerX = player.getX();
            int playerY = player.getY();

            if (player.isVisible() && !b.isDestroyed()) {
                if ( bombX >= (playerX) && 
                    bombX <= (playerX+PLAYER_WIDTH) &&
                    bombY >= (playerY) && 
                    bombY <= (playerY+PLAYER_HEIGHT) ) {
                        ImageIcon ii1 = 
                            new ImageIcon(expl);
                        player.setImage(ii1.getImage());
                         exp.play();
                        player.life--;
                        if(player.life==0)
                        player.setDying(true);
                        else {
                            ImageIcon ii = new ImageIcon("hinhanh/T1.jpg");
                          player.power=0;
                          player.speed=0;
                          player.setImage(ii.getImage());
                          player.setPl("hinhanh/T1.jpg");
                          player.setY(BOARD_HEIGHT/2+125);
                          player.setX(BOARD_WIDTH/2-100);
                          player.playername="hinhanh/T1.jpg";
                        }
                        b.setDestroyed(true);
                    }
            }
          if (boss.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (boss.getX()) && 
                        bombX <= (boss.getX() + 2*ALIEN_WIDTH) &&
                        bombY >= (boss.getY()) &&
                        bombY <= (boss.getY()+2*ALIEN_HEIGHT) ) {
                            boss.setDying(true);
                             exp.play();
                            b.setDestroyed(true);
                           ingame=false;
                        }
                }
          if (shot.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (shot.getX()) && bombX <= (shot.getX()+2*BOMB_HEIGHT) 
                            && bombY >= (shot.getY()) && bombY <= (shot.getY()+2*BOMB_HEIGHT) ) 
                      {
                            shot.die();
                            b.setDestroyed(true);
                        }
                }
             Iterator s = steelwalls.iterator();
            while (s.hasNext()) {
                Steelwall wall = (Steelwall) s.next();
                int aX = wall.getX();
                int aY = wall.getY();

                if (wall.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (aX) && 
                        bombX <= (aX + 2*ALIEN_WIDTH) &&
                        bombY >= (aY) &&
                        bombY <= (aY+2*ALIEN_HEIGHT) ) {
                           b.setDestroyed(true);
                            }
                }
            }
            
            Iterator w = walls.iterator();
            while (w.hasNext()) {
                Wall wall = (Wall) w.next();
                int aX = wall.getX();
                int aY = wall.getY();

                if (wall.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (aX) && 
                        bombX <= (aX + 2*ALIEN_WIDTH) &&
                        bombY >= (aY) &&
                        bombY <= (aY+2*ALIEN_HEIGHT) ) {
                           wall.setDying(true);
                        b.setDestroyed(true);
                            }
                }
            }
            if (!b.isDestroyed()) {
                if(b.duongbom==2){
                    b.setY(b.getY() + 2);   
                    if (b.getY() >= BOARD_HEIGHT)
                    b.setDestroyed(true);
                 }
                if(b.duongbom==1){
                   b.setY(b.getY()-2);
                   if(b.getY()<0) b.setDestroyed(true);
                }
               if(b.duongbom==3){
                   b.setX(b.getX()-2);
                   if(b.getX()<0) b.setDestroyed(true);
               }
               if(b.duongbom==4){
                   b.setX(b.getX()+2);
                   if(b.getX()>BOARD_WIDTH-BORDER_RIGHT ) b.setDestroyed(true);
               }
            }
          }  
            Random ge2 = new Random();
            if("Alien2".equals(aliens2.get(i).getClass().getSimpleName())){
                 int shot1 = ge2.nextInt(15);
            Alien2 a = (Alien2)aliens2.get(i);
            Alien2.Bomb b = a.getBomb();
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E42.jpg".equals(a.getShot())) {
                b.duongbom=2;
                b.setDestroyed(false);
                b.setX(a.getX()+11);
                b.setY(a.getY());   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E43.jpg".equals(a.getShot())) {
                b.duongbom=3;
                b.setDestroyed(false);
                b.setX(a.getX());
                b.setY(a.getY()+6);   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E44.jpg".equals(a.getShot())) {
                b.duongbom=4;
                b.setDestroyed(false);
                b.setX(a.getX());
                b.setY(a.getY()+6);   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E41.jpg".equals(a.getShot())) {
                b.duongbom=1;
                b.setDestroyed(false);
                b.setX(a.getX()+11);
                b.setY(a.getY());   
            }

            int bombX = b.getX();
            int bombY = b.getY();
            int playerX = player.getX();
            int playerY = player.getY();

            if (player.isVisible() && !b.isDestroyed()) {
                if ( bombX >= (playerX) && 
                    bombX <= (playerX+PLAYER_WIDTH) &&
                    bombY >= (playerY) && 
                    bombY <= (playerY+PLAYER_HEIGHT) ) {
                        ImageIcon ii1 = 
                            new ImageIcon(expl);
                        player.setImage(ii1.getImage());
                         exp.play();
                        player.life--;
                        if(player.life==0)
                        player.setDying(true);
                        else {
                            ImageIcon ii = new ImageIcon("hinhanh/T1.jpg");
                          player.power=0;
                          player.speed=0;
                          player.setImage(ii.getImage());
                          player.setPl("hinhanh/T1.jpg");
                          player.setY(BOARD_HEIGHT/2+125);
                          player.setX(BOARD_WIDTH/2-100);
                          player.playername="hinhanh/T1.jpg";
                        }
                        b.setDestroyed(true);
                    }
            }
          if (boss.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (boss.getX()) && 
                        bombX <= (boss.getX() + 2*ALIEN_WIDTH) &&
                        bombY >= (boss.getY()) &&
                        bombY <= (boss.getY()+2*ALIEN_HEIGHT) ) {
                            boss.setDying(true);
                             exp.play();
                            b.setDestroyed(true);
                           ingame=false;
                        }
                }
          if (shot.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (shot.getX()) && bombX <= (shot.getX()+2*BOMB_HEIGHT) 
                            && bombY >= (shot.getY()) && bombY <= (shot.getY()+2*BOMB_HEIGHT) ) 
                      {
                            shot.die();
                            b.setDestroyed(true);
                        }
                }
             Iterator s = steelwalls.iterator();
            while (s.hasNext()) {
                Steelwall wall = (Steelwall) s.next();
                int aX = wall.getX();
                int aY = wall.getY();

                if (wall.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (aX) && 
                        bombX <= (aX + 2*ALIEN_WIDTH) &&
                        bombY >= (aY) &&
                        bombY <= (aY+2*ALIEN_HEIGHT) ) {
                           b.setDestroyed(true);
                            }
                }
            }
            
            Iterator w = walls.iterator();
            while (w.hasNext()) {
                Wall wall = (Wall) w.next();
                int aX = wall.getX();
                int aY = wall.getY();

                if (wall.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (aX) && 
                        bombX <= (aX + 2*ALIEN_WIDTH) &&
                        bombY >= (aY) &&
                        bombY <= (aY+2*ALIEN_HEIGHT) ) {
                           wall.setDying(true);
                        b.setDestroyed(true);
                            }
                }
            }
            if (!b.isDestroyed()) {
                if(b.duongbom==2){
                    b.setY(b.getY() + 2);   
                    if (b.getY() >= BOARD_HEIGHT)
                    b.setDestroyed(true);
                 }
                if(b.duongbom==1){
                   b.setY(b.getY()-2);
                   if(b.getY()<0) b.setDestroyed(true);
                }
               if(b.duongbom==3){
                   b.setX(b.getX()-2);
                   if(b.getX()<0) b.setDestroyed(true);
               }
               if(b.duongbom==4){
                   b.setX(b.getX()+2);
                   if(b.getX()>BOARD_WIDTH-BORDER_RIGHT ) b.setDestroyed(true);
               }
            }
            }
          Random ge3 = new Random();
            if("Alien3".equals(aliens2.get(i).getClass().getSimpleName()))  {
                int shot1 = ge3.nextInt(15);
            Alien3 a = (Alien3)aliens2.get(i);
            Alien3.Bomb b = a.getBomb();
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E46.jpg".equals(a.getShot())) {
                b.duongbom=2;
                b.setDestroyed(false);
                b.setX(a.getX()+11);
                b.setY(a.getY());   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E47.jpg".equals(a.getShot())) {
                b.duongbom=3;
                b.setDestroyed(false);
                b.setX(a.getX());
                b.setY(a.getY()+6);   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E48.jpg".equals(a.getShot())) {
                b.duongbom=4;
                b.setDestroyed(false);
                b.setX(a.getX());
                b.setY(a.getY()+6);   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E45.jpg".equals(a.getShot())) {
                b.duongbom=1;
                b.setDestroyed(false);
                b.setX(a.getX()+11);
                b.setY(a.getY());   
            }

            int bombX = b.getX();
            int bombY = b.getY();
            int playerX = player.getX();
            int playerY = player.getY();

            if (player.isVisible() && !b.isDestroyed()) {
                if ( bombX >= (playerX) && 
                    bombX <= (playerX+PLAYER_WIDTH) &&
                    bombY >= (playerY) && 
                    bombY <= (playerY+PLAYER_HEIGHT) ) {
                        ImageIcon ii1 = 
                            new ImageIcon(expl);
                        player.setImage(ii1.getImage());
                         exp.play();
                        player.life--;
                        if(player.life==0)
                        player.setDying(true);
                        else {
                         ImageIcon ii = new ImageIcon("hinhanh/T1.jpg");
                          player.power=0;
                          player.speed=0;
                          player.setImage(ii.getImage());
                          player.setPl("hinhanh/T1.jpg");
                          player.setY(BOARD_HEIGHT/2+125);
                          player.setX(BOARD_WIDTH/2-100);
                          player.playername="hinhanh/T1.jpg";
                        }
                        b.setDestroyed(true);
                    }
            }
          if (boss.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (boss.getX()) && 
                        bombX <= (boss.getX() + 2*ALIEN_WIDTH) &&
                        bombY >= (boss.getY()) &&
                        bombY <= (boss.getY()+2*ALIEN_HEIGHT) ) {
                            boss.setDying(true);
                             exp.play();
                            b.setDestroyed(true);
                           ingame=false;
                        }
                }
          if (shot.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (shot.getX()) && bombX <= (shot.getX()+2*BOMB_HEIGHT) 
                            && bombY >= (shot.getY()) && bombY <= (shot.getY()+2*BOMB_HEIGHT)  ) 
                      {
                            shot.die();
                            b.setDestroyed(true);
                        }
                }
             Iterator s = steelwalls.iterator();
            while (s.hasNext()) {
                Steelwall wall = (Steelwall) s.next();
                int aX = wall.getX();
                int aY = wall.getY();

                if (wall.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (aX) && 
                        bombX <= (aX + 2*ALIEN_WIDTH) &&
                        bombY >= (aY) &&
                        bombY <= (aY+2*ALIEN_HEIGHT) ) {
                           b.setDestroyed(true);
                            }
                }
            }
            
            Iterator w = walls.iterator();
            while (w.hasNext()) {
                Wall wall = (Wall) w.next();
                int aX = wall.getX();
                int aY = wall.getY();

                if (wall.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (aX) && 
                        bombX <= (aX + 2*ALIEN_WIDTH) &&
                        bombY >= (aY) &&
                        bombY <= (aY+2*ALIEN_HEIGHT) ) {
                           wall.setDying(true);
                        b.setDestroyed(true);
                            }
                }
            }
            if (!b.isDestroyed()) {
                if(b.duongbom==2){
                    b.setY(b.getY() + 2);   
                    if (b.getY() >= BOARD_HEIGHT)
                    b.setDestroyed(true);
                 }
                if(b.duongbom==1){
                   b.setY(b.getY()-2);
                   if(b.getY()<0) b.setDestroyed(true);
                }
               if(b.duongbom==3){
                   b.setX(b.getX()-2);
                   if(b.getX()<0) b.setDestroyed(true);
               }
               if(b.duongbom==4){
                   b.setX(b.getX()+2);
                   if(b.getX()>BOARD_WIDTH-BORDER_RIGHT ) b.setDestroyed(true);
               }
            }
            }
            Random ge4 = new Random();
            if("Alien4".equals(aliens2.get(i).getClass().getSimpleName())) {
                 int shot1 = ge4.nextInt(15);
            Alien4 a = (Alien4)aliens2.get(i);
            Alien4.Bomb b = a.getBomb();
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E410.jpg".equals(a.getShot())) {
                b.duongbom=2;
                b.setDestroyed(false);
                b.setX(a.getX()+11);
                b.setY(a.getY());   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E411.jpg".equals(a.getShot())) {
                b.duongbom=3;
                b.setDestroyed(false);
                b.setX(a.getX());
                b.setY(a.getY()+6);   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E412.jpg".equals(a.getShot())) {
                b.duongbom=4;
                b.setDestroyed(false);
                b.setX(a.getX());
                b.setY(a.getY()+6);   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E49.jpg".equals(a.getShot())) {
                b.duongbom=1;
                b.setDestroyed(false);
                b.setX(a.getX()+11);
                b.setY(a.getY());   
            }

            int bombX = b.getX();
            int bombY = b.getY();
            int playerX = player.getX();
            int playerY = player.getY();

            if (player.isVisible() && !b.isDestroyed()) {
                if ( bombX >= (playerX) && 
                    bombX <= (playerX+PLAYER_WIDTH) &&
                    bombY >= (playerY) && 
                    bombY <= (playerY+PLAYER_HEIGHT) ) {
                        ImageIcon ii1 = 
                            new ImageIcon(expl);
                        player.setImage(ii1.getImage());
                         exp.play();
                        player.life--;
                        if(player.life==0)
                        player.setDying(true);
                        else {
                          ImageIcon ii = new ImageIcon("hinhanh/T1.jpg");
                          player.power=0;
                          player.speed=0;
                          player.setImage(ii.getImage());
                          player.setPl("hinhanh/T1.jpg");
                          player.setY(BOARD_HEIGHT/2+125);
                          player.setX(BOARD_WIDTH/2-100);
                          player.playername="hinhanh/T1.jpg";
                        }
                        b.setDestroyed(true);
                        
                    }
            }
          if (boss.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (boss.getX()) && 
                        bombX <= (boss.getX() + 2*ALIEN_WIDTH) &&
                        bombY >= (boss.getY()) &&
                        bombY <= (boss.getY()+2*ALIEN_HEIGHT) ) {
                            boss.setDying(true);
                             exp.play();
                            b.setDestroyed(true);
                           ingame=false;
                        }
                }
          if (shot.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (shot.getX()) && bombX <= (shot.getX()+2*BOMB_HEIGHT) 
                            && bombY >= (shot.getY()) && bombY <= (shot.getY()+2*BOMB_HEIGHT) ) 
                      {
                            shot.die();
                            b.setDestroyed(true);
                        }
                }
             Iterator s = steelwalls.iterator();
            while (s.hasNext()) {
                Steelwall wall = (Steelwall) s.next();
                int aX = wall.getX();
                int aY = wall.getY();

                if (wall.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (aX) && 
                        bombX <= (aX + 2*ALIEN_WIDTH) &&
                        bombY >= (aY) &&
                        bombY <= (aY+2*ALIEN_HEIGHT) ) {
                           b.setDestroyed(true);
                            }
                }
            }
            
            Iterator w = walls.iterator();
            while (w.hasNext()) {
                Wall wall = (Wall) w.next();
                int aX = wall.getX();
                int aY = wall.getY();

                if (wall.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (aX) && 
                        bombX <= (aX + 2*ALIEN_WIDTH) &&
                        bombY >= (aY) &&
                        bombY <= (aY+2*ALIEN_HEIGHT) ) {
                           wall.setDying(true);
                        b.setDestroyed(true);
                            }
                }
            }
            if (!b.isDestroyed()) {
                if(b.duongbom==2){
                    b.setY(b.getY() + 2);   
                    if (b.getY() >= BOARD_HEIGHT)
                    b.setDestroyed(true);
                 }
                if(b.duongbom==1){
                   b.setY(b.getY()-2);
                   if(b.getY()<0) b.setDestroyed(true);
                }
               if(b.duongbom==3){
                   b.setX(b.getX()-2);
                   if(b.getX()<0) b.setDestroyed(true);
               }
               if(b.duongbom==4){
                   b.setX(b.getX()+2);
                   if(b.getX()>BOARD_WIDTH-BORDER_RIGHT ) b.setDestroyed(true);
               }
            }
         }
     } 
         Random g = new Random();

        for(int i=0;i<aliens3.size();i++) {
            if("Alien".equals(aliens3.get(i).getClass().getSimpleName()))
            {
            int shot1 = g.nextInt(15);
            Alien a = (Alien)aliens3.get(i);
            Alien.Bomb b = a.getBomb();
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E22.jpg".equals(a.getShot())) {
                b.duongbom=2;
                b.setDestroyed(false);
                b.setX(a.getX()+11);
                b.setY(a.getY());   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E23.jpg".equals(a.getShot())) {
                b.duongbom=3;
                b.setDestroyed(false);
                b.setX(a.getX());
                b.setY(a.getY()+6);   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E24.jpg".equals(a.getShot())) {
                b.duongbom=4;
                b.setDestroyed(false);
                b.setX(a.getX());
                b.setY(a.getY()+6);   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E21.jpg".equals(a.getShot())) {
                b.duongbom=1;
                b.setDestroyed(false);
                b.setX(a.getX()+11);
                b.setY(a.getY());   
            }

            int bombX = b.getX();
            int bombY = b.getY();
            int playerX = player.getX();
            int playerY = player.getY();

            if (player.isVisible() && !b.isDestroyed()) {
                if ( bombX >= (playerX) && 
                    bombX <= (playerX+PLAYER_WIDTH) &&
                    bombY >= (playerY) && 
                    bombY <= (playerY+PLAYER_HEIGHT) ) {
                        ImageIcon ii1 = 
                            new ImageIcon(expl);
                        player.setImage(ii1.getImage());
                         exp.play();
                        player.life--;
                        if(player.life==0)
                        player.setDying(true);
                        else {
                            ImageIcon ii = new ImageIcon("hinhanh/T1.jpg");
                          player.power=0;
                          player.speed=0;
                          player.setImage(ii.getImage());
                          player.setPl("hinhanh/T1.jpg");
                          player.setY(BOARD_HEIGHT/2+125);
                          player.setX(BOARD_WIDTH/2-100);
                          player.playername="hinhanh/T1.jpg";
                        }
                        b.setDestroyed(true);
                    }
            }
            if (boss.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (boss.getX()) && 
                        bombX <= (boss.getX() + 2*ALIEN_WIDTH) &&
                        bombY >= (boss.getY()) &&
                        bombY <= (boss.getY()+2*ALIEN_HEIGHT) ) {
                            boss.setDying(true);
                             exp.play();
                            b.setDestroyed(true);
                           ingame=false;
                        }
                }
           if (shot.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (shot.getX()) && bombX <= (shot.getX()+2*BOMB_HEIGHT) 
                            && bombY >= (shot.getY()) && bombY <= (shot.getY()+2*BOMB_HEIGHT) ) 
                       {
                          //  shot.setDying(true);
                            shot.die();
                            b.setDestroyed(true);
                        }
                }
           Iterator s = steelwalls.iterator();
            while (s.hasNext()) {
                Steelwall wall = (Steelwall) s.next();
                int aX = wall.getX();
                int aY = wall.getY();

                if (wall.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (aX) && 
                        bombX <= (aX + 2*ALIEN_WIDTH) &&
                        bombY >= (aY) &&
                        bombY <= (aY+2*ALIEN_HEIGHT) ) {
                           b.setDestroyed(true);
                            }
                }
            }
            
            Iterator w = walls.iterator();
            while (w.hasNext()) {
                Wall wall = (Wall) w.next();
                int aX = wall.getX();
                int aY = wall.getY();

                if (wall.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (aX) && 
                        bombX <= (aX + 2*ALIEN_WIDTH) &&
                        bombY >= (aY) &&
                        bombY <= (aY+2*ALIEN_HEIGHT) ) {
                           wall.setDying(true);
                        b.setDestroyed(true);
                            }
                }
            }
            if (!b.isDestroyed()) {
                if(b.duongbom==2){
                    b.setY(b.getY() + 2);   
                    if (b.getY() >= BOARD_HEIGHT)
                    b.setDestroyed(true);
                 }
                if(b.duongbom==1){
                   b.setY(b.getY()- 2);
                   if(b.getY()<0) b.setDestroyed(true);
                }
               if(b.duongbom==3){
                   b.setX(b.getX()- 2);
                   if(b.getX()<0) b.setDestroyed(true);
               }
               if(b.duongbom==4){
                   b.setX(b.getX()+ 2);
                   if(b.getX()>BOARD_WIDTH-BORDER_RIGHT ) b.setDestroyed(true);
               }
            }
        }
           Random g1 = new Random();
            if("Alien1".equals(aliens3.get(i).getClass().getSimpleName())){
               int shot1 = g1.nextInt(15);
            Alien1 a = (Alien1)aliens3.get(i);
            Alien1.Bomb b = a.getBomb();
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E26.jpg".equals(a.getShot())) {
                b.duongbom=2;
                b.setDestroyed(false);
                b.setX(a.getX()+11);
                b.setY(a.getY());   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E27.jpg".equals(a.getShot())) {
                b.duongbom=3;
                b.setDestroyed(false);
                b.setX(a.getX());
                b.setY(a.getY()+6);   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E28.jpg".equals(a.getShot())) {
                b.duongbom=4;
                b.setDestroyed(false);
                b.setX(a.getX());
                b.setY(a.getY()+6);   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E25.jpg".equals(a.getShot())) {
                b.duongbom=1;
                b.setDestroyed(false);
                b.setX(a.getX()+11);
                b.setY(a.getY());   
            }

            int bombX = b.getX();
            int bombY = b.getY();
            int playerX = player.getX();
            int playerY = player.getY();

            if (player.isVisible() && !b.isDestroyed()) {
                if ( bombX >= (playerX) && 
                    bombX <= (playerX+PLAYER_WIDTH) &&
                    bombY >= (playerY) && 
                    bombY <= (playerY+PLAYER_HEIGHT) ) {
                        ImageIcon ii1 = 
                            new ImageIcon(expl);
                        player.setImage(ii1.getImage());
                         exp.play();
                        player.life--;
                        if(player.life==0)
                        player.setDying(true);
                        else {
                            ImageIcon ii = new ImageIcon("hinhanh/T1.jpg");
                          player.power=0;
                          player.speed=0;
                          player.setImage(ii.getImage());
                          player.setPl("hinhanh/T1.jpg");
                          player.setY(BOARD_HEIGHT/2+125);
                          player.setX(BOARD_WIDTH/2-100);
                          player.playername="hinhanh/T1.jpg";
                        }
                        b.setDestroyed(true);
                    }
            }
          if (boss.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (boss.getX()) && 
                        bombX <= (boss.getX() + 2*ALIEN_WIDTH) &&
                        bombY >= (boss.getY()) &&
                        bombY <= (boss.getY()+2*ALIEN_HEIGHT) ) {
                            boss.setDying(true);
                             exp.play();
                            b.setDestroyed(true);
                           ingame=false;
                        }
                }
          if (shot.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (shot.getX()) && bombX <= (shot.getX()+2*BOMB_HEIGHT) 
                            && bombY >= (shot.getY()) && bombY <= (shot.getY()+2*BOMB_HEIGHT) ) 
                      {
                            shot.die();
                            b.setDestroyed(true);
                        }
                }
             Iterator s = steelwalls.iterator();
            while (s.hasNext()) {
                Steelwall wall = (Steelwall) s.next();
                int aX = wall.getX();
                int aY = wall.getY();

                if (wall.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (aX) && 
                        bombX <= (aX + 2*ALIEN_WIDTH) &&
                        bombY >= (aY) &&
                        bombY <= (aY+2*ALIEN_HEIGHT) ) {
                           b.setDestroyed(true);
                            }
                }
            }
            
            Iterator w = walls.iterator();
            while (w.hasNext()) {
                Wall wall = (Wall) w.next();
                int aX = wall.getX();
                int aY = wall.getY();

                if (wall.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (aX) && 
                        bombX <= (aX + 2*ALIEN_WIDTH) &&
                        bombY >= (aY) &&
                        bombY <= (aY+2*ALIEN_HEIGHT) ) {
                           wall.setDying(true);
                        b.setDestroyed(true);
                            }
                }
            }
            if (!b.isDestroyed()) {
                if(b.duongbom==2){
                    b.setY(b.getY() + 2);   
                    if (b.getY() >= BOARD_HEIGHT)
                    b.setDestroyed(true);
                 }
                if(b.duongbom==1){
                   b.setY(b.getY()-2);
                   if(b.getY()<0) b.setDestroyed(true);
                }
               if(b.duongbom==3){
                   b.setX(b.getX()-2);
                   if(b.getX()<0) b.setDestroyed(true);
               }
               if(b.duongbom==4){
                   b.setX(b.getX()+2);
                   if(b.getX()>BOARD_WIDTH-BORDER_RIGHT ) b.setDestroyed(true);
               }
            }
          }  
            Random g2 = new Random();
            if("Alien2".equals(aliens3.get(i).getClass().getSimpleName())){
                 int shot1 = g2.nextInt(15);
            Alien2 a = (Alien2)aliens3.get(i);
            Alien2.Bomb b = a.getBomb();
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E42.jpg".equals(a.getShot())) {
                b.duongbom=2;
                b.setDestroyed(false);
                b.setX(a.getX()+11);
                b.setY(a.getY());   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E43.jpg".equals(a.getShot())) {
                b.duongbom=3;
                b.setDestroyed(false);
                b.setX(a.getX());
                b.setY(a.getY()+6);   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E44.jpg".equals(a.getShot())) {
                b.duongbom=4;
                b.setDestroyed(false);
                b.setX(a.getX());
                b.setY(a.getY()+6);   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E41.jpg".equals(a.getShot())) {
                b.duongbom=1;
                b.setDestroyed(false);
                b.setX(a.getX()+11);
                b.setY(a.getY());   
            }

            int bombX = b.getX();
            int bombY = b.getY();
            int playerX = player.getX();
            int playerY = player.getY();

            if (player.isVisible() && !b.isDestroyed()) {
                if ( bombX >= (playerX) && 
                    bombX <= (playerX+PLAYER_WIDTH) &&
                    bombY >= (playerY) && 
                    bombY <= (playerY+PLAYER_HEIGHT) ) {
                        ImageIcon ii1 = 
                            new ImageIcon(expl);
                        player.setImage(ii1.getImage());
                         exp.play();
                        player.life--;
                        if(player.life==0)
                        player.setDying(true);
                        else {
                            ImageIcon ii = new ImageIcon("hinhanh/T1.jpg");
                          player.power=0;
                          player.speed=0;
                          player.setImage(ii.getImage());
                          player.setPl("hinhanh/T1.jpg");
                          player.setY(BOARD_HEIGHT/2+125);
                          player.setX(BOARD_WIDTH/2-100);
                          player.playername="hinhanh/T1.jpg";
                        }
                        b.setDestroyed(true);
                    }
            }
          if (boss.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (boss.getX()) && 
                        bombX <= (boss.getX() + 2*ALIEN_WIDTH) &&
                        bombY >= (boss.getY()) &&
                        bombY <= (boss.getY()+2*ALIEN_HEIGHT) ) {
                            boss.setDying(true);
                             exp.play();
                            b.setDestroyed(true);
                           ingame=false;
                        }
                }
          if (shot.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (shot.getX()) && bombX <= (shot.getX()+2*BOMB_HEIGHT) 
                            && bombY >= (shot.getY()) && bombY <= (shot.getY()+2*BOMB_HEIGHT) ) 
                      {
                            shot.die();
                            b.setDestroyed(true);
                        }
                }
             Iterator s = steelwalls.iterator();
            while (s.hasNext()) {
                Steelwall wall = (Steelwall) s.next();
                int aX = wall.getX();
                int aY = wall.getY();

                if (wall.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (aX) && 
                        bombX <= (aX + 2*ALIEN_WIDTH) &&
                        bombY >= (aY) &&
                        bombY <= (aY+2*ALIEN_HEIGHT) ) {
                           b.setDestroyed(true);
                            }
                }
            }
            
            Iterator w = walls.iterator();
            while (w.hasNext()) {
                Wall wall = (Wall) w.next();
                int aX = wall.getX();
                int aY = wall.getY();

                if (wall.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (aX) && 
                        bombX <= (aX + 2*ALIEN_WIDTH) &&
                        bombY >= (aY) &&
                        bombY <= (aY+2*ALIEN_HEIGHT) ) {
                           wall.setDying(true);
                        b.setDestroyed(true);
                            }
                }
            }
            if (!b.isDestroyed()) {
                if(b.duongbom==2){
                    b.setY(b.getY() + 2);   
                    if (b.getY() >= BOARD_HEIGHT)
                    b.setDestroyed(true);
                 }
                if(b.duongbom==1){
                   b.setY(b.getY()-2);
                   if(b.getY()<0) b.setDestroyed(true);
                }
               if(b.duongbom==3){
                   b.setX(b.getX()-2);
                   if(b.getX()<0) b.setDestroyed(true);
               }
               if(b.duongbom==4){
                   b.setX(b.getX()+2);
                   if(b.getX()>BOARD_WIDTH-BORDER_RIGHT ) b.setDestroyed(true);
               }
            }
            }
          Random g3 = new Random();
            if("Alien3".equals(aliens3.get(i).getClass().getSimpleName()))  {
                int shot1 = g3.nextInt(15);
            Alien3 a = (Alien3)aliens3.get(i);
            Alien3.Bomb b = a.getBomb();
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E46.jpg".equals(a.getShot())) {
                b.duongbom=2;
                b.setDestroyed(false);
                b.setX(a.getX()+11);
                b.setY(a.getY());   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E47.jpg".equals(a.getShot())) {
                b.duongbom=3;
                b.setDestroyed(false);
                b.setX(a.getX());
                b.setY(a.getY()+6);   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E48.jpg".equals(a.getShot())) {
                b.duongbom=4;
                b.setDestroyed(false);
                b.setX(a.getX());
                b.setY(a.getY()+6);   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E45.jpg".equals(a.getShot())) {
                b.duongbom=1;
                b.setDestroyed(false);
                b.setX(a.getX()+11);
                b.setY(a.getY());   
            }

            int bombX = b.getX();
            int bombY = b.getY();
            int playerX = player.getX();
            int playerY = player.getY();

            if (player.isVisible() && !b.isDestroyed()) {
                if ( bombX >= (playerX) && 
                    bombX <= (playerX+PLAYER_WIDTH) &&
                    bombY >= (playerY) && 
                    bombY <= (playerY+PLAYER_HEIGHT) ) {
                        ImageIcon ii1 = 
                            new ImageIcon(expl);
                        player.setImage(ii1.getImage());
                         exp.play();
                        player.life--;
                        if(player.life==0)
                        player.setDying(true);
                        else {
                         ImageIcon ii = new ImageIcon("hinhanh/T1.jpg");
                          player.power=0;
                          player.speed=0;
                          player.setImage(ii.getImage());
                          player.setPl("hinhanh/T1.jpg");
                          player.setY(BOARD_HEIGHT/2+125);
                          player.setX(BOARD_WIDTH/2-100);
                          player.playername="hinhanh/T1.jpg";
                        }
                        b.setDestroyed(true);
                    }
            }
          if (boss.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (boss.getX()) && 
                        bombX <= (boss.getX() + 2*ALIEN_WIDTH) &&
                        bombY >= (boss.getY()) &&
                        bombY <= (boss.getY()+2*ALIEN_HEIGHT) ) {
                            boss.setDying(true);
                             exp.play();
                            b.setDestroyed(true);
                           ingame=false;
                        }
                }
          if (shot.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (shot.getX()) && bombX <= (shot.getX()+2*BOMB_HEIGHT) 
                            && bombY >= (shot.getY()) && bombY <= (shot.getY()+2*BOMB_HEIGHT)  ) 
                      {
                            shot.die();
                            b.setDestroyed(true);
                        }
                }
             Iterator s = steelwalls.iterator();
            while (s.hasNext()) {
                Steelwall wall = (Steelwall) s.next();
                int aX = wall.getX();
                int aY = wall.getY();

                if (wall.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (aX) && 
                        bombX <= (aX + 2*ALIEN_WIDTH) &&
                        bombY >= (aY) &&
                        bombY <= (aY+2*ALIEN_HEIGHT) ) {
                           b.setDestroyed(true);
                            }
                }
            }
            
            Iterator w = walls.iterator();
            while (w.hasNext()) {
                Wall wall = (Wall) w.next();
                int aX = wall.getX();
                int aY = wall.getY();

                if (wall.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (aX) && 
                        bombX <= (aX + 2*ALIEN_WIDTH) &&
                        bombY >= (aY) &&
                        bombY <= (aY+2*ALIEN_HEIGHT) ) {
                           wall.setDying(true);
                        b.setDestroyed(true);
                            }
                }
            }
            if (!b.isDestroyed()) {
                if(b.duongbom==2){
                    b.setY(b.getY() + 2);   
                    if (b.getY() >= BOARD_HEIGHT)
                    b.setDestroyed(true);
                 }
                if(b.duongbom==1){
                   b.setY(b.getY()-2);
                   if(b.getY()<0) b.setDestroyed(true);
                }
               if(b.duongbom==3){
                   b.setX(b.getX()-2);
                   if(b.getX()<0) b.setDestroyed(true);
               }
               if(b.duongbom==4){
                   b.setX(b.getX()+2);
                   if(b.getX()>BOARD_WIDTH-BORDER_RIGHT ) b.setDestroyed(true);
               }
            }
            }
            Random g4 = new Random();
            if("Alien4".equals(aliens3.get(i).getClass().getSimpleName())) {
                 int shot1 = g4.nextInt(15);
            Alien4 a = (Alien4)aliens3.get(i);
            Alien4.Bomb b = a.getBomb();
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E410.jpg".equals(a.getShot())) {
                b.duongbom=2;
                b.setDestroyed(false);
                b.setX(a.getX()+11);
                b.setY(a.getY());   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E411.jpg".equals(a.getShot())) {
                b.duongbom=3;
                b.setDestroyed(false);
                b.setX(a.getX());
                b.setY(a.getY()+6);   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E412.jpg".equals(a.getShot())) {
                b.duongbom=4;
                b.setDestroyed(false);
                b.setX(a.getX());
                b.setY(a.getY()+6);   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E49.jpg".equals(a.getShot())) {
                b.duongbom=1;
                b.setDestroyed(false);
                b.setX(a.getX()+11);
                b.setY(a.getY());   
            }

            int bombX = b.getX();
            int bombY = b.getY();
            int playerX = player.getX();
            int playerY = player.getY();

            if (player.isVisible() && !b.isDestroyed()) {
                if ( bombX >= (playerX) && 
                    bombX <= (playerX+PLAYER_WIDTH) &&
                    bombY >= (playerY) && 
                    bombY <= (playerY+PLAYER_HEIGHT) ) {
                        ImageIcon ii1 = 
                            new ImageIcon(expl);
                        player.setImage(ii1.getImage());
                         exp.play();
                        player.life--;
                        if(player.life==0)
                        player.setDying(true);
                        else {
                          ImageIcon ii = new ImageIcon("hinhanh/T1.jpg");
                          player.power=0;
                          player.speed=0;
                          player.setImage(ii.getImage());
                          player.setPl("hinhanh/T1.jpg");
                          player.setY(BOARD_HEIGHT/2+125);
                          player.setX(BOARD_WIDTH/2-100);
                          player.playername="hinhanh/T1.jpg";
                        }
                        b.setDestroyed(true);
                        
                    }
            }
          if (boss.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (boss.getX()) && 
                        bombX <= (boss.getX() + 2*ALIEN_WIDTH) &&
                        bombY >= (boss.getY()) &&
                        bombY <= (boss.getY()+2*ALIEN_HEIGHT) ) {
                            boss.setDying(true);
                             exp.play();
                            b.setDestroyed(true);
                           ingame=false;
                        }
                }
          if (shot.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (shot.getX()) && bombX <= (shot.getX()+2*BOMB_HEIGHT) 
                            && bombY >= (shot.getY()) && bombY <= (shot.getY()+2*BOMB_HEIGHT) ) 
                      {
                            shot.die();
                            b.setDestroyed(true);
                        }
                }
             Iterator s = steelwalls.iterator();
            while (s.hasNext()) {
                Steelwall wall = (Steelwall) s.next();
                int aX = wall.getX();
                int aY = wall.getY();

                if (wall.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (aX) && 
                        bombX <= (aX + 2*ALIEN_WIDTH) &&
                        bombY >= (aY) &&
                        bombY <= (aY+2*ALIEN_HEIGHT) ) {
                           b.setDestroyed(true);
                            }
                }
            }
            
            Iterator w = walls.iterator();
            while (w.hasNext()) {
                Wall wall = (Wall) w.next();
                int aX = wall.getX();
                int aY = wall.getY();

                if (wall.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (aX) && 
                        bombX <= (aX + 2*ALIEN_WIDTH) &&
                        bombY >= (aY) &&
                        bombY <= (aY+2*ALIEN_HEIGHT) ) {
                           wall.setDying(true);
                        b.setDestroyed(true);
                            }
                }
            }
            if (!b.isDestroyed()) {
                if(b.duongbom==2){
                    b.setY(b.getY() + 2);   
                    if (b.getY() >= BOARD_HEIGHT)
                    b.setDestroyed(true);
                 }
                if(b.duongbom==1){
                   b.setY(b.getY()-2);
                   if(b.getY()<0) b.setDestroyed(true);
                }
               if(b.duongbom==3){
                   b.setX(b.getX()-2);
                   if(b.getX()<0) b.setDestroyed(true);
               }
               if(b.duongbom==4){
                   b.setX(b.getX()+2);
                   if(b.getX()>BOARD_WIDTH-BORDER_RIGHT ) b.setDestroyed(true);
               }
            }
         }
     } 
         Random genee = new Random();

        for(int i=0;i<aliens4.size();i++) {
            if("Alien".equals(aliens4.get(i).getClass().getSimpleName()))
            {
            int shot1 = genee.nextInt(15);
            Alien a = (Alien)aliens4.get(i);
            Alien.Bomb b = a.getBomb();
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E22.jpg".equals(a.getShot())) {
                b.duongbom=2;
                b.setDestroyed(false);
                b.setX(a.getX()+11);
                b.setY(a.getY());   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E23.jpg".equals(a.getShot())) {
                b.duongbom=3;
                b.setDestroyed(false);
                b.setX(a.getX());
                b.setY(a.getY()+6);   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E24.jpg".equals(a.getShot())) {
                b.duongbom=4;
                b.setDestroyed(false);
                b.setX(a.getX());
                b.setY(a.getY()+6);   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E21.jpg".equals(a.getShot())) {
                b.duongbom=1;
                b.setDestroyed(false);
                b.setX(a.getX()+11);
                b.setY(a.getY());   
            }

            int bombX = b.getX();
            int bombY = b.getY();
            int playerX = player.getX();
            int playerY = player.getY();

            if (player.isVisible() && !b.isDestroyed()) {
                if ( bombX >= (playerX) && 
                    bombX <= (playerX+PLAYER_WIDTH) &&
                    bombY >= (playerY) && 
                    bombY <= (playerY+PLAYER_HEIGHT) ) {
                        ImageIcon ii1 = 
                            new ImageIcon(expl);
                        player.setImage(ii1.getImage());
                         exp.play();
                        player.life--;
                        if(player.life==0)
                        player.setDying(true);
                        else {
                            ImageIcon ii = new ImageIcon("hinhanh/T1.jpg");
                          player.power=0;
                          player.speed=0;
                          player.setImage(ii.getImage());
                          player.setPl("hinhanh/T1.jpg");
                          player.setY(BOARD_HEIGHT/2+125);
                          player.setX(BOARD_WIDTH/2-100);
                          player.playername="hinhanh/T1.jpg";
                        }
                        b.setDestroyed(true);
                    }
            }
            if (boss.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (boss.getX()) && 
                        bombX <= (boss.getX() + 2*ALIEN_WIDTH) &&
                        bombY >= (boss.getY()) &&
                        bombY <= (boss.getY()+2*ALIEN_HEIGHT) ) {
                            boss.setDying(true);
                             exp.play();
                            b.setDestroyed(true);
                           ingame=false;
                        }
                }
           if (shot.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (shot.getX()) && bombX <= (shot.getX()+2*BOMB_HEIGHT) 
                            && bombY >= (shot.getY()) && bombY <= (shot.getY()+2*BOMB_HEIGHT) ) 
                       {
                          //  shot.setDying(true);
                            shot.die();
                            b.setDestroyed(true);
                        }
                }
           Iterator s = steelwalls.iterator();
            while (s.hasNext()) {
                Steelwall wall = (Steelwall) s.next();
                int aX = wall.getX();
                int aY = wall.getY();

                if (wall.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (aX) && 
                        bombX <= (aX + 2*ALIEN_WIDTH) &&
                        bombY >= (aY) &&
                        bombY <= (aY+2*ALIEN_HEIGHT) ) {
                           b.setDestroyed(true);
                            }
                }
            }
            
            Iterator w = walls.iterator();
            while (w.hasNext()) {
                Wall wall = (Wall) w.next();
                int aX = wall.getX();
                int aY = wall.getY();

                if (wall.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (aX) && 
                        bombX <= (aX + 2*ALIEN_WIDTH) &&
                        bombY >= (aY) &&
                        bombY <= (aY+2*ALIEN_HEIGHT) ) {
                           wall.setDying(true);
                        b.setDestroyed(true);
                            }
                }
            }
            if (!b.isDestroyed()) {
                if(b.duongbom==2){
                    b.setY(b.getY() + 2);   
                    if (b.getY() >= BOARD_HEIGHT)
                    b.setDestroyed(true);
                 }
                if(b.duongbom==1){
                   b.setY(b.getY()- 2);
                   if(b.getY()<0) b.setDestroyed(true);
                }
               if(b.duongbom==3){
                   b.setX(b.getX()- 2);
                   if(b.getX()<0) b.setDestroyed(true);
               }
               if(b.duongbom==4){
                   b.setX(b.getX()+ 2);
                   if(b.getX()>BOARD_WIDTH-BORDER_RIGHT ) b.setDestroyed(true);
               }
            }
        }
           Random genee1 = new Random();
            if("Alien1".equals(aliens4.get(i).getClass().getSimpleName())){
               int shot1 = genee1.nextInt(15);
            Alien1 a = (Alien1)aliens4.get(i);
            Alien1.Bomb b = a.getBomb();
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E26.jpg".equals(a.getShot())) {
                b.duongbom=2;
                b.setDestroyed(false);
                b.setX(a.getX()+11);
                b.setY(a.getY());   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E27.jpg".equals(a.getShot())) {
                b.duongbom=3;
                b.setDestroyed(false);
                b.setX(a.getX());
                b.setY(a.getY()+6);   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E28.jpg".equals(a.getShot())) {
                b.duongbom=4;
                b.setDestroyed(false);
                b.setX(a.getX());
                b.setY(a.getY()+6);   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E25.jpg".equals(a.getShot())) {
                b.duongbom=1;
                b.setDestroyed(false);
                b.setX(a.getX()+11);
                b.setY(a.getY());   
            }

            int bombX = b.getX();
            int bombY = b.getY();
            int playerX = player.getX();
            int playerY = player.getY();

            if (player.isVisible() && !b.isDestroyed()) {
                if ( bombX >= (playerX) && 
                    bombX <= (playerX+PLAYER_WIDTH) &&
                    bombY >= (playerY) && 
                    bombY <= (playerY+PLAYER_HEIGHT) ) {
                        ImageIcon ii1 = 
                            new ImageIcon(expl);
                        player.setImage(ii1.getImage());
                         exp.play();
                        player.life--;
                        if(player.life==0)
                        player.setDying(true);
                        else {
                            ImageIcon ii = new ImageIcon("hinhanh/T1.jpg");
                          player.power=0;
                          player.speed=0;
                          player.setImage(ii.getImage());
                          player.setPl("hinhanh/T1.jpg");
                          player.setY(BOARD_HEIGHT/2+125);
                          player.setX(BOARD_WIDTH/2-100);
                          player.playername="hinhanh/T1.jpg";
                        }
                        b.setDestroyed(true);
                    }
            }
          if (boss.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (boss.getX()) && 
                        bombX <= (boss.getX() + 2*ALIEN_WIDTH) &&
                        bombY >= (boss.getY()) &&
                        bombY <= (boss.getY()+2*ALIEN_HEIGHT) ) {
                            boss.setDying(true);
                             exp.play();
                            b.setDestroyed(true);
                           ingame=false;
                        }
                }
          if (shot.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (shot.getX()) && bombX <= (shot.getX()+2*BOMB_HEIGHT) 
                            && bombY >= (shot.getY()) && bombY <= (shot.getY()+2*BOMB_HEIGHT) ) 
                      {
                            shot.die();
                            b.setDestroyed(true);
                        }
                }
             Iterator s = steelwalls.iterator();
            while (s.hasNext()) {
                Steelwall wall = (Steelwall) s.next();
                int aX = wall.getX();
                int aY = wall.getY();

                if (wall.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (aX) && 
                        bombX <= (aX + 2*ALIEN_WIDTH) &&
                        bombY >= (aY) &&
                        bombY <= (aY+2*ALIEN_HEIGHT) ) {
                           b.setDestroyed(true);
                            }
                }
            }
            
            Iterator w = walls.iterator();
            while (w.hasNext()) {
                Wall wall = (Wall) w.next();
                int aX = wall.getX();
                int aY = wall.getY();

                if (wall.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (aX) && 
                        bombX <= (aX + 2*ALIEN_WIDTH) &&
                        bombY >= (aY) &&
                        bombY <= (aY+2*ALIEN_HEIGHT) ) {
                           wall.setDying(true);
                        b.setDestroyed(true);
                            }
                }
            }
            if (!b.isDestroyed()) {
                if(b.duongbom==2){
                    b.setY(b.getY() + 2);   
                    if (b.getY() >= BOARD_HEIGHT)
                    b.setDestroyed(true);
                 }
                if(b.duongbom==1){
                   b.setY(b.getY()-2);
                   if(b.getY()<0) b.setDestroyed(true);
                }
               if(b.duongbom==3){
                   b.setX(b.getX()-2);
                   if(b.getX()<0) b.setDestroyed(true);
               }
               if(b.duongbom==4){
                   b.setX(b.getX()+2);
                   if(b.getX()>BOARD_WIDTH-BORDER_RIGHT ) b.setDestroyed(true);
               }
            }
          }  
            Random genee2 = new Random();
            if("Alien2".equals(aliens4.get(i).getClass().getSimpleName())){
                 int shot1 = genee2.nextInt(15);
            Alien2 a = (Alien2)aliens4.get(i);
            Alien2.Bomb b = a.getBomb();
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E42.jpg".equals(a.getShot())) {
                b.duongbom=2;
                b.setDestroyed(false);
                b.setX(a.getX()+11);
                b.setY(a.getY());   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E43.jpg".equals(a.getShot())) {
                b.duongbom=3;
                b.setDestroyed(false);
                b.setX(a.getX());
                b.setY(a.getY()+6);   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E44.jpg".equals(a.getShot())) {
                b.duongbom=4;
                b.setDestroyed(false);
                b.setX(a.getX());
                b.setY(a.getY()+6);   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E41.jpg".equals(a.getShot())) {
                b.duongbom=1;
                b.setDestroyed(false);
                b.setX(a.getX()+11);
                b.setY(a.getY());   
            }

            int bombX = b.getX();
            int bombY = b.getY();
            int playerX = player.getX();
            int playerY = player.getY();

            if (player.isVisible() && !b.isDestroyed()) {
                if ( bombX >= (playerX) && 
                    bombX <= (playerX+PLAYER_WIDTH) &&
                    bombY >= (playerY) && 
                    bombY <= (playerY+PLAYER_HEIGHT) ) {
                        ImageIcon ii1 = 
                            new ImageIcon(expl);
                        player.setImage(ii1.getImage());
                         exp.play();
                        player.life--;
                        if(player.life==0)
                        player.setDying(true);
                        else {
                            ImageIcon ii = new ImageIcon("hinhanh/T1.jpg");
                          player.power=0;
                          player.speed=0;
                          player.setImage(ii.getImage());
                          player.setPl("hinhanh/T1.jpg");
                          player.setY(BOARD_HEIGHT/2+125);
                          player.setX(BOARD_WIDTH/2-100);
                          player.playername="hinhanh/T1.jpg";
                        }
                        b.setDestroyed(true);
                    }
            }
          if (boss.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (boss.getX()) && 
                        bombX <= (boss.getX() + 2*ALIEN_WIDTH) &&
                        bombY >= (boss.getY()) &&
                        bombY <= (boss.getY()+2*ALIEN_HEIGHT) ) {
                            boss.setDying(true);
                             exp.play();
                            b.setDestroyed(true);
                           ingame=false;
                        }
                }
          if (shot.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (shot.getX()) && bombX <= (shot.getX()+2*BOMB_HEIGHT) 
                            && bombY >= (shot.getY()) && bombY <= (shot.getY()+2*BOMB_HEIGHT) ) 
                      {
                            shot.die();
                            b.setDestroyed(true);
                        }
                }
             Iterator s = steelwalls.iterator();
            while (s.hasNext()) {
                Steelwall wall = (Steelwall) s.next();
                int aX = wall.getX();
                int aY = wall.getY();

                if (wall.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (aX) && 
                        bombX <= (aX + 2*ALIEN_WIDTH) &&
                        bombY >= (aY) &&
                        bombY <= (aY+2*ALIEN_HEIGHT) ) {
                           b.setDestroyed(true);
                            }
                }
            }
            
            Iterator w = walls.iterator();
            while (w.hasNext()) {
                Wall wall = (Wall) w.next();
                int aX = wall.getX();
                int aY = wall.getY();

                if (wall.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (aX) && 
                        bombX <= (aX + 2*ALIEN_WIDTH) &&
                        bombY >= (aY) &&
                        bombY <= (aY+2*ALIEN_HEIGHT) ) {
                           wall.setDying(true);
                        b.setDestroyed(true);
                            }
                }
            }
            if (!b.isDestroyed()) {
                if(b.duongbom==2){
                    b.setY(b.getY() + 2);   
                    if (b.getY() >= BOARD_HEIGHT)
                    b.setDestroyed(true);
                 }
                if(b.duongbom==1){
                   b.setY(b.getY()-2);
                   if(b.getY()<0) b.setDestroyed(true);
                }
               if(b.duongbom==3){
                   b.setX(b.getX()-2);
                   if(b.getX()<0) b.setDestroyed(true);
               }
               if(b.duongbom==4){
                   b.setX(b.getX()+2);
                   if(b.getX()>BOARD_WIDTH-BORDER_RIGHT ) b.setDestroyed(true);
               }
            }
            }
          Random genee3 = new Random();
            if("Alien3".equals(aliens4.get(i).getClass().getSimpleName()))  {
                int shot1 = genee3.nextInt(15);
            Alien3 a = (Alien3)aliens4.get(i);
            Alien3.Bomb b = a.getBomb();
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E46.jpg".equals(a.getShot())) {
                b.duongbom=2;
                b.setDestroyed(false);
                b.setX(a.getX()+11);
                b.setY(a.getY());   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E47.jpg".equals(a.getShot())) {
                b.duongbom=3;
                b.setDestroyed(false);
                b.setX(a.getX());
                b.setY(a.getY()+6);   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E48.jpg".equals(a.getShot())) {
                b.duongbom=4;
                b.setDestroyed(false);
                b.setX(a.getX());
                b.setY(a.getY()+6);   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E45.jpg".equals(a.getShot())) {
                b.duongbom=1;
                b.setDestroyed(false);
                b.setX(a.getX()+11);
                b.setY(a.getY());   
            }

            int bombX = b.getX();
            int bombY = b.getY();
            int playerX = player.getX();
            int playerY = player.getY();

            if (player.isVisible() && !b.isDestroyed()) {
                if ( bombX >= (playerX) && 
                    bombX <= (playerX+PLAYER_WIDTH) &&
                    bombY >= (playerY) && 
                    bombY <= (playerY+PLAYER_HEIGHT) ) {
                        ImageIcon ii1 = 
                            new ImageIcon(expl);
                        player.setImage(ii1.getImage());
                         exp.play();
                        player.life--;
                        if(player.life==0)
                        player.setDying(true);
                        else {
                         ImageIcon ii = new ImageIcon("hinhanh/T1.jpg");
                          player.power=0;
                          player.speed=0;
                          player.setImage(ii.getImage());
                          player.setPl("hinhanh/T1.jpg");
                          player.setY(BOARD_HEIGHT/2+125);
                          player.setX(BOARD_WIDTH/2-100);
                          player.playername="hinhanh/T1.jpg";
                        }
                        b.setDestroyed(true);
                    }
            }
          if (boss.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (boss.getX()) && 
                        bombX <= (boss.getX() + 2*ALIEN_WIDTH) &&
                        bombY >= (boss.getY()) &&
                        bombY <= (boss.getY()+2*ALIEN_HEIGHT) ) {
                            boss.setDying(true);
                             exp.play();
                            b.setDestroyed(true);
                           ingame=false;
                        }
                }
          if (shot.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (shot.getX()) && bombX <= (shot.getX()+2*BOMB_HEIGHT) 
                            && bombY >= (shot.getY()) && bombY <= (shot.getY()+2*BOMB_HEIGHT)  ) 
                      {
                            shot.die();
                            b.setDestroyed(true);
                        }
                }
             Iterator s = steelwalls.iterator();
            while (s.hasNext()) {
                Steelwall wall = (Steelwall) s.next();
                int aX = wall.getX();
                int aY = wall.getY();

                if (wall.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (aX) && 
                        bombX <= (aX + 2*ALIEN_WIDTH) &&
                        bombY >= (aY) &&
                        bombY <= (aY+2*ALIEN_HEIGHT) ) {
                           b.setDestroyed(true);
                            }
                }
            }
            
            Iterator w = walls.iterator();
            while (w.hasNext()) {
                Wall wall = (Wall) w.next();
                int aX = wall.getX();
                int aY = wall.getY();

                if (wall.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (aX) && 
                        bombX <= (aX + 2*ALIEN_WIDTH) &&
                        bombY >= (aY) &&
                        bombY <= (aY+2*ALIEN_HEIGHT) ) {
                           wall.setDying(true);
                        b.setDestroyed(true);
                            }
                }
            }
            if (!b.isDestroyed()) {
                if(b.duongbom==2){
                    b.setY(b.getY() + 2);   
                    if (b.getY() >= BOARD_HEIGHT)
                    b.setDestroyed(true);
                 }
                if(b.duongbom==1){
                   b.setY(b.getY()-2);
                   if(b.getY()<0) b.setDestroyed(true);
                }
               if(b.duongbom==3){
                   b.setX(b.getX()-2);
                   if(b.getX()<0) b.setDestroyed(true);
               }
               if(b.duongbom==4){
                   b.setX(b.getX()+2);
                   if(b.getX()>BOARD_WIDTH-BORDER_RIGHT ) b.setDestroyed(true);
               }
            }
            }
            Random genee4 = new Random();
            if("Alien4".equals(aliens4.get(i).getClass().getSimpleName())) {
                 int shot1 = genee4.nextInt(15);
            Alien4 a = (Alien4)aliens4.get(i);
            Alien4.Bomb b = a.getBomb();
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E410.jpg".equals(a.getShot())) {
                b.duongbom=2;
                b.setDestroyed(false);
                b.setX(a.getX()+11);
                b.setY(a.getY());   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E411.jpg".equals(a.getShot())) {
                b.duongbom=3;
                b.setDestroyed(false);
                b.setX(a.getX());
                b.setY(a.getY()+6);   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E412.jpg".equals(a.getShot())) {
                b.duongbom=4;
                b.setDestroyed(false);
                b.setX(a.getX());
                b.setY(a.getY()+6);   
            }
            if (shot1 == 5 && a.isVisible() && b.isDestroyed() && "hinhanh/E49.jpg".equals(a.getShot())) {
                b.duongbom=1;
                b.setDestroyed(false);
                b.setX(a.getX()+11);
                b.setY(a.getY());   
            }

            int bombX = b.getX();
            int bombY = b.getY();
            int playerX = player.getX();
            int playerY = player.getY();

            if (player.isVisible() && !b.isDestroyed()) {
                if ( bombX >= (playerX) && 
                    bombX <= (playerX+PLAYER_WIDTH) &&
                    bombY >= (playerY) && 
                    bombY <= (playerY+PLAYER_HEIGHT) ) {
                        ImageIcon ii1 = 
                            new ImageIcon(expl);
                        player.setImage(ii1.getImage());
                         exp.play();
                        player.life--;
                        if(player.life==0)
                        player.setDying(true);
                        else {
                          ImageIcon ii = new ImageIcon("hinhanh/T1.jpg");
                          player.power=0;
                          player.speed=0;
                          player.setImage(ii.getImage());
                          player.setPl("hinhanh/T1.jpg");
                          player.setY(BOARD_HEIGHT/2+125);
                          player.setX(BOARD_WIDTH/2-100);
                          player.playername="hinhanh/T1.jpg";
                        }
                        b.setDestroyed(true);
                        
                    }
            }
          if (boss.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (boss.getX()) && 
                        bombX <= (boss.getX() + 2*ALIEN_WIDTH) &&
                        bombY >= (boss.getY()) &&
                        bombY <= (boss.getY()+2*ALIEN_HEIGHT) ) {
                            boss.setDying(true);
                             exp.play();
                            b.setDestroyed(true);
                           ingame=false;
                        }
                }
          if (shot.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (shot.getX()) && bombX <= (shot.getX()+2*BOMB_HEIGHT) 
                            && bombY >= (shot.getY()) && bombY <= (shot.getY()+2*BOMB_HEIGHT) ) 
                      {
                            shot.die();
                            b.setDestroyed(true);
                        }
                }
             Iterator s = steelwalls.iterator();
            while (s.hasNext()) {
                Steelwall wall = (Steelwall) s.next();
                int aX = wall.getX();
                int aY = wall.getY();

                if (wall.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (aX) && 
                        bombX <= (aX + 2*ALIEN_WIDTH) &&
                        bombY >= (aY) &&
                        bombY <= (aY+2*ALIEN_HEIGHT) ) {
                           b.setDestroyed(true);
                            }
                }
            }
            
            Iterator w = walls.iterator();
            while (w.hasNext()) {
                Wall wall = (Wall) w.next();
                int aX = wall.getX();
                int aY = wall.getY();

                if (wall.isVisible() && !b.isDestroyed()) {
                    if (bombX >= (aX) && 
                        bombX <= (aX + 2*ALIEN_WIDTH) &&
                        bombY >= (aY) &&
                        bombY <= (aY+2*ALIEN_HEIGHT) ) {
                           wall.setDying(true);
                        b.setDestroyed(true);
                            }
                }
            }
            if (!b.isDestroyed()) {
                if(b.duongbom==2){
                    b.setY(b.getY() + 2);   
                    if (b.getY() >= BOARD_HEIGHT)
                    b.setDestroyed(true);
                 }
                if(b.duongbom==1){
                   b.setY(b.getY()-2);
                   if(b.getY()<0) b.setDestroyed(true);
                }
               if(b.duongbom==3){
                   b.setX(b.getX()-2);
                   if(b.getX()<0) b.setDestroyed(true);
               }
               if(b.duongbom==4){
                   b.setX(b.getX()+2);
                   if(b.getX()>BOARD_WIDTH-BORDER_RIGHT ) b.setDestroyed(true);
               }
            }
         }
     } 
 
       
        
    }
    }
   }
   @SuppressWarnings("SleepWhileInLoop")
   public void run() {

        long beforeTime, timeDiff, sleep;

        beforeTime = System.currentTimeMillis();

        while (ingame) {
            State a1=null;
            int hehe=0;
            for(int i=0;i<aliens.size();i++) {
             if("Alien".equals(aliens.get(i).getClass().getSimpleName()))  
               a1=(Alien)aliens.get(i);
              if("Alien1".equals(aliens.get(i).getClass().getSimpleName()))  
               a1=(Alien1)aliens.get(i);
              if("Alien2".equals(aliens.get(i).getClass().getSimpleName()))  
               a1=(Alien2)aliens.get(i);
              if("Alien3".equals(aliens.get(i).getClass().getSimpleName()))  
               a1=(Alien3)aliens.get(i);
              if("Alien4".equals(aliens.get(i).getClass().getSimpleName()))  
               a1=(Alien4)aliens.get(i);
              if(a1.isVisible())   
                 hehe=1;
        }
         
        int hehe1=0;
            for(int i=0;i<aliens1.size();i++) {
             if("Alien".equals(aliens1.get(i).getClass().getSimpleName()))  
               a1=(Alien)aliens1.get(i);
              if("Alien1".equals(aliens1.get(i).getClass().getSimpleName()))  
               a1=(Alien1)aliens1.get(i);
              if("Alien2".equals(aliens1.get(i).getClass().getSimpleName()))  
               a1=(Alien2)aliens1.get(i);
              if("Alien3".equals(aliens1.get(i).getClass().getSimpleName()))  
               a1=(Alien3)aliens1.get(i);
              if("Alien4".equals(aliens1.get(i).getClass().getSimpleName()))  
               a1=(Alien4)aliens1.get(i);
              if(a1.isVisible())   
                 hehe1=1;
        }
         
        int hehe2=0;
            for(int i=0;i<aliens2.size();i++) {
            if("Alien".equals(aliens2.get(i).getClass().getSimpleName()))  
               a1=(Alien)aliens2.get(i);
              if("Alien1".equals(aliens2.get(i).getClass().getSimpleName()))  
               a1=(Alien1)aliens2.get(i);
              if("Alien2".equals(aliens2.get(i).getClass().getSimpleName()))  
               a1=(Alien2)aliens2.get(i);
              if("Alien3".equals(aliens2.get(i).getClass().getSimpleName()))  
               a1=(Alien3)aliens2.get(i);
              if("Alien4".equals(aliens2.get(i).getClass().getSimpleName()))  
               a1=(Alien4)aliens2.get(i);
              if(a1.isVisible())   
                 hehe2=1;
        }
        
        int hehe3=0;
            for(int i=0;i<aliens3.size();i++) {
             if("Alien".equals(aliens3.get(i).getClass().getSimpleName()))  
               a1=(Alien)aliens3.get(i);
              if("Alien1".equals(aliens3.get(i).getClass().getSimpleName()))  
               a1=(Alien1)aliens3.get(i);
              if("Alien2".equals(aliens3.get(i).getClass().getSimpleName()))  
               a1=(Alien2)aliens3.get(i);
              if("Alien3".equals(aliens3.get(i).getClass().getSimpleName()))  
               a1=(Alien3)aliens3.get(i);
              if("Alien4".equals(aliens3.get(i).getClass().getSimpleName()))  
               a1=(Alien4)aliens3.get(i);
              if(a1.isVisible())   
                 hehe3=1;
        }
        
        int hehe4=0;
            for(int i=0;i<aliens4.size();i++) {
             if("Alien".equals(aliens4.get(i).getClass().getSimpleName()))  
               a1=(Alien)aliens4.get(i);
              if("Alien1".equals(aliens4.get(i).getClass().getSimpleName()))  
               a1=(Alien1)aliens4.get(i);
              if("Alien2".equals(aliens4.get(i).getClass().getSimpleName()))  
               a1=(Alien2)aliens4.get(i);
              if("Alien3".equals(aliens4.get(i).getClass().getSimpleName()))  
               a1=(Alien3)aliens4.get(i);
              if("Alien4".equals(aliens4.get(i).getClass().getSimpleName()))  
               a1=(Alien4)aliens4.get(i);
              if(a1.isVisible())   
                 hehe4=1;
        }
        if(count<4 || count1<4 || count2<4 || count3<4 ||  count4<4){
            State a2=null;int j=(int)(Math.random()*(BOARD_WIDTH-BORDER_RIGHT-25));
            for(int i=0;i<Alien.size();i++){
                a2=(State)Alien.get(i);
                if(a2.isVisible()){
                while( j >= a2.getX()-25 && j <= a2.getX()+25 ){         
                    j=(int)(Math.random()*(BOARD_WIDTH-BORDER_RIGHT-25));
                }
               }
            }
            if((hehe==0 && (hehe1!=0 ||hehe4!=0 ||hehe2!=0||hehe3!=0 ) ) ){
                if(count<4){
                Alien alien = new Alien(j, 5);
                aliens.add(alien);
                Alien.add(alien);
                count++;
                }
                
                else {
                  if(count4<4){  
                      Alien4 alien = new Alien4(j, 5);
                      aliens.add(alien);
                      Alien.add(alien);
                      count4++;}
                  else {
                      if(count3<4){  
                      Alien3 alien = new Alien3(j, 5);
                      aliens.add(alien);
                      Alien.add(alien);
                      count3++;}
                      else{
                          if(count2<4){  
                      Alien2 alien = new Alien2(j, 5);
                      aliens.add(alien);
                      Alien.add(alien);
                      count2++;}
                          else{
                              if(count1<4){  
                      Alien1 alien = new Alien1(j, 5);
                      aliens.add(alien);
                      Alien.add(alien);
                      count1++;}
                          }
                      }
                  }
                 }
            } 
            if(hehe1==0 && (hehe4!=0 ||hehe!=0 ||hehe2!=0||hehe3!=0 )){
                if(count1<4){
                Alien1 alien = new Alien1(j, 5);
                aliens1.add(alien);
                Alien.add(alien);
                count1++;
                }
                
                else {
                  if(count<4){  
                      Alien alien = new Alien(j, 5);
                      aliens1.add(alien);
                      Alien.add(alien);
                      count++;}
                  else {
                      if(count4<4){  
                      Alien4 alien = new Alien4(j, 5);
                      aliens1.add(alien);
                      Alien.add(alien);
                      count4++;}
                      else{
                          if(count3<4){  
                      Alien3 alien = new Alien3(j, 5);
                      aliens1.add(alien);
                      Alien.add(alien);
                      count3++;}
                          else{
                              if(count2<4){  
                      Alien2 alien = new Alien2(j, 5);
                      aliens1.add(alien);
                      Alien.add(alien);
                      count2++;}
                          }
                      }
                  }
                 }
            } 
            if(hehe2==0 && (hehe1!=0 ||hehe!=0 ||hehe4!=0||hehe3!=0 )){
               if(count2<4){
                Alien2 alien = new Alien2(j, 5);
                aliens2.add(alien);
                Alien.add(alien);
                count2++;
                }
                
                else {
                  if(count1<4){  
                      Alien1 alien = new Alien1(j, 5);
                      aliens2.add(alien);
                      Alien.add(alien);
                      count1++;}
                  else {
                      if(count<4){  
                      Alien alien = new Alien(j, 5);
                      aliens2.add(alien);
                      Alien.add(alien);
                      count++;}
                      else{
                          if(count4<4){  
                      Alien4 alien = new Alien4(j, 5);
                      aliens2.add(alien);
                      Alien.add(alien);
                      count4++;}
                          else{
                              if(count3<4){  
                      Alien3 alien = new Alien3(j, 5);
                      aliens2.add(alien);
                      Alien.add(alien);
                      count3++;}
                          }
                      }
                  }
                 } 
            } 
            if(hehe3==0 && (hehe1!=0 ||hehe!=0 ||hehe2!=0||hehe4!=0 )){
                if(count3<4){
                Alien3 alien = new Alien3(j, 5);
                aliens3.add(alien);
                Alien.add(alien);
                count3++;
                }
                
                else {
                  if(count2<4){  
                      Alien2 alien = new Alien2(j, 5);
                      aliens3.add(alien);
                      Alien.add(alien);
                      count2++;}
                  else {
                      if(count1<4){  
                      Alien1 alien = new Alien1(j, 5);
                      aliens3.add(alien);
                      Alien.add(alien);
                      count1++;}
                      else{
                          if(count<4){  
                      Alien alien = new Alien(j, 5);
                      aliens3.add(alien);
                      Alien.add(alien);
                      count++;}
                          else{
                              if(count4<4){  
                      Alien4 alien = new Alien4(j, 5);
                      aliens3.add(alien);
                      Alien.add(alien);
                      count4++;}
                          }
                      }
                  }
                 }
            } 
            if(hehe4==0 && (hehe1!=0 ||hehe!=0 ||hehe2!=0||hehe3!=0 ) ){
                if(count4<4){
                Alien4 alien = new Alien4(j, 5);
                aliens4.add(alien);
                Alien.add(alien);
                count4++;
                }
                
                else {
                  if(count3<4){  
                      Alien3 alien = new Alien3(j, 5);
                      aliens4.add(alien);
                      Alien.add(alien);
                      count3++;}
                  else {
                      if(count2<4){  
                      Alien2 alien = new Alien2(j, 5);
                      aliens4.add(alien);
                      Alien.add(alien);
                      count2++;}
                      else{
                          if(count1<4){  
                      Alien1 alien = new Alien1(j, 5);
                      aliens4.add(alien);
                      Alien.add(alien);
                      count1++;}
                          else{
                              if(count<4){  
                      Alien alien = new Alien(j, 5);
                      aliens4.add(alien);
                      Alien.add(alien);
                      count++;}
                          }
                      }
                  }
                 }
            }
            if(hehe==0 && hehe1==0 && hehe2==0 && hehe3==0 && hehe4==0 && deaths<20){
                 if(count4<4){
                Alien4 alien = new Alien4(5, 5);
                aliens4.add(alien);
                Alien.add(alien);
                count4++;
                }
                
                else {
                  if(count3<4){  
                      Alien3 alien = new Alien3(5, 5);
                      aliens4.add(alien);
                      Alien.add(alien);
                      count3++;}
                  else {
                      if(count2<4){  
                      Alien2 alien = new Alien2(5, 5);
                      aliens4.add(alien);
                      Alien.add(alien);
                      count2++;}
                      else{
                          if(count1<4){  
                      Alien1 alien = new Alien1(5, 5);
                      aliens4.add(alien);
                      Alien.add(alien);
                      count1++;}
                          else{
                              if(count<4){  
                      Alien alien = new Alien(5, 5);
                      aliens4.add(alien);
                      Alien.add(alien);
                      count++;}
                          }
                      }
                  }
                 }
                 
                 if(count3<4){
                Alien3 alien = new Alien3(50, 5);
                aliens3.add(alien);
                Alien.add(alien);
                count3++;
                }
                
                else {
                  if(count2<4){  
                      Alien2 alien = new Alien2(50, 5);
                      aliens3.add(alien);
                      Alien.add(alien);
                      count2++;}
                  else {
                      if(count1<4){  
                      Alien1 alien = new Alien1(50, 5);
                      aliens3.add(alien);
                      Alien.add(alien);
                      count1++;}
                      else{
                          if(count<4){  
                      Alien alien = new Alien(50, 5);
                      aliens3.add(alien);
                      Alien.add(alien);
                      count++;}
                          else{
                              if(count4<4){  
                      Alien4 alien = new Alien4(50, 5);
                      aliens3.add(alien);
                      Alien.add(alien);
                      count4++;}
                          }
                      }
                  }
                 }
                 if(count2<4){
                Alien2 alien = new Alien2(200, 5);
                aliens2.add(alien);
                Alien.add(alien);
                count2++;
                }
                
                else {
                  if(count1<4){  
                      Alien1 alien = new Alien1(200, 5);
                      aliens2.add(alien);
                      Alien.add(alien);
                      count1++;}
                  else {
                      if(count<4){  
                      Alien alien = new Alien(200, 5);
                      aliens2.add(alien);
                      Alien.add(alien);
                      count++;}
                      else{
                          if(count4<4){  
                      Alien4 alien = new Alien4(200, 5);
                      aliens2.add(alien);
                      Alien.add(alien);
                      count4++;}
                          else{
                              if(count3<4){  
                      Alien3 alien = new Alien3(200, 5);
                      aliens2.add(alien);
                      Alien.add(alien);
                      count3++;}
                          }
                      }
                  }
                 }
                 if(count1<4){
                Alien1 alien = new Alien1(250, 5);
                aliens1.add(alien);
                Alien.add(alien);
                count1++;
                }
                
                else {
                  if(count<4){  
                      Alien alien = new Alien(250, 5);
                      aliens1.add(alien);
                      Alien.add(alien);
                      count++;}
                  else {
                      if(count4<4){  
                      Alien4 alien = new Alien4(250, 5);
                      aliens1.add(alien);
                      Alien.add(alien);
                      count4++;}
                      else{
                          if(count3<4){  
                      Alien3 alien = new Alien3(250, 5);
                      aliens1.add(alien);
                      Alien.add(alien);
                      count3++;}
                          else{
                              if(count2<4){  
                      Alien2 alien = new Alien2(250, 5);
                      aliens1.add(alien);
                      Alien.add(alien);
                      count2++;}
                          }
                      }
                  }
                 }
                  if(count<4){
                Alien alien = new Alien(430, 5);
                aliens.add(alien);
                Alien.add(alien);
                count++;
                }
                
                else {
                  if(count4<4){  
                      Alien4 alien = new Alien4(430, 5);
                      aliens.add(alien);
                      Alien.add(alien);
                      count4++;}
                  else {
                      if(count3<4){  
                      Alien3 alien = new Alien3(430, 5);
                      aliens.add(alien);
                      Alien.add(alien);
                      count3++;}
                      else{
                          if(count2<4){  
                      Alien2 alien = new Alien2(430, 5);
                      aliens.add(alien);
                      Alien.add(alien);
                      count2++;}
                          else{
                              if(count1<4){  
                      Alien1 alien = new Alien1(430, 5);
                      aliens.add(alien);
                      Alien.add(alien);
                      count1++;}
                          }
                      }
                  }
                 }
                 
                  
            }
        }
      if(control!=6){
          if(deaths==3) control=0;
        if(deaths>0 && deaths<20 && deaths ==4 && control!=9 && control!=8 && control!=3){
               present.setDying(true);
                int n=(int)(Math.random()*5);
                 present=new Present(50*(n+1), 180);
                if(n==0) 
                {ImageIcon ii1 = new ImageIcon("hinhanh/PU6.jpg");
                        present.setImage(ii1.getImage());
                        present.setPre("hinhanh/PU6.jpg");}
                if(n==1) 
                {ImageIcon ii1 = new ImageIcon("hinhanh/PU3.jpg");
                        present.setImage(ii1.getImage());
                        present.setPre("hinhanh/PU3.jpg");}
                if(n==2) 
                {ImageIcon ii1 = new ImageIcon("hinhanh/PU2.jpg");
                        present.setImage(ii1.getImage());
                        present.setPre("hinhanh/PU2.jpg");}
                if(n==3) 
                {ImageIcon ii1 = new ImageIcon("hinhanh/PU7.jpg");
                        present.setImage(ii1.getImage());
                        present.setPre("hinhanh/PU7.jpg");}
                if(n==4) 
                {ImageIcon ii1 = new ImageIcon("hinhanh/PU5.jpg");
                        present.setImage(ii1.getImage());
                        present.setPre("hinhanh/PU5.jpg");}
                if(control!=3) control=8;
                
            }
        
           if(deaths==9) control=0;
        
           if(deaths>0 && deaths<20 && deaths ==10 && control!=9 && control!=8 && control!=3)
            {   present.setDying(true);
                int n=(int)(Math.random()*5);
                 present=new Present(50*(n+1), 200);
                if(n==0) 
                {ImageIcon ii1 = new ImageIcon("hinhanh/PU6.jpg");
                        present.setImage(ii1.getImage());
                        present.setPre("hinhanh/PU6.jpg");}
                if(n==1) 
                {ImageIcon ii1 = new ImageIcon("hinhanh/PU3.jpg");
                        present.setImage(ii1.getImage());
                        present.setPre("hinhanh/PU3.jpg");}
                if(n==2) 
                {ImageIcon ii1 = new ImageIcon("hinhanh/PU5.jpg");
                        present.setImage(ii1.getImage());
                        present.setPre("hinhanh/PU5.jpg");}
                if(n==3) 
                {ImageIcon ii1 = new ImageIcon("hinhanh/PU2.jpg");
                        present.setImage(ii1.getImage());
                        present.setPre("hinhanh/PU2.jpg");}
                if(n==4) 
                {ImageIcon ii1 = new ImageIcon("hinhanh/PU7.jpg");
                        present.setImage(ii1.getImage());
                        present.setPre("hinhanh/PU7.jpg");}
                if(control!=3) control=8;
            }
           
           if(deaths==15) control=0;
           
           if(deaths>0 && deaths<20 && deaths ==16 && control!=9 && control!=8 && control!=3)
            {   present.setDying(true);
                int n=(int)(Math.random()*5);
                present=new Present(50*(n+1), 200);
                if(n==0) 
                {ImageIcon ii1 = new ImageIcon("hinhanh/PU6.jpg");
                        present.setImage(ii1.getImage());
                        present.setPre("hinhanh/PU6.jpg");}
                if(n==1) 
                {ImageIcon ii1 = new ImageIcon("hinhanh/PU3.jpg");
                        present.setImage(ii1.getImage());
                        present.setPre("hinhanh/PU3.jpg");}
                if(n==2) 
                {ImageIcon ii1 = new ImageIcon("hinhanh/PU2.jpg");
                        present.setImage(ii1.getImage());
                        present.setPre("hinhanh/PU2.jpg");}
                if(n==3) 
                {ImageIcon ii1 = new ImageIcon("hinhanh/PU5.jpg");
                        present.setImage(ii1.getImage());
                        present.setPre("hinhanh/PU5.jpg");}
                if(n==4) 
                {ImageIcon ii1 = new ImageIcon("hinhanh/PU7.jpg");
                        present.setImage(ii1.getImage());
                        present.setPre("hinhanh/PU7.jpg");}
                if(control!=3) control=8;
            }
        }
            if(player.getX()>=present.getX()-18 && player.getX() <= present.getX()+18 && player.getY()>=present.getY()-18 && player.getY()<=present.getY()+18){
               if("hinhanh/PU6.jpg".equals(present.getPre())) control=1;
               if("hinhanh/PU3.jpg".equals(present.getPre())) control=2;
               if("hinhanh/PU5.jpg".equals(present.getPre())) control=3;
               if("hinhanh/PU2.jpg".equals(present.getPre())) control=4;
               if("hinhanh/PU7.jpg".equals(present.getPre())) control=5;
                present.setDying(true);
               present=new Present();
                                      }
     
        if(control==1){
            if("hinhanh/T1.jpg".equals(player.getPl())){
                player.setPl("hinhanh/T13.jpg");
                ImageIcon im = new ImageIcon(player.getPl());
            player.setImage(im.getImage());
            player.power=1;
            player.speed=3;
            }
            if("hinhanh/T2.jpg".equals(player.getPl())){
                player.setPl("hinhanh/T14.jpg");
                ImageIcon im = new ImageIcon(player.getPl());
            player.setImage(im.getImage());
            player.power=1;
             player.speed=3;
            }    
            if("hinhanh/T3.jpg".equals(player.getPl())){
                player.setPl("hinhanh/T15.jpg");
                ImageIcon im = new ImageIcon(player.getPl());
            player.setImage(im.getImage());
            player.power=1;
             player.speed=3;
            }
            if("hinhanh/T4.jpg".equals(player.getPl())){
                player.setPl("hinhanh/T16.jpg");
                ImageIcon im = new ImageIcon(player.getPl());
            player.setImage(im.getImage());
            player.power=1;
             player.speed=3;
            }
            player.playername="hinhanh/T13.jpg";
            control=9;//sau khi an sao thi control=9
        }    
            
       if(control==2){
              State a=null; 
            for(int i=0;i<aliens.size();i++) {
            if("Alien".equals(aliens.get(i).getClass().getSimpleName()))
              {a = (Alien)aliens.get(i);
              }
             if("Alien1".equals(aliens.get(i).getClass().getSimpleName()))
              {a = (Alien1)aliens.get(i);
              }   
            if("Alien2".equals(aliens.get(i).getClass().getSimpleName()))
              {a = (Alien2)aliens.get(i);
              }
            if("Alien3".equals(aliens.get(i).getClass().getSimpleName()))
              {a = (Alien3)aliens.get(i);
              }
            if("Alien4".equals(aliens.get(i).getClass().getSimpleName()))
              {a = (Alien4)aliens.get(i);
              }
            
            ImageIcon im = new ImageIcon(expl);
            exp.play();
            a.setImage(im.getImage());
            a.setDying(true);
        }  
           for(int i=0;i<aliens1.size();i++) {
            if("Alien".equals(aliens1.get(i).getClass().getSimpleName()))
              {a = (Alien)aliens1.get(i);
              }
             if("Alien1".equals(aliens1.get(i).getClass().getSimpleName()))
              {a = (Alien1)aliens1.get(i);
              }   
            if("Alien2".equals(aliens1.get(i).getClass().getSimpleName()))
              {a = (Alien2)aliens1.get(i);
              }
            if("Alien3".equals(aliens1.get(i).getClass().getSimpleName()))
              {a = (Alien3)aliens1.get(i);
              }
            if("Alien4".equals(aliens1.get(i).getClass().getSimpleName()))
              {a = (Alien4)aliens1.get(i);
              }
            
            ImageIcon im = new ImageIcon(expl);
            exp.play();
            a.setImage(im.getImage());
            a.setDying(true);
        }
         
              for(int i=0;i<aliens2.size();i++) {
            if("Alien".equals(aliens2.get(i).getClass().getSimpleName()))
              {a = (Alien)aliens2.get(i);
              }
             if("Alien1".equals(aliens2.get(i).getClass().getSimpleName()))
              {a = (Alien1)aliens2.get(i);
              }   
            if("Alien2".equals(aliens2.get(i).getClass().getSimpleName()))
              {a = (Alien2)aliens2.get(i);
              }
            if("Alien3".equals(aliens2.get(i).getClass().getSimpleName()))
              {a = (Alien3)aliens2.get(i);
              }
            if("Alien4".equals(aliens2.get(i).getClass().getSimpleName()))
              {a = (Alien4)aliens2.get(i);
              }
            
            ImageIcon im = new ImageIcon(expl);
            exp.play();
            a.setImage(im.getImage());
            a.setDying(true);
        }
           
                 for(int i=0;i<aliens3.size();i++) {
            if("Alien".equals(aliens3.get(i).getClass().getSimpleName()))
              {a = (Alien)aliens3.get(i);
              }
             if("Alien1".equals(aliens3.get(i).getClass().getSimpleName()))
              {a = (Alien1)aliens3.get(i);
              }   
            if("Alien2".equals(aliens3.get(i).getClass().getSimpleName()))
              {a = (Alien2)aliens3.get(i);
              }
            if("Alien3".equals(aliens3.get(i).getClass().getSimpleName()))
              {a = (Alien3)aliens3.get(i);
              }
            if("Alien4".equals(aliens3.get(i).getClass().getSimpleName()))
              {a = (Alien4)aliens3.get(i);
              }
            
            ImageIcon im = new ImageIcon(expl);
            exp.play();
            a.setImage(im.getImage());
            a.setDying(true);
        }
                 for(int i=0;i<aliens4.size();i++) {
            if("Alien".equals(aliens4.get(i).getClass().getSimpleName()))
              {a = (Alien)aliens4.get(i);
              }
             if("Alien1".equals(aliens4.get(i).getClass().getSimpleName()))
              {a = (Alien1)aliens4.get(i);
              }   
            if("Alien2".equals(aliens4.get(i).getClass().getSimpleName()))
              {a = (Alien2)aliens4.get(i);
              }
            if("Alien3".equals(aliens4.get(i).getClass().getSimpleName()))
              {a = (Alien3)aliens4.get(i);
              }
            if("Alien4".equals(aliens4.get(i).getClass().getSimpleName()))
              {a = (Alien4)aliens4.get(i);
              }
            
            ImageIcon im = new ImageIcon(expl);
            exp.play();
            a.setImage(im.getImage());
            a.setDying(true);
        }   
                 
        deaths+=5;
        control=0;//sau khi an bom thi control=0
            }
        if(control==3){
            dem++;
            if(dem==500) {control=9;dem=0;}//sau khi ket thuc hen gio thi control=9
        }
        if(control==5){
            player.life++;
            control=9;
        }
       if(control==4){
             for (int ii=0; ii < 1; ii++) {
            for (int j=0; j <2 ; j++) {
                Iterator ii4 = walls.iterator();
        while (ii4.hasNext()) {
              Wall a = (Wall) ii4.next();
              if(a.getX()==(BOARD_WIDTH-BORDER_RIGHT)/2-25 && a.getY()==BOARD_HEIGHT-50-25*j)
                a.setDying(true);
              }
                Steelwall wall = new Steelwall((BOARD_WIDTH-BORDER_RIGHT)/2-25, BOARD_HEIGHT-50-25*j);
                 steelwalls.add(wall);
            }
          }
        for (int ii=0; ii < 1; ii++) {
            for (int j=0; j <1 ; j++) {
                Iterator ii4 = walls.iterator();
                while (ii4.hasNext()) {
              Wall a = (Wall) ii4.next();
              if(a.getX()==(BOARD_WIDTH-BORDER_RIGHT)/2 && a.getY()==BOARD_HEIGHT-75)
                a.setDying(true);
              }
                Steelwall wall = new Steelwall( (BOARD_WIDTH-BORDER_RIGHT)/2,BOARD_HEIGHT-75 );
                 steelwalls.add(wall);
            }
          }   
        for (int ii=0; ii < 1; ii++) {
            for (int j=0; j <2 ; j++) {
                Iterator ii4 = walls.iterator();
                while (ii4.hasNext()) {
              Wall a = (Wall) ii4.next();
              if(a.getX()==(BOARD_WIDTH-BORDER_RIGHT)/2+25 && a.getY()==BOARD_HEIGHT-50-25*j)
                a.setDying(true);
              }
                Steelwall wall = new Steelwall((BOARD_WIDTH-BORDER_RIGHT)/2+25,BOARD_HEIGHT-50-25*j );
                 steelwalls.add(wall);
               }
              }
            control=9;//ket thuc xay thanh control=9
           }  
         
          repaint();
          animationCycle();
         
            timeDiff = System.currentTimeMillis() - beforeTime;
            sleep = DELAY - timeDiff;
            sleep*=1;
            if (sleep < 0) 
               sleep = 2;
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                System.out.println("interrupted");
            }
            beforeTime = System.currentTimeMillis();
        }
        if(player.level==1){
             gameOver();
        for(int i=0;i<1000000000;i++) {
         if(i==1000000000)  {
                break;
           }
         }
        this.fr.setVisible(false); 
        JFrame f=new Java_tank();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(BOARD_WIDTH,BOARD_HEIGHT );
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setResizable(false);
        }
        else {
         gameOver();
         for(int i=0;i<1000000000;i++) {
         if(i==1000000000)  {
                break;
           }
         }
         Board1 board1=new Board1();
        board1.fr1=new JFrame("Game tank");
         board1.fr1.add(board1);
        board1.fr1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        board1.fr1.setSize(BOARD_WIDTH,BOARD_HEIGHT );
        board1.fr1.setLocationRelativeTo(null);
        board1.fr1.setVisible(true);
        board1.fr1.setResizable(false);
        this.fr.setVisible(false);    
          
      }
  }  

    private class TAdapter extends KeyAdapter {

        public void keyReleased(KeyEvent e) {
            player.keyReleased(e);
        }

        public void keyPressed(KeyEvent e) {

          player.keyPressed(e);

          int x = player.getX();
          int y = player.getY();
          
          if (ingame)
          {
            if (e.getKeyChar() == KeyEvent.VK_SPACE) {
                if (!shot.isVisible() && ("hinhanh/T1.jpg".equals(player.getPl()) || "hinhanh/T13.jpg".equals(player.getPl())) )
                    shot=new Shot(x,y,1);
                if (!shot.isVisible() && ("hinhanh/T2.jpg".equals(player.getPl()) || "hinhanh/T14.jpg".equals(player.getPl())) )
                    shot=new Shot(x,y,2);
                if (!shot.isVisible() && ("hinhanh/T3.jpg".equals(player.getPl()) || "hinhanh/T15.jpg".equals(player.getPl())))
                    shot=new Shot(x,y,3);
                if (!shot.isVisible() && ("hinhanh/T4.jpg".equals(player.getPl()) || "hinhanh/T16.jpg".equals(player.getPl())))
                    shot=new Shot(x,y,4);
            }
          if(e.getKeyChar() == KeyEvent.VK_ESCAPE){
            if(control!=6) control=6;
            else control=8;
          }
                   
          }
        }
    }

}

