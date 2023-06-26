import java.util.* ;
import java.io.*; 

public class Solution {
	
	public static long maxSubarraySum(int[] arr, int n) {
		// write your code here
		long maxi = Integer.MIN_VALUE;
        long sum = 0;
        for(int i=0;i<n;i++){
            sum += arr[i];
            maxi = Math.max(maxi,sum);
            if(sum<0) sum = 0;
        }
		if(maxi<0) return 0;
        return maxi;
	}

}
