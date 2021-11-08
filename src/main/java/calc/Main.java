package calc;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        Menu menu = new Menu();
        Calculator calc = new Calculator();
        int exit;
        double result = 0;

        do {
            System.out.println("Enter first number:");
            double firstNumber = menu.readDouble();
            System.out.println("Enter second number:");
            double secondNumber = menu.readDouble();

            System.out.print("Select an option from the menu that is displayed:");
            System.out.println("\n1-sum\n2-subtract\n3-division\n4-multiplication");
            int menuNumber = menu.readInt();

            switch (menuNumber) {
                case 1:
                    result = calc.add(firstNumber, secondNumber);
                    break;
                case 2:
                    result = calc.subtract(firstNumber, secondNumber);
                    break;
                case 3:
                    result = calc.division(firstNumber, secondNumber);
                    break;
                case 4:
                    result = calc.multiplication(firstNumber, secondNumber);
                    break;
                default:
                    System.out.println("Incorrect input :(");
                    break;
            }
                if(menuNumber>0 && menuNumber<=4){
                    System.out.println("Result: " + result);
                }

            System.out.println("Enter 0 to exit or 1 to continue:");
            exit = scanner.nextInt();
        }
        while (exit != 0);
    }
}