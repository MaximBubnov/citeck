package max.bubnov.third;

import java.util.Scanner;

/**
 * 3. написать алгоритм, как в целом числе самый правый ноль превратить в единицу не используя
 * циклы и рекурсию.
 */
public class ThirdTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        scanner.close();

        System.out.println("Your number " + number + " in binary " + Integer.toString(number, 2));

        int another = getNumber(number);



        System.out.println("Now your number is " + another + " in binary " + Integer.toString(another, 2));
    }

    private static int getNumber(int number) {
        if((number & 1) != 1) {
            number ^= 1;
        }
        return number;
    }

}
