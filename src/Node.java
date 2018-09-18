import java.util.ArrayList;
import java.util.Scanner;

/**
 * @program: Tree
 * @description:
 * @author: mezereonxp Email: mezereonxp@gmail.com
 * @create: 2018/9/18
 **/

public class Node {
    public static int maxn = 1000000;
    public static int[] layer = new int[maxn];
    public static int[] in = new int[maxn];
    public static int n;
    public static ArrayList ans = new ArrayList();

    public Integer data;
    public Node left, right;

    Node() {
        data = null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] a = scanner.nextLine().split(" ");
        n = a.length;
        for (int i = 0; i < n; i++) {
            layer[i] = Integer.parseInt(a[i]);
        }
        String[] b = scanner.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            in[i] = Integer.parseInt(b[i]);
        }

        Node root = null;
        for (int i = 0; i < n; i++) {
            int u;
            for (u = 0; u < n; u++) {
                if (in[u] == layer[i]) break;
            }
            root = creat(root, layer[i], u);
        }
        ans.clear();
        post2(root);
        outans2();
        ans.clear();
        pre(root);
        outans();
        ans.clear();
        post(root);
        outans();

    }

    public static Node creat(Node root, int data, int index) {
        if (root == null || root.data == null) {
            root = new Node();
            root.left = null;
            root.right = null;
            root.data = data;
            return root;
        }
        int u;
        for (u = 0; u < n; u++) {
            if (in[u] == root.data) break;
        }
        if (u < index) {
            root.right = creat(root.right, data, index);
        } else {
            root.left = creat(root.left, data, index);
        }
        return root;
    }

    public static void pre(Node root) {
        if (root != null) {
            ans.add(root.data);
            pre(root.left);
            pre(root.right);
        }
    }

    public static void outans() {
        for (int i = 0; i < ans.size(); i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(ans.get(i));
        }
        System.out.println();
    }

    public static void outans2() {
        for (int i = 0; i < ans.size(); i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(ans.get(i));
        }
        System.out.println();
    }

    static void post(Node root) {
        if (root != null) {
            post(root.left);
            post(root.right);
            ans.add(root.data);
        }
    }

    static void post2(Node root) {
        if (root != null) {
            post2(root.left);
            post2(root.right);
            if (root.left == null && root.right == null) {
                ans.add(root.data);
            }
        }
    }
}




