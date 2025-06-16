//  디지털 티비

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        int a = 0, b = 0;
        for (int i = 0; i < n; i++) {
            String input = sc.next();
            if (input.equals("KBS1")) {
                a = i;
            } else if (input.equals("KBS2")) {
                b = i;
            }
            arr[i] = input;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < a; i++) {
            result.append(1);
        }
        for (int i = 0; i < a; i++) {
            result.append(4);
        }
        if (a > b) {
            b += 1;
        }
        for (int i = 0; i < b; i++) {
            result.append(1);
        }
        for (int i = 0; i < b - 1; i++) {
            result.append(4);
        }
        System.out.println(result);
    }
}