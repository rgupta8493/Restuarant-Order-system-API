import java.util.*;
// estimating time for the order to be serviced for the customers .
//Decide your own priority and check how may min it will take for your order to be processed
//assumption every order atleast takes 2 minutes
public class Restaurant {
    static Map<Integer, Integer> m = new LinkedHashMap<>();
    static Queue<Map.Entry<Integer, Integer>> q = new LinkedList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("No of orders:");
        int orders = sc.nextInt();
        System.out.println("Mine position:");
        int position = sc.nextInt();
        System.out.println("Enter priority");
        for (int i = 1; i <= orders; i++) {
            m.put(i, sc.nextInt());

        }
        for (Map.Entry e : m.entrySet()) {
            q.add(e);
        }

        System.out.println("Estimated time: "+findTime(q, position, m)+" minutes");


    }

    private static int findTime(Queue<Map.Entry<Integer, Integer>> q, int pos, Map m1) {
        int time = 0;
        boolean flag = true;
        int m = 0;
        while (q.size() != 0) {
            m = (int) Collections.max(m1.values());
            if (q.peek().getValue() == m) {
                time += 2;
                if (q.peek().getKey() == pos) {
                    flag = false;
                }
                m1.remove(q.peek().getKey(), q.peek().getValue());
                q.poll();
                if (flag == false) return time;

            } else {
                Map.Entry<Integer, Integer> m3 = q.poll();
                q.add(m3);
            }

        }

        return -1;
    }
}

