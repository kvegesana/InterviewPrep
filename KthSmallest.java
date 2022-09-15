// Java program to find k'th smallest element in expected
// linear time
class KthSmallest {
    // This function returns k'th smallest element in arr[l..r]
    // using QuickSort based method. ASSUMPTION: ALL ELEMENTS
    // IN ARR[] ARE DISTINCT
    int kthSmallest(int arr[], int l, int r, int k) {
        // If k is smaller than number of elements in array
        if (k > 0 && k <= r - l + 1) {
            // Partition the array around a random element and
            // get position of pivot element in sorted array
            int pos = randomPartition(arr, l, r);
            System.out.println("Position :" + " " + arr[pos] + " " + pos);
            printAr(arr);
            // If position is same as k
            if (pos - l == k - 1)
                return arr[pos];

            // If position is more, recur for left subarray
            if (pos - l > k - 1) {
                System.out.println("Left : ");
                return kthSmallest(arr, l, pos - 1, k);
            }

            // Else recur for right subarray
            System.out.println("Right : ");
            return kthSmallest(arr, pos + 1, r, k - pos + l - 1);
        }

        // If k is more than number of elements in array
        return Integer.MAX_VALUE;
    }

    void printAr(int[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Utility method to swap arr[i] and arr[j]
    void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Standard partition process of QuickSort(). It considers
    // the last element as pivot and moves all smaller element
    // to left of it and greater elements to right. This function
    // is used by randomPartition()
    int partition(int arr[], int l, int r) {
        int x = arr[r], i = l;
        for (int j = l; j < r; j++) {
            if (arr[j] <= x) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, r);
        return i;
    }

    // Picks a random pivot element between l and r and
    // partitions arr[l..r] arount the randomly picked
    // element using partition()
    int randomPartition(int arr[], int l, int r) {
        int n = r - l + 1;
        int pivot = (int) (Math.random() * (n - 1));
        System.out.println("Random Pivot: " + pivot + " " + arr[pivot]);
        swap(arr, l + pivot, r);
        return partition(arr, l, r);
    }

    // Driver method to test above
    public static void main(String args[]) {
        KthSmallest ob = new KthSmallest();
        int arr[] = { 4, 5, 10, 11, 1, 3, 19, 8, 7, 15 };
        int n = arr.length, k = 5;
        System.out.println("K'th smallest element is " +
                ob.kthSmallest(arr, 0, n - 1, k));
    }
}
/* This code is contributed by Rajat Mishra */
