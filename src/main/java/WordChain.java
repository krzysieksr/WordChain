import java.util.List;
import java.util.Scanner;

public class WordChain {

    public static void main(String[] args) {

        System.out.println("Please enter first word:");
        Scanner sc = new Scanner(System.in);
        String fromWord = sc.nextLine();
        System.out.println("Please enter second word:");
        String toWord = sc.nextLine();

        if (fromWord.length() != toWord.length()) {
            System.err.println("Words must be of the same length.");
            System.exit(1);
        }

        ShortestChain shortestChain = new ShortestChain(fromWord, toWord);
        List<String> chain = shortestChain.findShortestChain();

        System.out.println(chain != null ? "The shortest word chain:\n" + chain : "Solution has not found");
    }
}
