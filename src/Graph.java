import java.util.Scanner;
import java.util.Stack;

/**
 * @program: Graph
 * @description:
 * @author: mezereonxp Email: mezereonxp@gmail.com
 * @create: 2018/9/6
 **/
public class Graph {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] map = new int[n][n];
        int[] flag = new int[n];
        flag[0] = 1;

        for (int i = 1; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            map[x - 1][y - 1] = 1;
            map[y - 1][x - 1] = 1;
        }

        int sum = 0;
        Stack<Integer> stack = new Stack();
        stack.push(0);
        while (check(flag)) {
            int position = stack.peek();
            int isGo = 0;
            for (int i = 0; i < n; i++) {
                if (flag[i] == 0 && map[position][i] == 1) {
                    stack.push(i);
                    flag[i] = 1;
                    isGo = 1;
                    sum++;
                    break;
                }
            }
            if (isGo == 0) {
                sum++;
                stack.pop();
            }
        }
        System.out.println(sum);
    }

    private static boolean check(int[] flag) {
        for (int i = 0; i < flag.length; i++) {
            if (flag[i] == 0) {
                return true;
            }
        }
        return false;
    }
}
