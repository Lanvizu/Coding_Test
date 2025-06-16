//  삼각형과 세 변

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static String one = "Equilateral";
    static String two = "Isosceles";
    static String three = "Scalene";
    static String four = "Invalid";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int[] inputs = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .sorted()
                    .toArray();
            if (inputs[0] == 0 && inputs[1] == 0 && inputs[2] == 0) {
                break;
            }
            if (inputs[0] == inputs[1] && inputs[1] == inputs[2]) {
                System.out.println(one);
            } else if (inputs[2] == inputs[1] || (inputs[0] == inputs[1] && inputs[1] + inputs[0] > inputs[2])) {
                System.out.println(two);
            } else {
                if (inputs[2] < inputs[0] + inputs[1]) {
                    System.out.println(three);
                } else {
                    System.out.println(four);
                }
            }
        }
    }
}