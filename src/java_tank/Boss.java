
package java_tank;

import javax.swing.ImageIcon;


public class Boss extends State{
      public Boss(int x,int y){
            this.x=x;
            this.y=y;
            ImageIcon ii=new ImageIcon("hinhanh/Base1.jpg");
             setImage(ii.getImage());
              }
    
}
