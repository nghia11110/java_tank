
package java_tank;
import java.awt.Image;
public class State {
    private boolean visible;
        private Image image;
        protected int x;
        protected int y;
        protected boolean dying;
        protected int dx;
        protected int dy; 
        protected String pl="hinhanh/T1.jpg";
        protected  String al;
        protected  String pre;
        protected int blood;
      public void setBlood(){this.blood-=1;}
    
    public int getBlood(){return this.blood;}
        public State() {
            visible = true;
        }

        public void die() {
            visible = false;
        }

        public boolean isVisible() {
            return visible;
        }

        protected void setVisible(boolean visible) {
            this.visible = visible;
        }

        public void setImage(Image image) {
            this.image = image;
        }

        public Image getImage() {
            return image;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }
        public int getY() {
            return y;
        }

        public int getX() {
            return x;
        }
        public void setPl(String s){
           this.pl=s.substring(0);
        }
        public void setAl(String s){
           this.al=s.substring(0);
        }
        public String getAl(){
           return al;
        }
        
         public void setPre(String s){
           this.pre=s.substring(0);
        }
        public String getPre(){
           return pre;
        }
        public String getPl(){
           return pl;
        }
        public void setDying(boolean dying) {
            this.dying = dying;
        }

        public boolean isDying() {
            return this.dying;
        }
}
