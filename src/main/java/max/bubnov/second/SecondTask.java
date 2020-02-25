package max.bubnov.second;

import java.util.Stack;

/**
 * 2. написать алгоритм проверки корректности регулярного выражения, которое включает [,],(,)
 * т.е., например ([][[]()]) - правильно,
 *                ([][]()]) – неправильно
 */

public class SecondTask {

    public static void main(String[] args) {
        checkString("([][[]()])"); // - no error
        System.out.println("______________________________");
        checkString("([][]()])"); // - error
    }


    public static void checkString(String input) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i); // получаем символ из строки
            switch (ch) { //если он равен скобкам открывания
                case '[':
                case '(':
                    stack.push(ch); // кладем в стек
                    break;
                case ']':
                case ')':
                    if(!stack.isEmpty()) {
                        char chr = stack.pop(); //берем поочередно верхний элемент стека и сравниваем на открытие
                        if (ch == ']' && chr != '[' || ch == ')' && chr != '(') {
                            System.out.println("Скобка: " + ch + " в позиции " + i + " закрыта, но не открыта.");
                        }
                    }
                    break;
                default:
                    break;
            }
        }
        if (!stack.isEmpty()) {
            System.out.println("Ошибка. Скобка открыта, но не закрыта");
        }
    }
}
