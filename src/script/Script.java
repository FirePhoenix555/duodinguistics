package script;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Script {

    private static final List<String> cons = Arrays.asList("p","t","k","f","s","h","c","m","n","w","r","y");
    private static final List<String> vows = Arrays.asList("a","i","u","e","o");


    public Script() {

    }
    public static BufferedImage[] getScript(String s) {


        BufferedImage[] b;


    }

    /*
     * input s given in romanization, with ch replaced by t or ts depending on etymology
     */
    private static String[] getSyllables(String s) {
        s = s.replaceAll("ts", "c"); // make one character for easier parsing
        s = s.replaceAll("(n[aeiou])", "_$1"); // noting all syllables with n onsets

        ArrayList<String> f = new ArrayList<String>(); // final return list

        String vowel = "[aeiou]";
        String consonant = "[ptkfshcmnwry]";

        String pattern = "(^|" + vowel + "n?)_?(" + consonant + "?" + vowel + "n?)";
        Pattern p = Pattern.compile(pattern); // nC | C | /0
        Matcher m;

        while (true) {
            m = p.matcher(s);
            if (!m.lookingAt()) break; // no more syllables to find

            String syllable = m.group(2);
            f.add(syllable.replaceAll("c", "ts")); // add to the list of syllables

            s = s.replaceFirst(syllable, "");
        }

        return f.toArray(new String[]{}); // return as string[] array
    }

    private static boolean endOfSyllable(String overall, int index) {

        // it's a vowel followed by <2 consonants
        // it's 'n' followed by a consonant
    }
}
