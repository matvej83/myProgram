package haffmancode;

import java.util.ArrayList;
import java.util.List;

public class Node implements Comparable<Node> {

    public Node() {
    }

    private int sum;
    private String code;

    public Node(int sum) {
        this.sum = sum;
    }

    void buildCode(String code) {
        this.code = code;
    }


    public int getSum() {
        return sum;
    }

    public String getCode() {
        return code;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(sum, o.sum);
    }

    public static class InternalNode extends Node {
        private Node left;
        private Node right;

        @Override
        void buildCode(String code) {
            super.buildCode(code);
            left.buildCode(code + "0");
            right.buildCode(code + "1");
        }

        public InternalNode(Node left, Node right) {
            super(left.sum + right.sum);
            this.left = left;
            this.right = right;
        }
    }

    public static class LeafNode extends Node {

        private char symbol;
        private List<String> codeTable = new ArrayList<>();

        private String outputFile;

        public void setOutputFile(String outputFile) {
            this.outputFile = outputFile;
        }

        public String getOutputFile() {
            return outputFile;
        }

        public LeafNode() {
        }


        public LeafNode(char symbol, int count) {
            super(count);
            this.symbol = symbol;
        }

        @Override
        void buildCode(String code) {
            super.buildCode(code);
            System.out.println(symbol + "-->" + code);
            this.codeTable.add(symbol + " " + code);
        }
    }
}