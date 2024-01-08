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

    public boolean confirmWord(String word) {
        Word w = dict.getWord(word);
        if (!words.contains(w)) return false;
        if (w.getGuess().equals(w.getMeaning())) {
            w.confirm();
            return true;
        }
        return false;
    }

    public void setGuess(String word, String guess) {
        dict.getWord(word).setGuess(guess);
    }

    public String getGuess(String word) {
        return dict.getWord(word).getGuess();
    }

    // TODO
    //  getters & setters
}
