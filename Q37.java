public class Q37 {
    public static void main(String[] args) {

    }

    public int findPeakElement(int[] ar) {
        int n = ar.length;
        int l = 0, r = n - 1;
        if (n == 0 || n == 1)
            return 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            System.out.println(mid + " " + l + " " + r);
            if (mid > 0 && mid < n - 1) {
                if (ar[mid] > ar[mid - 1] && ar[mid] > ar[mid + 1]) {
                    return mid;
                } else {
                    if (ar[mid - 1] < ar[mid] && ar[mid] < ar[mid + 1]) {
                        l = mid + 1;
                    } else if (ar[mid - 1] > ar[mid] && ar[mid] > ar[mid + 1]) {
                        r = mid - 1;
                    } else {
                        r = mid - 1;
                    }
                }
            } else if (mid == 0 || mid == n - 1) {
                if (mid == 0) {
                    if (ar[mid] > ar[mid + 1]) {
                        return mid;
                    } else {
                        l = mid + 1;
                    }
                } else {
                    if (ar[mid] > ar[mid - 1]) {
                        return mid;
                    } else {
                        r = mid - 1;
                    }
                }
            }
        }
        return ar[l];
    }

    // Version 2
    public int findPeakElement2(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}
