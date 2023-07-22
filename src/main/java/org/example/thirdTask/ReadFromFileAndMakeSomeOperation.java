package org.example.thirdTask;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ReadFromFileAndMakeSomeOperation {
    private String readFromFile(File file){
        StringJoiner stringJoiner = new StringJoiner("\n");
        try (Scanner sc = new Scanner(file)){
            while (sc.hasNextLine()){
                stringJoiner.add(sc.nextLine());
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return stringJoiner.toString();
    }
    public void amountOfSymbols(File file){
        String line = readFromFile(file);
        String[] arr = line.split("\\s++");
        Map<String, Integer> wordFreq = new HashMap<>();
        for (String word : arr) {
            word = word.trim();
            wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
        }

        Map<String, Integer> sortedWordFreq = sortByFrequency(wordFreq);

        for (Map.Entry<String, Integer> entry : sortedWordFreq.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }
    private Map<String, Integer> sortByFrequency(Map<String, Integer> wordFreq) {
        Map<String, Integer> sortedWordFreq = new TreeMap<>((a, b) -> {
            int freqA = wordFreq.get(a);
            int freqB = wordFreq.get(b);
            return Integer.compare(freqB, freqA);
        });

        sortedWordFreq.putAll(wordFreq);
        return sortedWordFreq;
    }
}
