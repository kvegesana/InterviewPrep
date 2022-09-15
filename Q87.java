import java.util.*;

public class Q87 {
    public static void main(String[] args) {

    }

    public int[] asteroidCollision(int[] a) {
        LinkedList<Integer> s = new LinkedList<Integer>();
        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0 || s.isEmpty() || s.getLast() < 0)
                s.add(a[i]);
            else if (s.getLast() <= -a[i])
                if (s.pollLast() < -a[i])
                    i--;
        }
        return s.stream().mapToInt(i -> i).toArray();
    }
}
