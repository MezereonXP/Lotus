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
        int count = 0;
        for (int i = 1; i <= n; i++) {
            String s = i + "";
            char[] chars = s.toCharArray();
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == '1') {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
