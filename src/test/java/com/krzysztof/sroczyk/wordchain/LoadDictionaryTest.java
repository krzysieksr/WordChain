package com.krzysztof.sroczyk.wordchain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LoadDictionaryTest {

    @Test
    public void testLoadWordList() {
        LoadDictionary loadDictionary = new LoadDictionary();

        assertThat(loadDictionary.loadWordList(3)).isNotEmpty();
        assertThat(loadDictionary.loadWordList(3)).contains("but");
    }
}
