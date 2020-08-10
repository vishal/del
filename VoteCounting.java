package del;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class VoteCounting {

	public static void main(String[] args) {

		List <String> votes = new ArrayList <String> ();
		votes.add("A");
		votes.add("A");
		votes.add("A");
		votes.add("A");
		votes.add("A");
		votes.add("A");
		votes.add("A");
		votes.add("A");
		votes.add("A");
		votes.add("A");
		votes.add("A");
		votes.add("C");
		votes.add("B");
		votes.add("D");
		votes.add("C");
		votes.add("C");
		votes.add("B");
		votes.add("B");
		votes.add("B");
		votes.add("C");
		votes.add("B");
		
		List <String> chosen = parliamentParties(votes);
		System.out.println(chosen.size());
		for (int i = 0; i < chosen.size(); i++){
			System.out.println (chosen.get(i));
		}

		
	}
	
	public static List<String> parliamentParties(List<String> votes) {
	    
        HashMap<String, Integer> voteCountMap = new HashMap<String,Integer>();
        List <String> resultList = new ArrayList <String> ();
        int totalVotes = votes.size();
        
        //System.out.println  (totalVotes);

        for (int i = 0; i < votes.size(); i++){

            String key = votes.get(i);
            Integer count = 0;
            voteCountMap.putIfAbsent(key, count);
            voteCountMap.put(key, voteCountMap.get(key) + 1);

        }

        for (String name : voteCountMap.keySet()) {
        	System.out.println(name + ": "+ voteCountMap.get(name) + " Total: " + totalVotes + " " + (voteCountMap.get(name)*1.0 / totalVotes ));
            if (voteCountMap.get(name)*1.0 / totalVotes >= 0.05) resultList.add (name);
        }

        Collections.sort(resultList);



        return resultList;

    }

}
