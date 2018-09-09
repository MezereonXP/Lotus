package JinDon;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @program: Main
 * @description: Main class
 * @author: mezereonxp Email: mezereonxp@gmail.com
 * @create: 2018/9/9
 **/
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            Map<Integer, ArrayList<Integer>> map = new HashMap<>();
            ArrayList<ArrayList<Integer>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            for (int j = 1; j <= N; j++) {
                result.get(0).add(j);
            }
            for (int j = 0; j < M; j++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                if (!map.containsKey(x)) {
                    map.put(x, new ArrayList<>());
                }
                if (!map.containsKey(y)) {
                    map.put(y, new ArrayList<>());
                }
                map.get(x).add(y);
                map.get(y).add(x);
            }
            for (Integer key : map.keySet()) {
                for (int j = 0; j < map.get(key).size(); j++) {
                    for (int k = 0; k < result.size(); k++) {
                        if (result.get(k).contains(key) && result.contains(map.get(key).get(j))) {
                            result.get(k).remove(key);
                            if (k + 1 < result.size()) {
                                result.get(k + 1).add(key);
                            } else {
                                result.add(new ArrayList<>());
                                result.get(k + 1).add(key);
                            }
                        }
                    }
                }
            }
            for (int k = 0; k < result.size(); k++) {
                for (int j = 0; j < result.get(k).size(); j++) {
                    for (int l = k + 1; l < result.size(); l++) {
                        for (int m = 0; m < result.get(l).size(); m++) {
                            if (!map.get(result.get(l).get(m)).contains(result.get(k).get(j))) {
                                System.out.println("No");
                            }
                        }
                    }
                }
            }
            System.out.println("Yes");

        }
    }
}
