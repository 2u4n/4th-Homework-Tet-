import java.util.Scanner;
public class ScannerExample {
    public static void main(String[] args) {
        Scanner keyboardScanner = new Scanner(System.in);
//        System.out.print("Enter a number? ");
//        int number = keyboardScanner.nextInt();
//        System.out.println(String.format("You just entered %s ", number));
        //fori (you can use this shortcut)
        //for(int i = 0; i < 4; i++)
//        while (true) //used for game developing (called Game Loop)
//        {
//            System.out.println("Enter a number for a? ");
//            int a = keyboardScanner.nextInt();
//
//            System.out.println("Enter a number for b? ");
//            int b = keyboardScanner.nextInt();
//
//            System.out.println("Enter an operation? ");
//            String sign = keyboardScanner.next();
//            // int, float, double, byte ==
//            // String, Map
//            if (sign.equals("+")) {
//                System.out.println("Result = " + (a + b));
//            } else if (sign.equals("-")) {
//                System.out.println("Result = " + (a - b));
//            } else if (sign.equals("*")) {
//                System.out.println("Result = " + (a * b));
//            } else if (sign.equals("/")) {
//                System.out.println("Result = " + (a / b));
//            } else {
//                System.out.println("You've entered a wrong operation");
//
//        System.out.println("Enter a number n? ");
//        int n = keyboardScanner.nextInt();
//        for (int i = 0; i < n; i++)
//        {
//            System.out.print("*");
//        }
//        System.out.println("\n" + "Enter another number n? ");
//        int m = keyboardScanner.nextInt();
//        for (int i = 0; i < n; i++)
//        {
//            System.out.print("*x");
//        }
//        System.out.println("\n" + "Enter ANOTHER number n? ");
//        int o = keyboardScanner.nextInt();
//        for (int i = 0; i < 2; i++)
//        {
//            for (int j = 0; j < o; j++)
//            {
//                System.out.print("*");
//            }
//            System.out.print("\n");
//        }

        int p = 6;
        int q = 8;
        int x = 3;
        int y = 2;
        for (int i = 0; i < q; i++)
        {
            for (int j = 0; j < p; j++)
            {
                if (i == x && j == y)
                {
                    System.out.print("P ");
                }
                System.out.print("- ");
            }
            System.out.print("\n");
            //Hỏi xem người dùng muốn đi đâu. Hỏi theo "W", "A", "S", "D"
        }
    }
}