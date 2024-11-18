import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;

public class AgeCalculator {
    public static int getCalculatedAge(String age) {
        String[] dateOfBirth = age.split("[\\./,]");
        if (dateOfBirth.length != 3) {
            throw new IllegalArgumentException("Требуемый формат даты рождения: DD.MM.YYYY");
        }
        int day = Integer.parseInt(dateOfBirth[0]);
        int month = Integer.parseInt(dateOfBirth[1]);
        int year = Integer.parseInt(dateOfBirth[2]);
        LocalDate birthDate = LocalDate.of(year, month, day);
        return AgeCalculator.calculateAge(birthDate, LocalDate.now());
    }
    private static int calculateAge(LocalDate birthDate, LocalDate currentDate) throws DateTimeException {
        int age = Period.between(birthDate, currentDate).getYears();
        if (birthDate.isAfter(currentDate)) {
            throw new DateTimeException("Дата рождения не может быть позднее нынешней даты");
        } else if (age < 0 || age > 200) {
            throw new DateTimeException("Возраст вне границ допустимых значений");
        } else {
            return age;
        }
    }
}
