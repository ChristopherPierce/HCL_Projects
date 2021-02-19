import java.util.ArrayList;
import java.util.Collections;

public class LongestIncreasingSubsequence {
	
	private ArrayList<Integer> list = new ArrayList<Integer>();
	
	public LongestIncreasingSubsequence(ArrayList<Integer> list) {
		this.list.addAll(list);
	}
	
	public ArrayList<Integer> solve() {
		return returnLIS();
	}
	
	private ArrayList<Integer> returnLIS() {
		ArrayList<Integer> P = new ArrayList<Integer>(Collections.nCopies(list.size(), 0));
		ArrayList<Integer> M = new ArrayList<Integer>(Collections.nCopies(list.size()-1, 0));
		
		int L = 0;
		for(int i = 0; i < list.size(); i++) {
			int low = 1;
			int high = L;
			while(low <= high) {
				int mid = (int) Math.ceil((low+high)/2);
				if(list.get(M.get(mid)) < list.get(i))
					low = mid+1;
				else
					high = mid-1;
			}
			int newL = low;
			P.set(i, M.get(newL-1));
			M.set(newL, i);
			if(newL > L)
				L = newL;
		}
		
		ArrayList<Integer> S = new ArrayList<Integer>(Collections.nCopies(L, 0));
		int k = M.get(L);
		for(int i = L-1; i >= 0; i--) {
			S.set(i, list.get(k));
			k = P.get(k);
		}
		
		return S;
	}
}
