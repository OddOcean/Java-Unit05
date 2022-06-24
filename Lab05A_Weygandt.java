// Aweygandt2022 10.20.21
// Purpose of Program:
// demonstrate solution of the fencepost problem by drawing a fence 
// program will be able to draw a fence with a for, while or do while loop
// program will also check for proper user input 

import java.awt.*;
import javax.swing.JFrame;
import java.util.Scanner;

public class Lab05A_Weygandt extends Canvas {
   
  //set width and height of canvas
  private static int Cwidth = 1600;
  private static int Cheight = 500;
  
  public static void main(String[] args) {
    JFrame frame = new JFrame("Your Name Here");
    //main method has to exist in file being run
    //code below create a jframe with a canvas on it
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Canvas canvas = new Lab05A_Weygandt();//constructor must match class name
    canvas.setSize(Cwidth, Cheight);
    canvas.setBackground(Color.WHITE);//colors:RED,GREEN,BLUE,YELLOW,MAGENTA,CYAN,WHITE,BLACK,GRAY,LIGHT_GRAY,DARK_GRAY,PINK,ORANGE    
    frame.add(canvas);
    frame.pack();
    frame.setVisible(true);
    //end canvas code, do not edit
  }

  public void paint(Graphics g){
    int loop = 0;//used by while and do while loop as counter
    Scanner input = new Scanner(System.in); //create scanner object for input
    //use getInt method to get error checked input from user
    int sections = getInt(input, "\nHow many sections of fence would you like?: ");
    int loopType = getInt(input, "What type of loop would you like to use?(for - 1, while - 2, do while - 3): ");
    while (loopType < 1 && loopType > 3){//makes sure loopType is within range
      loopType = getInt(input, "Please enter a number from 1 - 3: ");
    }
    if (loopType == 1){//if user wants a for loop
      for (int i = 0; i < sections; i++){//repeats code until i equal too or greater than sections
        drawPicket(g, i*120);//draws pickets 120 pixels appart
        drawRails(g, i*120);
        drawPicket(g, 120+i*120);
      }
    }else if (loopType == 2){//if user wants a while loop
      while (loop < sections){//repeats code until loop is equal too or greater than sections
        drawPicket(g, loop*120);//draws pickets 120 pixels appart
        drawRails(g, loop*120);
        drawPicket(g, 120+loop*120);
        loop++;//increses loop by 1 each iteration
      }
    }else if (loopType == 3){//if user wants a do while loop
      do {//repeats code until loop is equal too or greater than sections
        drawPicket(g, loop*120);//draws pickets 120 pixels appart
        drawRails(g, loop*120);
        drawPicket(g, 120+loop*120);
        loop++;//increses loop by 1 each iteration
      } while (loop < sections);
    }
  }//end paint
  
  
  //method that checks for correct input from user
  //if incorrect input avoid error, send output to user and ask for correct input
  public static int getInt(Scanner console, String prompt){//takes and imput when 
    System.out.print(prompt);
    while (!console.hasNextInt()){ //make sure an int was entered
      console.nextLine(); //clear the invalid input before prompting again
      System.out.print("Please enter The numerator as an int (1, 2, ect...): ");
    }
    return console.nextInt();
  }
  
  //method for painting a fence post to canvas window
  public static void drawPicket(Graphics g, int x){//draws a picket at x + 10 when called
    int [] picketX = {20+x, 30+x, 30+x, 10+x, 10+x};//sets up pionts for picket xs and ys
    int [] picketY = {10, 60, 490, 490, 60};
    g.setColor(Color.BLACK);//sets drawing color to black
    g.fillPolygon(picketX, picketY, 5);//draws picket
  }
  
  //method for painting two rails inbetween posts.
  public static void drawRails(Graphics g, int x){//draws two rails at x + 30 when called
    int [] railX = {30+x, 130+x, 130+x, 30+x};
    int [] railY = {150, 150, 170, 170};
    int [] rail2Y = {440, 440, 460, 460};
    g.setColor(Color.RED);//sets drawing color to black
    g.fillPolygon(railX, railY, 4);//draws rails
    g.fillPolygon(railX, rail2Y, 4);
  }
   
}//end class