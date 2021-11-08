package calc;

/**
 * В отдельном проекте создать класс calc.Calculator.java, содержащий 4 метода: сумма, разность, деление, умножение
 */
public class Calculator {

    public double add(double firstNumber, double secondNumber) {
        return firstNumber + secondNumber;
    }

    public double subtract(double firstNumber, double secondNumber) {
        return firstNumber - secondNumber;
    }

    public double division(double firstNumber, double secondNumber) {
        if (secondNumber == 0) {
            System.out.println("It is impossible to divide by zero");
            return -1;
        }
        return firstNumber / secondNumber;
    }

    public double multiplication(double firstNumber, double secondNumber) {
        return firstNumber * secondNumber;
    }
}