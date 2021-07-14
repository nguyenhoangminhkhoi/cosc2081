import java.util.Scanner;

public class Week3 {
  public static void main(String[] args) {
//    int[] numbers = genNumbers();
//    printArray(numbers);
//    sortBySelection(numbers);
//    printArray(numbers);
//    System.out.println(getIndexMin(new int[]{17, 29, 25, 18, 9, 10}));
//    System.out.println(getIndexMinFrom(new int[]{17, 29, 25, 18, 9, 10, 33}, 5));
//    playTicTacToe();
//    System.out.printgln(isPossible("Tri", "Tri"));
//    System.out.println(isPossible("The tree is here", "Tri"));
//    System.out.println(isPossible("Tree Tree Tree", "Tri"));
  }

  // utility function
  public static void printArray(int[] numbers) {
    for (int n : numbers) {
      System.out.printf(" %d ", n);
    }
    System.out.println();
  }

  // exercise 1
  public static int[] genNumbers() {
    Scanner sc = new Scanner(System.in);
    int[] numbers;
    int N;
    System.out.print("Enter N: ");
    N = sc.nextInt();
    numbers = new int[N];
    for (int i = 0; i < N; i++) {
      // numbers[i] = (int)Math.round(Math.random() * N);
      numbers[i] = (int)(Math.random() * (N + 1));

      // remember: both expressions generate [0-N] range
      // they just distribute values differently
    }
    return numbers;
  }

  // exercise 2
  public static int getIndexMin(int[] numbers) {
    int idx;
    idx = 0;
    for (int i = 0; i < numbers.length; i++) {
      if (numbers[i] < numbers[idx]) {
        idx = i;
      }
    }
    return idx;
  }

  // exercise 3
  public static int getIndexMinFrom(int[] numbers, int from) {
    int idx;
    idx = from;
    for (int i = from; i < numbers.length; i++) {
      if (numbers[i] < numbers[idx]) {
        idx = i;
      }
    }
    return idx;
  }

  // exercise 4
  public static int[] exchangeMinFrom(int[] numbers, int from) {
    int minIdx = getIndexMinFrom(numbers, from);
    int tmp = numbers[minIdx];
    numbers[minIdx] = numbers[from];
    numbers[from] = tmp;
    return numbers;
  }

  // exercise 5
  public static int[] sortBySelection(int[] numbers) {
    int n = numbers.length;
    // exchange min for (n - 1) times
    int times = 0;
    while (times < n - 1) {
      numbers = exchangeMinFrom(numbers, times);
      times++;
    }
    return numbers;
  }

  // exercise 6
  public static void displayGame(char[][] board) {
    for (char[] row : board) {
      for (char cell : row) {
        System.out.print(cell);
      }
      System.out.println();
    }
  }

  public static char endGame(char[][] board) {
    int BOARD_SIZE = 3;
    // players
    char[] players = {'X', 'O'};
    for (char player : players) {
      // if current player wins?
      // there is a row containing all values of the user
      for (int row = 0; row < BOARD_SIZE; row++) {
        if (board[row][0] == player &&
            board[row][1] == player &&
            board[row][2] == player) {
          return player;
        }
      }

      // there is a col containing all values of the user
      for (int col = 0; col < BOARD_SIZE; col++) {
        if (board[0][col] == player &&
            board[1][col] == player &&
            board[2][col] == player) {
          return player;
        }
      }

      // there is a diagonal containing all values of the user
      if (board[0][0] == player &&
          board[1][1] == player &&
          board[2][2] == player) {
        return player;
      }

      if (board[0][2] == player &&
          board[1][1] == player &&
          board[2][0] == player) {
        return player;
      }
    }
    // if there is at least 1 empty cell, the game can continue
    for (int row = 0; row < BOARD_SIZE; row++) {
      for (int col = 0; col < BOARD_SIZE; col++) {
        if (board[row][col] == '.') {
          return '.';
        }
      }
    }
    return ' ';
  }

  // exercise 7
  public static void playTicTacToe() {
    char[] players = {'X', 'O'};
    int currentPlayer = 0;
    char[][] gameBoard = {
        {'.', '.', '.'},
        {'.', '.', '.'},
        {'.', '.', '.'}
    };
    Scanner sc = new Scanner(System.in);

    char finish = endGame(gameBoard);
    while (finish == '.') {
      // still not end game yet, so display current state
      System.out.println("Current game board");
      displayGame(gameBoard);
      // advance to next player and display that info
      currentPlayer = (currentPlayer + 1) % players.length;
      System.out.println("Current player: " + players[currentPlayer]);
      // accept new piece from the current player
      System.out.print("Choose row (0 - 3): ");
      int row = sc.nextInt();
      System.out.print("Choose col (0 - 3): ");
      int col = sc.nextInt();
      gameBoard[row][col] = players[currentPlayer];
      // check game state again
      finish = endGame(gameBoard);
    }
    // Display end game state
    if (finish == ' ') {
      System.out.println("It's a tie");
    } else {
      System.out.println(players[currentPlayer] + " wins!");
    }
  }

  // exercise 8
  public static boolean isPossible(String msg, String yourName) {
    // recursive method demonstration
    // if yourName is empty => always possible
    if (yourName.equals("")) {
      return true;
    }
    // yourName is not emtpy (otherwise it returned already)
    // but msg is empty => no further action can be done
    if (msg.equals("")) {
      return false;
    }
    // if the first letter of msg == first letter of your name
    // advance to next postion of both string objects
    // otherwise, advance to next position of msg
    // in both cases, the parameters are shorter than original values
    if (msg.charAt(0) == yourName.charAt(0)) {
      return isPossible(msg.substring(1), yourName.substring(1));
    }
    return isPossible(msg.substring(1), yourName);
  }
}
