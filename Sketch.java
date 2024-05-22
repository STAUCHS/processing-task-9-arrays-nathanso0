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
  boolean downPressedSnow = false;
  boolean upPressedSnow = false;
  boolean GameEnd = false;
  boolean mouseclick = false;
  int Lives = 3;

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
    if (Lives == 3) {
      fill (225, 0, 0);
      rect(width-20, 0, 20, 20);
    }
    if (Lives >= 2){
      fill (225, 0, 0);
      rect(width-40, 0 ,20, 20);
    }
    if (Lives >= 1) {
      fill (225, 0, 0);
      rect(width-60, 0, 20, 20);
    }
       if(Lives == 0){
        GameEnd = true;
      }
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
  fill(0,0,225);
  ellipse(characterX, characterY, 20, 20);
  if (GameEnd == true){
    background(0);
    System.out.println("Game Over Buddy");
  }
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

      // Edit later to make bln for mutli key pressing
      if (keyPressed) {
        if (upPressedSnow) {
          snowY[i] += 1;
        }
        else if (downPressedSnow) {
          snowY[i] -= 0.5;
        }
      }
      if(dist(characterX, characterY, snowX[i], snowY[i]) < snowDiameter/2){
        Lives -= 1;
        snowY[i] = 0;
        snowX[i] = random(width);
      } 
      if(mouseclick == true){
        if(dist(mouseX, mouseY, snowX[i], snowY[i]) < snowDiameter){
          snowY[i] = 0;
          snowX[i] = random(width);
          mouseclick = false;
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
    else if (keyCode == DOWN) {
      downPressedSnow = true;
    }
    else if (keyCode == UP) {
      upPressedSnow = true;
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
    else if (keyCode == DOWN) {
      downPressedSnow = false;
    }
    else if (keyCode == UP) {
      upPressedSnow = false;
    }
}
public void SnowHide(){
    for(int i = 0; i < snowX.length; i++){
      if (dist(characterX, characterY, snowX[i], snowY[i]) < snowDiameter){
        snowY[i] = 0;
        snowX[i] = random(width);
      }
    }
  }
  public void MouseClicked() {
    mouseclick = true;
  } 

}