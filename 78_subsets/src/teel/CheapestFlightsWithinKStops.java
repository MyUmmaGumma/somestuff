package teel;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CheapestFlightsWithinKStops {
	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
		class EdgeWeight {
			int n;
			int w;
			EdgeWeight(int e, int _w) { n = e; w = _w;}
		}
		Map<Integer, Set<EdgeWeight>> m = new HashMap<>();
		
		for (int []f : flights) {
			Set<EdgeWeight> s = null;
			if (m.containsKey(f[0])) {
				s = m.get(f[0]);
			} else {
				s = new HashSet<>();
				m.put(f[0], s);
			}
			s.add(new EdgeWeight(f[1], f[2]));
		}
		
		int []dist = new int [n];
		Arrays.fill(dist, Integer.MAX_VALUE/2);
		int []newdist = new int [n];
		Arrays.fill(dist, Integer.MAX_VALUE/2);
		dist[src] = 0;
		newdist[src] = 0;
		
		for (int i = 0; i <= K; i++) {
			for (int []edge : flights)
			{
				newdist[edge[1]] = Math.min(newdist[edge[1]], dist[edge[0]] + edge[2]);
			}
			dist = newdist;
		}
		if (dist[dst] == Integer.MAX_VALUE/2) {
			return -1;
		}
		return dist[dst];
		/*
		 *    int[] dis = new int[n];
        int[] pre = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE / 2);
        Arrays.fill(pre, Integer.MAX_VALUE / 2);
        dis[src] = pre[src] = 0;

        for (int i = 0; i <= K; ++i) {
            for (int[] edge: flights)
                dis[edge[1]] = Math.min(dis[edge[1]], pre[edge[0]] + edge[2]);

            pre = dis;
        }

        return dis[dst] < Integer.MAX_VALUE / 2 ? dis[dst] : -1;
		 */
    }
	
	
	public static void main(String []args)
	{
		CheapestFlightsWithinKStops c = new CheapestFlightsWithinKStops();
		int [][] edges = {{0,1,100},{1,2,100},{0,2,500}};
		System.out.println(c.findCheapestPrice(3, edges, 0 ,2, 1));
	}
}
