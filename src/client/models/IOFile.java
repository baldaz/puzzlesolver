package puzzlesolver;

import java.io.File;

public abstract class IOFile extends File {

    public IOFile(String path) {
        super(path);
    }

    public abstract void read();

    public abstract void write();

}