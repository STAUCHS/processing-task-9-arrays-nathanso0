import processing.core.PApplet;

public class Sketch extends PApplet {

  // Relateed arrays and varaibles for the (x,y) coordinate of the snowflakes
  float[] snowX = new float [42];
  float[] snowY = new float [42];
  int snowDiameter = 10;
  //Related arrays and varaiables for the (x,y) coordinates of the character
  boolean upPressed = false;
  boolean downPressed = false;
  boolean leftPressed = false;
  boolean rightPressed = false;
  float characterY = 150;
  float characterX = 150;

  public void settings() {
    size(400, 400);
  }

  public void setup() {
    background(0);
    // genertates random x and y values
    for (int i = 0; i < snowX.length; i++){
      snowX[i] = random(width);
      snowY[i] = random(height);
    }
  }

  public void draw() {
    background(0);
    //draw snow
    snow();
    //draw player character
    if (upPressed) {
      characterY--;
    }
    if (downPressed) {
      characterY++;
    }
    if (leftPressed) {
      characterX--;
    }
    if (rightPressed) {
      characterX++;
  }
  fill(225,0,0);
  ellipse(characterX, characterY, 20, 20);
  }

  // All other defined methods are written below:
  public void snow(){
    for (int i = 0; i < snowX.length; i++){
      fill(255);
    circle(snowX[i], snowY[i], snowDiameter);
      snowY[i] += 1;
        //When snow hits ground resest
      if (snowY[i]> height){
        snowY[i] = 0;
        snowX[i] = random(width);
      }
      if (keyPressed) {
        if (keyCode == DOWN) {
          snowY[i] += 1;
        }
        else if (keyCode == UP) {
          snowY[i] -= 0.5;
        }
      }
    }
  }
  public void keyPressed() {
    if (key == 'w') {
      upPressed = true;
    }
    else if (key == 's') {
      downPressed = true;
    }
    else if (key == 'a') {
      leftPressed = true;
    }
    else if (key == 'd') {
      rightPressed = true;
    }
  }
  
  public void keyReleased() {
    if (key == 'w') {
      upPressed = false;
    }
    else if (key == 's') {
      downPressed = false;
    }
    else if (key == 'a') {
      leftPressed = false;
    }
    else if (key == 'd') {
      rightPressed = false;
    }
  }
}