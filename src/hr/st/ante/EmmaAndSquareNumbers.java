package hr.st.ante;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class EmmaAndSquareNumbers {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new FileInputStream("files/EmmaAndSquareNumbers.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] res;
        int arr_size = 0;
        arr_size = Integer.parseInt(in.nextLine().trim());

        String[] arr = new String[arr_size];
        for (int i = 0; i < arr_size; i++) {
            String arr_item;
            try {
                arr_item = in.nextLine();
            } catch (Exception e) {
                arr_item = null;
            }
            arr[i] = arr_item;
        }
        res = getMinimumUniqueSum(arr);
        for (int res_i = 0; res_i < res.length; res_i++) {
            bw.write(String.valueOf(res[res_i]));
            bw.newLine();
        }

        bw.close();
    }

    private static int[] getMinimumUniqueSum(String[] arr) {
        int N = arr.length;
        int results[] = new int[arr.length];

        for (int i = 0; i < N; i++) {
            String[] boundries = arr[i].split(" ");
            int a = Integer.parseInt(boundries[0]);
            int b = Integer.parseInt(boundries[1]);

            for (int root = (int) Math.sqrt(a); root <= (int) Math.sqrt(b); root++) {
                int sq = root * root;
                if (sq <= b && sq >= a) {
                    results[i]++;
                }
            }
        }
        return results;
    }
}
