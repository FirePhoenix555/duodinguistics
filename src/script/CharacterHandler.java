package script;

import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CharacterHandler {

    private BufferedImage P;
    private BufferedImage T;
    private BufferedImage K;
    private BufferedImage F;
    private BufferedImage S;
    private BufferedImage H;
    private BufferedImage TS;
    private BufferedImage M;
    private BufferedImage N;
    private BufferedImage W;
    private BufferedImage R;
    private BufferedImage Y;

    public CharacterHandler() throws IOException {
        // TODO make actual file paths
        P = ImageIO.read(new File("path-to-file"));
        T = ImageIO.read(new File("path-to-file"));
        K = ImageIO.read(new File("path-to-file"));
        F = ImageIO.read(new File("path-to-file"));
        S = ImageIO.read(new File("path-to-file"));
        H = ImageIO.read(new File("path-to-file"));
        TS = ImageIO.read(new File("path-to-file"));
        M = ImageIO.read(new File("path-to-file"));
        N = ImageIO.read(new File("path-to-file"));
        W = ImageIO.read(new File("path-to-file"));
        R = ImageIO.read(new File("path-to-file"));
        Y = ImageIO.read(new File("path-to-file"));
    }

    private BufferedImage getBaseCharacter(char c) {
        return switch (c) {
            case 'p' -> P;
            case 't' -> T;
            case 'k' -> K;
            case 'f' -> F;
            case 's' -> S;
            case 'h' -> H;
            case 'c' -> TS;
            case 'm' -> M;
            case 'n' -> N;
            case 'w' -> W;
            case 'r' -> R;
            case 'y' -> Y;
            default -> null;
        };
    }

    /*
     * Input syllable has all instances of ts replaced with c
     */
    public BufferedImage getCharacter(String syllable) { // TODO maybe make this class store each combination, if characters implement more fluid merging of vowels and consonants
        char c = syllable.charAt(0);
        char v = syllable.charAt(1);

        syllable = syllable.replaceFirst(c + "", "");
        syllable = syllable.replaceFirst(v + "", "");

        BufferedImage base = getBaseCharacter(c);

        BufferedImage vowel = getVowelDiacritic(v); // returns blank image if vowel is 'a'

        // https://stackoverflow.com/questions/2318020/merging-two-images
        BufferedImage character = new BufferedImage(base.getWidth(), base.getHeight(), BufferedImage.TYPE_INT_ARGB); // all images have same width and height

        Graphics g = character.getGraphics();
        g.drawImage(base, 0, 0, null);
        g.drawImage(vowel, 0, 0, null);

        if (!syllable.isEmpty()) { // remaining coda /n/
            BufferedImage n = getN();
            g.drawImage(n, 0, 0, null);
        }

        g.dispose();

        // todo trim excess whitespace off?

        return character;
    }
}
