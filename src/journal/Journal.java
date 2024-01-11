package journal;

import java.awt.image.BufferedImage;
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
    
    public Word getWord(String word) {
        return dict.getWord(word);
    }

    public boolean confirmWord(String word) {
        Word w = getWord(word);
        if (!words.contains(w)) return false;
        if (w.getGuess().equals(w.getMeaning())) {
            w.confirm();
            return true;
        }
        return false;
    }

    public void setGuess(String word, String guess) {
        getWord(word).setGuess(guess);
    }

    public String getGuess(String word) {
        return getWord(word).getGuess();
    }
    
    public String getMeaning(String word) {
        Word w = getWord(word);
        if (w.getConfirmedStatus()) {
            return w.getMeaning();
        } else {
            return w.getGuess();
        }
    }
    
    public String getRomanization(String word) {
        return getWord(word).getRomanization();
    }
    
    public BufferedImage[] getSpelling(String word) {
        return getWord(word).getSpelling();
    }
}
