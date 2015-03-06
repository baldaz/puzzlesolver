package puzzlesolver;

// This class will contain sorting logic of the puzzle
import java.util.Vector;
import java.util.Iterator;

public class PuzzleController implements IPuzzleController {

    private Puzzle model;
    private IPuzzleView view;

    public PuzzleController(Puzzle m, IPuzzleView v) {
        model = m;
        view = v;
    }

    public void sort() {
        SortAlg alg = new SortAlgSeq(model);
        alg.sort();
    }

    public void display() {
        view.printPuzzle(model);
        view.printPuzzleText(model);
    }
}