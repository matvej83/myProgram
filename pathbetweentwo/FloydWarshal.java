package pathbetweentwo;

public class FloydWarshal {

    public int[][] floydWarshall(int[][] graph, int vertexNumber) {
        //graph[][] - adjacency matrix
        int[][] dist = new int[vertexNumber][vertexNumber]; // dist[i][j] = minimal distance from i vertex to j vertex
        for (int i = 0; i < vertexNumber; i++) System.arraycopy(graph[i], 0, dist[i], 0, vertexNumber);
        for (int k = 0; k < vertexNumber; k++)
            for (int i = 0; i < vertexNumber; i++)
                for (int j = 0; j < vertexNumber; j++)
                    if (i == j) {
                        dist[i][j] = 0;
                    } else {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
        return dist;
    }
}