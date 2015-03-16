package puzzlesolver;

import java.io.File;

/**
 * MVC Pattern File representing an abstract base for input output file for puzzles.
 */

public abstract class IOFile extends File {

    private Puzzle puzzle = new Puzzle();
    private String outpath = new String("");

    /**
     * Constructor
     * @param path, path of the input file.
     * @param opath, path of the output file.
     */

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

    /**
     * Read data from the input file.
     */

    public abstract void read();

    /**
     * Write data to the output file in outpath.
     */

    public abstract void write();

}