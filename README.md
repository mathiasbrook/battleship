# Battleship

Single player Battleship in the Java console. The computer hides 5 ships on a 10x10 board and you try to sink all of them.

## Features
- Ships are placed randomly, either across or down, without overlapping: carrier (5), battleship (4), destroyer (3), submarine (3) and patrol boat (2)
- Board with row and column numbers that shows hits (`H`), misses (`M`) and unknown spots (`#`)
- Hit or miss message after every shot
- Won't let you shoot the same spot twice or shoot off the board (those don't count as guesses)
- Pick a guess limit from 1-83 or `-1` for unlimited guesses
- Win check when every ship space has been hit, and the ship locations are shown if you run out of guesses

## How to run
```
javac Battleship.java BattleshipRunner.java && java BattleshipRunner
```
Enter guesses as a row and a column, like `3 7`.

## Sample output
A real game with a 5 guess limit (lines starting with `>` are what I typed):

```
Enter your guess limit. Type a number from 1 - 83 for the preferred amount of guesses and -1 for unlimited guesses
> 100
Please type a number from 1 - 83, or -1 for unlimited guesses
> 5
   1 2 3 4 5 6 7 8 9 10
 1 # # # # # # # # # # 
 2 # # # # # # # # # # 
 3 # # # # # # # # # # 
 4 # # # # # # # # # # 
 5 # # # # # # # # # # 
 6 # # # # # # # # # # 
 7 # # # # # # # # # # 
 8 # # # # # # # # # # 
 9 # # # # # # # # # # 
10 # # # # # # # # # # 

Enter a row and a column (1-10), for example: 3 7
> 1 1
   1 2 3 4 5 6 7 8 9 10
 1 H # # # # # # # # #
```
...
```

Miss!
1 guesses left
Enter a row and a column (1-10), for example: 3 7
> 10 10
   1 2 3 4 5 6 7 8 9 10
 1 H # # # # # # # # # 
 2 # M # # # # # # # # 
 3 # # # # # # # # # # 
 4 # # # # # # # # # # 
 5 # # # # M # # # # # 
 6 # # # # # # # # # # 
 7 # # # # # # # # # # 
 8 # # # # # # # # # # 
 9 # # # # # # # # M # 
10 # # # # # # # # # M 

Miss!
0 guesses left
Out of guesses! Here's where the ships were:
   1 2 3 4 5 6 7 8 9 10
 1 H # # # # # # # # # 
 2 A # # # # # # # # # 
 3 A # # # # # # # # # 
 4 A # # # # # # A A A 
 5 A # # # # # # # # # 
 6 # # # # # # # # # # 
 7 # A A A A # # # # # 
 8 A A A # # # # # # # 
 9 # # # # # # # # # # 
10 A A # # # # # # # #
```

With unlimited guesses, the end of a game:
```
   1 2 3 4 5 6 7 8 9 10
 1 M M M M M M H H H H 
 2 M M M M H H H M M M 
 3 M M M M M M M M M H 
 4 M M M M M M M M M H 
 5 M M M M M M M M M H 
 6 M M M M M M M M M H 
 7 M M M M M M M M M H 
 8 M M H H H M M M M M 
 9 M M M M H M M M M M 
10 M M M M H # # # # # 

Hit!
You sank all the ships in 95 guesses!
```

## Concepts used
- 2D arrays with number codes for each square (ship, hit, empty, miss)
- Random placement with bounds and overlap checking
- Method overloading (`play()` and `play(int)`)
- Loops with input validation using `Scanner`
- Splitting the game (`Battleship`) from the program that runs it (`BattleshipRunner`)

## What I'd add next
- Tell you when a specific ship is sunk
- Letter and number coordinates like `B7`
- A two player mode or a computer that shoots back at your own board
