package script;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    private static String[] parseString(String s) {
        s = s.replaceAll("ts", "c"); // make one character for easier parsing

        ArrayList<String> sb = new ArrayList<String>(); // string builder

        String current = "";

        // TODO use regex and not this parsing algorithm

        int len = s.length();
        for (int i = 0; i < len; i++) {
            String c = s.charAt(i) + "";
            if (cons.contains(c) || vows.contains(c)) { // valid character
                current += c;

                if (vows.contains(c) && (i < len - 2 ? !s.substring(i + 1, i + 3).contains(vows) : true)) { // end of syllable

                }
            } else {
                return null;
            }
        }
    }

    private static boolean endOfSyllable(String overall, int index) {

        // it's a vowel followed by <2 consonants
        // it's 'n' followed by a consonant
    }
}
