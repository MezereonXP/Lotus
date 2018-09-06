import org.omg.CORBA.INTERNAL;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @program: Segment
 * @description:
 * @author: mezereonxp Email: mezereonxp@gmail.com
 * @create: 2018/9/6
 **/
public class Segment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int t = scanner.nextInt();

        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + t; j < n; j++) {
                if (j - i + 1 == k) {
                    if (count(numbers, i, j, t)) {
                        sum++;
                    }
                } else {
                    continue;
                }
            }
        }
        System.out.println(sum);
    }

    private static boolean count(int[] numbers, int i, int j, int t) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int k = i; k <= j; k++) {
            if (map.containsKey(numbers[k])) {
                map.put(numbers[k], map.get(numbers[k]) + 1);
            } else {
                map.put(numbers[k], 1);
            }
        }

        for (int k = i; k <= j; k++) {
            if (map.get(numbers[k]) >= t) {
                return true;
            }
        }
        return false;
    }
}
