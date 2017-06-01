import java.util.Scanner;

class APlusB {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int a = s.nextInt();
    int b = s.nextInt();
    if(a < 0 || a > 9 || b < 0 || b > 9)
    	System.out.println("Invalid Input");
    else
    	System.out.println(a + b);
  }
}