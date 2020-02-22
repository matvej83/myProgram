package iotest;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class TreeOfDirectory2 {
    private static class Element {
        public final String indent;
        public final File file;

        public Element(String indent, File file) {
            this.indent = indent;
            this.file = file;
        }

        @Override
        public String toString() {
            return indent + file.getName();
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path: ");
        //String path = scanner.nextLine();
        String path = "/home/vladimir/Картинки";
        File dir = new File(path);
        if (!dir.exists() || !dir.isDirectory()) {
            System.err.println("Incorrect directory name!");
        }
        Deque<Element> stack = new ArrayDeque<>();
        stack.add(new Element("+-", dir));
        while (!stack.isEmpty()) {
            Element element = stack.pollLast();
            System.out.println(element.toString());
            if (element.file.isDirectory()) {
                File[] files = element.file.listFiles();
                for (int i = files.length - 1; i >= 0; i--) {
                    stack.add(new Element(element.indent + " +-", files[i]));
                }
            }
        }
    }
}