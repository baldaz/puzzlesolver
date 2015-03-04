package puzzlesolver;

import java.io.File;

public abstract class IOFile extends File {

    public IOFile(String path) {
        super(path);
    }

    public abstract Puzzle read();

    public abstract void write();

}