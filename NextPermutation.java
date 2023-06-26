import java.util.* ;
import java.io.*; 
import java.util.ArrayList;
import java.util.Collections;

public class Solution 
{
	public static ArrayList<Integer> nextPermutation(ArrayList<Integer> permutation) 
	{
		// Write your code here.
		int n = permutation.size();
		if(n==1) return permutation;
		int changePoint = Integer.MAX_VALUE;
		int nextSmallest = Integer.MAX_VALUE;
		int smallestNextIndex = -1;

		for(int i=n-1;i>0;i--){
			if(permutation.get(i)>permutation.get(i-1)){
				changePoint = i-1;
				break;
			}
		}
		if(changePoint==Integer.MAX_VALUE){
			Collections.sort(permutation);
			return permutation;
		}
		for(int i=changePoint;i<n;i++){
			if(permutation.get(changePoint)<permutation.get(i)){
				if(permutation.get(i)<nextSmallest){
					smallestNextIndex = i;
					nextSmallest = permutation.get(i);
				}
			}
		}
		int temp = permutation.get(changePoint);
		permutation.set(changePoint,permutation.get(smallestNextIndex));
		permutation.set(smallestNextIndex,temp);
		Collections.sort(permutation.subList(changePoint+1,n));
		return permutation;
	}
}
