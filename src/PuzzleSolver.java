import puzzlesolver.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PuzzleSolver {

    public static void main(String args[]) {
        Puzzle puzzle = new Puzzle();
        // puzzle = readFile(Paths.get(args[0]));
        IPuzzleView view = new PuzzleView(new IOPuzzle(args[0]));
        puzzle = view.inputPuzzle();
        IPuzzleController controller = new PuzzleController(puzzle, view);
        controller.display();
        controller.sort();
        controller.display();
    }
}
