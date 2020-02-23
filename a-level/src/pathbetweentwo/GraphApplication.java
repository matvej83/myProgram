package pathbetweentwo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/***
 * This program has created as a part of home task:
 * Given the cities list. All the path between the cities has a cost (integer positive value). Task - find the most
 * beneficial path between two cities. The maximum path cost - 200000.
 * An initial data must be read from the file input.txt.
 * The result must be written in the file output.txt.
 *
 * Input scheme:
 *
 * n [city number <= 10000]
 * NAME [city name]
 * p [the number of neighbors of the city NAME]
 * nr cost [nr - the neighbor NAME index (nr begins from 1)]
 *            [cost - the cost of the path]
 * r [path numbers, that you must to find <= 100]
 * NAME1 NAME2 [NAME1 - path begin, NAME2 - path end]
 *
 * Output scheme:
 *
 * cost [the minimum cost of the path from NAME1 tо NAME2]
 *
 * Input example:
 * 4
 * gdansk
 * 2
 * 2 1
 * 3 3
 * bydgoszcz
 * 3
 * 1 1
 * 3 1
 * 4 4
 * torun
 * 3
 * 1 3
 * 2 1
 * 4 1
 * warszawa
 * 2
 * 2 4
 * 3 1
 * 2
 * gdansk warszawa
 * bydgoszcz warszawa
 *
 * Output example:
 * 3
 * 2
 */
public class GraphApplication {
    public static void main(String[] args) throws IOException {
        final int INFINITY = 200000;
        int vertexNumber = 0;
        int[][] graph;
        int neighbours = 0;
        int initialVertex = 1;
        List<String> cities = new ArrayList<>();
        List<String> paths = new ArrayList<>();
        IOtoFile ioToFile = new IOtoFile();
        List<String> readData = ioToFile.inputFromFile(args[0]);
        System.out.println("We've read this data " + readData.toString());
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
            System.out.println("The shortest path by the route " + tmp + " is " + shortPaths[counter]);
            counter++;
        }
        ioToFile.outputToFile(shortPaths, args[1]);
    }
}