package journal;

import java.util.ArrayList;

public class Journal {

    private final ArrayList<Word> words;
    private final Dictionary dict;

    public Journal() {
        words = new ArrayList<Word>();
        dict = new Dictionary();
    }

    public void addWord(String word) {
        Word w = dict.getWord(word);
        words.add(w);
    }

    // TODO
    //  getters & setters
    //  way to confirm word
    //  ...
}
