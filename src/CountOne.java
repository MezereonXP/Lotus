import java.util.Scanner;

/**
 * @program: Count
 * @description:
 * @author: mezereonxp Email: mezereonxp@gmail.com
 * @create: 2018/9/18
 **/
public class CountOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(NumberOf1Between1AndN_Solution(n));
    }

    public static long NumberOf1Between1AndN_Solution(int n) {
        long count = 0;
        long i = 1;
        long current = 0, after = 0, before = 0;

        while ((n / i) != 0) {
            before = n / (i * 10);
            current = (n / i) % 10;
            after = n - (n / i) * i;
            if (current > 1) {
                count = count + (before + 1) * i;
            } else if (current == 0) {
                count = count + before * i;
            } else if (current == 1) {
                count = count + before * i + after + 1;
            }
            i = i * 10;

        }
        return count;
    }
}
