package iotest;

import java.io.File;
import java.util.*;

public class TreeOfDir {
    public static void main(String[] args) {
        String root = "/home/vladimir/workspace";
        File rootDir = new File(root);
        List<String> result = new ArrayList<>();
        Queue<File> fileTree = new PriorityQueue<>();

        Collections.addAll(fileTree, rootDir.listFiles());

        while (!fileTree.isEmpty())
        {
            File currentFile = fileTree.remove();
            if(currentFile.isDirectory()){
                Collections.addAll(fileTree, currentFile.listFiles());
            } else {
                result.add(currentFile.getAbsolutePath());
            }
        }
        for (String tmp:result) {
            System.out.println(tmp);
        }
    }
}
