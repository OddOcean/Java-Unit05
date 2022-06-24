// Aidan Weygandt 10.22.21
// Purpose of Program: 
// Convert user input numbers to user input bases 
// output conversions will be in a string format
// input will check to make sure correct data type
// one method handles all bases less then 10 and the other handles hexadecimal 

import java.util.Scanner;

class Lab05B_Weygandt{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    System.out.println("Hello world!");
    int base = enterData(input, "Enter a base for your number to be converted to (2, 5, 8 or 16): ");
    while (base != 2 && base != 5 && base != 8 && base != 16){//makes sure base is 2, 5, 8, or 16, else it repeatedly asks for another number
      base = enterData(input, "Base must be 2, 5, 8 or 16: ");
    }
    int num = enterData(input, "Enter a number to be converted: ");
    System.out.println(num + " converted to base " + base + " is " + toBase(num, base));
  }

  //method checks for correct input from user
  //if incorrect input avoid error, send output to user and ask for correct input
  public static int enterData(Scanner console, String prompt){
    System.out.print(prompt);
    while (!console.hasNextInt()){ //make sure an int was entered
      console.next(); //clear the invalid input before prompting again
      System.out.print("Please enter a valid integer: ");
    }
    return console.nextInt();
  }

  //method for decimal input to a String base less than 10 format output
  public static String toBase(int x, int b){
    String ret = "";
    int rem;
    while (x > 0){
      rem = x % b;
      if (b == 16){
        if (rem == 10){
          ret += "A";
        }else if (rem == 11){
          ret += "B";
        }else if (rem == 12){
          ret += "C";
        }else if (rem == 13){
          ret += "D";
        }else if (rem == 14){
          ret += "E";
        }else if (rem == 15){
          ret += "F";
        }else{
          ret += rem;
        }
      }else{
        ret += rem;
      }
      x /= b;
    }
    return reverse(ret);//returns reversed 
  }
  
  //method for returning the reversed version of a string
  public static String reverse(String s){
    String palindrome = "";
    for (int i = s.length() - 1; i >= 0; i--){//creates palindrome of string by counting through it backwords and adding each character to a new string
      palindrome = palindrome + s.charAt(i);
    }
    return palindrome;
  }
}