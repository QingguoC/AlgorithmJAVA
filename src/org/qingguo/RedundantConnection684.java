package org.qingguo;

import com.sun.istack.internal.NotNull;

import java.util.Arrays;

public class RedundantConnection684 {
    public int[] findRedundantConnection(int[][] edges){
        int[] parents = new int[edges.length + 1];
        int[] sizes = new int[edges.length + 1];
        Arrays.fill(sizes,1);
        for (int[] edge : edges){

            if (parents[edge[0]] == 0) parents[edge[0]] = edge[0];
            if (parents[edge[1]] == 0) parents[edge[1]] = edge[1];
            int pu = find(edge[0],parents);
            int pv = find(edge[1],parents);
            if (pu == pv){
                return edge;
            }
            if (sizes[pv] > sizes[pu]){
                int temp = pv;
                pv = pu;
                pu = temp;
            }
            parents[pv] = pu;       // union small one to big one
            sizes[pu] += sizes[pv]; // only root parent store useful size info
        }
        return new int[]{0,0};
    }

    private int find(int node, int[] parents){
        while (parents[node] != node){
            parents[node] = parents[parents[node]];
            node = parents[node];
        }
        return node;
    }

}
