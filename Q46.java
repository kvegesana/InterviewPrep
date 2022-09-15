import java.util.ArrayList;
import java.util.HashMap;

public class Q46 {
    public static void main(String[] args) {

    }

    HashMap<Integer, ArrayList<Integer>> map;

    public Solution(int[] ar) {
        int n = ar.length;
         map = new HashMap<>();
        for(int i=0;i<n;++i){
            if(!map.containsKey(ar[i])){
                map.put(ar[i], new ArrayList<Integer>());
            }
            ArrayList<Integer> list = map.get(ar[i]);
            list.add(i);
        }

    }

    public int pick(int k) {
        ArrayList<Integer> list = map.get(k);
        int n = list.size();
        double ran = Math.random() * n;
        int t = (int) ran;
        return list.get(t);
    }
}
