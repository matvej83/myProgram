package pathbetweentwo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GraphApplication {
    public static void main(String[] args) throws IOException {
        final int INFINITY = 200000;
        int vertexNumber = 0;
        int[][] graph;
        int neighbours = 0;
        int initialVertex = 1;
        List<String> cities = new ArrayList<>();
        List<String> paths = new ArrayList<>();
        List<String> readData = new IOtoFile().inputFromFile("src/pathbetweentwo/input.txt");
        System.out.println("We've read this data from file " + readData.toString());
        vertexNumber = Integer.parseInt(readData.get(0));
        graph = new int[vertexNumber][vertexNumber];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                graph[i][j] = INFINITY;
            }
        }
        int iterator = 1;
        int weight = 0;
        int neighbour = 0;
        int pathNumber = 0;
        while (iterator < readData.size()) {
            if (cities.size() < vertexNumber) {
                cities.add(readData.get(iterator));
                iterator++;
                neighbours = Integer.parseInt(readData.get(iterator));
                iterator++;
                for (int j = 0; j < neighbours; j++) {
                    String tmp = readData.get(iterator);
                    Scanner sc = new Scanner(tmp);
                    while (sc.hasNext()) {
                        neighbour = sc.nextInt();
                        weight = sc.nextInt();
                        graph[initialVertex - 1][neighbour - 1] = weight;
                        iterator++;
                    }
                    sc.close();
                }
                initialVertex++;
            } else {
                pathNumber = Integer.parseInt(readData.get(iterator));
                iterator++;
                for (int i = 0; i < pathNumber; i++) {
                    paths.add(readData.get(iterator));
                    iterator++;
                    if (iterator > readData.size()) {
                        return;
                    }
                }
            }
        }
        int[][] result = new int[vertexNumber][vertexNumber];
        System.arraycopy(new FloydWarshal().floydWarshall(graph, vertexNumber), 0, result, 0, vertexNumber);

        //get shortest paths
        int[] shortPaths = new int[pathNumber];
        int counter = 0, firstIndex = 0, lastIndex = 0;
        for (String tmp : paths) {
            firstIndex = cities.indexOf(tmp.substring(0, tmp.indexOf(' ')));
            lastIndex = cities.indexOf(tmp.substring(tmp.indexOf(' ') + 1));
            shortPaths[counter] = result[firstIndex][lastIndex];
            counter++;
        }
        new IOtoFile().outputToFile(shortPaths, "src/pathbetweentwo/output.txt");
        //testing code are given below
        //System.out.println(paths.toString());
        //System.out.println(Arrays.deepToString(graph));
        //System.out.println(Arrays.deepToString(result));
    }
}