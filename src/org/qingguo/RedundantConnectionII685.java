package org.qingguo;

import java.util.Arrays;

public class RedundantConnectionII685 {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] parents = new int[edges.length + 1]; //store parent node
        int[] roots = new int[edges.length + 1];    // store union root
        int[] sizes = new int[edges.length + 1];    // store union size
        int[] ans1 = null;
        int[] ans2 = null;
        Arrays.fill(sizes, 1);
        for (int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            if (parents[edge[1]] > 0){
                ans1 = new int[]{parents[v], v};
                ans2 = new int[]{u, v};;        // new to avoid -1 effect
                edge[0] = -1;
                edge[1] = -1;
            }
            parents[v] = u; 
        }
        for (int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            if (u < 0 || v < 0) continue;
            if (roots[u] == 0){
                roots[u] = u;
            }
            if (roots[v] == 0){
                roots[v] = v;
            }
            int ru = find(u, roots);
            int rv = find(v, roots);
            if (ru == rv){
                return ans1 == null ? edge : ans1;
            }
            if (sizes[rv] > sizes[ru]){
                int temp = rv;
                rv = ru;
                ru = temp;
            }
            roots[rv] = ru;
            sizes[ru] += sizes[rv];
        }
        return ans2;
    }
    private int find(int node, int[] root){
        while (root[node] != node){
            root[node] = root[root[node]];
            node = root[node];
        }
        return node;
    }
}
