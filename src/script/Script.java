package script;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Objects;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Script {
    private static final String vowel = "[aeiou]";
    private static final String consonant = "[ptkfshcmnwry]";

    public Script() {

    }

    public static BufferedImage[] getScript(String s, Characters c) {
        String[] syllables = getSyllables(s);

        BufferedImage[] b = new BufferedImage[syllables.length];

        Pattern p = Pattern.compile("(" + consonant + "?)(" + vowel + ")(n?)");
        Matcher m;

        for (int i = 0; i < syllables.length; i++) {
            String syllable = syllables[i];

//            m = p.matcher(syllable);
//            if (!m.find()) throw new Error("Invalid syllable: " + syllable);

//            String onset = m.group(1);
//            String vow = m.group(2); // the vowel in the syllable
//            String coda = m.group(3);

            BufferedImage img = c.getCharacter(syllable);

            b[i] = img;
        }

        return b;
    }

    /*
     * input s given in romanization, with ch replaced by t or ts depending on etymology
     */
    private static String[] getSyllables(String s) {
        s = s.replaceAll("ts", "c"); // make one character for easier parsing
        s = s.replaceAll("(n[aeiou])", "_$1"); // noting all syllables with n onsets

        ArrayList<String> f = new ArrayList<String>(); // final return list

        String pattern = "(^|" + vowel + "n?)_?(" + consonant + "?" + vowel + "n?)";
        Pattern p = Pattern.compile(pattern);
        Matcher m;

        while (true) {
            m = p.matcher(s);
            if (!m.lookingAt()) break; // no more syllables to find

            String syllable = m.group(2);
            f.add(syllable); // add to the list of syllables

            s = s.replaceFirst(syllable, "");
        }

        return f.toArray(new String[]{}); // return as string[] array
    }
}