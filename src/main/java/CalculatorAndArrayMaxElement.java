/**
 * Class CalculatorAndArrayMaxElement allows a user to choose what to do
 *  to execute operations addition, subtraction, multiplication or division with two numbers
 *  or
 *  to find the longest word in array of words
 * @author Malakhova Olga
 * @version 1.0
 */

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorAndArrayMaxElement {
    public static void main (String args[]) {

        System.out.println("Enter '1' for Calculator program or '2' for ArrayMaxElement program");
        Scanner scanner = new Scanner(System.in);
        int option = Integer.parseInt(scanner.next());
        switch (option) {
            case 1:
                calculator();
                break;
            case 2:
                arrayMaxElement();
                break;
        }
    }

    /**
     *
     * @param input string to parse
     * @return array of operation members (numbers and the sign)
     */
    public static String[] analyseInputString (String input) {
        String [] members = new String [3];
        int i = 0;

        Pattern pattern = Pattern.compile("\\-?\\d+(\\.\\d{0,})?");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            members[i] = input.substring(start,end);
//            System.out.println(members[i]);
            i++;
        }

        pattern = Pattern.compile("[/*+-]");
        matcher = pattern.matcher(input);

        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            members[2] = input.substring(start,end);
//            System.out.println(members[i]);
        }
        return members;
    }

    /**
     *
     * @param a the first operation member
     * @param b the second operation member
     * @param sign operation sign (+, -, *, or /)
     * @return result of the operation
     */
    public static float executeOperation (float a, float b, char sign) {
        float c = 0;

        switch (sign) {
            case '+':
                c = a + b;
                break;
            case '-':
                c = a + b;
                break;
            case '*':
                c = a * b;
                break;
            case '/':
                c = a / b;
                break;
        }
        return c;
    }

    public static void calculator() {
        System.out.println("Enter two numbers to execute operation addition, subtraction, multiplication or division");
        System.out.println("Examples: 5.0+5.0, 3.2-2.3, 4.4*0, 7.4/2.8");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        String [] members = analyseInputString (input);
        float a = Float.parseFloat(members[0]);
        float b = Float.parseFloat(members[1]);
        char sign = members[2].charAt(0);
        float c = executeOperation(a,b,sign);
        System.out.printf(input + " = %.4f", c);
    }

    public static void arrayMaxElement() {
        System.out.println("Enter the number of words");
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.next());
        String [] words = new String [n];
        int i = 0;
        System.out.println("Enter " + n + " words:");
        while (i < n) {
            words[i] = scanner.next();
            i++;
        }
        int length_max = words[0].length();
        int length_index = 0;
        for (i = 0; i < n; i++) {
            if (words[i].length() > length_max) {
                length_max = words[i].length();
                length_index = i;
            }
        }
        System.out.println("The longest word is: " + words[length_index]);
    }
}
