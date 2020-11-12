package ru.geekbrains;

import java.util.*;

public class RandomWords {

    public void go () {
        // populating ArrayList with 20 random words
        ArrayList<String> randomWords = randomWords();
        System.out.println("Printing 20 random words:");
        System.out.println(randomWords);

        // showing only unique words using Set
        Set<String> uniqueWords = new HashSet<>(randomWords);
        System.out.println("\nPrinting unique words only:");
        System.out.println(uniqueWords);

        // creating TreeMap, where 'key' is a unique word, 'value' is a count of duplicates;
        Map<String, Integer> countWords = new TreeMap<>();
        for (String word : uniqueWords) {
            // count duplicates
            int count = 0;
            for (String randomWord : randomWords) {
                if (word.equals(randomWord)) {
                    count++;
                }
            }
            // add as many elements as in uniqueWords
            countWords.put(word, count);
        }
        System.out.println("\nPrinting words and # of their duplicates:");
        System.out.println(countWords);
    }

    private ArrayList<String> randomWords() {
        ArrayList<String> words = new ArrayList<>();
        words.add("null");
        words.add("friction");
        words.add("drain");
        words.add("hook");
        words.add("cows");
        words.add("shade");
        words.add("fly");
        words.add("hook");
        words.add("gate");
        words.add("null");
        words.add("practice");
        words.add("arm");
        words.add("receipt");
        words.add("surprise");
        words.add("ancient");
        words.add("card");
        words.add("fly");
        words.add("null");
        words.add("wish");
        words.add("arm");

        return words;
    }

}
