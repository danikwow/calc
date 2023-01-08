import java.util.Scanner;
import java.util.InputMismatchException;
public class Calc{
    //Объявляем переменные для дальнейшего использования
    static Scanner scanner = new Scanner(System.in);
    static String userInput;
    static int numberOne, numberTwo;
    static String numberOneRoman, numberTwoRoman;
    static String line3, line4;
    static boolean romanOrArabian,romanOrArabian2;
    static char signs;
    static int result;
    static String[] block;

    //Создаем метод
    public static void main(String[] inputArgs) throws InputMismatchException{
        //Просим пользователя ввести данные для вычесления.
        System.out.println("Введите уравнение формата (n+a). а и n могут быть в диапазоне от 1 до 10." +
                "Возможно использование римских цифр от I до X. Для отправки нажмите Enter");
        //Считываем строку пользователя и помещяем её в переменную userInput
        userInput = scanner.nextLine();

        //Создаем однострочный массив с символами длинной 8 строк
        char[] userChar = new char[10];
        //Заполняем массив символами из строки введенной пользователем, циклом ищём орифметический знак и помещаем его в переменную
        for (int i = 0; i < userInput.length(); i++) {
            userChar[i] = userInput.charAt(i);
            if (userChar[i] == '+') {
                signs = '+';
            }
            if (userChar[i] == '-') {
                signs = '-';
            }
            if (userChar[i] == '*') {
                signs = '*';
            }
            if (userChar[i] == '/') {
                signs = '/';
            }
        }

        String userCharString = String.valueOf(userChar);
        block = userCharString.split("[+-/*]");
        if (block.length > 2 )throw new InputMismatchException();
        String line1 = block[0];
        String line2 = block[1];
        line3 = line1.trim();
        line4 = line2.trim();
        romanOrArabian = Boolean.parseBoolean(romOrArab(line3));
        romanOrArabian2 = Boolean.parseBoolean(romOrArab(line4));
        if  ( romanOrArabian != romanOrArabian2) throw new InputMismatchException();
        if (romanOrArabian == true && romanOrArabian2 == true) {
            numberOneRoman = examRoman(line3);
            numberTwoRoman = examRoman(line4);
            numberOne = romanToNumber(line3);
            numberTwo = romanToNumber(line4);
            //Вызываем метод, внутри которого выбирается знак для уравнения и происходят его вычисление.
            result = calculated(numberOne, numberTwo, signs);
            //Вызываем метод, конвертирующий арабские числа в римски и выводит ответ.
            String resultRoman = convertNumToRoman(result);
            String resultRoman2 = line3 + " " + signs + " " + line4 + " = " + resultRoman;
            System.out.println("Результат в римских цифрах:");
            System.out.println(resultRoman2);
        }
        if (romanOrArabian == false && romanOrArabian2 == false){
            numberOne = exam(Integer.parseInt(line3));
            numberTwo = exam(Integer.parseInt(line4));
            result = calculated(numberOne, numberTwo, signs);
            System.out.println("Результаты для арабских цифр:");
            String result2 = numberOne + " " + signs + " " + numberTwo + " = " + result;
            System.out.println(result2);
        }
    }
     private static int exam(int num1) throws InputMismatchException{
        int num = num1;
        if (num <= 1 && num >= 10){
            throw new InputMismatchException();
        }
        else{
            return num;
        }
    }
    private static String examRoman(String num1) throws InputMismatchException{
        int num = romanToNumber(num1);
        if (num <= 1 && num >= 10){
            throw new InputMismatchException();
        }
        return num1;
    }
    //Массив даныхх с необходимыми римскими числами.
    private static String convertNumToRoman (int numArabian) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        return roman[numArabian];
    }
        private static String romOrArab(String l3){
        String Roman[] = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
            for (int i = 0; i < 10; i++){
                if (l3.equals(Roman[0])){
                    return l3 = String.valueOf(true);
                }
                if (l3.equals(Roman[1])){
                    return l3 = String.valueOf(true);
                }
                if (l3.equals(Roman[2])){
                    return l3 = String.valueOf(true);
                }
                if (l3.equals(Roman[3])){
                    return l3 = String.valueOf(true);
                }
                if (l3.equals(Roman[4])){
                    return l3 = String.valueOf(true);
                }
                if (l3.equals(Roman[5])){
                    return l3 = String.valueOf(true);
                }
                if (l3.equals(Roman[6])){
                    return l3 = String.valueOf(true);
                }
                if (l3.equals(Roman[7])){
                    return l3 = String.valueOf(true);
                }
                if (l3.equals(Roman[8])){
                    return l3 = String.valueOf(true);
                }
                if (l3.equals(Roman[9])){
                    return l3 = String.valueOf(true);
                }
                else
                    return l3 = String.valueOf(false);
            }
            return l3;
        }


    //Метод конвертирующий значение арабских цифр в римские, для дальнейших подсчетов
    private static int romanToNumber (String roman) {
        try {
            if (roman.equals("I")) {
                return 1;
            } else if (roman.equals("II")) {
                return
                        2;
            } else if (roman.equals("III")) {
                return 3;
            } else if (roman.equals("IV")) {
                return 4;
            } else if (roman.equals("V")) {
                return 5;
            } else if (roman.equals("VI")) {
                return 6;
            } else if (roman.equals("VII")) {
                return 7;
            } else if (roman.equals("VIII")) {
                return 8;
            } else if (roman.equals("IX")) {
                return 9;
            } else if (roman.equals("X")) {
                return 10;
            }
        } finally {

        }
        return -1;
    }
    //Метод определяющий знак уравнения ивыполняющий вычисления.
    private static int calculated (int num1, int num2, char op) {
        int result = 0;
        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                try {
                    result = num1 / num2;
                } catch (ArithmeticException | InputMismatchException e) {
                    System.out.println("Исключение: " + e);
                    System.out.println("Допускается использование целых чисел, больше 0.");

                    break;
                }
                break;
            default:
                throw new IllegalArgumentException("Не верный знак операции");
        }
        return result;
    }
}
