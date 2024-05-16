import processing.core.PApplet;

public class Sketch extends PApplet {

  // Relateed arrays and varaibles for the (x,y) coordinate of the snowflakes
  float[] snowX = new float [42];
  float[] snowY = new float [42];
  int snowDiameter = 10;
  //Related arrays and varaiables for the (x,y) coordinates of the character
  boolean upPressedCharacter = false;
  boolean downPressedCharacter = false;
  boolean leftPressedCharacter = false;
  boolean rightPressedCharacter = false;
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
    if (upPressedCharacter) {
      characterY--;
    }
    if (downPressedCharacter) {
      characterY++;
    }
    if (leftPressedCharacter) {
      characterX--;
    }
    if (rightPressedCharacter) {
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
      upPressedCharacter = true;
    }
    else if (key == 's') {
      downPressedCharacter = true;
    }
    else if (key == 'a') {
      leftPressedCharacter = true;
    }
    else if (key == 'd') {
      rightPressedCharacter = true;
    }
  }
  
  public void keyReleased() {
    if (key == 'w') {
      upPressedCharacter = false;
    }
    else if (key == 's') {
      downPressedCharacter = false;
    }
    else if (key == 'a') {
      leftPressedCharacter = false;
    }
    else if (key == 'd') {
      rightPressedCharacter = false;
    }
  }
}