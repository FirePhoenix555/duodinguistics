package journal;

import script.CharacterHandler;
import script.Script;

import java.awt.image.BufferedImage;

public class Word {
    private final String romanization;
    private final String meaning;
    private final BufferedImage[] spelling;
    // (sound file for recording of word)

    private String meaningGuess = "";
    private boolean confirmed = false;

    protected Word(String romanization, String meaning, CharacterHandler c) {
        this.romanization = romanization;
        this.meaning = meaning;
        this.spelling = Script.getScript(romanization, c);
    }

    public BufferedImage[] getSpelling() {
        return spelling;
    }

    public String getMeaning() {
        return meaning;
    }

    public String getRomanization() {
        return romanization;
    }

    protected void setGuess(String guess) {
        meaningGuess = guess;
    }

    public String getGuess() {
        return meaningGuess;
    }

    protected void confirm() {
        confirmed = true;
    }

    public boolean getConfirmedStatus() {
        return confirmed;
    }
}
