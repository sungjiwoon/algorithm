package samsung;

import java.util.*;

public class Test {
    static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return this.x +","+y;
        }
        @Override
        public boolean equals(Object o) {
            if (o instanceof Pair) {
                Pair p = (Pair) o;
                return (this.x == p.x) && (this.y == p.y);
            }
            return false;
        }
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    public static void main(String[] args) {

        HashMap<Pair, Integer> hm = new HashMap<>();
        hm.put(new Pair(1, 3), 0);
        hm.put(new Pair(1, 3), 1);
        hm.put(new Pair(1, 3), 2);
        hm.put(new Pair(3, 1), 3);

        System.out.println(Objects.hash(1, 3));
        System.out.println(Objects.hash(3, 1));

        for (Pair p : hm.keySet()) {
            System.out.println(p.toString() + ": " + hm.get(p));
        }

    }
}
