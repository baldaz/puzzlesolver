package puzzlesolver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Iterator;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IOPuzzle extends IOFile {

    private static Charset charset = StandardCharsets.UTF_8;
    private Puzzle puzzle;
    private String outpath;

    public IOPuzzle(String path, String opath) {
        super(path);
        outpath = opath;
    }

    public Puzzle puzzle() {
        return puzzle;
    }

    public void read() {
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
        puzzle = ret;
    }

    public void write() {
        int row = 0;
        int col = 1;
        int size = puzzle.size();
        String pcomplete = "";
        Iterator<Piece> it = puzzle().pieces().iterator();
        Piece temp = it.next();
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(outpath), charset)) {
            while(!temp.east().equals("VUOTO")) {
                writer.write(temp.ch());
                col++;
                String token = "";
                if(temp.east().equals("VUOTO")) token = temp.ch() + "\n";
                else token = temp.ch();
                pcomplete += token;
                temp = it.next();
            }
            row = size / col;
            while(it.hasNext()) {
                writer.write(temp.ch());
                String token = "";
                if(temp.east().equals("VUOTO")) token = temp.ch() + "\n";
                else token = temp.ch();
                pcomplete += token;
                temp = it.next();
            }
            writer.write(temp.ch());
            pcomplete += temp.ch() + "\n";
            writer.write("\n\n");
            writer.write(pcomplete);
            writer.write("\n");
            writer.write(Integer.toString(row)); writer.write(" "); writer.write(Integer.toString(col));
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}