import java.util.Locale;
import java.util.Scanner;

public class task2 {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        int wordNumber = rnd(words);
        String wordText = words[wordNumber];
        int result = 2;

        System.out.println("Программа загадала фрукт на английском языке.");
        System.out.println("============================================");
        System.out.println("Угадайте этот фрукт. Кол-во попыток" + task1.ANSI_RED + " неограниченно" + task1.ANSI_RESET + ".");
        System.out.println("Фрукт: " + wordText);

        do {
            result = getTextFromScanner(wordText);
        }
        while (result != 1 && result != 0);
        scanner.close();
    }

    public static int getTextFromScanner(String wordText) {
        int result = 2;
        String trial;
        do {
            System.out.print("Введите название фрукта: ");
            trial = scanner.nextLine();
            if (trial.equals("0")) {
                System.out.println("Вы сдались. Фуу. Загаданное слово было " + wordText);
                result = 0;
                break;
            }
            if (equalsUpper(trial) == 1) break;
            if (compareString(wordText, trial) == 1) {
                result = 1;
                System.out.println("Вы угадали! Поздравляю!");
            } else compareChar(wordText, trial);
        } while (result != 1 && result != 0);
        return result;
    }


    //рандомайзер слова из списка
    public static int rnd(String[] mas) {
        int i = mas.length - 1;
        System.out.println(i);
        return (int) (Math.random() * ++i);
    }

    //сравнение загаданного слова и введённого целиком
    public static int compareString(String wordText, String trial) {
        int result = 2;
        if (wordText.equals(trial)) result = 1;
        return result;
    }


    //сравнение загаданного слова и введённого побуквам
    public static void compareChar(String wordText, String trial) {
        System.out.print("Ваши совпадения: ");
        for (int i = 0; i < wordText.length() && i < trial.length(); i++) {
            char a = wordText.charAt(i);
            char b = trial.charAt(i);
            if (a == b) System.out.print(a);
            else {
                System.out.print("*");
            }
        }
        for (int i = wordText.length(); i < 15; i++) System.out.print("*");
        System.out.println();
    }


    //проверка на наличие заглавных букв
    public static int equalsUpper(String trial) {
        int result = 2;
        for (int i = 0; i < trial.length(); i++) {
            String a = trial.substring(i, i + 1).toLowerCase();
            String b = trial.substring(i, i + 1);
            if (!a.equals(b)) {
                result = 1;
                System.out.println("Вы ввели заглавные буквы. Попробуйте ещё раз.");
                break;
            }
        }
        return result;
    }
}
