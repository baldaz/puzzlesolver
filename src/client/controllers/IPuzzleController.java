package puzzlesolver;

import java.rmi.*;

/**
 * Public interface for the puzzle controller.
 */

public interface IPuzzleController {

    // sorting method

    public void sort(String host);

    // display method

    public void output();
}
