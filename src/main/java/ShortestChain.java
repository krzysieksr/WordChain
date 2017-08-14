import java.util.*;
import java.util.stream.Collectors;

public class ShortestChain {

    private String fromWord;
    private String toWord;
    private List<String> wordList;


    public ShortestChain(final String fromWord, final String toWord) {
        this.fromWord = fromWord;
        this.toWord = toWord;

        LoadDictionary loadDictionary = new LoadDictionary();
        wordList = loadDictionary.loadWordList(fromWord.length());
    }

    List<String> findShortestChain() {
        Map<String, String> previous = new HashMap<>();

        Queue<String> queue = new ArrayDeque<>();
        queue.add(fromWord);

        String parentWord;
        while (!queue.isEmpty() && !(parentWord = queue.remove()).equals(toWord)) {
            List<String> nextWords = getNextWords(parentWord);
            for (String nextWord : nextWords) {
                if (!previous.containsKey(nextWord)) {
                    previous.put(nextWord, parentWord);
                    queue.add(nextWord);
                }
            }
        }

        return getFinalChain(previous, fromWord, toWord);
    }

    List<String> getNextWords(final String word) {
        List<String> nextWords;
        nextWords = wordList.stream().filter(wordFromList -> getDifferentWord(word, wordFromList) == 1).collect(Collectors.toList());

        return nextWords;
    }

    int getDifferentWord(final String word1, final String word2) {
        int diff = 0;
        for (int n = 0; n < word1.length(); n++) {
            if (word1.charAt(n) != word2.charAt(n)) {
                diff++;
            }
        }
        return diff;
    }

    List<String> getFinalChain(final Map<String, String> previous, final String fromWord, final String toWord) {
        if (!previous.containsKey(toWord)) {
            return null;
        }

        List<String> path = new ArrayList<>();
        String word = toWord;
        while (!word.equals(fromWord)) {
            path.add(0, word);
            word = previous.get(word);
        }

        path.add(0, fromWord);

        return path;
    }

}
