import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PuzzleSolver {

    private static Charset charset = StandardCharsets.UTF_8;

    public static void main(String args[]) {
        Puzzle puzzle = new Puzzle();
        // ABC
        Piece p1 = new Piece("C1", "C", "VUOTO", "I1", "H1", "VUOTO");
        Piece p2 = new Piece("A1", "A", "VUOTO", "O1", "L1", "I1" );
        Piece p3 = new Piece("I1", "I", "VUOTO", "A1", "E1", "C1" );
        Piece p4 = new Piece("O1", "O", "VUOTO", "VUOTO", "O2", "A1");

        Piece p5 = new Piece("O2", "O", "O1", "VUOTO", "A2", "L1");
        Piece p6 = new Piece("L1", "L", "I1", "O2", "L2", "E1");
        Piece p7 = new Piece("H1", "H", "C1", "E1", "H2", "VUOTO");
        Piece p8 = new Piece("E1", "E", "A1", "L1", "O3", "H1");

        Piece p9 = new Piece("A2", "A", "O2", "VUOTO", "VUOTO", "L2");
        Piece p10 = new Piece("H2", "H", "H1", "O3", "VUOTO", "VUOTO");
        Piece p11 = new Piece("L2", "L", "L1", "A2", "VUOTO", "O3");
        Piece p12 = new Piece("O3", "O", "E1", "L2", "VUOTO", "H2");
        // Populate puzzle
        puzzle.addPiece(p1);
        puzzle.addPiece(p2);
        puzzle.addPiece(p3);
        puzzle.addPiece(p4);
        puzzle.addPiece(p5);
        puzzle.addPiece(p6);
        puzzle.addPiece(p7);
        puzzle.addPiece(p8);
        puzzle.addPiece(p9);
        puzzle.addPiece(p10);
        puzzle.addPiece(p11);
        puzzle.addPiece(p12);
        // View, will save to file after controller operation of sorting
        PuzzleView view = new PuzzleView();
        PuzzleController controller = new PuzzleController(puzzle, view);
        controller.display();
        controller.sort();
        controller.display();
    }

    private static String readFile(Path path) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        } catch (IOException e) {
            System.err.println(e);
        }
        return content.toString();
    }
}
