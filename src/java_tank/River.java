
package java_tank;

import javax.swing.ImageIcon;


public class River extends State{
    private String ri="hinhanh/water.jpg";
    
    
    public River(int x, int y) {
        this.x = x;
        this.y = y;
        ImageIcon ii = new ImageIcon(ri);
        setImage(ii.getImage());
    }
}
