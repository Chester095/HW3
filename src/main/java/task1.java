import java.util.Scanner;

public class task1 {
    public static Scanner scanner = new Scanner(System.in);
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static boolean isNumber = false;

    public static void main(String[] args) {
        final int min = 0;
        final int max = 9;
        int count = 3;
        final int rnd = rnd(min, max);
        System.out.println("Программа загадала случайное число от 0 до 9.");
        System.out.println("=============================================");
        System.out.println("      Угадайте это число за" + ANSI_RED + " 3 " + ANSI_RESET + "попытки.       ");
        do {
            count--;
            int d = getNumberFromScanner(min, max);
            if (d == rnd) {
                System.out.println("Вы угадали!!!");
                count = 0;
            } else if (count != 0)
                System.out.println("Вы неугадали! Осталось " + ANSI_RED + count + ANSI_RESET + " попыток!");
            else System.out.println(ANSI_RED + "Вы проиграли! Правильное число = "+rnd + ANSI_RESET);
        }
        while (count > 0);

    }

    public static int getNumberFromScanner(int min, int max) {
        int number = 0;
        do {
            isNumber = scanner.hasNextInt();
            if (isNumber) {
                number = scanner.nextInt();
                if (number < min || number > max) {
                    System.out.println("Вы ввели число выходящее за пределы.\nПожалуйста, повторите попытку ввода.");
                    scanner.nextLine();
                }

            } else {
                System.out.println("Вы ввели не число.\nПожалуйста, повторите попытку ввода.");
                scanner.nextLine();
            }
        } while (number < min || number > max);
        return number;
    }

    public static int rnd(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

}
