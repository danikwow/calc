import java.util.Scanner;
import java.util.InputMismatchException;
public class calculator {
      //Объявляем переменные для дальнейшего использования
      static Scanner scanner = new Scanner(System.in);
      static int numberOne, numberTwo;
      static char signs;
      static int result;
      //Создаем метод
      public static void main(String[] input)
      {
            //Просим пользователя ввести данные для вычесления.
            System.out.println("Введите уравнение формата (n+a). а и n могут быть в диапазоне от 1 до 10." +
                    "Возможно использование римских цифр от I до X. Для отправки нажмите Enter");
            //Считываем строку пользователя и помещяем её в переменную userInput
            String userInput = scanner.nextLine();
            //Создаем однострочный массив с символами длинной 8 строк
            char[] userChar = new char[10];
            //Заполняем массив символами из строки введенной пользователем, циклом ищём орифметический знак и помещаем его в переменную
            for (int i = 0; i < userInput.length(); i++){
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
            //Берём строку введённую пользователем и помещаем её в массив
            String userCharString = String.valueOf(userChar);
            //Берём строку введённую пользователем, разделяем её на две части до и после арифметического символа и помещаем в массив
            //убираем пробелы и присваиваем значение переменным
            String[] block = userCharString.split("[+-/*]");
            String line1 = block[0];
            String line2 = block[1];
            String line3 = line2.trim();
            numberOne = romanToNumber(line1);
            numberTwo = romanToNumber(line3);
            if (numberOne < 0 && numberTwo < 0){
                  result = 0;
      }
            else{
                  //Вызываем метод, внутри которого выбирается знак для уравнения и происходят его вычисление.
                  result = calculated(numberOne,numberTwo,signs);
                  System.out.println("Результат в римских цифрах:");
                  //Вызываем метод, конвертирующий арабские числа в римски и выводит ответ.
                  String resultRoman = convertNumToRoman(result);
                  System.out.println(line1 + " " + signs + " " + line3 + " = " + resultRoman);
            }
            numberOne = Integer.parseInt(line1);
            numberTwo = Integer.parseInt(line3);
            result = calculated(numberOne,numberTwo,signs);
            System.out.println("Результаты для арабских цифр:");
            System.out.println(numberOne + " " + signs + " " + numberTwo + " = " + result);

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
            final String s = roman[numArabian];
            return s;
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
            } catch (InputMismatchException e) {
                  throw new InputMismatchException("Неверный формат данных");
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
