package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by an039me on 10/21/2015.
 */
public class Dijk1 {
    static int MAX = 1000;

    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numOfTestCases = Integer.parseInt(bufferedReader.readLine());

        for(int testCase = 0; testCase < numOfTestCases; testCase++){
            String[] split = bufferedReader.readLine().split("\\s+");
            int N = Integer.parseInt(split[0]);
            int M = Integer.parseInt(split[1]);

            int[] distance = new int[N + 1];
            Arrays.fill(distance, MAX);
            boolean[] visited = new boolean[N + 1];
            Arrays.fill(visited, false);

            Graph graph = new Graph(N);
            for(int edge = 0; edge < M; edge++){
                String[] strings = bufferedReader.readLine().split("\\s+");
                int v1 = Integer.parseInt(strings[0]);
                int v2 = Integer.parseInt(strings[1]);
                int weight = Integer.parseInt(strings[2]);
                graph.addNeighbour(v1, new Vertex(v2, weight));
                graph.addNeighbour(v2, new Vertex(v1, weight));
            }

            int startPosition = Integer.parseInt(bufferedReader.readLine());
            distance[startPosition] = 0;
            for(int idx = 1; idx <= N; idx++){
                int min = findMin(distance, visited);
                if (min > 0) {
                    visited[min] = true;

                    Iterator<Vertex> iterator = graph.getNeighbours(min).iterator();
                    while (iterator.hasNext()){
                        Vertex next = (Vertex) iterator.next();
                        int currentId = next.id;
                        int calculatedWeight = distance[min] + next.weight;
                        if(distance[currentId] > calculatedWeight){
                            distance[currentId] = calculatedWeight;
                        }
                    }
                }
            }

            for(int i = 1; i <= N; i++){
                if(distance[i] != 0){
                    if(distance[i] == MAX){
                        System.out.print(-1 + " ");
                    }
                    else
                        System.out.print(distance[i] + " ");
                }
            }
            System.out.println();
        }
    }

    static int findMin(int[] distance, boolean[] visited){
        int min = MAX;
        int index = -1;
        for(int i = 1; i < distance.length; i++){
            if(!visited[i] && distance[i] < min){
                min = distance[i];
                index = i;
            }
        }
        return index;
    }

    private static class Vertex {
        int id;
        int weight;

        Vertex(int id, int weight){
            this.id = id;
            this.weight = weight;
        }
    }

    static class Graph{

        Map<Integer, List<Vertex>> adjacencyList;

        Graph(int n){
            adjacencyList = new HashMap<>();

            for(int i = 1; i <= n; i++){
                adjacencyList.put(i, new ArrayList<Vertex>());
            }
        }

        void addNeighbour(int startId, Vertex endVertex){
            adjacencyList.get(startId).add(endVertex);
        }

        List<Vertex> getNeighbours(int vertexId){
            return adjacencyList.get(vertexId);
        }
    }
}
