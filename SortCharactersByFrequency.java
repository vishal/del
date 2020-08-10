package del;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

//https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3337/
//Given a string, sort it in decreasing order based on the frequency of characters.


public class SortCharactersByFrequency {

	public static void main(String[] args) {

		String s = "Googleisnamedaftergoogol";
		System.out.println (frequencySort(s));

	}
	
	public static String frequencySort(String s) {
		//PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
//		HashMap <Character,Integer> charMap = new HashMap <Character,Integer> ();
//		
//		char[] stringToCharArray = s. toCharArray();
//		for (char output : stringToCharArray) {
//			charMap.putIfAbsent(output, 0);
//			charMap.put(output, charMap.get(output) + 1);
//		}
//		
//		List<Integer> sortedCounts = new ArrayList<Integer>(charMap.values()); 
//		Collections.sort(sortedCounts,Comparator.reverseOrder()); 
//		
//		return s;
		
		
		if(s == null || s.length() == 0) return s;

		int[] cnt_arr = new int[256];
		for(char c : s.toCharArray()){
		    cnt_arr[c]++;
		}

		PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> cnt_arr[b] - cnt_arr[a]);
		for(int i = 0; i < 256; i++){
		    pq.offer((char)i);
		}

		StringBuilder sb = new StringBuilder();
		while(!pq.isEmpty()){
		    Character c = pq.poll();
		    for(int i = 0; i < cnt_arr[c]; i++){
		        sb.append(c);
		    }
		}

		return sb.toString();
		
    }

}





