
package java_tank;
import javax.swing.ImageIcon;
public class Shot extends State {
     private String shot = "hinhanh/bomb.png";
     protected   int duongdan;
    private final int H_SPACE = 11;
    private final int V_SPACE = 6;

    public Shot(){if("hinhanh/T1.jpg".equals(getPl()) || "hinhanh/T13.jpg".equals(getPl())) this.duongdan=1;
    if("hinhanh/T2.jpg".equals(getPl()) || "hinhanh/T14.jpg".equals(getPl())) this.duongdan=2;
        if("hinhanh/T3.jpg".equals(getPl()) || "hinhanh/T15.jpg".equals(getPl())) this.duongdan=3;
            if("hinhanh/T4.jpg".equals(getPl()) || "hinhanh/T16.jpg".equals(getPl())) this.duongdan=4;
    }
 
    public  Shot(int x, int y,int duongdan) {

        ImageIcon ii = new ImageIcon(shot);
        setImage(ii.getImage());
        this.duongdan=duongdan;
     //   setY(y-50);
        if("hinhanh/T3.jpg".equals(getPl()) || "hinhanh/T15.jpg".equals(getPl()))
        {
            setX(x  );
             setY(y +24);
        }
        if("hinhanh/T4.jpg".equals(getPl()) || "hinhanh/T16.jpg".equals(getPl()))
        {
            setX(x );
             setY(y + 24 );
        }
        if("hinhanh/T1.jpg".equals(getPl()) || "hinhanh/T13.jpg".equals(getPl()))
        { 
            setX(x + H_SPACE);
             setY(y + V_SPACE);
        }
        if("hinhanh/T2.jpg".equals(getPl()) || "hinhanh/T14.jpg".equals(getPl()))
        {
            setX(x + H_SPACE);
             setY(y + V_SPACE);
        }
        
    }
}
