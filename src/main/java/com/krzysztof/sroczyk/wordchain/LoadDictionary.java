package com.krzysztof.sroczyk.wordchain;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LoadDictionary {

    List<String> loadWordList(final int wordLength) {
        List<String> wordList;
        String fileName = "dictionary.txt";
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        try (Stream<String> stream = Files.lines(Paths.get(file.toURI()), Charset.forName("ISO-8859-1"))) {
            wordList = stream.filter(readLine -> readLine.length() == wordLength).collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Exception while reading the file", e);
        }

        return wordList;
    }
}
