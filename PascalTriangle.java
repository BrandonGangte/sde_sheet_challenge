import java.io.*;
import java.util.* ;

import java.util.ArrayList;

public class Solution {

	public static ArrayList<Long> generateRow(int n){
		long ans = 1;
		ArrayList<Long> row = new ArrayList<>();
		row.add((long) 1);
		for(int i=1;i<n;i++){
			ans = ans * (n-i);
			ans = ans/i;
			row.add(ans);
		}
		return row;
	}

	public static ArrayList<ArrayList<Long>> printPascal(int n) {
        // Write your code here.
		ArrayList<ArrayList<Long>> anslist = new ArrayList<>();
		for(int i=1;i<=n;i++){
			anslist.add(generateRow(i));
		}
		return anslist;
	}
}
