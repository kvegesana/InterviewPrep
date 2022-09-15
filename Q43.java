public class Q43 {
    public int firstBadVersion(int n) {
        int l = 1;
        int r = n;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            boolean a = isBadVersion(mid);
            if ((mid == 1 || (!isBadVersion(mid - 1))) && a) {
                return mid;
            } else if (a) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    // Version 2
    public int firstBadVersion2(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean isBadVersion(int i) {
        return false;
    }
}
