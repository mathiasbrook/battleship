import java.util.*;
import java.io.*;
public class Battleship {

   private int[][] board;

//1 Ship
//2 Hit
//3 Empty
//4 Miss

   public Battleship() {
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
         if (x + var >= board[0].length) return false;
         for (int col = x; col < x + var; col++) {
            if (board[col][y] != 3) return false;
         }
         int temp = 0;
         for (int col = x; col < x + var; col++) {
            temp++;
            board[col][y] = 1;
         }
         System.out.println(temp);
         return true;
      }
      if (r == 1) {
         if (y + var >= board.length) return false;
         for (int row = y; row < y + var; row++) {
            if (board[x][row] != 3) return false;
         }
         int temp = 0;
         for (int row = y; row < y + var; row++) {
            temp++;
            board[x][row] = 1;
         }
         System.out.println(temp);
         return true;
      }
      return false;
   }
      
   public String printHits() {
      String temp = "";
      for (int x = 0; x < board.length; x++) {
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
      String temp = "";
      for (int x = 0; x < board.length; x++) {
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
   public void play() {
      
   }
   
   public void play(int x) {
      
   }
   public static void main(String[] args){
      Battleship temp = new Battleship();
      System.out.println(temp.printBoats());
   } 
}