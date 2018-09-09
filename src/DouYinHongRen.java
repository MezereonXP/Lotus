/**
 * @program: DouYinHongRen
 * @description:
 * @author: mezereonxp Email: mezereonxp@gmail.com
 * @create: 2018/9/9
 **/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class DouYinHongRen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < M; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if (map.containsKey(x)) {
                map.get(x).add(y);
            } else {
                map.put(x, new ArrayList<Integer>());
                map.get(x).add(y);
            }
            countMap.put(x, 0);
            countMap.put(y, 0);
        }

        Map<Integer, Set<Integer>> history = new HashMap<>();
        Map<Integer, ArrayList<Integer>> newMap = map;
        while (check(newMap)) {
            for (Integer integer : newMap.keySet()) {
                if (!history.containsKey(integer)) {
                    history.put(integer, new HashSet<>());
                }
                for (int j = 0; j < newMap.get(integer).size(); j++) {
                    countMap.put(newMap.get(integer).get(j), countMap.get(newMap.get(integer).get(j)) + 1);
                    history.get(integer).add(newMap.get(integer).get(j));
                }
            }
            Map<Integer, ArrayList<Integer>> replaceMap = new HashMap<>();

            for (Integer integer : newMap.keySet()) {
                replaceMap.put(integer, new ArrayList<>());
                for (int j = 0; j < map.get(integer).size(); j++) {
                    int y = map.get(integer).get(j);
                    if (map.containsKey(y)) {
                        for (int k = 0; k < map.get(y).size(); k++) {
                            if (map.get(y).get(k) != integer && !history.get(integer).contains(map.get(y).get(k))) {
                                replaceMap.get(integer).add(map.get(y).get(k));
                                history.get(integer).add(map.get(y).get(k));
                            }
                        }
                    }
                }
            }
            newMap = replaceMap;
        }
        int sum = 0;
        for (Integer i : countMap.keySet()) {
//            if (countMap.get(i) > N) {
//                sum++;
//            }
            System.out.println("[" + i + "," + countMap.get(i) + "]");
        }
        System.out.println(sum);
//        int[] arr = new int[M*2];
//        List<List<Integer>> list = new ArrayList<>();
//        List<Integer> list1 = new ArrayList<>();
//        for (int i=0;i<M*2;i++){
//            arr[i] = scanner.nextInt();
//        }
//        for (int i=0;i<M*2;i++) {
//            list1.add(arr[i]);
//            if (list1.size()==2) {
//                list.add(new ArrayList<>(list1));
//                list1.clear();
//            }
//        }
//        int count =0;
//        for (int i=0;i<list.size();i++){
//            for (int j=i+1;j<list.size();j++){
//                if (list.get(i).get(1)==list.get(j).get(0) && list.get(i).get(0) != list.get(j).get(1)){
//                    count ++;
//                }
//            }
//        }
//        System.out.println(count);
//        System.out.println(list.get(0).get(1));
//        System.out.println(Arrays.toString(arr));
    }

    private static boolean check(Map<Integer, ArrayList<Integer>> map) {
        for (Integer key : map.keySet()) {
            if (map.get(key).size() != 0) {
                return true;
            }
        }
        return false;
    }
}