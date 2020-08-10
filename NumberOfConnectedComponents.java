package del;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NumberOfConnectedComponents {
    public static void main(String[] args){
        int[][] edge = {{0,1}, {1,2},{3,4}};
        int n = 5;
        System.out.println(connectedcount(n, edge));

    }

    public static int connectedcount(int n, int[][] edges) {

        boolean[] visited = new boolean[n];
        List[] adj = new List[n];
        for(int i=0; i<adj.length; i++){
            adj[i] = new ArrayList<Integer>();
        }

        // create the adjacency list
        for(int[] e: edges){
            int from = e[0];
            int to = e[1];
            adj[from].add(to);
            adj[to].add(from);

        }
        Stack<Integer> stack = new Stack<>();
        int ans = 0; // ans = count of how many times DFS is carried out

        // this for loop through the entire graph
        for(int i = 0; i < n; i++){
            // if a node is not visited
            if(!visited[i]){
                ans++;
                //push it in the stack
                stack.push(i);

             
                while(!stack.empty()) {

                    int current = stack.peek();
                    stack.pop(); //pop the node
                    visited[current] = true; // mark the node as visited

                    List<Integer> list1 = adj[current];

        // push the connected components of the current node into stack
                    for (int neighbours:list1) {
                        if (!visited[neighbours]) {
                            stack.push(neighbours);
                        }
                    }
                }

        }
    }
        return ans;
    }
}