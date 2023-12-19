package journal;

import script.CharacterHandler;

import java.io.IOException;
import java.util.Objects;

public class Dictionary {

    Word[] words;

    public Dictionary() {
        try {
            String[][] wordList = DictionaryLoader.loadWords();

            CharacterHandler c = new CharacterHandler();
            words = new Word[wordList.length];

            for (int i = 0; i < words.length; i++) {
                String romanization = wordList[i][0];
                String meaning = wordList[i][1];
                words[i] = new Word(romanization, meaning, c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Word getWord(String word) {
        for (Word w : words) {
            String r = w.getRomanization();
            if (Objects.equals(r, word)) {
                return w;
            }
        }
        return null;
    }
}
