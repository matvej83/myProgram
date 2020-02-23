package haffmancode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class HaffmanCode {
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
            Node.LeafNode node = new Node.LeafNode(entry.getKey(), entry.getValue());
            charNodes.put(entry.getKey(), node);
            priorityQueue.add(node);
        }
        int sum = 0;
        while (priorityQueue.size() > 1) {
            Node first = priorityQueue.poll();
            Node second = priorityQueue.poll();
            Node.InternalNode node = new Node.InternalNode(first, second);
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
    }
}