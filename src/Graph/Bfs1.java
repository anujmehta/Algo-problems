package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by an039me on 10/13/2015.
 */
public class Bfs1 {

        private static class Graph{
            Map<Integer, Set<Integer>> adjacencyList;

            public Graph(int n){
                adjacencyList = new HashMap<>();

                for(int i = 1; i <= n; i++){
                    adjacencyList.put(i, new TreeSet<Integer>());
                }
            }

            void addNeighbour(int v1, int v2){
                adjacencyList.get(v1).add(v2);
            }

            Set<Integer> getNeighbours(int v){
                return adjacencyList.get(v);
            }

            public String toString(){
                StringBuffer stringBuffer = new StringBuffer();
                for (Map.Entry<Integer, Set<Integer>> entry : adjacencyList.entrySet()) {
                    stringBuffer.append(entry.getKey() + "-->" + entry.getValue());
                }
                return stringBuffer.toString();
            }
        }

        private static class Node {
            int id = -1;
            int distance = -1;

            Node(int id, int distance){
                this.id = id;
                this.distance = distance;
            }
        }

        public static void main(String[] args) throws Exception {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            int numOfTestCases = Integer.parseInt(bufferedReader.readLine().trim());
            for(int test = 0; test < numOfTestCases; test++) {
                String[] split = bufferedReader.readLine().split("\\s+");
                int N = Integer.parseInt(split[0]);
                int M = Integer.parseInt(split[1]);
                Graph graph = new Graph(N);

                for(int edge = 0; edge < M; edge++){
                    String[] strings = bufferedReader.readLine().split("\\s+");
                    int startVertex = Integer.parseInt(strings[0]);
                    int endVertex = Integer.parseInt(strings[1]);
                    graph.addNeighbour(startVertex, endVertex);
                    graph.addNeighbour(endVertex, startVertex);
                }

                int startPosition = Integer.parseInt(bufferedReader.readLine().trim());
                boolean[] visited = new boolean[N + 1];
                int[] count = new int[N + 1];
                Arrays.fill(count, -1);

                ArrayDeque<Node> queue = new ArrayDeque<>();
                queue.add(new Node(startPosition, 0));
                visited[startPosition] = true;
                count[startPosition] = 0;

                while (!queue.isEmpty()){
                    Node element = queue.removeFirst();

                    Set<Integer> neighbours = graph.getNeighbours(element.id);
                    if(neighbours != null && neighbours.size() > 0) {
                        for (Integer neighbour : neighbours) {
                            if(!visited[neighbour])
                            {
                                visited[neighbour] = true;
                                count[neighbour] = count[element.id] + 1;
                                queue.add(new Node(neighbour, count[neighbour]));
                            }
                        }
                    }
                }

                for(int i = 1; i <= N; i++){
                    if(count[i] == -1)
                    {
                        System.out.print(-1 + " ");
                    }
                    else if(count[i] > 0){
                        System.out.print(count[i] * 6 + " ");
                    }
                }
                System.out.println();
            }
        }
}
