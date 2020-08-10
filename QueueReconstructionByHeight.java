package del;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class QueueReconstructionByHeight {

	public static void main(String[] args) {
		//[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
		// TODO Auto-generated method stub
		
		int [] [] q = { {7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2} };
		int [] [] q2 = reconstructQueue(q);
		
		for (int i = 0; i < q2.length; i++) System.out.println(q2[i][0] + " " + q2[i][1]);

	}
	
	public static int[][] reconstructQueue(int[][] people) {
		
//		int [] [] res = new int [people.length] [2];
//		
//		Arrays.sort(people, new Comparator<int[]>() { 
//	          public int compare(final int[] entry1, final int[] entry2) { 
//	        	  if (entry1[1] < entry2[1]) return 1; 
//	        	  else return -1; 
//	          } 
//		});
//
//		int [] p = new int [people.length];
//		//List <Integer> posArr = Arrays.asList(people.length);
//		
//		dot (res, 0, p);
//
//		return res;
        
		
		Arrays.sort(people, (p1, p2) -> p1[0] == p2[0] ? p1[1] - p2[1] : p2[0] - p1[0]); 
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            list.add(people[i][1], people[i]); // placing people based on the K value
        }
        return list.toArray(people); // convert list to array
		
    }
	
	public static void dot (int [] [] res, int n,  int [] arr) {
		
	}

}






//public int[][] reconstructQueue(int[][] people) {
//    quickSort(people, 0, people.length-1);
//    ArrayList<int[]> res = new ArrayList<>();
//    for(int[] person : people) {
//        res.add(person[1], person);
//    }
//    
//    int i = 0;
//    for(int[] r : res) {
//        people[i++] = r;
//    }
//    
//    return people;
//}
//
//private void quickSort(int[][] people, int left, int right) {
//    if (left >= right) return;
//    int[] pivot = people[left];
//    int i = left;
//    int j = right;
//    while (i < j) {
//        while ((people[j][0] < pivot[0] || (people[j][0] == pivot[0] && people[j][1] >= pivot[1])) && i < j) {
//            j--;
//        }
//        while ((people[i][0] > pivot[0] || (people[i][0] == pivot[0] && people[i][1] <= pivot[1])) && i < j) {
//            i++;
//        }
//        if (i < j) {
//            int[] tmp = people[i];
//            people[i] = people[j];
//            people[j] = tmp;
//        }
//    }
//    // Swap pivot with left(start)
//    people[left] = people[i];
//    people[i] = pivot;
//    quickSort(people, left, i - 1);
//    quickSort(people, i + 1, right);
//}
//}