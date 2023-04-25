import java.util.Scanner;

public class Calc {

    public static void main(String[] args) {

        System.out.println("Введите выражения");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(calc(input));
    }

    public static String calc(String input) {

        String[] romeNum ={"I","II","III","IV","V","VI","VII","IIX","IX","X"};
        String[] equation = input.split(" ");

        int leng2 = equation.length;
        int leng = input.length();
        int check = 0;
        int check1 = 0;

        try {
            if (leng < 5 || leng2 > 3 )
                throw new Exception("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < 10; i++) {
            if (equation[0].equals(romeNum[i])) {
                equation[0] = String.valueOf(i + 1);
                check1 = 1;
            }
        }

        for (int i = 0; i < 10; i++) {
            if(equation[2].equals(romeNum[i])) {
                equation[2] = String.valueOf(i+1);
                check = 1;
            }
        }

        int obj1 = Integer.parseInt(equation[0]);
        int obj2 = Integer.parseInt(equation[2]);

        try {
            if (obj1 < 1 || obj2 < 1)
                throw new Exception("Введено неверное значение!");
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }

        if (obj1 > 10 || obj2 > 10 || obj1 == 0 || obj2 == 0) try {
            throw new Exception("Введено неверное значение!");
        }
        catch (Exception e)  {
            throw new RuntimeException(e);
        }

        try{
            if (check1 != check)
                throw new Exception("Используются одновременно разные системы счисления");
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }

        switch (equation[1]) {
            case "+" -> {
                input = String.valueOf(obj1 + obj2);
            }
            case "-" -> {
                input = String.valueOf(obj1 - obj2);
            }
            case "/" -> {
                input = String.valueOf(obj1 / obj2);
            }
            case "*" -> {
                input = String.valueOf(obj1 * obj2);
            }
            default -> {  try {
                throw new Exception("Неверный оператор!");
            }
            catch (Exception e) {
                throw new RuntimeException(e);
            }

            }
        }

        if (check1 == 1){
            String s = "";
            int ret = Integer.parseInt(input);
            while (ret >= 100) {
                s += "C";
                ret -= 100;
            }
            while (ret >= 90) {
                s += "XC";
                ret -= 90;
            }
            while (ret >= 50) {
                s += "L";
                ret -= 50;
            }
            while (ret >= 40) {
                s += "XL";
                ret -= 40;
            }
            while (ret >= 10) {
                s += "X";
                ret -= 10;
            }
            while (ret >= 9) {
                s += "IX";
                ret -= 9;
            }
            while (ret >= 5) {
                s += "V";
                ret  -= 5;
            }
            while (ret >= 4) {
                s += "IV";
                ret -= 4;
            }
            while (ret >= 1) {
                s += "I";
                ret -= 1;
            }

            if (Integer.parseInt(input) <= 0) {
                throw new RuntimeException("Невозможная операция");
            }
            input = s;
        }

        return input;

    }
}