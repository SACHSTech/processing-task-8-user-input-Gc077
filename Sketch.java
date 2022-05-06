import processing.core.PApplet;

public class Sketch extends PApplet {
	
	// Delcare global variables
  int intHouseXdefault = 50;
  int intHouseYdefault = 250;
  int intSunXdefault = 50;
  int intSunYdefault = 60;
  boolean isSunPressed = false;
  boolean isHousePressed = false;
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
    background(135, 206, 235);
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
	   // Environment Designs 
    // Background 
    if (isSunPressed == false) {
      background(135, 206, 235);
    }
    else if (mouseY <= 150 && isSunPressed == true) {
      background(135, 206, 235);
    }
    else if (mouseY > 150 && mouseY < 300 && isSunPressed == true) {
      background(238, 93, 108);
    }
    else if (mouseY > 300 && isSunPressed == true) {
      background(0);
    }
    
    // Draw sun and animate through mouse inputs
    // Arrow key movements 
    if(mouseX >= intSunXdefault && mouseX <= (intSunXdefault + 80) && mouseY >= intSunYdefault && mouseY <= (intSunYdefault + 80) && isSunPressed == false){
      if(mousePressed == true){
        isSunPressed = true;
        mousePressed = false;
      }
      else{}
    }
    else{}

    if(keyPressed){
      if(keyCode == DOWN){
        intSunYdefault++;
      }
      else if(keyCode == UP){
        intSunYdefault--;
      }
      else if(keyCode == RIGHT){
        intSunXdefault++;
      }
      else if(keyCode == LEFT){
        intSunXdefault--;
      }
    }
    if (isSunPressed == true && mousePressed == true)
    {
      isSunPressed = false;
    }

    if (isSunPressed == false){
      sun(intSunXdefault, intSunYdefault, 80);
    }
    else if (isSunPressed == true){
      sun(mouseX, mouseY, 80);
    }

    // Draw Grass
    grass(0, 300, 400, 100);
    // Key inputs for grass colour change
    if (keyPressed){
      if (key == ' ')
      {
      fill(0); 
      rect(0, 300, 400, 100);
      }
      else{}
    }

    // Draw house 1
    house(200, 100, 200);

    // Draw house 2 and animate through mouse inputs
    if(mouseX > 50 && mouseX < 150 && mouseY > 250 && mouseY < 350 && isHousePressed == false){
      if(mousePressed){
        isHousePressed = true;
        mousePressed = false;
      }
      else{}
    }
    else{}

    if(isHousePressed == false){
      house(intHouseXdefault, intHouseYdefault, 100);
    }
    else if(isHousePressed == true){
      house(mouseX, mouseY, 100);
    }

    if (isHousePressed == true && mousePressed == true)
    {
      isHousePressed = false;
    }
}


  /**
  * Draws a base grass for a drawing that utilizes grass for the base
  * 
  * @param intGrassX x-coordinate for the grass
  * @param intGrassY y-coordinate for the grass
  * @param intGrWidth width of grass
  * @param intGrHeight height of grass
  * 
  */
  private void grass(int intGrassX, int intGrassY, int intGrWidth, int intGrHeight)
  { 
    // Draw base grass
    stroke(0, 120, 0);
    fill(0, 120, 0);
    rect(intGrassX, intGrassY, intGrWidth, intGrHeight);
  }

  /**
  * Draws a sun to the screen
  * 
  * @param intSunX x-coordinate of the sun
  * @param intSunY y-coordinate of the sun
  * @param intSunSize size of the sun
  * 
  */
  private void sun(int intSunX, int intSunY, int intSunSize)
  { 
    // Draw sun
    stroke(255, 167, 0);
    fill(255, 255, 0);
    ellipse(intSunX, intSunY, intSunSize, intSunSize);
  }

  /**
   * Draws a house to the screen
   * 
   * @param intHouseX x-coordinate of the house
   * @param intHouseY y-coordinate of the house
   * @param intHouseSize size integer of the house
   * 
   */
  private void house(int intHouseX, int intHouseY, int intHouseSize)
  {
    // Base rectangle of the body of the house
    stroke(0);
    fill(160, 55, 63);
    rect(intHouseX, intHouseY, intHouseSize, intHouseSize);

    // Roof
    fill(0);
    triangle(intHouseX, intHouseY, intHouseX + (intHouseSize / 2), intHouseY - (intHouseSize / 4), intHouseX + (intHouseSize), intHouseY);

    // Window
    if (mouseY > 300 && isSunPressed == true) {
      fill(255, 255, 0);
    }
    else{
    fill(0);
    }
    rect((intHouseX + (intHouseSize / 2)), (intHouseY + (intHouseSize / 2)), (intHouseSize / 2), (intHouseSize / 4));

    // Door 
    fill(0);
    rect(intHouseX, (intHouseY + (intHouseSize / 2)), (intHouseSize / 3), (intHouseSize / 2));
  }
}