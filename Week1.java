import java.util.Scanner;

public class Week1 {
  public static void main(String[] args) {
    ex1();
    ex2();
    ex3();
    ex4();
    ex5();
  }
  
  static void ex1() {
    System.out.println("************");
    System.out.println("* Tri Dang *");
    System.out.println("************");
  }
  
  static void ex2() {
    int x = 10, y = 20;
    System.out.println("x and y before swapping: " + x + ", " + y);
    int tmp;
    // swawpping logic here
    tmp = x;
    x = y;
    y = tmp;
    System.out.println("x and y after swapping: " + x + ", " + y);
  }
  
  static void ex3() {
    int s;
    Scanner sc = new Scanner(System.in);
    System.out.print("Input the number of seconds from mid-night: ");
    s = sc.nextInt();
    int h = s / 3600;  // there are 3600 seconds in 1 hour
    s = s % 3600;  // remaining seconds after extracting all whole hours
    int m = s / 60;  // there are 60 seconds in 1 minute
    s = s % 60;  // remaining seconds after extracting all whole minutes    
    System.out.println("Current time: " + h + ':' + m + ':' + s);
  }
  
  // utility function for exercise 4 and 5
  // get the distance between 2 points whose coordinate values
  // are specified by the parameters
  // using the Pythagorean formula
  static double length(double x1, double y1, double x2, double y2) {
    return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
  }
  
  static void ex4() {
    double xA, yA, xB, yB;
    Scanner sc = new Scanner(System.in);
    System.out.print("xA: ");
    xA = sc.nextDouble();
    System.out.print("yA: ");
    yA = sc.nextDouble();
    System.out.print("xB: ");
    xB = sc.nextDouble();
    System.out.print("yA: ");
    yB = sc.nextDouble();
    double l = length(xA, yA, xB, yB);
    System.out.println("Length of AB: " + l);
    System.out.println("Circumference: " + (l * 4));
    System.out.println("Area: " + (l * l));
  }
  
  static void ex5() {
    double xA, yA, rA, xB, yB, rB;
    Scanner sc = new Scanner(System.in);
    System.out.print("xA: ");
    xA = sc.nextDouble();
    System.out.print("yA: ");
    yA = sc.nextDouble();
    System.out.print("Radius of circle A: ");
    rA = sc.nextDouble();
    System.out.print("xB: ");
    xB = sc.nextDouble();
    System.out.print("yA: ");
    yB = sc.nextDouble();
    System.out.print("Radius of circle B: ");
    rB = sc.nextDouble();
    double l = length(xA, yA, xB, yB);
    if (rA + rB >= l && Math.abs(rA - rB) <= l) {
      System.out.println("Intersected");
    } else {
      System.out.println("Not intersected");
    }
  }
}
