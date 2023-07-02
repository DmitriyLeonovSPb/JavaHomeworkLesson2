import java.util.InputMismatchException;
import java.util.Scanner;

public class JavaSeminar2Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            double divisible;
            double divider;
            while (true) {
                try {
                    System.out.print("Введете числитель: ");
                    divisible = scanner.nextDouble();
                    break;
                } catch (InputMismatchException ex) {
                    System.out.println("Ошибка: Введено не число.\n");
                    scanner.nextLine();
                }
            }
            while (true) {
                try {
                    System.out.print("Введите знаменатель: ");
                    divider = scanner.nextInt();
                    checkInput(divider);
                    break;
                } catch (DivisionByZeroException ex) {
                    System.out.println("Ошибка: " + ex.getMessage() + "\n");
                    scanner.nextLine();
                } catch (InputMismatchException ex){
                    System.out.println("Ошибка: Введено не число.\n");
                    scanner.nextLine();
                }
            }
            System.out.printf("Решение: %s / %s = %s", divisible, divider, String.format("%.2f", divisible / divider));
        } catch (Exception ex) {
            System.out.println("Ошибка.\n");
            scanner.nextLine();
        }
    }
    public static void checkInput(double value) throws DivisionByZeroException {
        if (value == 0) {
            throw new DivisionByZeroException("Дел. на ноль!!!");
        }
    }
}
class DivisionByZeroException extends Exception {
    public DivisionByZeroException(String message) {
        super(message);
    }
}