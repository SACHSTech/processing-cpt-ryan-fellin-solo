import java.sql.Time;
import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {
  ArrayList<Obstacle> obstaclegen = new ArrayList<Obstacle>();
  PImage player;
  PImage titlescreen;
  PImage backgroundpic;
  float spawnpointx = 100;
  float spawnpointy = 480;
  float circley;
  float circlex;
  float playerlength = 20;
  float playerwidth = 80;
  float vely = 0;
  float velx = 0;
  float ground = (height - 95);
  float startDash;
  float dashTime;
  float dashSpeed;
  int level = 0;
  int backgroundnum;
  int platforms;
  int platformstatus;
  double grav = (float) 0.5;
  boolean[] keyboardkey = new boolean[255];
  boolean jumping = false;
  boolean dodgeroll = false;
  boolean iframe = false;
  boolean hit = false;
  boolean left;
  boolean right;
  boolean whileloop = true;
  boolean touchingGround;
  long time = System.currentTimeMillis();
  int dodgedelay = 3000;

  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
    // put your size call here
    size(800, 800);

  }

  /**
   * Called once at the beginning of execution. Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    backgroundpic = loadImage("cave.png");
    pushMatrix();
    titlescreen = loadImage("cavetitlescreen.png");

    popMatrix();

    player = loadImage("80X20PLACEHOLDER.png");
    circlex = spawnpointx;
    circley = spawnpointy;
    level();

  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {

    // vely = (vely + 1);
    backgroundphoto();
    image(player, circlex, circley);
    circlex = circlex + velx;
    circlex = circlex + velx;
    circley = circley + vely;
    System.out.println(touchingGround);
    for (int i = 0; i < obstaclegen.size(); i++) {

      // check collision for this obstacle
      Obstacle Obstacle = obstaclegen.get(i);
      //System.out.println(obstaclegen.get(i));
      if (circlex + playerlength + 10 + velx > Obstacle.x && circlex + velx < Obstacle.x + Obstacle.obstw
          && circley + playerwidth > Obstacle.y && circley < Obstacle.y + Obstacle.obsth) {
        velx = 0;

        if (left) {
          circlex = Obstacle.x + Obstacle.obstw;

        }
        if (right) {
          circlex = Obstacle.x - 50;
        }

      }
      if (circlex + playerlength > Obstacle.x && circlex < Obstacle.x + Obstacle.obstw
          && circley + playerwidth + vely > Obstacle.y && circley + vely < Obstacle.y + Obstacle.obsth) {
        vely = 0;

        touchingGround = true;
      }
      
      if (circley > height) {
        circlex = spawnpointx;
        circley = spawnpointy;
      }
      if (circlex > width || circlex < 0) {
        System.out.println("nextlevel");
        level++;
        level();

      }

      fill(255, 0, 0);

      rect(Obstacle.x, Obstacle.y, Obstacle.obstw, Obstacle.obsth);
    }

    if (touchingGround) {
      vely = 0;
      jumping = false;
      //circley =  circley - 10;
    }
    
    else if(!touchingGround){
      vely = vely + 1;
    }
    
    

    // player();

    // sample code, delete this stuff
    // ellipse(width / 2, height - 20, 50, 50);

    // define other methods down here.
    /*
     * public void player() {
     * // vely = vely + 1;F
     * image(player, circlex, circley);
     * while (whileloop) {
     * 
     * }
     * 
     * 
     * circlex = circlex + velx;
     * circley = circley + vely;
     * // lower edge collision detection
     * 
     * if (circley > height) {
     * 
     * vely = 0;
     * 
     * jumping = false;
     * 
     * }
     * 
     * 
     * 
     */

    if (keyboardkey[(int) 'w']) {
      System.out.println("w pressed");
      if (!jumping) {
        jumping = true;
        touchingGround = false;
        vely = (vely = (-15));
        

      }

    }
    if (keyboardkey[(int) 'a']) {
      System.out.println("a pressed");
      velx = -6;
      left = true;
      right = false;
    }
    if (keyboardkey[(int) 'd']) {
      System.out.println("d pressed");
      velx = 6;
      left = false;
      right = true;
      
    }
   if (keyboardkey[(int)'s']){
      touchingGround = false
      ;
   }

    if (keyboardkey[(int) 'l']) {
      System.out.println("dodgeroll");
      startDash = time;
      if (!dodgeroll) {
        dodgeroll = true;
        if (left) {
          velx = -20;
          vely = 0;

        }
        if (right) {
          velx = 20;
          vely = 0;

        }

      }
    }
    /*
     * if (time > dodgedelay + 1000) {
     * dodgeroll = !dodgeroll;
     * }
     */
  }

  public void level() {
    if(level == 0){
      obstaclegen.add(new Obstacle(0, width - 20, width, 20));
      
      
    }
    if (level == 1) {
      backgroundnum =  1;
      obstaclegen.add(new Obstacle(0, 0, width, 20));
      // obstaclegen.add(new Obstacle(0, width-20, width, 20));
      obstaclegen.add(new Obstacle(0, 0, 20, height));
      obstaclegen.add(new Obstacle(width - 20, 150, 20, height - 20));
      obstaclegen.add(new Obstacle(700, 450, 300, 600));
      obstaclegen.add(new Obstacle(600, 250, 200, 0));
      obstaclegen.add(new Obstacle(0, 400, 200, 20));
      obstaclegen.add(new Obstacle(0, 300, 100, 20));
      obstaclegen.add(new Obstacle(400, 550, 200, 300));
      obstaclegen.add(new Obstacle(0, 600, 300, 300));
      obstaclegen.add(new Obstacle(0, 0, 0, 1));
      
      circlex = spawnpointx;
      circley = spawnpointy;
    }
    if (level == 2) {
      obstaclegen.clear();
      obstaclegen.add(new Obstacle(0, 0, width, 20));
      obstaclegen.add(new Obstacle(400, width - 100, width, 40));
      obstaclegen.add(new Obstacle(0, 250, 25, height));
      obstaclegen.add(new Obstacle(width - 20, 0, 20, height));
      obstaclegen.add(new Obstacle(0, 600, 200, 50));
      obstaclegen.add(new Obstacle(500, width - 300, width, 40));
      obstaclegen.add(new Obstacle(0, 400, 200, 50));
      obstaclegen.add(new Obstacle(500, width - 500, width, 40));
      obstaclegen.add(new Obstacle(0, 800, 200, 50));

      spawnpointx = 600;
      //velx = 0;
      //vely = 0;
      spawnpointy = 600;
      circlex = spawnpointx;
      circley = spawnpointy;
    }
    if (level == 3) {
      obstaclegen.clear();
      //obstaclegen.add(new Obstacle(0, 0, width, 20));
      obstaclegen.add(new Obstacle(0, width - 20, width, 20));
      obstaclegen.add(new Obstacle(0, 0, 20, height));
      obstaclegen.add(new Obstacle(width - 20, -120, 20, height - 20));
      obstaclegen.add(new Obstacle(100, width - 500, width, 20));
      obstaclegen.add(new Obstacle(- 100, width - 350, width, 20));
      obstaclegen.add(new Obstacle(100, width - 200, width, 20));
      obstaclegen.add(new Obstacle(-100, width - 650, width, 20));
      spawnpointx = 100;
      //velx = 0;
      //vely = 0;
      spawnpointy = 50;
      circlex = spawnpointx;
      circley = spawnpointy;
    }
    if (level == 4) {
      obstaclegen.clear();
      obstaclegen.add(new Obstacle(0, 0, width, 20));
      obstaclegen.add(new Obstacle(0, width - 20, width, 20));
      obstaclegen.add(new Obstacle(0, 0, 20, height));
      obstaclegen.add(new Obstacle(width-20, -150, 20, height - 20));
      obstaclegen.add(new Obstacle(400, 200, 20, height));
      obstaclegen.add(new Obstacle(200, width - 100, 400, 20));
      obstaclegen.add(new Obstacle(0, width - 200, 100, 20));
      obstaclegen.add(new Obstacle(200, width - 300, 400, 20));
      obstaclegen.add(new Obstacle(0, width - 400, 100, 20));
      obstaclegen.add(new Obstacle(200, width - 500, 400, 20));
      obstaclegen.add(new Obstacle(height- 100, width - 400, 100, 20));
      obstaclegen.add(new Obstacle(height- 100, width - 200, 100, 20));

      spawnpointx = 100;
      //velx = 0;
      //vely = 0;
      spawnpointy = 650;
      circlex = spawnpointx;
      circley = spawnpointy;
      touchingGround = false;
    }
    if(level == 5){
      obstaclegen.clear();
      background(GRAY);
      textSize(60);
      text("You Escaped the Great Cave!", 0, 400);
      textSize(56);
      text("Thank you for playing", 130, 500);
      
      stop();
    }

  }

  // Thanks to Caleb for the help with keyboard input using arrays!
  public void keyPressed() {
    if ((int) key != 65535) {
      keyboardkey[(int) key] = true;
      System.out.println((int) key);
    }
  }

  public void keyReleased() {
    if ((int) key == 'l') {
      dodgeroll = false;
      velx = 0;
    }
    if ((int) key == 'w') {

    }
    if ((int) key == 'a') {
      velx = 0;
    }
    if ((int) key == 'd') {
      velx = 0;
    }
    if ((int) key != 65535) {
      keyboardkey[(int) key] = false;
    }

  }
  public void backgroundphoto(){
    if(backgroundnum == 0){
      background(titlescreen);
    }
    if(backgroundnum == 1){
      background(backgroundpic);
    }
  }

}
