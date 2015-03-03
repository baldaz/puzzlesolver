package puzzlesolver;

import java.io.File;

public abstract class InputFileStream extends File {

    public InputFileStream(String path) {
        super(path);
    }

    public abstract void write();

}