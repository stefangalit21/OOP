import java.util.LinkedList;

public class Graph {
    int V;
    LinkedList<Edge> edges = new LinkedList<>();

    public Graph(int V) {
        this.V = V;
    }

    public void addEdge(int src, int dest, int weight) {
        edges.add(new Edge(src, dest, weight));
    }
}
