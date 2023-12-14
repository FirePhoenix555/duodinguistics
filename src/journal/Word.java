package journal;

import script.CharacterHandler;
import script.Script;

import java.awt.image.BufferedImage;

public class Word {
    private final String romanization;
    private final String meaning;
    private final BufferedImage[] spelling;
    private String meaningGuess;

    public Word(String romanization, String meaning, CharacterHandler c) {
        this.romanization = romanization;
        this.meaning = meaning;
        this.spelling = Script.getScript(romanization, c);
        this.meaningGuess = "";
    }

    public void setGuess(String guess) {
        meaningGuess = guess;
    }

    public String getGuess() {
        return meaningGuess;
    }
}
