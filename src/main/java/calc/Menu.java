package calc;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Menu {
    final Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

    public double readDouble() {
        double input;
        try {
            input = scanner.nextDouble();
        } catch (InputMismatchException e) {
            scanner.next();
            return readDouble();
        }
        return input;
    }

    public int readInt() {
        int input;
        try {
            input = scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.next();
            return readInt();
        }
        return input;
    }
}