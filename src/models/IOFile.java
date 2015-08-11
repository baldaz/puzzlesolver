package puzzlesolver;

import java.io.File;
import java.io.IOException;

/**
 * Abstract base representing input output file for puzzles.
 */

public abstract class IOFile extends File {

    private Puzzle puzzle = new Puzzle();
    private String outpath = new String("");

    /**
     * Constructor
     * @param path path of the input file.
     * @param opath path of the output file.
     */

    public IOFile(String path, String opath) {
        super(path);
        outpath = opath;
    }

	/**
	 * @return reference to the instance of puzzle
	 */

    public Puzzle puzzle() {
        return puzzle;
    }

	/**
	 * @return output file path
	 */
	
    public String outpath() {
        return outpath;
    }

    /**
     * Read data from the input file.
     */

    public abstract void read() throws IOException;

    /**
     * Write data to the output file in outpath.
     */

    public abstract void write();

}
