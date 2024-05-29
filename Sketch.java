import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {
  PImage player;
  float circley = 200;
  float circlex = 200;
  float vely = 0;
   float velx = 0;
   float ground = (height - 75);
   double grav = (float)0.5;
   boolean[] keyboardkey = new boolean[255];
	
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(400, 400);
   
    
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    background(210, 255, 173);
   player = loadImage("80X20PLACEHOLDER.png"); 
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
    background(210, 255, 173);
	  player();


	// sample code, delete this stuff
  ellipse(width/2, height/2, 50, 50);
  
  }
  
  // define other methods down here.
  public void player(){
    //vely = vely + 1;
    image(player, circlex, circley);
    circlex = circlex + velx;
    circley = circley + vely;
    // lower edge collision detection
   if(vely < ground){
    vely += grav;
   }
   else{
    vely = 0;
   }
  }
  public void combometer(){
    
  }
//Thanks to Caleb for the help with keyboard input using arrays!
  public void keyPressed(){
    if((int)key != 65535){
    keyboardkey[(int)key] = true;
    System.out.println((int)key);
    }
  }
  public void keyReleased(){
    if((int)key != 65535){
    keyboardkey[(int)key] = false;
  }
}
} 

