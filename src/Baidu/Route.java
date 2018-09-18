package Baidu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @program: Route
 * @description:
 * @author: mezereonxp Email: mezereonxp@gmail.com
 * @create: 2018/9/11
 **/
public class Route {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> baseCoor = new ArrayList<>();
        baseCoor.add(scanner.nextInt());
        baseCoor.add(scanner.nextInt());
        List<List<Integer>> pickup = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(scanner.nextInt());
            list.add(scanner.nextInt());
            pickup.add(list);
        }

        System.out.println(minRoutes(6, baseCoor, pickup));
    }

    public static int minRoutes(int numOfPickupLoc, List<Integer> baseCoor, List<List<Integer>> pickupLocCoor) {
        int minCount = 0;
        while (!pickupLocCoor.isEmpty()) {
            Map<Double, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < pickupLocCoor.size(); i++) {
                int x = pickupLocCoor.get(i).get(0);
                int y = pickupLocCoor.get(i).get(1);
                double tempMargin = countMargin(x, y, baseCoor);
                if (!map.containsKey(tempMargin)) {
                    map.put(tempMargin, new ArrayList<>());
                }
                map.get(tempMargin).add(i);
            }
            int max = 0;
            Double maxKey = new Double(0);
            for (Double key : map.keySet()) {
                if (map.get(key).size() > max) {
                    max = map.get(key).size();
                    maxKey = key;
                }
            }
            minCount++;
            List<List<Integer>> newPickupCoor = new ArrayList<>();

            for (int i = 0; i < pickupLocCoor.size(); i++) {
                if (!map.get(maxKey).contains(i)) {
                    List<Integer> list = new ArrayList<>();
                    list.add(pickupLocCoor.get(i).get(0));
                    list.add(pickupLocCoor.get(i).get(1));
                    newPickupCoor.add(list);
                }
            }
            pickupLocCoor = newPickupCoor;
        }
        return minCount;
    }

    private static double countMargin(int x, int y, List<Integer> baseCoor) {
        if (x != baseCoor.get(0)) {
            return (y - baseCoor.get(1)) * 1.0 / (x - baseCoor.get(0));
        } else {
            return Double.MAX_VALUE;
        }
    }
}
