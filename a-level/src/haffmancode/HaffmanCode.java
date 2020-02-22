package haffmancode;

import java.util.*;

public class HaffmanCode {
    public class Node implements Comparable<Node> {
        private final int sum;
        private String code;

        public Node(int sum) {
            this.sum = sum;
        }

        void buildCode(String code) {
            this.code = code;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(sum, o.sum);
        }

        public int getSum() {
            return sum;
        }

        public String getCode() {
            return code;
        }
    }

    public class InternalNode extends Node {
        private Node left;
        private Node right;

        public InternalNode(Node left, Node right) {
            super(left.sum + right.sum);
            this.left = left;
            this.right = right;
        }

        @Override
        void buildCode(String code) {
            super.buildCode(code);
            left.buildCode(code + "0");
            right.buildCode(code + "1");
        }

    }

    class LeafNode extends Node {
        private char symbol;


        public LeafNode(char symbol, int count) {
            super(count);
            this.symbol = symbol;
        }

        @Override
        void buildCode(String code) {
            super.buildCode(code);
            System.out.println(symbol + "-->" + code);
        }

    }

    public void compressData(String ifName, String ofName) {
        String inputFile = ifName;
        String outputFile = ofName;
        String readString;
        IOtoFile ioToFile = new IOtoFile();
        List<String> initData = ioToFile.inputStringsFromFile(inputFile);
        Map<Character, Integer> count = new HashMap<>();
        for (String initDatum : initData) {
            readString = initDatum;
            for (int i = 0; i < readString.length(); i++) {
                char readChar = readString.charAt(i);
                if (count.containsKey(readChar)) {
                    count.put(readChar, count.get(readChar) + 1);
                } else {
                    count.put(readChar, 1);
                }
            }
        }
        Map<Character, Node> charNodes = new HashMap<>();
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            LeafNode node = new LeafNode(entry.getKey(), entry.getValue());
            charNodes.put(entry.getKey(), node);
            priorityQueue.add(node);
        }
        int sum = 0;
        while (priorityQueue.size() > 1) {
            Node first = priorityQueue.poll();
            Node second = priorityQueue.poll();
            InternalNode node = new InternalNode(first, second);
            sum += node.getSum();
            priorityQueue.add(node);
        }
        if (count.size() == 1) {
            sum = count.get(count.keySet());
        }
        Node root = priorityQueue.poll();
        if (count.size() == 1) {
            root.buildCode("0");
        } else {
            root.buildCode("");
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int k = 0; k < initData.size(); k++) {
            readString = initData.get(k);
            for (int i = 0; i < readString.length(); i++) {
                char readChar = readString.charAt(i);
                stringBuilder.append(charNodes.get(readChar).getCode());
            }
        }
        System.out.println(stringBuilder.toString());
        ioToFile.writeToBinary(stringBuilder.toString(), outputFile);

        for (Map.Entry entry : charNodes.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " Value: "
                    + entry.getValue().toString());
        }
    }
}