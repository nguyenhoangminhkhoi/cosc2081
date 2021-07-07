public class Week2 {
  public static void main(String[] args) {
    exercise1(5);
    exercise2(4);
    exercise3(20);
    exercise4(10, 9);
    exercise5(1000);
    exercise5(1000000);
    exercise6("ABCXYZ", 2);
    exercise6("ABCXYZ", -1);
  }

  // build a string consists of n <c> characters
  public static String buildLine(char c, int n) {
    // StringBuffer is mutable compared to String
    // As such, Java does not need to create many String objects
    StringBuffer sb = new StringBuffer();
    while (n > 0) {
      sb.append(c);
      n--;
    }
    return sb.toString();
  }

  public static void exercise1(int n) {
    System.out.printf("\nExercise 1 - Draw a solid square of length %d \n", n);
    String line = buildLine('*', n);
    while (n > 0) {
      System.out.println(line);
      n--;
    }
  }

  public static void exercise2(int n) {
    System.out.printf("\nExercise 2 - Draw an empty square of length %d \n", n);
    // the first and last lines consist of all *
    String horLine = buildLine('*', n);
    // the other lines consist of 2 * at the left-most and right-most
    String otherLine = '*' + buildLine(' ', n - 2) + '*';
    for (int i = 0; i < n; i++) {
      if (i == 0 || i == n - 1) {
        System.out.println(horLine);
        // I use continue to skip the remaining code
        // So I don't need to use else
        continue;
      }
      System.out.println(otherLine);
    }
  }

  // Return if 2 values are close enough
  public static boolean closeEnough(double d1, double d2) {
    // Specify what you think is close enough
    // It depends on your own problem
    double epsilon = 0.000001;

    return (Math.abs(d1 - d2) <= epsilon);
  }

  public static void exercise3(double d) {
    System.out.printf("\nExercise 3 - Calculate the square root of %f \n", d);
    double min = 0, max = d;
    double avg = (min + max) / 2;
    while (!closeEnough(avg * avg, d)) {
      if (avg * avg > d) {
        // too big
        max = avg;
      } else {
        // too small
        min = avg;
      }
      avg = (min + max) / 2;
    }
    System.out.printf("The square root of %f is %f \n", d, avg);
  }

  // This is a generalization of exercise 4
  // There are n people (including you) instead of 3
  public static void exercise4(double S, int n) {
    System.out.printf("\nExercise 4 - Calculate contributions of %d people for %.2f dollar \n", n, S);
    int money = (int)(S * 100);
    int least = money / n;
    int remainder = money % n;
    if (remainder == 0) {
      System.out.printf("Each person pays %.2f \n", least / 100.0);
    } else {
      // remainder = X means X people have to pay 0.01 more than the others
      // You are in the second group, because you are the organizer :)
      System.out.printf("%d person pay %.2f each \n", remainder, (least + 1) / 100.0);
      if (n - remainder - 1 > 0) {
        // there is at least one person pays the same as you
        System.out.printf("You and %d other pay %.2f each \n", n - remainder - 1, least / 100.0);
      } else {
        System.out.printf("You pay %.2f \n", least / 100.0);
      }
    }
  }

  public static void exercise5(int points) {
    System.out.printf("\nExercise 5 - Calculate PI using %d random points \n", points);
    int insideCount = 0;
    for (int i = 0; i < points; i++) {
      double x = Math.random() * 2 - 1;
      double y = Math.random() * 2 - 1;
      // if the point(x, y) is in the circle of radius 1
      // and its center is positioned at (0, 0)
      // we don't need to get the square root of (x * x + y * y)
      // because we just want to compare it with 1
      // if (x * x + y * y) > 1, then the same applies for its square root
      // and vice versa
      if (x * x + y * y <= 1) {
        insideCount++;
      }
    }
    System.out.printf("The approximate value of PI is %f", insideCount * 4.0 / points);
  }

  // shift a character c key positions
  // if key > 0, shift to the right
  // otherwise, shift to the left
  // but because we use remainder, the sign of key does not matter
  public static char shift(char c, int key) {
    int numOfChar = 26; // number of characters in the alphabet, for English it is 26
    // 1, 27, 53, etc. have the same shift
    key %= numOfChar;
    // transform key to a positive value
    if (key < 0) {
      key += numOfChar;
    }
    // shift and restart if necessary
    char newC = (char)('A' + ((c - 'A' + key) % numOfChar));
    return newC;
  }

  public static void exercise6(String msg, int key) {
    System.out.printf("\nExercise 6 - Encrypt and Decrypt with Shift cipher \n");
    System.out.printf("\nMessage %s and key %d \n", msg, key);
    // Encrypt
    StringBuffer cipherText = new StringBuffer();
    int index = 0;
    while (index < msg.length()) {
      char original = msg.charAt(index);
      char encrypted = shift(original, key);
      cipherText.append(encrypted);
      index++;
    }
    String encryptionResult = cipherText.toString();
    System.out.printf("\nCipher text is %s \n", encryptionResult);

    // Decrypt
    StringBuffer decipherText = new StringBuffer();
    index = 0;
    while (index < encryptionResult.length()) {
      char cipher = encryptionResult.charAt(index);
      char decipher = shift(cipher, -key);
      decipherText.append(decipher);
      index++;
    }
    String decryptionResult = decipherText.toString();
    System.out.printf("\nDecipher text is %s \n", decryptionResult);
  }
}
