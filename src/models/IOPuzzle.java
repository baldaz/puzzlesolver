package puzzlesolver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class IOPuzzle extends IOFile {

    private static Charset charset = StandardCharsets.UTF_8;

    public IOPuzzle(String path) {
        super(path);
    }

    public Puzzle read() {
        Puzzle ret = new Puzzle();
        try (BufferedReader reader = Files.newBufferedReader(toPath(), charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                if(!line.isEmpty()) {
                    String [] input = line.split("\t");
                    if(input.length == 6) {
                        String id = input[0];
                        String ch = input[1];
                        String nt = input[2];
                        String et = input[3];
                        String st = input[4];
                        String wt = input[5];
                        Piece p = new Piece(id, ch, nt, et, st, wt);
                        ret.addPiece(p);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println(e);
        }
        return ret;
    }

    public void write() {

    }
}