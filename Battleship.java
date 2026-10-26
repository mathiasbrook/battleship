import java.util.*;
public class Battleship {

   private int[][] board;
   private Scanner scan;
   private int guesses = 0;

//1 Ship
//2 Hit
//3 Empty
//4 Miss

   public Battleship(Scanner s) {
      this();
      scan = s;
   }

   public Battleship() {
      scan = new Scanner(System.in);
      board = new int[10][10];
      for (int r = 0; r < board.length; r++)
         for (int c = 0; c < board.length; c++)
            board[r][c] = 3;
      ArrayList<Integer> temp = new ArrayList<Integer>(Arrays.asList(2, 3, 3, 4, 5));
      
      while (temp.size()!=0) {
         int x = (int)(Math.random()*10);
         int y = (int)(Math.random()*10);
         int r = (int)((Math.random()*2)); //r 0 = 0 degrees, r 1 = 90 degrees
         if (placeBoat(temp.get(0),x,y,r) == true) temp.remove(0);
      }
      //carrier 5
      //battleship 4
      //destroyer 3
      //submarine 3
      //patrol boat 2
      
   }
   
   public boolean placeBoat(int var, int x, int y, int r) {
      if (r == 0) {
         if (x + var > board[0].length) return false;
         for (int col = x; col < x + var; col++) {
            if (board[col][y] != 3) return false;
         }
         for (int col = x; col < x + var; col++) {
            board[col][y] = 1;
         }
         return true;
      }
      if (r == 1) {
         if (y + var > board.length) return false;
         for (int row = y; row < y + var; row++) {
            if (board[x][row] != 3) return false;
         }
         for (int row = y; row < y + var; row++) {
            board[x][row] = 1;
         }
         return true;
      }
      return false;
   }
      
   public String printHits() {
      String temp = "   1 2 3 4 5 6 7 8 9 10\n";
      for (int x = 0; x < board.length; x++) {
         if (x < 9) temp += " ";
         temp += (x + 1) + " ";
         for (int y = 0; y < board[0].length; y++) {
            if (board[x][y] == 2) temp += "H ";
            else if (board[x][y] == 4) temp += "M ";
            else temp += "# ";
         }
         temp+= "\n";
      }
      return temp;
   } 
   
   public String printBoats() {
      String temp = "   1 2 3 4 5 6 7 8 9 10\n";
      for (int x = 0; x < board.length; x++) {
         if (x < 9) temp += " ";
         temp += (x + 1) + " ";
         for (int y = 0; y < board[0].length; y++) {
            if (board[x][y] == 1) temp += "A ";
            else if (board[x][y] == 2) temp += "H ";
            else temp += "# ";
         }
         temp+= "\n";
      }
      return temp;
   }  
   public boolean shootBoard(int x, int y) { //true = successful shot, //false = occupied space
      if (board[x][y] == 1) {
         board[x][y] = 2;
         return true;
      } 
      if (board[x][y] == 3) {
         board[x][y] = 4;
         return true;
      }
      return false;
   }
   //checks if there are any ship spaces left that haven't been hit
   public boolean allSunk() {
      for (int r = 0; r < board.length; r++)
         for (int c = 0; c < board[0].length; c++)
            if (board[r][c] == 1) return false;
      return true;
   }

   //asks for one guess and shoots it, returns false if the spot was already shot
   private boolean guess() {
      System.out.println("Enter a row and a column (1-10), for example: 3 7");
      int row = scan.nextInt();
      int col = scan.nextInt();
      while (row < 1 || row > 10 || col < 1 || col > 10) { //waits for numbers in the board
         System.out.println("That's off the board. Enter a row and a column from 1-10");
         row = scan.nextInt();
         col = scan.nextInt();
      }
      if (shootBoard(row - 1, col - 1) == false) {
         System.out.println("You already shot there, try again");
         return false;
      }
      guesses++;
      System.out.println(printHits());
      if (board[row - 1][col - 1] == 2) System.out.println("Hit!");
      else System.out.println("Miss!");
      return true;
   }

   //plays with unlimited guesses, returns true when all the ships are sunk
   public boolean play() {
      System.out.println(printHits());
      while (allSunk() == false) {
         guess();
      }
      return true;
   }

   //plays with a guess limit, returns true if all the ships are sunk before the guesses run out
   public boolean play(int x) {
      System.out.println(printHits());
      while (allSunk() == false && guesses < x) {
         if (guess() == true) System.out.println((x - guesses) + " guesses left");
      }
      return allSunk();
   }

   public int getGuesses() {
      return guesses;
   }
}
