package del;

import java.util.Arrays;

public class RandomPickWithWeight {

	private double[] array, prob;
	    
	public void Solution(int[] w) {
	        double sum = 0.0;
	        int i, N = w.length;
	        this.array = new double[N];
	        this.prob = new double[N];
	        
	        for(i = 0; i < N; i++){
	            this.array[i] = w[i];
	            sum += this.array[i];
	        }
	        
	        for(i = 0; i < N; i++) {
	            this.array[i] += (i == 0) ? 0 : this.array[i - 1]; 
	            this.prob[i] = this.array[i] / sum;
	        }
	    }
	    
	public int pickIndex() {
	        return Math.abs(Arrays.binarySearch(this.prob, Math.random())) - 1;
	}

	
}
