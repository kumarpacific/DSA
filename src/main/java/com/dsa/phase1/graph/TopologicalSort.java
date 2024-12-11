package com.dsa.phase1.graph;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {

    static class Edge{
        int src;
        int next;
        Edge(int src, int next){
            this.src = src;
            this.next = next;
        }
    }

    /**
     *  Example Graph:
     *      0----->3<----4
     *      |      ^     |  \
     *      v      |     v   v
     *      1----->2     5---->6
     *
     *      Topological sort : reverse 4560123
     */
    public static void main(String[] args) {
        int vertices = 7;
        ArrayList<Edge>[] graph = new ArrayList[vertices];
        for(int i=0; i<vertices; i++){
            graph[i] = new ArrayList<>();
        }
        // initialization
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,3));
        graph[1].add(new Edge(1,2));
        graph[2].add(new Edge(2,3));
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));
        graph[4].add(new Edge(4,6));
        graph[5].add(new Edge(5,6));

        // Topological sort code starts below

        boolean[] visited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i<vertices; i++){
            if(visited[i] == false){
                topologicalSort(graph,i,stack,visited);
            }
        }

        while(stack.size() > 0){
            System.out.println(stack.pop());
        }
    }

    private static void topologicalSort(ArrayList<Edge>[] graph, int src, Stack<Integer> st,boolean[] visited){
        visited[src] = true;
        for (Edge e: graph[src]){
            if(visited[e.next] != true){
                topologicalSort(graph, e.next, st,visited);
            }
        }
        st.push(src);
    }

}
