
package java_tank;

import javax.swing.ImageIcon;


public class Steelwall extends State{
    private String ste="hinhanh/SteelWall.jpg";
    
    
    public Steelwall(int x, int y) {
        this.x = x;
        this.y = y;
        ImageIcon ii = new ImageIcon(ste);
        setImage(ii.getImage());
    }
}
