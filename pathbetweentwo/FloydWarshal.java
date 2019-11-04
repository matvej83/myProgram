package pathbetweentwo;

public class FloydWarshal {

    public Number[][] floydWarshall(Number[][] graph, int vertexNumber) {
        //graph[][] - adjacency matrix
        Number[][] dist = new Number[vertexNumber][vertexNumber]; // dist[i][j] = minimal distance from i vertex to j vertex
        for (int i = 0; i < vertexNumber; i++) System.arraycopy(graph[i], 0, dist[i], 0, vertexNumber);
        for (int k = 0; k < vertexNumber; k++)
            for (int i = 0; i < vertexNumber; i++)
                for (int j = 0; j < vertexNumber; j++)
                    if (i == j) {
                        dist[i][j] = 0;
                    } else {
                        dist[i][j] = Math.min(dist[i][j].longValue(), dist[i][k].longValue() + dist[k][j].longValue());
                    }
        return dist;
    }
}
