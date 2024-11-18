import java.time.DateTimeException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите имя, фвамилию, отчество, дату рождения. Например: Иванов Иван Иванович 01.01.2001");
        try (Scanner in = new Scanner(System.in)) {
            String s = in.nextLine().trim();
            System.out.println(InitialsAndSexChecker.getOutputString(s));
        } catch (IllegalArgumentException | DateTimeException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Необработанныя ошибка");
        }
    }
}