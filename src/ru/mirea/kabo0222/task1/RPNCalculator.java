package ru.mirea.kabo0222.task1;
import java.util.Scanner;
import java.util.Stack;

public class RPNCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение в обратной польской записи:");
        String expression = scanner.nextLine();

        double result = calculate(expression);
        System.out.println("Результат: " + result);
    }

    public static double calculate(String expression) {
        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (Character.isDigit(c)) {
                stack.push((double) Character.getNumericValue(c));
            } else if (isOperator(c)) {
                double operand2 = stack.pop();
                double operand1 = stack.pop();
                double result = performOperation(c, operand1, operand2);
                stack.push(result);
            }
        }

        return stack.pop();
    }

    public static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    public static double performOperation(char operator, double operand1, double operand2) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Недопустимая операция: " + operator);
        }
    }
}
