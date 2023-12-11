package script;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Characters {

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

    public Characters() throws IOException {
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

    public BufferedImage getCharacter(String c) {
        return switch (c) {
            case "p" -> P;
            case "t" -> T;
            case "k" -> K;
            case "f" -> F;
            case "s" -> S;
            case "h" -> H;
            case "ts" -> TS;
            case "m" -> M;
            case "n" -> N;
            case "w" -> W;
            case "r" -> R;
            case "y" -> Y;
            default -> null;
        };
    }
}
