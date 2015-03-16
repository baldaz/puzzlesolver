package puzzlesolver;

import java.io.File;

public abstract class IOFile extends File {

    private Puzzle puzzle = new Puzzle();
    private String outpath = new String("");

    public IOFile(String path, String opath) {
        super(path);
        outpath = opath;
    }

    public Puzzle puzzle() {
        return puzzle;
    }

    public String outpath() {
        return outpath;
    }

    public abstract void read();

    public abstract void write();

}