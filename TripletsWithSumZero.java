class Triplet
{
    // Function to check if triplet is present 
    // arr[]: input array
    // n: size of the array
	public boolean findTriplets(int ar[] , int n)
    {
        //add code here.
        Arrays.sort(ar);
        for(int i=0;i<n-2;++i){
        	int l = i+1;
        	int r = n-1;
        	while(l<r){
        		int sum = ar[i] + ar[l] + ar[r];
        		if(sum == 0) return true;
        		else if(sum < 0) l++;
        		else r--;
        	}
        }
        return false;
    }
}