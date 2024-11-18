public class InitialsAndSexChecker {
    public static String getOutputString(String s) throws IllegalArgumentException {
        String[] parts = s.split(" ");
        if (parts.length != 4) {
            throw new IllegalArgumentException("Не хватает аргументов");
        }
        String sex = determineSex(parts[2]);
        int age = AgeCalculator.getCalculatedAge(parts[3]);
        return "ФИО: " + parts[0] + " " +
                parts[1].toUpperCase().charAt(0) + "." +
                parts[2].toUpperCase().charAt(0) + ". " +
                "\nПол: " + sex +
                "\nВозраст: " + formatAge(age);
    }
    private static String determineSex(String patronymic) {
        if (patronymic.toLowerCase().endsWith("ч")) {
            return "М";
        }
        else if (patronymic.toLowerCase().endsWith("а")) {
            return "Ж";
        }
        else {
            return "Определить не удалось";
        }
    }
    private static String formatAge(int age) {
        String suffix;
        if (age % 10 == 1) {
            suffix = " год";
        } else if (age % 10 == 2 || age % 10 == 3 || age % 10 == 4) {
            suffix = " года";
        } else {
            suffix = " лет";
        }
        return age + suffix;
    }
}
