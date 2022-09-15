import java.util.HashMap;
import java.util.Map.Entry;

public class Q24 {
    public static void main(String[] args) {

    }

    class SparseVector {
        public HashMap<Integer, Integer> map;

        SparseVector(int[] nums) {
            map = new HashMap<>();
            for (int i = 0; i < nums.length; ++i) {
                if (nums[i] != 0) {
                    map.put(i, nums[i]);
                }
            }
        }

        // Return the dotProduct of two sparse vectors
        public int dotProduct(SparseVector vec) {
            HashMap<Integer, Integer> map2 = vec.map;
            int sum = 0;
            for (Entry<Integer, Integer> entry : map.entrySet()) {
                int key = entry.getKey();
                int val = entry.getValue();
                if (map2.containsKey(key)) {
                    sum += (val * map2.get(key));
                }
            }
            return sum;
        }
    }
}
