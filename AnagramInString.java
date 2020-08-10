package del;

import java.util.ArrayList;
import java.util.List;

public class AnagramInString {

	//https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3332/
	// Returns every position in string s where anagram of p starts
	public List<Integer> findAnagrams(String s, String p) {
        int[] letters = new int[26];
        for(int i = 0; i < p.length(); i++) {
            letters[p.charAt(i) - 'a']++;
        }
        int j = 0;
        int rem = p.length();
        List<Integer> result = new ArrayList();
        for(int i = 0; i < s.length(); i++) {
            while(j < s.length() && j - i < p.length()) {
                if(letters[s.charAt(j++) - 'a']-- > 0) {
                    rem--;
                }
            }
            if(rem == 0 && j - i == p.length()) result.add(i);
            if(letters[s.charAt(i) - 'a']++ >= 0) rem++;
        }
        return result;
    }
	
	//https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3333/
	// returns true if s1 (or any permutation of its characters) exists in s2
	public boolean checkInclusion(String s1, String s2) {
       int[] letters = new int[26];
        for(int i = 0; i < s1.length(); i++) {
            letters[s1.charAt(i) - 'a']++;
        }
        int j = 0;
        int rem = s1.length();
        //List<Integer> result = new ArrayList();
        for(int i = 0; i < s2.length(); i++) {
            while(j < s2.length() && j - i < s1.length()) {
                if(letters[s2.charAt(j++) - 'a']-- > 0) {
                    rem--;
                }
            }
            if(rem == 0 && j - i == s1.length()) return true;
            if(letters[s2.charAt(i) - 'a']++ >= 0) rem++;
        }
        return false; 
    }
	
}
