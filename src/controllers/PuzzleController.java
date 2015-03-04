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
        SortAlgFromTop alg = new SortAlgFromTop(model);
        Thread t = new Thread(alg);
        t.start();
        try {
            t.join();
        } catch(InterruptedException e) {
            System.err.println(e);
        }
    }

    public void display() {
        view.printPuzzle(model);
        view.printPuzzleText(model);
    }
}