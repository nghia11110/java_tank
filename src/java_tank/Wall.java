
package java_tank;

import javax.swing.ImageIcon;


public class Wall extends State{
    private String wa="hinhanh/Wall.jpg";
    
    
    public Wall(int x, int y) {
        this.x = x;
        this.y = y;
        ImageIcon ii = new ImageIcon(wa);
        setImage(ii.getImage());
        
    }
}
