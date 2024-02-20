package journal;

import java.io.*;
import java.util.ArrayList;

public class DictionaryLoader {

    private static final String wordPath = "assets/wordlist.tsv";

    protected static String[][] loadWords() throws IOException {

        ArrayList<String[]> s = new ArrayList<String[]>();

        File f = new File(wordPath);
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);

        while (true) {
            String line = br.readLine();
            if (line == null) break;

            String[] lineItems = line.split("\t");
            s.add(lineItems);
        }

        br.close();

        return s.toArray(new String[][]{});
    }
}