package del;

import java.util.ArrayList;
import java.util.List;

public class BipartiteGraph {
	
	 private static enum Colour {
	        RED, BLUE;
	    }
	    
	    public boolean possibleBipartition(int N, int[][] dislikes) {
	        if (dislikes == null || dislikes.length == 0) return true;
	        
	        MyGraph g = new MyGraph(N+1);
	        for (int[] d : dislikes) {
	            g.addEdge(d[0], d[1]);
	        }
	        Colour[] colours = new Colour[N+1];
	        for (int u = 1; u <= N; u++) {
	            if (colours[u] == null) {
	                if (!isBipartite(g, u, colours, Colour.RED))
	                    return false;
	            }
	        }
	        return true;
	    }
	    
	    
	    private static class MyGraph {
	        int V;
	        List<Integer>[] adj;
	        public MyGraph(int V) {
	            this.V = V;
	            this.adj = (List<Integer>[])new ArrayList[V];
	            for (int u = 0; u < V; u++) {
	                adj[u] = new ArrayList<>();
	            }
	        }
	        public void addEdge(int u, int v) {
	            this.adj[u].add(v);
	            this.adj[v].add(u);
	        }
	        
	    }
	    
	    public boolean isBipartite(MyGraph g, int u, Colour[] colours, Colour colour) {
	        colours[u] = colour;
	        Colour nextColour = (colour == Colour.RED) ? Colour.BLUE : Colour.RED;
	        for (int v : g.adj[u]) {
	            if (colours[v] == null) {
	                if (!isBipartite(g, v, colours, nextColour))
	                    return false;
	            }
	            else if (colours[v] == colour)
	                return false;
	        }
	        return true;
	    }

}
