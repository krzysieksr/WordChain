import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class ShortestChainTest {

    @Test
    public void testFindShortestChain() {
        ShortestChain shortestChain = new ShortestChain("cat", "dog");

        assertThat(shortestChain.findShortestChain()).isNotEmpty();
        assertThat(shortestChain.findShortestChain()).contains("cot");
        assertThat(shortestChain.findShortestChain().size()).isEqualTo(4);
    }

    @Test
    public void testGetNextWords() {
        ShortestChain shortestChain = new ShortestChain("cat", "dog");

        assertThat(shortestChain.getNextWords("cot")).contains("cwt");
        assertThat(shortestChain.getNextWords("cot").size()).isEqualTo(34);
    }

    @Test
    public void testGetDifferentWord() {
        ShortestChain shortestChain = new ShortestChain("cat", "dog");

        assertThat(shortestChain.getDifferentWord("fog", "mog")).isEqualTo(1);
    }

    @Test
    public void testGetFinalChain() {
        //given
        ShortestChain shortestChain = new ShortestChain("cat", "dog");

        HashMap<String, String> previous = new HashMap<>();
        previous.put("pat", "cat");
        previous.put("cot", "cat");
        previous.put("cog", "cot");
        previous.put("dog", "cog");

        assertThat(shortestChain.getFinalChain(previous, "cat", "dog")).isEqualTo(Arrays.asList("cat", "cot", "cog", "dog"));
    }
}
