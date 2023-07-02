import java.util.Scanner;
public class JavaSeminar2Task1 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int value;
            while (true) {
                try {
                    System.out.print("Введите положительное целое число: ");
                    value = scanner.nextInt();
                    checkInput(value);
                    break;
                } catch (InvalidNumberException ex) {
                    System.out.println("Error: " + ex.getMessage() + "\n");
                    scanner.nextLine();
                }
            }
        }
    }    
    public static void checkInput(int value) throws InvalidNumberException {
        if (value <= 0) {
            throw new InvalidNumberException("некорректное число.");
        }
        System.out.println("Число " + value + " - корректно.");
    }
}
class InvalidNumberException extends Exception {
    public InvalidNumberException(String message) {
        super(message);
    }
}