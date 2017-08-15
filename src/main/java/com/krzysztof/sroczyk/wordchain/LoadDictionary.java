package com.krzysztof.sroczyk.wordchain;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class LoadDictionary {

    public List<String> loadWordList(final int wordLength) {
        List<String> wordList = new ArrayList<>();
        String fileName = "/dictionary.txt";

        try {
            InputStream in = getClass().getResourceAsStream(fileName);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String word;
            while ((word = reader.readLine()) != null) {
                if (word.length() == wordLength) {
                    wordList.add(word);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Exception while reading the file", e);
        }

        return wordList;
    }
}
