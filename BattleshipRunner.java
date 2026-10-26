public class BattleshipRunner {
   public static void main(String[] args){
      Battleship game = new Battleship();
      Scanner gameSelect = new Scanner(System.in);
      System.out.println("Enter your guess limit. Type a number from 1 - 83 for the preferred amount of guesses and -1 for unlimited guesses");
      int limit = gameSelect.nextInt(); //Int scan for guess limit
      while (true) {
         if ((limit < 83 && limit > 0 )|| limit == -1) { //Limits that are 1+ and -1 are valid
            break;
         }
         limit = gameSelect.nextInt(); //waits for another int input if previous number was invalid
      }
      if (limit == -1) {
         if (game.play() == true) {
            
         } //If limit is -1 play guess game with unlimited guesses
      }
      else {
         if (game.play(limit) == true) {
            
         } //If limit is 1+ play guess game with limited guesses
      }
  }
}