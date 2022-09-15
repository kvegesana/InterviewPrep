public class Q53 {
    public static void main(String[] args) {

    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 < n2)
            return findMedianSortedArrays(nums2, nums1);

        int l = 0, r = n2 * 2;
        while (l <= r) {
            int mid2 = l + (r - l) / 2;
            int mid1 = n1 + n2 - mid2;
            int l1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[(mid1 - 1) / 2];
            int l2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[(mid2 - 1) / 2];

            int r1 = (mid1 == n1 * 2) ? Integer.MAX_VALUE : nums1[(mid1) / 2];
            int r2 = (mid2 == n2 * 2) ? Integer.MAX_VALUE : nums2[(mid2) / 2];

            if (l1 > r2) {
                l = mid2 + 1;
            } else if (l2 > r1) {
                r = mid2 - 1;
            } else {
                double ans = Math.max(l1, l2) + Math.min(r1, r2);
                ans /= 2.0f;
                return ans;
            }
        }
        return 0;
    }
}
