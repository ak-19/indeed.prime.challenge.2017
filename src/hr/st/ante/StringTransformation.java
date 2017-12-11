package hr.st.ante;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StringTransformation {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner inScan = new Scanner(new FileInputStream("files/StringTransformation.txt"));
        int numberOfScenarios = inScan.nextInt();
        for (int scenario = 0; scenario < numberOfScenarios; scenario++) {
            int N = inScan.nextInt();
            System.out.println(findString(inScan.next(), N));
        }
    }

    private static String findString(String input, int N) {
        char[] letters = new char[N];
        int[] occurrence = new int['z'];
        for (int i = 0; i < N; i++) {
            int c = input.charAt(i) - 'a';
            letters[i] =  (char)('a' + (c + occurrence[c]++) % 26);
        }
        return new String(letters);
    }
}
