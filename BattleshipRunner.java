import java.util.Scanner;

public class BattleshipRunner {
   public static void main(String[] args){
      Scanner gameSelect = new Scanner(System.in);
      Battleship game = new Battleship(gameSelect);
      System.out.println("Enter your guess limit. Type a number from 1 - 83 for the preferred amount of guesses and -1 for unlimited guesses");
      int limit = gameSelect.nextInt(); //Int scan for guess limit
      while (true) {
         if ((limit <= 83 && limit > 0 )|| limit == -1) { //Limits from 1-83 and -1 are valid
            break;
         }
         limit = gameSelect.nextInt(); //waits for another int input if previous number was invalid
      }
      boolean won;
      if (limit == -1) won = game.play(); //If limit is -1 play guess game with unlimited guesses
      else won = game.play(limit); //If limit is 1+ play guess game with limited guesses
      if (won == true) {
         System.out.println("You sank all the ships in " + game.getGuesses() + " guesses!");
      } else {
         System.out.println("Out of guesses! Here's where the ships were:");
         System.out.println(game.printBoats());
      }
  }
}