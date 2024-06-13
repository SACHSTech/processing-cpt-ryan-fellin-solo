/**
 * @author Ryan
 * This class defines how the obstacle values behave, determining various parameters of the obstacle
 * @param obstx X Co-Ordinate of the Obstacle
 * @param obsty Y Co-Ordinate of the Obstacle
 * @param obstwidth Width of the Obstacle
 * @param obstheight Height of the Obstacle
 */
public class Obstacle {
    
        float x;
        float y;
        float obsth;
        float obstw;
        
        public Obstacle(float obstx, float obsty, float obstwidth, float obstheight){
          this.x = obstx;
          this.y = obsty;
          this.obstw = obstwidth;
          this.obsth = obstheight;
        }
      
}
